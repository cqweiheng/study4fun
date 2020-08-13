package com.springcloud.consumer.service.impl;

import com.springcloud.consumer.pojo.Product;
import com.springcloud.consumer.service.ProductProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductProviderImpl implements ProductProvider {

	@Override
	public Product getProduct(Long id) {
		Product product = new Product();
		product.setId(-1111L);
		product.setNote("系统繁忙稍后再试......");
		return product;
	}

	@Override
	public ResponseEntity addProduct(Product product) {
		return null;
	}
}
