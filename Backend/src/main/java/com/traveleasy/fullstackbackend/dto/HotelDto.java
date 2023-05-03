package com.traveleasy.fullstackbackend.dto;

import com.traveleasy.fullstackbackend.model.Card;
import com.traveleasy.fullstackbackend.model.Deal;
import com.traveleasy.fullstackbackend.model.Hotel;
import com.traveleasy.fullstackbackend.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HotelDto extends Hotel {

    private User userData;
    private Card cardData;
    private Hotel hotelSelectedData;
}
