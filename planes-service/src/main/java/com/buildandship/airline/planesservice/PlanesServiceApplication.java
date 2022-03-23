package com.buildandship.airline.planesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PlanesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanesServiceApplication.class, args);
	}

}
