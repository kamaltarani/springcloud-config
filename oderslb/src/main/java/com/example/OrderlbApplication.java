package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages="com.example.repository")
@EnableDiscoveryClient
@RibbonClient(configuration=CustomLoadBalancerConfiguration.class, name="lb-Kamal")
public class OrderlbApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderlbApplication.class, args);
	}
}
