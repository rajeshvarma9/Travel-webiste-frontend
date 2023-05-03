package com.traveleasy.fullstackbackend.dto;

import com.traveleasy.fullstackbackend.model.Flight;
import com.traveleasy.fullstackbackend.model.Passenger;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FlightDto extends Flight {

    private Flight flightData;
    private PassengerObj passengerData;
}
