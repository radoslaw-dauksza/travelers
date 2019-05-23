package com.radoslaw.dauksza.travelers.flight;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SkyscannerFlightApiConfig {

    @Value("${skyscanner.flight.api.endpoint}")
    private String skyscannerFlightApiEndpoint;

    @Value("${skyscanner.flight.api.key}")
    private String skyscannerFlightApiKey;
}
