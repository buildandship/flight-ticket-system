package com.buildandship.airline.flightsservice.domain.service;

import com.buildandship.airline.flightsservice.domain.dto.Plane;
import com.buildandship.airline.flightsservice.domain.model.Flight;
import com.buildandship.airline.flightsservice.domain.repository.FlightRepository;
import com.buildandship.airline.flightsservice.domain.resource.FlightQuery;
import com.buildandship.airline.flightsservice.domain.resource.FlightRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {

  private static final DateTimeFormatter FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  private final FlightRepository flightRepository;
  private final PlaneService planeService;

  public List<Flight> flights() {
    return flightRepository.findAll();
  }

  public Optional<Flight> flight(@NonNull String id) {
    return flightRepository.findById(id);
  }
  
  public Flight create(@NonNull FlightRequest flightRequest) {
    Plane plane = this.planeService.plane(flightRequest.getPlaneId());
    return this.flightRepository.save(
        Flight.builder()
            .from(flightRequest.getFrom())
            .to(flightRequest.getTo())
            .plane(plane)
            .arriveAt(flightRequest.getArriveAt())
            .departureAt(flightRequest.getDepartureAt())
            .connections(flightRequest.getConnections())
            .prices(flightRequest.getPrices())
            .build());
  }

  public Flight update(@NonNull String id, @NonNull FlightRequest flightRequest) {
    Optional<Flight> byId = this.flightRepository.findById(id);
    Flight flight =
        byId.orElseThrow(() -> new RuntimeException("Flight with Id " + id + " not found!!!"))
            .fromFlightRequest(flightRequest);
    return this.flightRepository.save(flight);
  }

  public void delete(@NonNull Flight flight) {
    this.flightRepository.delete(flight);
  }

  public Flight flightBy(@NonNull FlightQuery query) {
    final LocalDateTime departureAt = LocalDateTime.parse(query.getDepartureAt(), FORMATTER);
    final LocalDateTime arriveAt = LocalDateTime.parse(query.getArriveAt(), FORMATTER);
    return this.flightRepository.findByFromCodeAndToCodeAndDepartureAtAfterAndAndArriveAtBefore(
        query.getFrom(), query.getTo(), departureAt, arriveAt);
  }
}
