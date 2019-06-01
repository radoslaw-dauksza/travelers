package com.radoslaw.dauksza.travelers.flight;

import com.radoslaw.dauksza.travelers.skyscanner.dto.BrowseRouteResultDto;
import com.radoslaw.dauksza.travelers.skyscanner.dto.FlightLivePricesResponseDto;
import com.radoslaw.dauksza.travelers.skyscanner.SkyscannerApiClient;
import com.radoslaw.dauksza.travelers.skyscanner.dto.SearchFlightParametersDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class FlightController {
    SkyscannerApiClient client;

    FlightController(SkyscannerApiClient client) {
        this.client = client;
    }

    @GetMapping("/flights")
    public BrowseRouteResultDto getRoutes() {
        SearchFlightParametersDto flightParametersDto = new SearchFlightParametersDto();
        flightParametersDto.setCountry("PL");
        flightParametersDto.setCurrency("PLN");
        flightParametersDto.setDestinationPlace("any");
        flightParametersDto.setLocale("pl-PL");
        flightParametersDto.setOriginPlace("PL-sky");
        flightParametersDto.setOutboundDate(LocalDate.now().plusMonths(1));
        return client.browseRoutes(flightParametersDto);
    }

    @GetMapping("/flights/prices")
    public FlightLivePricesResponseDto getFlightLivePrices() {
        return new FlightLivePricesResponseDto();
    }
}
