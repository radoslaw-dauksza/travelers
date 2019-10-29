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
            "WHERE q.outboundConnection.origin.placeId = :originPlaceId " +
            "AND q.outboundConnection.departureDate BETWEEN :minDate AND :maxDate")
    List<Quote> getQuotesByOriginIdAndDepartureDateBetween(
            @Param("originPlaceId") long placeId,
            @Param("minDate")LocalDate minDate,
            @Param("maxDate") LocalDate maxDate);

    @Query("SELECT q FROM Quote q " +
            "WHERE q.outboundConnection.origin.countryName LIKE :countryName " +
            "AND q.outboundConnection.departureDate BETWEEN :minDate AND :maxDate " +
            "AND q.minPrice <= :maxMinPrice " +
            "ORDER BY q.minPrice ASC")
    List<Quote> getQuotesWhereOriginCountryNameLikeAndMaxMinPriceAndDepartureDateBetween(
            @Param("countryName") String countryName,
            @Param("maxMinPrice") double maxMinPrice,
            @Param("minDate")LocalDate minDate,
            @Param("maxDate") LocalDate maxDate);
}
