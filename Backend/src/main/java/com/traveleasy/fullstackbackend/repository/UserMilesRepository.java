package com.traveleasy.fullstackbackend.repository;

import com.traveleasy.fullstackbackend.model.UserMiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMilesRepository extends JpaRepository<UserMiles,Integer> {
}
