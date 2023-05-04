package com.traveleasy.fullstackbackend.controller;

import com.traveleasy.fullstackbackend.exception.NotFoundException;
import com.traveleasy.fullstackbackend.model.Deal;
import com.traveleasy.fullstackbackend.model.Flight;
import com.traveleasy.fullstackbackend.model.User;
import com.traveleasy.fullstackbackend.repository.DealRepository;
import com.traveleasy.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.traveleasy.fullstackbackend.dto.DealDto;

import java.util.List;
import java.util.Optional;

import static com.traveleasy.fullstackbackend.controller.UserController.USER;

@RestController
@CrossOrigin("http://localhost:3000/")
public class DealController {
    public static final String DEAL = "Deal";
    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/bookdeal/{id}")
    private Deal addDeal(@RequestBody DealDto newDealData, @PathVariable Long id){

        User userinfo = userRepository.findById(id)
                .orElseThrow(()->new NotFoundException("",id,USER));
        //save flight and passenger info in db
        System.out.println("USER _INFO " +userinfo);
        System.out.println("DATA FROM API " +newDealData.toString());
        Deal dealData = newDealData.getDeal();
        Deal newDealBooking = Deal.builder()
                .departureDate(dealData.getDepartureDate())
                .arrivalDate(dealData.getArrivalDate())
                .deals_price(dealData.getDeals_price())
                .miles(dealData.getMiles())
                .departureCityName(dealData.getDepartureCityName())
                .arrivalCityName(dealData.getArrivalCityName())
                .airline(dealData.getAirline())
                .departureTime(dealData.getDepartureTime())
                .arrivalTime(dealData.getArrivalTime())
                .user(userinfo)
                .build();
        Deal savedDealData =   dealRepository.save(newDealBooking);
        System.out.println("saved deal data : "+savedDealData.toString());
        return savedDealData;
    }

//    @PutMapping("/deal/{id}")
//    private Deal editDeal(Deal editDeal,@PathVariable Long id){
//        return dealRepository.findById(id).map(dealdata -> {
//            dealdata.setDealMiles(editDeal.getDealMiles());
//            dealdata.setDealPrice(editDeal.getDealPrice());
//            dealdata.setDealName(editDeal.getDealName());
//            return dealRepository.save(dealdata);
//        }).orElseThrow(() -> new NotFoundException("",id, DEAL));
//    }

    @GetMapping("/deals")
    private List<Deal> getAllDeals(){
        return dealRepository.findAll();
    }
    @GetMapping("/deal/{id}")
    private Deal getDeal(@PathVariable Long id){
        return dealRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("",id,DEAL));
    }

    @DeleteMapping("/deal/{id}")
    private String deleteDeal(@PathVariable Long id){
        if(!dealRepository.existsById(id)){
            throw new NotFoundException("",id,DEAL);
        }
        dealRepository.deleteById(id);
        return "Deal with "+id+" has been deleted successfully";
    }
}
