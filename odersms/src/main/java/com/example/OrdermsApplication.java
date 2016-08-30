package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages="com.example.repository")
@EnableDiscoveryClient
public class OrdermsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdermsApplication.class, args);
	}
}
