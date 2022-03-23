package com.buildandship.airline.passengersservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
  private String email;
  private String phone;
  private String alternatePhone;
}
