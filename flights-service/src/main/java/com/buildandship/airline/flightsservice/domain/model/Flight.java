package com.buildandship.airline.flightsservice.domain.model;

import com.buildandship.airline.flightsservice.domain.dto.Airport;
import com.buildandship.airline.flightsservice.domain.dto.Connection;
import com.buildandship.airline.flightsservice.domain.dto.Plane;
import com.buildandship.airline.flightsservice.domain.dto.RegularPrice;
import com.buildandship.airline.flightsservice.domain.resource.FlightRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Document(value = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
  @Id private String id;
  private Airport from;
  private Airport to;
  private LocalDateTime departureAt;
  private LocalDateTime arriveAt;
  private Plane plane;
  private Set<Connection> connections;
  private Set<RegularPrice> prices;

  private static final DateTimeFormatter FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  @Builder
  public static Flight newFlight(
      Airport from,
      Airport to,
      String departureAt,
      String arriveAt,
      Plane plane,
      Set<Connection> connections,
      Set<RegularPrice> prices) {
    Flight newFlight = new Flight();
    newFlight.from = from;
    newFlight.to = to;
    newFlight.departureAt = LocalDateTime.parse(departureAt, FORMATTER);
    newFlight.arriveAt = LocalDateTime.parse(arriveAt, FORMATTER);
    newFlight.plane = plane;
    newFlight.connections = connections;
    newFlight.prices = prices;
    return newFlight;
  }
  
  public Flight fromFlightRequest(FlightRequest request){
    this.from = request.getFrom();
    this.to = request.getTo();
    this.departureAt = LocalDateTime.parse(request.getDepartureAt(), FORMATTER);
    this.arriveAt = LocalDateTime.parse(request.getArriveAt(), FORMATTER);
    this.connections = request.getConnections();
    return this;
  
  }
}
