package com.radoslaw.dauksza.travelers.weather.repository;

import com.radoslaw.dauksza.travelers.weather.domain.Wind;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WindRepository extends CrudRepository<Wind, Long> {
}
