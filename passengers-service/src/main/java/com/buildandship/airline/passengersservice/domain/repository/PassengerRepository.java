package com.buildandship.airline.passengersservice.domain.repository;

import com.buildandship.airline.passengersservice.domain.model.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends MongoRepository<Passenger, String> {
}
