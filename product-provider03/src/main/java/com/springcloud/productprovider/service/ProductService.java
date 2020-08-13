package com.springcloud.productprovider.service;

import com.springcloud.productprovider.pojo.Product;
import org.springframework.stereotype.Service;

public interface ProductService {

	Product getProduct(Long id);
}
