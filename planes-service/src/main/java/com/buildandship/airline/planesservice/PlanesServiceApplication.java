package com.buildandship.airline.planesservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(
    info =
        @Info(
            title = "Planes microservice API",
            version = "1.0",
            description = "Planes microservice information"))
public class PlanesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanesServiceApplication.class, args);
	}

}
