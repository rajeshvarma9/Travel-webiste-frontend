package com.traveleasy.fullstackbackend.repository;

import com.traveleasy.fullstackbackend.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRatingRepository extends JpaRepository<Rating,Integer> {
}
