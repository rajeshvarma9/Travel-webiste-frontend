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
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private Long cardNumber;
    private String expiryDate;
    private int cvv;
    @Enumerated(EnumType.STRING)
    private CardType cardType;
    private String cardOwnerName;
    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
