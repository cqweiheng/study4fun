package com.springcloud.consumer.service;

import com.springcloud.consumer.pojo.Product;
import com.springcloud.consumer.service.impl.ProductProviderImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @date 2020/7/28 12:27
 * @author wei.heng
 */
@FeignClient(value = "PRODUCT-PROVIDER"
	, fallback = ProductProviderImpl.class
	/*, fallbackFactory = */)
public interface ProductProvider {

	/**
	 * 获取产品对象
	 * @param id 主键ID
	 * @return com.springcloud.consumer.pojo.Product
	 * @date 2020/7/28 12:27
	 * @author wei.heng
	 */
	@GetMapping("/product/{id}")
	Product getProduct(@PathVariable Long id);

	/**
	 *
	 * 新增产品对象
	 * @param product 产品对象
	 * @return org.springframework.http.ResponseEntity
	 * @date 2020/7/28 12:27
	 * @author wei.heng
	 */
	@PostMapping("/product")
	ResponseEntity addProduct(@RequestBody Product product);

}

