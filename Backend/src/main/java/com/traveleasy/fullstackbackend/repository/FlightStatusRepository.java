package com.traveleasy.fullstackbackend.repository;

import com.traveleasy.fullstackbackend.model.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightStatusRepository extends JpaRepository<FlightStatus,Long> {
}
