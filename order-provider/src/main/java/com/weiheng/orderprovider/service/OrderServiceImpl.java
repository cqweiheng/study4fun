package com.weiheng.orderprovider.service;

import com.weiheng.orderprovider.dao.OrderDao;
import com.weiheng.orderprovider.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;

	@Override
	public String addOrder(Order order){

		orderDao.save(order);
		return "success";
	}

	@Override
	public List<Order> getAll(){
		return orderDao.findAll();
	}

	@Override
	public List<Order> getByName(String name) {
		return orderDao.findByName(name);
	}
}
