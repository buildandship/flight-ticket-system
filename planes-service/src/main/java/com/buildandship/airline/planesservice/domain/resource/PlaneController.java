package com.buildandship.airline.planesservice.domain.resource;

import com.buildandship.airline.planesservice.domain.exception.PlaneNotFoundException;
import com.buildandship.airline.planesservice.domain.model.Plane;
import com.buildandship.airline.planesservice.domain.service.PlaneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
@RequiredArgsConstructor
@Slf4j
public class PlaneController {

  private final PlaneService service;

  @Operation(summary = "Get a all planes")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Found all the planes",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Plane.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Planes are available",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Plane not found", content = @Content)
      })
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Plane> planes() {
    return service.planes();
  }

  @Operation(summary = "Get a plane by its id")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Found the plane",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Plane.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid plane id supplied",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Plane not found", content = @Content)
      })
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Plane> plane(@PathVariable("id") String id) {
    Plane plane =
        service
            .plane(id)
            .orElseThrow(() -> new PlaneNotFoundException("Plane with ID : " + id + " not found"));
    return ResponseEntity.ok().body(plane);
  }

  @Operation(summary = "Create the plane with details")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "201",
            description = "Created the plane successfully",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Plane.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid plane information supplied",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Plane not saved", content = @Content)
      })
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Plane createPlane(@RequestBody PlaneRequest request) {
    return service.create(request);
  }

  @Operation(summary = "Update the plane with details")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "201",
            description = "Updated the plane details successfully",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Plane.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid plane information supplied",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Plane not saved", content = @Content)
      })
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Plane updatePlane(@PathVariable("id") String id, @RequestBody PlaneRequest request) {
    return service.update(id, request);
  }

  @Operation(summary = "Delete the plane with given id")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "204",
            description = "Deleted the plane successfully",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Plane.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid plane id information supplied",
            content = @Content),
        @ApiResponse(
            responseCode = "404",
            description = "Plane not deleted successfully",
            content = @Content)
      })
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
