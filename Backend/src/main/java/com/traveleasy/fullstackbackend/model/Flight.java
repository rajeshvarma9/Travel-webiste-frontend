package com.traveleasy.fullstackbackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    private String airline;
    private String departureCityName;
    private String arrivalCityName;
    private Date departureDate;
    private Date returnDate;
    private TripType tripType;//ONEWAY OR ROUND TRIP
    private FlightType flightType;//DOMESTIC OR INTERNATIONAL
    private int price;
    private int miles;
    private String flightNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Passenger> passengersList;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;


}
