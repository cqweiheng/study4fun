package com.springcloud.productprovider.service.impl;

import com.springcloud.productprovider.dao.ProductDao;
import com.springcloud.productprovider.pojo.Product;
import com.springcloud.productprovider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public Product getProduct(Long id) {
		return productDao.getProduct(id);
	}
}
