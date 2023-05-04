package com.traveleasy.fullstackbackend.controller;

import com.traveleasy.fullstackbackend.exception.NotFoundException;
import com.traveleasy.fullstackbackend.model.FlightStatus;
import com.traveleasy.fullstackbackend.repository.FlightStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightStatusController {
    public static final String FLIGHT_STATUS ="flight status";
    @Autowired
    private FlightStatusRepository flightStatusRepository;

    @GetMapping("/allflightstatus")
    List<FlightStatus> getAllUsers(){
        return flightStatusRepository.findAll();
    }
    @GetMapping("/flightstatus/{id}")
    FlightStatus getFlightStatusById(@PathVariable Long id){
        return flightStatusRepository.findById(id)
                .orElseThrow(()->new NotFoundException("",id,FLIGHT_STATUS));
    }
    @PostMapping("flightstatus")
    FlightStatus addFlightStatus(FlightStatus newflightStatus){
        return flightStatusRepository.save(newflightStatus);
    }

    @DeleteMapping("/flightstatus/{id}")
    String deleteFlightStatus(@PathVariable Long id){
        if(!flightStatusRepository.existsById(id)){
            throw new NotFoundException("",id, FLIGHT_STATUS);
        }
        flightStatusRepository.deleteById(id);
        return "Flight Status with "+id+" has been deleted successfully";
    }
    @PutMapping("/flightstatus/{id}")
    FlightStatus updateFlightStatus(@RequestBody FlightStatus newStatus, @PathVariable Long id){
        return flightStatusRepository.findById(id)
                .map(c_flight_status -> {
                    c_flight_status.setStatus(newStatus.getStatus());
                    c_flight_status.setFlightNumber(newStatus.getFlightNumber());
                    c_flight_status.setAirlineName(newStatus.getAirlineName());
                    c_flight_status.setDepartureDate(newStatus.getDepartureDate());
                    return flightStatusRepository.save(c_flight_status);
                }).orElseThrow(()->new NotFoundException("",id,FLIGHT_STATUS));
    }

}
