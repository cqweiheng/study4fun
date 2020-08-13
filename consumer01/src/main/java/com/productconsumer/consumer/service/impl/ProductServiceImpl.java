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
 *
 * @date 2020/7/27 16:59
 * @author wei.heng
 */
@Service
public class ProductServiceImpl implements ProductService {

	private RestTemplate restTemplate;

	@Autowired
	public ProductServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 *
	 *
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
			,@HystrixProperty(name = "maxRequestsInBatch", value = "200")}
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

	@HystrixCommand(defaultFallback="fallBack01")
	@Override
	public Product getProduct(Long id) {
		return restTemplate.getForObject("http://PRODUCT-PROVIDER/product/"+id, Product.class);
	}

	@HystrixCommand(fallbackMethod = "fallBack02", commandProperties = {
		// 默认20个;10s内请求数大于10个时启动熔断
		// 如果错误率没有超过CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE值，不会触发fallBack02()。
		@HystrixProperty(
			name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,
			value = "10"),
		// 默认采样周期为10秒，失败率50%；
		// 这里为了测试，设置请求错误率大于20%时就熔断，当请求符合熔断条件时将触发fallBack02()。
		@HystrixProperty(
			name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,
			value = "20"),
		// 默认值5000ms；这里设置熔断20秒后去尝试请求
		@HystrixProperty(
			name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,
			value = "20000"),
		// 是否强制开启熔断，默认false；为true时，所有请求都被拒绝，直接到fallback方法
		@HystrixProperty(
			name = HystrixPropertiesManager.CIRCUIT_BREAKER_FORCE_OPEN, value = "false"),
		// 是否强制关闭熔断，默认false；为true时，将忽略错误
		@HystrixProperty(
			name = HystrixPropertiesManager.CIRCUIT_BREAKER_FORCE_CLOSED, value = "false")
	})
	@Override
	public Product getHystrixProduct(Long id) {
		int random = 0;
		try {
			random = SecureRandom.getInstanceStrong().nextInt(10);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(LocalTime.now() + " ======= random：" + random);
		if(random%2 != 0){
			System.out.println(LocalTime.now() + " ==== error");
			throw new RuntimeException("我出错了");
		}
		return restTemplate.getForObject("http://PRODUCT-PROVIDER/product/"+id, Product.class);
	}

	public Product fallBack02(Long id) {

		System.out.println(LocalTime.now() + " =========fallBack02");
		Product product = new Product();
		product.setId(-1111L);
		product.setNote("系统繁忙稍后再试......");
		return product;
	}

	/**
	 *
	 * 服务降级托底数据返回
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
