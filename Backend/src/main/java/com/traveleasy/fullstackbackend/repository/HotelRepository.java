package com.traveleasy.fullstackbackend.repository;

import com.traveleasy.fullstackbackend.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
