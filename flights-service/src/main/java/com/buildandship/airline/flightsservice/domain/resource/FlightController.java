package com.buildandship.airline.flightsservice.domain.resource;

import com.buildandship.airline.flightsservice.domain.dto.Plane;
import com.buildandship.airline.flightsservice.domain.model.Flight;
import com.buildandship.airline.flightsservice.domain.service.FlightService;
import com.buildandship.airline.flightsservice.domain.service.PlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/flight")
@RequiredArgsConstructor
public class FlightController {

  private final FlightService flightService;
  private final PlaneService planeService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Flight> flights() {
    return flightService.flights();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Flight> flight(@PathVariable("id") String id) {
    Flight flight =
        flightService
            .flight(id)
            .orElseThrow(() -> new RuntimeException("Flight with Id " + id + " not found!!!"));
    return ResponseEntity.ok().body(flight);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Flight createFlight(@RequestBody FlightRequest request, UriComponentsBuilder uriBuilder) {
    //FIXME
    URI uri = uriBuilder.path("/flights/{id}").build().toUri();
    Plane plane = this.planeService.plane(uri.toString());
    request.setPlaneId(plane.getId());
    return flightService.create(request);
  /*
    return this.flightService.create(request).map(data -> {
      URI location = uriBuilder.path("/flights/{id}")
              .buildAndExpand(data.getId())
              .toUri();
      return ResponseEntity.created(location).build();
    }
    );*/

  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Flight updateFlight(@PathVariable("id") String id, @RequestBody FlightRequest request) {
   return this.flightService.update(id,request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<String> deleteFlight(@PathVariable("id") String id) {
    Flight flight =
        flightService
            .flight(id)
            .orElseThrow(() -> new RuntimeException("Flight with Id " + id + " not found!!!"));
    flightService.delete(flight);
    return ResponseEntity.ok().body("Successfully delete the flight!!!");
  }
}
