package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.model.Order;

@RestController
public class ConsumerService {

	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/orderPost", method=RequestMethod.POST)
	public ResponseEntity<String> getData(){
		List<ServiceInstance> list = client.getInstances("order-microservice");
		if(list != null && list.size()>0){
			URI uri = list.get(0).getUri();
			if(uri != null){
				Order order1 = new Order(1, "Order1", new Date(), true);
				Order order2 = new Order(1, "Order2", new Date(), false);
				List<Order> orderList = new LinkedList<>();
				orderList.add(order1);
				orderList.add(order2);
				try {
					uri = new URI(uri.toString().concat("api/order"));
					return (new RestTemplate()).postForEntity(uri, orderList.get(0), String.class);
				} catch (RestClientException | URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		}
		return null;
	}
	
}
