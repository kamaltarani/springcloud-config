package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderService {

	@Autowired
	private OrderClient orderClient;
	
	@RequestMapping("/")
	@ResponseBody
	public List<Order> findAll(){
		return orderClient.findAll();
	}
}
