package com.example.dao;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Order;

@FeignClient("order-microservice")
public interface OrderRepository {

	@RequestMapping(value="/api/order")
	List<Order> findAll();
}
