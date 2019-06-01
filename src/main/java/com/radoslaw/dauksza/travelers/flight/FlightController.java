package com.radoslaw.dauksza.travelers.flight;

import com.radoslaw.dauksza.travelers.skyscanner.SkyscannerApiClient;
import com.radoslaw.dauksza.travelers.skyscanner.dto.BrowseQuotesResultDto;
import com.radoslaw.dauksza.travelers.skyscanner.dto.FlightLivePricesResponseDto;
import com.radoslaw.dauksza.travelers.skyscanner.dto.SearchFlightParametersDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public BrowseQuotesResultDto getRoutes() {
        SearchFlightParametersDto flightParametersDto = new SearchFlightParametersDto();
        flightParametersDto.setCountry("PL");
        flightParametersDto.setCurrency("PLN");
        flightParametersDto.setDestinationPlace("Anywhere");
        flightParametersDto.setLocale("pl-PL");
        flightParametersDto.setOriginPlace("PL-sky");
        flightParametersDto.setOutboundDate(LocalDate.now().plusMonths(1));
        return client.browseQuotes(flightParametersDto);
    }

    @GetMapping("/flights/prices")
    public FlightLivePricesResponseDto getFlightLivePrices() {
        return new FlightLivePricesResponseDto();
    }
}
