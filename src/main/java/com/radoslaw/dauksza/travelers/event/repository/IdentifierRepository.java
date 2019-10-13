package com.radoslaw.dauksza.travelers.event.repository;

import com.radoslaw.dauksza.travelers.event.domain.Identifier;
import org.springframework.data.repository.CrudRepository;

public interface IdentifierRepository extends CrudRepository<Identifier, String> {
}
