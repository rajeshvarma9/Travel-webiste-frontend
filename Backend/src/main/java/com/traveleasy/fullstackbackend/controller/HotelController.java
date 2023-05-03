package com.traveleasy.fullstackbackend.controller;

import com.traveleasy.fullstackbackend.dto.FlightDto;
import com.traveleasy.fullstackbackend.dto.HotelDto;
import com.traveleasy.fullstackbackend.exception.NotFoundException;
import com.traveleasy.fullstackbackend.model.*;
import com.traveleasy.fullstackbackend.repository.HotelRepository;
import com.traveleasy.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.traveleasy.fullstackbackend.controller.UserController.USER;

@RestController
@CrossOrigin("http://localhost:3000/")
public class HotelController {
    public static final String HOTEL = "hotel";
    @Autowired
    private HotelRepository HotelRepository;

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/bookhotel/{id}")
    Hotel addHotel(@RequestBody HotelDto newBooking, @PathVariable Long id) {

        User userinfo = userRepository.findById(id)
                .orElseThrow(()->new NotFoundException("User not found while booking hotel",id,USER));
        //save flight and passenger info in db
        System.out.println("USER _INFO " +userinfo);
        System.out.println("DATA FROM API " +newBooking.toString());
        Hotel hotelData = newBooking.getHotelSelectedData();
        Hotel newHotelBooking = Hotel.builder()
                .destination(hotelData.getDestination())
                .checkindate(hotelData.getCheckindate())
                .checkoutdate(hotelData.getCheckoutdate())
                .roomcount(hotelData.getRoomcount())
                .guestcount(hotelData.getGuestcount())
                .totalprice(hotelData.getTotalprice())
                .hotelname(hotelData.getHotelname())
                .hotelid(hotelData.getHotelid())
                .user(userinfo)
                .build();
        Hotel savedHotelData =   HotelRepository.save(newHotelBooking);
        System.out.println("saved deal data : "+savedHotelData.toString());
        return savedHotelData;

    }

    //To edit Hotel information need to edit this according what to change in Hotel data and when to change
    @PutMapping("/hotel/{id}")
    Hotel updateHotel(@RequestBody Hotel newHotel, @PathVariable Long id){
        return HotelRepository.findById(id)
                .map(hotel -> {
                   hotel.setDestination(newHotel.getDestination());
                   hotel.setCheckindate(newHotel.getCheckindate());
                   hotel.setCheckoutdate(newHotel.getCheckoutdate());
                   hotel.setTotalprice(newHotel.getTotalprice());
                   hotel.setRoomcount(newHotel.getRoomcount());
                   hotel.setGuestcount(newHotel.getGuestcount());
                    return HotelRepository.save(hotel);
                }).orElseThrow(()->new NotFoundException("",id,HOTEL));
    }
    @GetMapping("/hotels")
    List<Hotel> getAllHotels(){
        return HotelRepository.findAll();
    }
    @GetMapping("/hotel/{id}")
    Hotel getHotelById(@PathVariable Long id){
        return HotelRepository.findById(id)
                .orElseThrow(()->new NotFoundException("",id,HOTEL));
    }

    @DeleteMapping("/hotel/{id}")
    String deleteHotelById(@PathVariable long id){
        if(!HotelRepository.existsById(id)){
            throw new NotFoundException("",id,HOTEL);
        }
        HotelRepository.deleteById(id);
        return "Hotel with "+id+" has been deleted successfully";
    }

}
