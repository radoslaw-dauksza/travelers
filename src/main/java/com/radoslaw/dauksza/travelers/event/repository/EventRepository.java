package com.radoslaw.dauksza.travelers.event.repository;

import com.radoslaw.dauksza.travelers.event.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}
