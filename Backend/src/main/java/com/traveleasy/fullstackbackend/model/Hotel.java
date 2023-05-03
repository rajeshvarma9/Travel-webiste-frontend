package com.traveleasy.fullstackbackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    @Id
    @GeneratedValue
    private Long id;
    private String destination;
    private Date checkindate;
    private Date checkoutdate;
    private int roomcount;
    private int guestcount;
    private int totalprice;
    private String hotelname;
    private String hotelid;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;


}
