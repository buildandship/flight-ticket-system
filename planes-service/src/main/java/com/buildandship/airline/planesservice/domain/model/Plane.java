package com.buildandship.airline.planesservice.domain.model;

import com.buildandship.airline.planesservice.domain.dto.PlaneModel;
import com.buildandship.airline.planesservice.domain.dto.Seat;
import com.buildandship.airline.planesservice.domain.resource.PlaneRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(value = "planes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Plane {

  @Id private String id;
  private String owner;
  private PlaneModel model;
  private Set<Seat> seats;
  private String notes;

  public static Plane newPlane(String owner, PlaneModel model, Set<Seat> seats, String notes) {
    Plane plane = new Plane();
    plane.owner = owner;
    plane.model = model;
    plane.seats = seats;
    plane.notes = notes;
    return plane;
  }

  public Plane fromPlaneRequest(@NonNull PlaneRequest request) {
    this.owner = request.getOwner();
    this.model = request.getModel();
    this.seats = request.getSeats();
    this.notes = request.getNotes();
    return this;
  }
}
