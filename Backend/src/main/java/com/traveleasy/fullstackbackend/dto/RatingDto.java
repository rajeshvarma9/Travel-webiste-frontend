package com.traveleasy.fullstackbackend.dto;

import com.traveleasy.fullstackbackend.model.Rating;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RatingDto extends Rating {

    private String comments;
    private int userRating;


}
