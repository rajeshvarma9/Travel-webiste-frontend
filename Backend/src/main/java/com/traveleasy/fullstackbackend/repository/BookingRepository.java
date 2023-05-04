package com.traveleasy.fullstackbackend.repository;

import com.traveleasy.fullstackbackend.model.BookingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingHistory,Long> {
}
