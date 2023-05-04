package com.traveleasy.fullstackbackend.controller;

import com.traveleasy.fullstackbackend.dto.FlightDto;
import com.traveleasy.fullstackbackend.exception.NotFoundException;
import com.traveleasy.fullstackbackend.model.Flight;
import com.traveleasy.fullstackbackend.model.Passenger;
import com.traveleasy.fullstackbackend.model.User;
import com.traveleasy.fullstackbackend.model.UserMiles;
import com.traveleasy.fullstackbackend.repository.FlightRepository;
import com.traveleasy.fullstackbackend.repository.UserMilesRepository;
import com.traveleasy.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.traveleasy.fullstackbackend.controller.UserController.USER;

@RestController
@CrossOrigin("http://localhost:3000/")
public class FlightController {
    public static final String FLIGHT = "flight";
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMilesRepository userMilesRepository;

    @PostMapping("/bookflightmiles/{id}")
    Flight bookFlightwithMiles(@RequestBody FlightDto newBooking, @PathVariable Long id) {

        User userinfo = userRepository.findById(id)
                .orElseThrow(()->new NotFoundException("",id,USER));
        //save flight and passenger info in db
        System.out.println("USER _INFO with miles booking " +userinfo);
        System.out.println("DATA FROM API with miles booking " +newBooking.getPassengerData().getList());
        List<Passenger> passengerList = new ArrayList<>();
        passengerList.addAll(newBooking.getPassengerData().getList());
        System.out.println("Passenger Data in save Flight with miles booking : "+passengerList.toString());
        Flight data = newBooking.getFlightData();
        Flight newFlightBooking = Flight.builder()
                .flightNumber(data.getFlightNumber())
                .airline(data.getAirline())
                .miles(data.getMiles())
                .arrivalCityName(data.getArrivalCityName())
                .departureCityName(data.getDepartureCityName())
                .departureDate(data.getDepartureDate())
                .returnDate(data.getReturnDate())
                .price(0)
                .passengersList(passengerList)
                .user(userinfo)
                .build();
        Flight savedFlightData =   flightRepository.save(newFlightBooking);
        System.out.println("User miles info while booking flight with miles : "+userinfo.getUserMiles().toString());
        int total_availbleMiles = userinfo.getUserMiles() !=null
                ? userinfo.getUserMiles().getMilesRemaining()
                : 0;

        if(savedFlightData != null){
            //addd miles to user miles after booking a flight
            int flightbookingMiles = passengerList.size() * 15000;
            int usermilesID = userinfo.getUserMiles().getId();
            UserMiles userMiles = userMilesRepository.findAll().stream()
                    .filter(miles-> miles.getId() == usermilesID)
                    .findFirst().get();
            System.out.println("user miles using filter by id "+userMiles.toString());
            userMiles.setMilesRemaining(total_availbleMiles - data.getMiles());
            userMiles.setMilesRedeemed(userMiles.getMilesRedeemed() + data.getMiles());
            userMiles.setMilesEarned(flightbookingMiles + userMiles.getMilesEarned());
//            userMiles.setMilesRemaining(userMiles.getMilesEarned()-flightbookingMiles);

            userinfo.setUserMiles(userMiles);
            User updatedUser = userRepository.save(userinfo);
            System.out.println("Updated user with miles infomartion : "+updatedUser.toString());
        }
        System.out.println("saved flight data : "+savedFlightData.toString());
        return savedFlightData;
    }

