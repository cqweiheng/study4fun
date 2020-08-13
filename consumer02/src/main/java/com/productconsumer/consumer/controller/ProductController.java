package com.productconsumer.consumer.controller;

import com.productconsumer.consumer.pojo.Product;
import com.productconsumer.consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @date 2020/7/27 14:58
 * @author wei.heng
 */
@RestController
public class ProductController {


	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> product(@PathVariable Long id){
		Product product = productService.getProduct(id);
		return ResponseEntity.ok(product);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> products(){
		List<Product> products = productService.getProducts();
		return ResponseEntity.ok(products);
	}

}
