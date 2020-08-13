package com.springcloud.consumer.controller;

import com.springcloud.consumer.pojo.Product;
import com.springcloud.consumer.service.ProductProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @date 2020/7/27 14:58
 * @author wei.heng
 */
@RestController
public class ProductController {

	private ProductProvider productProvider;

	@Autowired
	public ProductController(ProductProvider productProvider) {
		this.productProvider = productProvider;
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> product(@PathVariable Long id){
		Product product = productProvider.getProduct(id);
		return ResponseEntity.ok(product);
	}

	@PostMapping("/product")
	public ResponseEntity products(@RequestBody Product product){
		return productProvider.addProduct(product);
	}

}
