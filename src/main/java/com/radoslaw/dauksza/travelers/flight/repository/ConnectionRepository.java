package com.radoslaw.dauksza.travelers.flight.repository;


import com.radoslaw.dauksza.travelers.flight.domain.Connection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Long> {
    @Query("SELECT c FROM Connection c " +
            "WHERE c.origin.placeId = :origin " +
            "AND c.destination.placeId = :destination " +
            "AND departureDate = :date")
    List<Connection> findByOriginPlaceIdAndDestinationPlaceIdAndDepartureDate(
            @Param("origin") long originPlaceId,
            @Param("destination") long destinationPlaceId,
            @Param("date") LocalDate departureDate);
}

