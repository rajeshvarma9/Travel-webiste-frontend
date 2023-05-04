package com.traveleasy.fullstackbackend.repository;

import com.traveleasy.fullstackbackend.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<Deal,Long> {
}
