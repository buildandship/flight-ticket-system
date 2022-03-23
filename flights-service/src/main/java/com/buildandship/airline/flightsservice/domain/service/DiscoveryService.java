package com.buildandship.airline.flightsservice.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DiscoveryService {

  private final LoadBalancerClient loadBalancerClient;
  private final DiscoveryClient discoveryClient;

  public Flux<String> serviceAddressFor(String service) {
    return Flux.defer(
        () ->
            Flux.just(this.discoveryClient.getInstances(service))
                .flatMap(
                    srv ->
                        Mono.just(this.loadBalancerClient.choose(service))
                            .flatMap(
                                serviceInstance ->
                                    Mono.just(serviceInstance.getUri().toString()))));
  }
}
