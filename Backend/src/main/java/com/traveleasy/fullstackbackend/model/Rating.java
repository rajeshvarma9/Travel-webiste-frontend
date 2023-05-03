package com.traveleasy.fullstackbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    @Id
    @GeneratedValue
    private Long id;
    private int ratingNumber;
    private String ratingComments;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
