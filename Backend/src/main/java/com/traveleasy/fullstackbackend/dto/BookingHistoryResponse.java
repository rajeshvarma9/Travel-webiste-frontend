package com.traveleasy.fullstackbackend.dto;

import com.traveleasy.fullstackbackend.model.Deal;
import com.traveleasy.fullstackbackend.model.Flight;
import com.traveleasy.fullstackbackend.model.Hotel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingHistoryResponse {


    private List<Flight> flights;
    private List<Deal> deals;
    private List<Hotel> hotels;


}
