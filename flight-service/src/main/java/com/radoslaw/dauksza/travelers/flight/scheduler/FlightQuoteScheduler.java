package com.radoslaw.dauksza.travelers.flight.scheduler;

import com.radoslaw.dauksza.travelers.flight.service.FlightService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FlightQuoteScheduler {
    private FlightService flightService;

    public FlightQuoteScheduler(FlightService flightService) {
        this.flightService = flightService;
    }

    @Scheduled(fixedDelay = 7200000L)
    private void updateFlightQuotes() {
        flightService.updateFlightQuotesFromPoland(LocalDate.now());
        System.out.println("ok");
    }
}
