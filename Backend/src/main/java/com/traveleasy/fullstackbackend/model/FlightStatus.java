package com.traveleasy.fullstackbackend.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FlightStatus {
    @Generated
    @Id
    private Long id;
    private String flightNumber;
    private String airlineName;
    private Date departureDate;
    private FlightStatusType status;




}
