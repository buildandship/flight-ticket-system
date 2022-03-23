package com.buildandship.airline.flightsservice.domain.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvailableSeats {
  private Long available;
  private String flightId;
}
