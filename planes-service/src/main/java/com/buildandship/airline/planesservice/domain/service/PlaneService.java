package com.buildandship.airline.planesservice.domain.service;

import com.buildandship.airline.planesservice.domain.model.Plane;
import com.buildandship.airline.planesservice.domain.repository.PlaneRepository;
import com.buildandship.airline.planesservice.domain.resource.PlaneRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaneService {

  private final PlaneRepository repository;

  public List<Plane> planes() {
    return this.repository.findAll();
  }

  public Optional<Plane> plane(@NonNull String id) {
    return repository.findById(id);
  }

  public Plane create(@NonNull PlaneRequest request) {
    final Plane plane =
        Plane.builder()
            .owner(request.getOwner())
            .model(request.getModel())
            .seats(request.getSeats())
            .notes(request.getNotes())
            .build();
    return this.repository.save(plane);
  }

  public Plane update(@NonNull String id, @NonNull PlaneRequest request) {
    Optional<Plane> byId = this.repository.findById(id);
    Plane plane = byId.orElseThrow().fromPlaneRequest(request);
    return this.repository.save(plane);
  }

  public void delete(@NonNull Plane plane) {
    this.repository.delete(plane);
  }
}
