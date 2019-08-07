package com.radoslaw.dauksza.travelers.hotel.repository;

import com.radoslaw.dauksza.travelers.hotel.domain.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, Long> {
}
