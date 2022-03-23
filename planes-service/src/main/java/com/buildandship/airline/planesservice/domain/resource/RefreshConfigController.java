package com.buildandship.airline.planesservice.domain.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/refresh")
@RefreshScope
public class RefreshConfigController {
  
  @Value("${config.name}")
  private String configName;
  
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public String getConfig(){
    return configName;
  }
}
