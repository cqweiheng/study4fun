package com.productconsumer.consumer.service;

import com.productconsumer.consumer.pojo.Product;

import java.util.List;
import java.util.concurrent.Future;

/**
 *
 * @date 2020/7/29 15:08
 * @author wei.heng
 */
public interface ProductService {

	/**
	 *
	 * 获取产品信息
	 * @param id 产品ID
	 * @return com.productconsumer.consumer.pojo.Product
	 * @date 2020/7/29 15:08
	 * @author wei.heng
	 */
	Product getProduct(Long id);

	Product getProductTreadIsolution(Long id);
	Product getProductTreadIsolution2(Long id);

	/**
	 *
	 * hystrix请求合并获取产品对象
	 * @param id 产品主键ID
	 * @return java.util.concurrent.Future<com.productconsumer.consumer.pojo.Product>
	 * @date 2020/7/29 15:38
	 * @author wei.heng
	 */
	Future<Product> loadFutureProduct(Long id);

	/**
	 *
	 * 批量获取产品信息
	 * @param ids 产品ID数组
	 * @return java.util.List<com.productconsumer.consumer.pojo.Product>
	 * @date 2020/7/29 15:08
	 * @author wei.heng
	 */
	List<Product> getProducts(List<Long> ids);

	/**
	 *
	 * 获取所有产品信息
	 * @return java.util.List<com.productconsumer.consumer.pojo.Product>
	 * @date 2020/7/29 15:08
	 * @author wei.heng
	 */
	List<Product> getProducts();
}
