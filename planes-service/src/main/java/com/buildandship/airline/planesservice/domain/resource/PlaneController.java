package com.buildandship.airline.planesservice.domain.resource;

import com.buildandship.airline.planesservice.domain.exception.PlaneNotFoundException;
import com.buildandship.airline.planesservice.domain.model.Plane;
import com.buildandship.airline.planesservice.domain.service.PlaneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plane")
@RequiredArgsConstructor
@Slf4j
public class PlaneController {

  private final PlaneService service;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Plane> planes() {
    return service.planes();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Plane> plane(@PathVariable("id") String id) {
    Plane plane =
        service
            .plane(id)
            .orElseThrow(() -> new PlaneNotFoundException("Plane with ID : " + id + " not found"));
    return ResponseEntity.ok().body(plane);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Plane createPlane(@RequestBody PlaneRequest request) {
    return service.create(request);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Plane updatePlane(@PathVariable("id") String id, @RequestBody PlaneRequest request) {
    return service.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<String> deletePlane(@PathVariable("id") String id) {
    Plane plane =
        service
            .plane(id)
            .orElseThrow(
                () -> new PlaneNotFoundException("Plane with ID : " + id + " not found!!"));
    service.delete(plane);
    return ResponseEntity.ok().body("Successfully deleted the plane!!!");
  }
}
