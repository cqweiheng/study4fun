package com.springcloud.productprovider.service.impl;

import com.springcloud.productprovider.dao.ProductDao;
import com.springcloud.productprovider.pojo.Product;
import com.springcloud.productprovider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public Product getProduct(Long id) {
		return productDao.getProduct(id);
	}

	@Override
	public List<Product> getProducts(Long[] ids) {
		return productDao.getProducts(ids);
	}

	@Override
	public int inserProduct(Product product) {
		return productDao.insertProduct(product);
	}
}
