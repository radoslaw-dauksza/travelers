package com.radoslaw.dauksza.travelers.event.repository;

import com.radoslaw.dauksza.travelers.event.domain.Performance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends CrudRepository<Performance, Long> {
}
