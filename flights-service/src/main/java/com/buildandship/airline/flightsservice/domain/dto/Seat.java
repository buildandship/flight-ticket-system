package com.buildandship.airline.flightsservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
  private String identity;
  private Integer row;
  private Category category;
}
