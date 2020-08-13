package com.springcloud.productprovider.controller;

import com.springcloud.productprovider.pojo.Product;
import com.springcloud.productprovider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/product/{id}")
	public Product product(@PathVariable Long id){
		System.out.println("============ 7003:" + id);
		return productService.getProduct(id);
	}

}
