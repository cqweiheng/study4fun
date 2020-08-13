package com.springcloud.productprovider.service;

import com.springcloud.productprovider.pojo.Product;

import java.util.List;

/**
 *
 * @date 2020/7/27 16:37
 * @author wei.heng
 */
public interface ProductService {

	/**
	 *
	 * 获取产品对象
	 * @param id 产品ID
	 * @return com.springcloud.productprovider.pojo.Product
	 * @date 2020/7/27 16:38
	 * @author wei.heng
	 */
	Product getProduct(Long id);

	/**
	 *
	 * 批量获取产品信息
	 * @param ids 产品ID的数组
	 * @return List<Product>
	 * @date 2020/7/29 14:45
	 * @author wei.heng
	 */
	List<Product> getProducts(Long[] ids);

	/**
	 *
	 * 新增产品对象
	 * @param product 产品对象
	 * @return int 影响行数
	 * @date 2020/7/28 11:09
	 * @author wei.heng
	 */
	int inserProduct(Product product);
}
