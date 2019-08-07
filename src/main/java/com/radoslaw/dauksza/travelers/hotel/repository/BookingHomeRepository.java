package com.radoslaw.dauksza.travelers.hotel.repository;

import com.radoslaw.dauksza.travelers.hotel.domain.BookingHome;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookingHomeRepository extends CrudRepository<BookingHome, Long> {
}
