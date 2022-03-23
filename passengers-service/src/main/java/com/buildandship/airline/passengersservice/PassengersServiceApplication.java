package com.buildandship.airline.passengersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PassengersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassengersServiceApplication.class, args);
	}

}
