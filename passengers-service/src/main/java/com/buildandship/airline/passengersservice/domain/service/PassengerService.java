package com.buildandship.airline.passengersservice.domain.service;

import com.buildandship.airline.passengersservice.domain.model.Passenger;
import com.buildandship.airline.passengersservice.domain.repository.PassengerRepository;
import com.buildandship.airline.passengersservice.domain.resource.PassengerRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengerService {

  private final PassengerRepository repository;

  public List<Passenger> passengers() {
    return repository.findAll();
  }

  public Optional<Passenger> passenger(@NonNull String id) {
    return repository.findById(id);
  }

  public Passenger create(@NonNull PassengerRequest request) {
    final Passenger passenger =
        Passenger.builder()
            .address(request.getAddress())
            .contact(request.getContact())
            .birthDate(request.getBirthDate())
            .fidelityNumber(request.getFidelityNumber())
            .lastName(request.getLastName())
            .name(request.getName())
            .documents(request.getDocuments())
            .build();
    return repository.save(passenger);
  }

  public Passenger update(@NonNull String id, @NonNull PassengerRequest request) {
    Optional<Passenger> byId = this.repository.findById(id);
    Passenger passenger =
        byId.orElseThrow(() -> new RuntimeException("Passenger with Id " + id + " not found"))
            .fromPassengerRequest(request);
    return this.repository.save(passenger);
  }

  public void delete(@NonNull Passenger passenger) {
    this.repository.delete(passenger);
  }
}
