package com.productconsumer.consumer.service.impl;

import com.productconsumer.consumer.pojo.Product;
import com.productconsumer.consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public Product getProduct(Long id) {
		return restTemplate.getForObject("http://PRODUCT-PROVIDER/product/"+id, Product.class);
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
