package com.traveleasy.fullstackbackend.repository;

import com.traveleasy.fullstackbackend.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
