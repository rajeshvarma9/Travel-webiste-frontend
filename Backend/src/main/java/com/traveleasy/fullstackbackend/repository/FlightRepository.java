package com.traveleasy.fullstackbackend.repository;

import com.traveleasy.fullstackbackend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}
