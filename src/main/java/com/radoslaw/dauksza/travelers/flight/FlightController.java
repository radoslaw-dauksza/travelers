package com.radoslaw.dauksza.travelers.flight;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class FlightController {
    SkyscannerFlightApiClient client;

    FlightController(SkyscannerFlightApiClient client) {
        this.client = client;
    }

    @GetMapping("/flights")
    public BrowseRouteResultDto getFlights(@RequestBody FlightParametersDto flightParameters) {

        return client.browseRoutes(flightParameters);
    }
}
