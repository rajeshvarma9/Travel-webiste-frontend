package com.traveleasy.fullstackbackend.model;

import lombok.*;
import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookingHistory {
    @GeneratedValue
    @Id
    private int bookingId;
//    private int paymentId;


//    private Flight flightInfo;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User userInfo;
//    private Hotel hotelInfo;

}
