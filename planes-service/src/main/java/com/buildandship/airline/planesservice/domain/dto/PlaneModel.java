package com.buildandship.airline.planesservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaneModel {
  private String factory;
  private String model;
  private String name;
  private String referenceName;
}
