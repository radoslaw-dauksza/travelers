package com.radoslaw.dauksza.travelers.weather.repository;

import com.radoslaw.dauksza.travelers.weather.domain.Rain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RainRepository extends CrudRepository<Rain, Long> {
}
