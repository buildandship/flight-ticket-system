package com.buildandship.airline.flightsservice.domain.repository;

import com.buildandship.airline.flightsservice.domain.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {

  Flight findByFromCodeAndToCodeAndDepartureAtAfterAndAndArriveAtBefore(
      String fromCode, String toCode, LocalDateTime departure, LocalDateTime arriveAt);
}
