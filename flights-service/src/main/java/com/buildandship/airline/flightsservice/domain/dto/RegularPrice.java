package com.buildandship.airline.flightsservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegularPrice {
  private Category targetCategory;
  private BigDecimal price;
}
