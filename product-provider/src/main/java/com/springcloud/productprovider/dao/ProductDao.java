package com.springcloud.productprovider.dao;


import com.springcloud.productprovider.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @date 2020/7/27 16:33
 * @author wei.heng
 */
@Repository
public interface ProductDao {

	/**
	 * 获取产品对象
	 * @param id 主键ID
	 * @return com.springcloud.productprovider.pojo.Product
	 * @date 2020/7/27 16:33
	 * @author wei.heng
	 */
	Product getProduct(@Param("id") Long id);

	/**
	 *
	 * 批量获取产品对象
	 * @param ids 产品ID数组
	 * @return java.util.List<com.springcloud.productprovider.pojo.Product>
	 * @date 2020/7/29 14:52
	 * @author wei.heng
	 */
	List<Product> getProducts(Long[] ids);

	/**
	 *
	 * 新增产品对象
	 * @param product 产品对象
	 * @return int 影响行数
	 * @date 2020/7/28 11:08
	 * @author wei.heng
	 */
	int insertProduct(Product product);
}
