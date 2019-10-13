package com.radoslaw.dauksza.travelers.event.repository;

import com.radoslaw.dauksza.travelers.event.domain.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
