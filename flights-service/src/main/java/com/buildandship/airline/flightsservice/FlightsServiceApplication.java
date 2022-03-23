package com.buildandship.airline.flightsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FlightsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsServiceApplication.class, args);
	}

}
