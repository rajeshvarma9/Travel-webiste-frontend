package com.traveleasy.fullstackbackend.repository;

import com.traveleasy.fullstackbackend.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Long> {
}
