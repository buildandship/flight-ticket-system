package com.buildandship.airline.passengersservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String country;
}
