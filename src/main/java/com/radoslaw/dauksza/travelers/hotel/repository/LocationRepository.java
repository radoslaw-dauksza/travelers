package com.radoslaw.dauksza.travelers.hotel.repository;

import com.radoslaw.dauksza.travelers.hotel.domain.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
