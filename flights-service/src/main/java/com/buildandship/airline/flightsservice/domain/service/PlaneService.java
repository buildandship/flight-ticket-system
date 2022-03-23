package com.buildandship.airline.flightsservice.domain.service;

import com.buildandship.airline.flightsservice.domain.exception.PlaneNotFoundException;
import com.buildandship.airline.flightsservice.domain.dto.Plane;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PlaneService {
  
  private final WebClient webClient;
  private final String planesService;
  private final String planesServiceApiPath;
  private final DiscoveryService discoveryService;
  
  
  public PlaneService(WebClient webClient, DiscoveryService discoveryService,
                      @Value("${planes.service}") String planesService, @Value("${planes.path}") String planesServiceApiPath) {
    this.webClient = webClient;
    this.discoveryService = discoveryService;
    this.planesService = planesService;
    this.planesServiceApiPath = planesServiceApiPath;
  }

  public Plane plane(String id) {
    return discoveryService
        .serviceAddressFor(this.planesService)
        .next()
        .flatMap(
            address ->
                this.webClient
                    .mutate()
                    .baseUrl(address + "/" + id)
                    .build()
                    .get()
                    .retrieve()
                    .onStatus(
                        HttpStatus::is4xxClientError,
                        clientResponse -> Mono.error(new PlaneNotFoundException(id)))
                    .onStatus(
                        HttpStatus::is5xxServerError,
                        clientResponse -> Mono.error(new PlaneNotFoundException(id)))
                    .bodyToMono(Plane.class))
        .block();
  }
  /*
  public Mono<Plane> plane(String id) {
    return discoveryService
            .serviceAddressFor(this.planesService)
            .next()
            .flatMap(
                    address ->
                            this.webClient
                                    .mutate()
                                    .baseUrl(address + "/" + id)
                                    .build()
                                    .get()
                                    .retrieve()
                                    .onStatus(
                                            HttpStatus::is4xxClientError,
                                            clientResponse -> Mono.error(new PlaneNotFoundException(id)))
                                    .onStatus(
                                            HttpStatus::is5xxServerError,
                                            clientResponse -> Mono.error(new PlaneNotFoundException(id)))
                                    .bodyToMono(Plane.class));
  }
   */
  
}