    @PostMapping("/bookflight/{id}")
    Flight addFlight(@RequestBody FlightDto newBooking, @PathVariable Long id){

        User userinfo = userRepository.findById(id)
                .orElseThrow(()->new NotFoundException("",id,USER));
        //save flight and passenger info in db
        System.out.println("USER _INFO " +userinfo);
        System.out.println("DATA FROM API " +newBooking.getPassengerData().getList());
        List<Passenger> passengerList = new ArrayList<>();
        passengerList.addAll(newBooking.getPassengerData().getList());
        System.out.println("Passenger Data in save Flight booking : "+passengerList.toString());
        Flight data = newBooking.getFlightData();
        Flight newFlightBooking = Flight.builder()
                .flightNumber(data.getFlightNumber())
                .airline(data.getAirline())
                .miles(0)
                .arrivalCityName(data.getArrivalCityName())
                .departureCityName(data.getDepartureCityName())
                .departureDate(data.getDepartureDate())
                .returnDate(data.getReturnDate())
                .price(data.getPrice())
                .passengersList(passengerList)
                .user(userinfo)
                .build();
        Flight savedFlightData =   flightRepository.save(newFlightBooking);
        //get all milesdata for that user
//        System.out.println("Miles Data : "+userMilesRepository.findAll().size());
//        userMilesRepository.findAll().stream()
//                .forEach(e->System.out.println(e.toString()));
        System.out.println("User miles info while booking flight : "+userinfo.getUserMiles().toString());
        int total_availbleMiles = userinfo.getUserMiles() !=null
                ? userinfo.getUserMiles().getMilesRemaining()
                : 0;

//        userRepository.

//        List<UserMiles> userMilesList = userMilesRepository.findAll().stream()
//                .filter(miles-> miles.getUser().getId() == id)
//                .collect(Collectors.toList());

        //get toal miles remaining for that user
//         int total_availbleMiles = userMilesList.size() > 0 ?userMilesList.stream()
//                .map(userMiles -> userMiles.getMilesRemaining())
//                .mapToInt(Integer::intValue)
//                .sum()
//                 : 0;

        if(savedFlightData != null){
            //addd miles to user miles after booking a flight
            int flightbookingMiles = passengerList.size() * 15000;
            int usermilesID = userinfo.getUserMiles().getId();
            UserMiles userMiles = userMilesRepository.findAll().stream()
                .filter(miles-> miles.getId() == usermilesID)
                        .findFirst().get();
            System.out.println("user miles using filter by id "+userMiles.toString());
            userMiles.setMilesRemaining(total_availbleMiles +flightbookingMiles);
            userMiles.setMilesEarned(flightbookingMiles + userMiles.getMilesEarned());


//                    UserMiles.builder()
//                    .milesEarned(prebookingMiles)
//                    .milesRemaining(total_availbleMiles +prebookingMiles)
//                    .build();
//            userMilesRepository.save(userMiles);
            userinfo.setUserMiles(userMiles);
            User updatedUser = userRepository.save(userinfo);
            System.out.println("Updated user with miles infomartion : "+updatedUser.toString());
        }

        System.out.println("saved flight data : "+savedFlightData.toString());
        return savedFlightData;
    }

    //To edit flight information need to edit this according what to change in flight data and when to change
//    @PutMapping("/flight/{id}")
//    Flight updateFlight(@RequestBody Flight newFlight, @PathVariable Long id){
//        return flightRepository.findById(id)
//                .map(flight -> {
//                    flight.setAirlineName(newFlight.getAirlineName());
////                    flight.setMiles(newFlight.getMiles());
//                    flight.setSource(newFlight.getSource());
//                    flight.setDestination(newFlight.getDestination());
//                    flight.setDepartureDate(newFlight.getDepartureDate());
//                    flight.setReturnDate(newFlight.getReturnDate());
////                    flight.setPrice(newFlight.getPrice());
//                    return flightRepository.save(flight);
//                }).orElseThrow(()->new NotFoundException(id,FLIGHT));
//    }
    @GetMapping("/flights")
    List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }
    @GetMapping("/flight/{id}")
    Flight getFlightById(@PathVariable Long id){
        return flightRepository.findById(id)
                .orElseThrow(()->new NotFoundException("",id,FLIGHT));
    }

    @DeleteMapping("/flight/{id}")
    String deleteFlightById(@PathVariable long id){
        if(!flightRepository.existsById(id)){
            throw new NotFoundException("",id,FLIGHT);
        }
        flightRepository.deleteById(id);
        return "Flight with "+id+" has been deleted successfully";
    }


}
