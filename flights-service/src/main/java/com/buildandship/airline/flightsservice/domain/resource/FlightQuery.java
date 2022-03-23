package com.buildandship.airline.flightsservice.domain.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightQuery {
  private String from;
  private String to;
  private String departureAt;
  private String arriveAt;
}
