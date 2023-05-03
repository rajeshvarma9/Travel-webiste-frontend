package com.traveleasy.fullstackbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMiles {
    @Id
    @GeneratedValue
    private int id;
    private int milesEarned = 0;
    private int milesRedeemed = 0;
    private int milesRemaining = 0;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
