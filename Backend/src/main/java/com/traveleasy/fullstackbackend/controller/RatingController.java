package com.traveleasy.fullstackbackend.controller;

import com.traveleasy.fullstackbackend.dto.RatingDto;
import com.traveleasy.fullstackbackend.exception.NotFoundException;
import com.traveleasy.fullstackbackend.model.Card;
import com.traveleasy.fullstackbackend.model.Rating;
import com.traveleasy.fullstackbackend.model.User;
import com.traveleasy.fullstackbackend.repository.RatingRepository;
import com.traveleasy.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.traveleasy.fullstackbackend.controller.UserController.USER;

@RestController
@CrossOrigin("http://localhost:3000/")
public class RatingController {

    public static final String RATING = "rating";
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/allratings")
    private List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @GetMapping("/rating/{id}")
    private Rating getRating(@PathVariable Long id) {
        return ratingRepository.findById(id).orElseThrow(() -> new NotFoundException("", id, RATING));
    }

    @PostMapping("/userrating/{id}")
    private Rating addRating(@RequestBody  RatingDto newRating, @PathVariable Long id) {

        User userinfo = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User is not found while saving rating", id, USER));
        System.out.println("USER _INFO in RATING CONTROLLER " + userinfo);
        System.out.println("Rating Data from UI "+newRating.toString());
        //save user rating
        Rating ratingData = Rating.builder()
                .ratingComments(newRating.getComments())
                .ratingNumber(newRating.getUserRating())
                .user(userinfo)
                .build();
        return ratingRepository.save(ratingData);
    }

//    @PutMapping("/editrating/{id}")
//    private Rating editRating(@PathVariable Long id, Rating newRating) {
//        return ratingRepository.findById(id).map(userrating -> {
//            userrating.setRatingNumber(newRating.getRatingNumber());
//            userrating.setRatingComments(newRating.getRatingComments());
//            return ratingRepository.save(userrating);
//        }).orElseThrow(() -> new NotFoundException("", id, RATING));
//    }

    @DeleteMapping("/deleterating/{id}")
    private void deleteRating(@PathVariable Long id) {
        ratingRepository.deleteById(id);
    }
}
