package com.buildandship.airline.passengersservice.domain.resource;

import com.buildandship.airline.passengersservice.domain.model.Passenger;
import com.buildandship.airline.passengersservice.domain.service.PassengerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passenger")
@RequiredArgsConstructor
@Slf4j
public class PassengerController {

  private final PassengerService service;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Passenger> passengers() {
    return service.passengers();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Passenger> passengerById(@PathVariable("id") String id) {
    Passenger passenger =
        service
            .passenger(id)
            .orElseThrow(
                () -> new RuntimeException("Passenger with the Id : " + id + " not found"));
    return ResponseEntity.ok().body(passenger);
  }
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Passenger createPassenger(@RequestBody PassengerRequest request){
    return service.create(request);
  }
  
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Passenger updatePassenger(@PathVariable("id") String id, @RequestBody PassengerRequest request){
    return service.update(id,request);
  }
  
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<String> deletePassenger(@PathVariable("id") String id){
    Passenger passenger = service.passenger(id).orElseThrow(()-> new RuntimeException("Passenger with id : "+id+" not found!!!"));
    service.delete(passenger);
    return ResponseEntity.ok().body("Passenger deleted successfully");
  }
  
}
