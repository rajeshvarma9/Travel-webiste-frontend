package com.traveleasy.fullstackbackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "Users")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mailingAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Card> cards;

    //mile history
    @OneToOne(cascade = CascadeType.ALL)
    private UserMiles userMiles;

    //rating info
    @OneToOne(cascade = CascadeType.ALL)
    private Rating userRating;

    //booking history -- yet to create
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<BookingHistory> bookingHistory;
}
