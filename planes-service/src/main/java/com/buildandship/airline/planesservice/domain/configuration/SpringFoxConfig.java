package com.buildandship.airline.planesservice.domain.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {
  
  private ApiInfo apiInfo() {
    return new ApiInfo("Planes service Rest APIs",
            "APIs for planes microservice.",
            "1.0",
            "Terms of service",
            new Contact("Praveen Mishra", "www.org.com", "praveen.mishra@emaildomain.com"),
            "License of API",
            "API license URL",
            Collections.emptyList());
  }
  
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
  }
}
