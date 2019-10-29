package com.radoslaw.dauksza.travelers.flight.repository;

import com.radoslaw.dauksza.travelers.flight.domain.Carrier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrierRepository extends CrudRepository<Carrier, Long> {
}
