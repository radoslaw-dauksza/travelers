package com.radoslaw.dauksza.travelers.flight;

import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private SkyscannerFlightApiClient flightApiClient;

    FlightService(SkyscannerFlightApiClient flightApiClient) {
        this.flightApiClient = flightApiClient;
    }

    BrowseRouteResultDto BrowseRouts(FlightParametersDto flightParameters) {
        return flightApiClient.browseRoutes(flightParameters);
    }

    BrowseQuotesResultDto browseQuotes(FlightParametersDto flightParameters) {
        return flightApiClient.browseQuotes(flightParameters);
    }

    BrowseDatesResultDto browseDates(FlightParametersDto flightParameters) {
        return flightApiClient.browseDates(flightParameters);
    }
}
