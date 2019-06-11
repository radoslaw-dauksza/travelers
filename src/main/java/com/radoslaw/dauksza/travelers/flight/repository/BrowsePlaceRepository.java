package com.radoslaw.dauksza.travelers.flight.repository;

import com.radoslaw.dauksza.travelers.flight.domain.BrowsePlace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowsePlaceRepository extends CrudRepository<BrowsePlace, Long> {
}
