package com.weiheng.orderprovider.service;

import com.weiheng.orderprovider.pojo.Order;

import java.util.List;

public interface OrderService {

	String addOrder(Order order);

	List<Order> getAll();

	List<Order> getByName(String name);
}
