package com.buildandship.airline.flightsservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airport {

  private String name;
  private String code;
  private String city;
  private String country;
}
