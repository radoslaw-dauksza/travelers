package com.radoslaw.dauksza.travelers.flight.controller;

import com.radoslaw.dauksza.travelers.flight.domain.dto.FlightLivePricesResponseDto;
import com.radoslaw.dauksza.travelers.flight.domain.dto.FlightQuoteDto;
import com.radoslaw.dauksza.travelers.flight.mapper.CarrierMapper;
import com.radoslaw.dauksza.travelers.flight.mapper.ConnectionMapper;
import com.radoslaw.dauksza.travelers.flight.mapper.FlightQuoteMapper;
import com.radoslaw.dauksza.travelers.flight.mapper.PlaceMapper;
import com.radoslaw.dauksza.travelers.flight.service.FlightService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class FlightController {
    private FlightQuoteMapper flightQuoteMapper;
    private FlightService flightService;

    public FlightController(FlightQuoteMapper flightQuoteMapper,
                            FlightService flightService) {
        this.flightQuoteMapper = flightQuoteMapper;
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public List<FlightQuoteDto> getSuggestedFlightsQuotes() {
        flightService.updateFlightQuotesFromPoland(LocalDate.now());
        return flightQuoteMapper.mapToFlightQuoteDtos(flightService.getSuggestedQuotesFromPoland());
    }

    @GetMapping("/flights/prices")
    public FlightLivePricesResponseDto getFlightLivePrices() {
        return new FlightLivePricesResponseDto();
    }
}
