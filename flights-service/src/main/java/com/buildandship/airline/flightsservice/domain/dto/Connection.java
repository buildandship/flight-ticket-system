package com.buildandship.airline.flightsservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Connection {
  private Airport from;
  private Airport to;
  private LocalDateTime departureAt;
  private LocalDateTime arriveAt;
  private Integer order;
}
