package com.example;

//import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/*import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;*/

@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	/*@Bean
	public Filter shallowEtagHeaderFilter(){
		return new ShallowEtagHeaderFilter();
	}*/
}
