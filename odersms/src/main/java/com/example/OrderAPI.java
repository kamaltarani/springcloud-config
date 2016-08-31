package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Order;
import com.example.repository.OrderRepository;

@RestController
public class OrderAPI {

	@Autowired
	private OrderRepository manufaturerRepository;

	@RequestMapping(value = "/api/order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> add(@RequestBody Order manufacturer) {
		manufaturerRepository.save(manufacturer);
		return new ResponseEntity<Order>(manufacturer, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/order", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = new ArrayList<>();
		list.add(new Order(1, "Local Order", new Date(), true));
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/order/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Order> update(@RequestBody Order manufacturer, @PathVariable("id") Integer id) {
		Order manufacturerOne = manufaturerRepository.findOne(id);
		if (manufacturerOne != null) {
			manufacturerOne.setActive(manufacturer.getActive());
			manufacturerOne.setOrderDate(manufacturer.getOrderDate());
			manufacturerOne.setName(manufacturer.getName());
			manufaturerRepository.save(manufacturerOne);
		}
		return new ResponseEntity<Order>(manufacturer, HttpStatus.ACCEPTED);
	}
}
