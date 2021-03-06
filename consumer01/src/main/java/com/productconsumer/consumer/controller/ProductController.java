package com.productconsumer.consumer.controller;

import com.productconsumer.consumer.pojo.Product;
import com.productconsumer.consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

	@GetMapping("/hystrixproduct/{id}")
	public ResponseEntity<Product> hystrixproduct(@PathVariable Long id){
		Product product = productService.getHystrixProduct(id);
		return ResponseEntity.ok(product);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> products(){
		List<Product> products = productService.getProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity products(@PathVariable Long id){
		System.out.println("start time: " + LocalDateTime.now());
		Future<Product> productFuture = productService.loadFutureProduct(id);
		Product product = null;
		try {
			product = productFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		Assert.notNull(product, "product为null，数据异常");
		System.out.println("end time: " + LocalDateTime.now() + " - " + product.getName());
		return new ResponseEntity(product, product == null ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

}
