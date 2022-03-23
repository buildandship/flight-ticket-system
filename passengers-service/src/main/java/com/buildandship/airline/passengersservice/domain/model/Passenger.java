package com.buildandship.airline.passengersservice.domain.model;

import com.buildandship.airline.passengersservice.domain.dto.Address;
import com.buildandship.airline.passengersservice.domain.dto.Contact;
import com.buildandship.airline.passengersservice.domain.dto.PassengerDocument;
import com.buildandship.airline.passengersservice.domain.resource.PassengerRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Document(value = "passengers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger {
  @Id private String id;
  private String name;
  private String lastName;
  private String fidelityNumber;
  private Set<PassengerDocument> documents;
  private Address address;
  private LocalDate birthDate;
  private Contact contact;

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");

  @Builder
  public static Passenger newPassenger(
      String name,
      String lastName,
      String fidelityNumber,
      Set<PassengerDocument> documents,
      Address address,
      String birthDate,
      Contact contact) {
    final Passenger passenger = new Passenger();
    passenger.setName(name);
    passenger.setLastName(lastName);
    passenger.setFidelityNumber(fidelityNumber);
    passenger.setContact(contact);
    passenger.setAddress(address);
    passenger.setDocuments(documents);
    passenger.setBirthDate(LocalDate.parse(birthDate, FORMATTER));
    return passenger;
  }

  public Passenger fromPassengerRequest(PassengerRequest passengerRequest) {
    this.name = passengerRequest.getName();
    this.lastName = passengerRequest.getLastName();
    this.fidelityNumber = passengerRequest.getFidelityNumber();
    this.contact = passengerRequest.getContact();
    this.address = passengerRequest.getAddress();
    this.documents = passengerRequest.getDocuments();
    this.birthDate = LocalDate.parse(passengerRequest.getBirthDate().toString(), FORMATTER);
    return this;
  }
}
