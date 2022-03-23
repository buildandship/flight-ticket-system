package com.buildandship.airline.flightsservice.domain.resource;

import com.buildandship.airline.flightsservice.domain.dto.Airport;
import com.buildandship.airline.flightsservice.domain.dto.Connection;
import com.buildandship.airline.flightsservice.domain.dto.RegularPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightRequest {
  private Airport from;
  private Airport to;
  private String departureAt;
  private String arriveAt;
  private String planeId;
  private Set<Connection> connections;
  private Set<RegularPrice> prices;
  
}
