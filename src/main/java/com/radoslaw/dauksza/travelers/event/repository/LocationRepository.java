package com.radoslaw.dauksza.travelers.event.repository;

import com.radoslaw.dauksza.travelers.event.domain.Location;
import com.radoslaw.dauksza.travelers.event.domain.LocationId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("EventLocationRepository")
public interface LocationRepository extends CrudRepository<Location, LocationId> {
}
