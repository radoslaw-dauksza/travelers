package com.radoslaw.dauksza.travelers.flight.repository;

import com.radoslaw.dauksza.travelers.flight.domain.Quote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {

    @Query("SELECT q FROM Quote q " +
            "WHERE q.outboundConnection.origin.placeId = :origin " +
            "AND q.outboundConnection.departureDate BETWEEN :minDate AND :maxDate")
    List<Quote> getQuotesByOriginIdAndDepartureDateBetween(
            @Param("origin") long placeId,
            @Param("minDate")LocalDate minDate,
            @Param("maxDate") LocalDate maxDate);
}
