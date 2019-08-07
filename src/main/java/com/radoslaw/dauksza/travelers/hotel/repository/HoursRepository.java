package com.radoslaw.dauksza.travelers.hotel.repository;

import com.radoslaw.dauksza.travelers.hotel.domain.Hours;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;
import java.util.Optional;

public interface HoursRepository extends CrudRepository<Hours, Long> {
}
