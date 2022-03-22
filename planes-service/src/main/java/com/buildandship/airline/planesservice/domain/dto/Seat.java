package com.buildandship.airline.planesservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
  
  private String identity;
  private Integer row;
  private SeatIdentity rightSide;
  private SeatIdentity leftSide;
  private Category category;
  
}
