package com.productconsumer.consumer.service;

import com.productconsumer.consumer.pojo.Product;

import java.util.List;

public interface ProductService {

	Product getProduct(Long id);

	List<Product> getProducts();
}
