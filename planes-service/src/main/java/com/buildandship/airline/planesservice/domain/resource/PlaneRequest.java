package com.buildandship.airline.planesservice.domain.resource;

import com.buildandship.airline.planesservice.domain.dto.PlaneModel;
import com.buildandship.airline.planesservice.domain.dto.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaneRequest {
  private String owner;
  private PlaneModel model;
  private Set<Seat> seats;
  private String notes;
}
