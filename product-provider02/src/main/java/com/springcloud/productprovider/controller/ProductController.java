package com.springcloud.productprovider.controller;

import com.springcloud.productprovider.pojo.Product;
import com.springcloud.productprovider.service.ProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/product/{id}")
	public Product product(@PathVariable Long id){
		System.out.println("=== 7002:" + id);
		return productService.getProduct(id);
	}

	@GetMapping("/products/{ids}")
	public List<Product> product(@PathVariable Long[] ids){
		System.out.println("=== 7002:" + StringUtils.join(ids,","));
		return productService.getProducts(ids);
	}

	@PostMapping("/product")
	public ResponseEntity product(@RequestBody Product product){
		System.out.println("=== 7002:" + product.getName());
		int i = productService.inserProduct(product);
		ResponseEntity responseEntity;
		if(i > 0){
			responseEntity = new ResponseEntity(HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

}
