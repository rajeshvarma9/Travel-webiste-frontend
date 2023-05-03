package com.traveleasy.fullstackbackend.dto;

import com.traveleasy.fullstackbackend.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUserDto extends User {

    private String username;
    private String password;
}
