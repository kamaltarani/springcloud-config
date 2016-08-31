package com.example;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("order-microservice")
public interface OrderClient {

	@RequestMapping(value = "/api/order", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	List<Order> findAll();
}
