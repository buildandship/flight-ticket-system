package com.buildandship.airline.flightsservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plane {

private String id;
private PlaneModel model;
private Set<Seat> seats;

}
