package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.OrderRepository;
import com.example.model.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	@HystrixCommand(fallbackMethod="findAllFallback")
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	public List<Order> findAllFallback(){
		List<Order> list = new ArrayList<Order>();
		list.add(new Order(1, "static Data", new Date(), true));
		return list;
	}

}
