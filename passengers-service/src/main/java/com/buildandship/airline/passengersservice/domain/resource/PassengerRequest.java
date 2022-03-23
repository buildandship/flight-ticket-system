package com.buildandship.airline.passengersservice.domain.resource;

import com.buildandship.airline.passengersservice.domain.dto.Address;
import com.buildandship.airline.passengersservice.domain.dto.Contact;
import com.buildandship.airline.passengersservice.domain.dto.PassengerDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerRequest {
  private String name;
  private String lastName;
  private String fidelityNumber;
  private Set<PassengerDocument> documents;
  private Address address;
  private LocalDate birthDate;
  private Contact contact;
}
