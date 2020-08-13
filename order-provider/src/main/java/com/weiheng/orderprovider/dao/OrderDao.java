package com.weiheng.orderprovider.dao;

import com.weiheng.orderprovider.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {

	List<Order> findByName(String name);
}
