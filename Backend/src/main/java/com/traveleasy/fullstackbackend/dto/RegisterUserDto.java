package com.traveleasy.fullstackbackend.dto;

import com.traveleasy.fullstackbackend.model.Card;
import com.traveleasy.fullstackbackend.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RegisterUserDto extends User {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mailingAddress;
    private Card card;


}
