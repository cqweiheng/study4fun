package com.springcloud.productprovider.dao;


import com.springcloud.productprovider.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {

	Product getProduct(@Param("id") Long id);
}
