package com.traveleasy.fullstackbackend.controller;

import com.traveleasy.fullstackbackend.dto.BookingHistoryResponse;
import com.traveleasy.fullstackbackend.exception.NotFoundException;
import com.traveleasy.fullstackbackend.model.*;
import com.traveleasy.fullstackbackend.repository.DealRepository;
import com.traveleasy.fullstackbackend.repository.FlightRepository;
import com.traveleasy.fullstackbackend.repository.HotelRepository;
import com.traveleasy.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.traveleasy.fullstackbackend.controller.UserController.USER;

@RestController
@CrossOrigin("http://localhost:3000/")
public class BookingController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private DealRepository dealRepository;

    @GetMapping("/userbookinghistory/{id}")
    private BookingHistoryResponse getBookingHistory(@PathVariable Long id){
        List<Deal> deals = dealRepository.findAll();
        List<Flight> flights = flightRepository.findAll();
        List<Hotel> hotels = hotelRepository.findAll();
        User userinfo = userRepository.findById(id)
                .orElseThrow(()->new NotFoundException("",id,USER));
        System.out.println("USER _INFO in booking history " +userinfo);
        BookingHistoryResponse response = new BookingHistoryResponse();
        System.out.println("deals size "+deals.size() +
                "flights size " +flights.size() +
                "hotels size "+hotels.size()
        );
        if( deals != null  && deals.size() > 0){
            deals = deals.stream()
                    .filter(deal -> deal.getUser().getId()==id)
                    .collect(Collectors.toList());
//            System.out.println(deals.get(0).toString());
            response.setDeals(deals);
        }
        if(flights != null && flights.size() > 0){
            flights = flights.stream()
                    .filter(flight -> flight.getUser().getId() == id)
                    .collect(Collectors.toList());
//            System.out.println(flights.get(0).toString());
            response.setFlights(flights);
        }
        if(hotels != null && hotels.size() > 0){
            hotels = hotels.stream()
                    .filter(hotel -> hotel.getUser().getId() == id)
                    .collect(Collectors.toList());
//            System.out.println(hotels.get(0).toString());
            response.setHotels(hotels);
        }
        return response;
    }
}
