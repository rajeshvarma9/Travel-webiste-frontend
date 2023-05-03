package com.traveleasy.fullstackbackend.dto;

import com.traveleasy.fullstackbackend.model.Passenger;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class PassengerObj {

    private List<Passenger> list;
}
