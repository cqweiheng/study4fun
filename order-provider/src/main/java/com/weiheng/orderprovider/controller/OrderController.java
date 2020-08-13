package com.weiheng.orderprovider.controller;

import com.weiheng.orderprovider.pojo.Order;
import com.weiheng.orderprovider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("add")
	public String addOrder(Order order){
		orderService.addOrder(order);
		System.out.println(order.toString());
		return "success";
	}

	@GetMapping("getAll")
	public List<Order> getAll(){
		return orderService.getAll();
	}

	@PostMapping("getByName")
	public List<Order> getByName(String name){
		return orderService.getByName(name);
	}
}
