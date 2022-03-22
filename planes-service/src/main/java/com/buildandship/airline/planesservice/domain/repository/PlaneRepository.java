package com.buildandship.airline.planesservice.domain.repository;

import com.buildandship.airline.planesservice.domain.model.Plane;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends MongoRepository<Plane, String> {
}
