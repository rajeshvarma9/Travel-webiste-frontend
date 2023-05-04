package com.traveleasy.fullstackbackend.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Deal {
    @Id
    @GeneratedValue
    private Long id;
    private String dealName;
    private String departureCityName;
    private String arrivalCityName;
    private Timestamp departureDate;
    private Timestamp arrivalDate;
    private int minPrice;
    private int maxPrice;
    private int deals_price;
    private int miles;
    private String airline;
    private String arrivalTime;
    private String departureTime;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;


}
