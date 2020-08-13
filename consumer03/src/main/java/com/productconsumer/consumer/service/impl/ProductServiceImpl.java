package com.productconsumer.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.productconsumer.consumer.pojo.Product;
import com.productconsumer.consumer.service.ProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author wei.heng
 * @date 2020/7/27 16:59
 */
@Service
public class ProductServiceImpl implements ProductService {

	private RestTemplate restTemplate;

	@Autowired
	public ProductServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * @param id 主键ID
	 * @return java.util.concurrent.Future<com.productconsumer.consumer.pojo.Product>
	 * @date 2020/7/29 17:02
	 * @author wei.heng
	 */
	// @HystrixCollapser注解的方法，返回类型必须为Future，否则无法进行请求合并
	@HystrixCollapser(
		// 指定合并请求的方法，方法只能接收一个参数，如果需要传递多个参数，需要封装为一个参数类
		batchMethod = "getProducts"
		// 请求合并方式：REQUEST/GLOBAL。前者对一个request内的多次服务请求进行合并，后者是对单个应用中的所有线程的请求进行合并
		, scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL
		, collapserProperties = {
		// 这里为了测试配置为5000，把5000ms内的请求进行合并(默认值为10ms)
		@HystrixProperty(name = "timerDelayInMilliseconds", value = "5000")
		// 设置触发批处理执行之前，在批处理中允许的最大请求数
		, @HystrixProperty(name = "maxRequestsInBatch", value = "200")}
	)
	@Override
	public Future<Product> loadFutureProduct(Long id) {
		System.out.println("test:id = " + id + " -- " + LocalDateTime.now());
		return null;
	}

	@HystrixCommand
	@Override
	public List<Product> getProducts(List<Long> ids) {
		String idsStr = StringUtils.join(ids, ",");
		System.out.println("idsStr:" + idsStr);
		Product[] products = restTemplate.getForObject("http://PRODUCT-PROVIDER/products/" + idsStr, Product[].class);
		Assert.notNull(products, "获取到的产品信息为空");
		return Arrays.asList(products);
	}

	@HystrixCommand(defaultFallback = "fallBack01")
	@Override
	public Product getProduct(Long id) {
		return restTemplate.getForObject("http://PRODUCT-PROVIDER/product/" + id, Product.class);
	}

	@HystrixCommand
	(
		//熔断回调方法
		fallbackMethod = "fallBack02",
		//给provider提供的服务进行线程池分组,如果groupKey一样，运行在同一个线程池
		groupKey = "products-provider",
		//指定需要调用的provider接口的方法名字
		commandKey = "getProductTreadIsolution",
		//给线程池起名字
		threadPoolKey = "products-provider",
		threadPoolProperties = {
			//线程池大小
			@HystrixProperty(name = "coreSize", value = "30"),
			//最大队列长度,正数表示阻塞队列
			@HystrixProperty(name = "maxQueueSize", value = "100"),
			//线程存活时间
			@HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
			//拒绝请求
			@HystrixProperty(name = "queueSizeRejectionThreshold", value = "15")
		}
	)
	@Override
	public Product getProductTreadIsolution(Long id) {
		System.out.println("=== getProductTreadIsolution："+Thread.currentThread().getName());
		return restTemplate.getForObject("http://PRODUCT-PROVIDER/product/" + id, Product.class);
	}


	@HystrixCommand
		(
			//熔断回调方法
			fallbackMethod = "fallBack02",
			//给provider提供的服务进行线程池分组,如果groupKey一样，运行在同一个线程池
			groupKey = "products-provider2",
			//指定需要调用的provider接口的方法名字
			commandKey = "getProductTreadIsolution2",
			//给线程池起名字
			threadPoolKey = "products-provider2",
			threadPoolProperties = {
				//线程池大小
				@HystrixProperty(name = "coreSize", value = "30"),
				//最大队列长度,正数表示阻塞队列
				@HystrixProperty(name = "maxQueueSize", value = "100"),
				//线程存活时间
				@HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
				//拒绝请求
				@HystrixProperty(name = "queueSizeRejectionThreshold", value = "15")
			}
		)
	@Override
	public Product getProductTreadIsolution2(Long id) {
		System.out.println("=== getProductTreadIsolution："+Thread.currentThread().getName());
		return restTemplate.getForObject("http://PRODUCT-PROVIDER/product/" + id, Product.class);
	}

	public Product fallBack02(Long id) {

		System.out.println(LocalTime.now() + " =========fallBack02");
		Product product = new Product();
		product.setId(-1111L);
		product.setNote("系统繁忙稍后再试......");
		return product;
	}


	/**
	 * 服务降级托底数据返回
	 *
	 * @return com.productconsumer.consumer.pojo.Product
	 * @date 2020/7/29 17:04
	 * @author wei.heng
	 */
	private Product fallBack01() {

		Product product = new Product();
		product.setId(-1111L);
		product.setNote("系统繁忙稍后再试......");
		return product;
	}

	@Override
	public List<Product> getProducts() {
		// 循环调用看看各个服务后台的日志打印 - 测试
		List<Product> products = new ArrayList<>();
		final int times = 10;
		for (int i = 0; i < times; i++) {
			Product product = restTemplate
				.getForObject("http://PRODUCT-PROVIDER/product/" + (i + 1), Product.class);
			products.add(product);
		}
		return products;
	}
}
