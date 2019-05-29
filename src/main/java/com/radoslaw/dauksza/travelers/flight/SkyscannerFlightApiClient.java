package com.radoslaw.dauksza.travelers.flight;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
class SkyscannerFlightApiClient {
    public static final String BROWSE_ROUTES = "browseroutes";
    public static final String BROWSE_DATES = "browsedates";
    public static final String BROWSE_QUOTES = "browsequotes";
    private SkyscannerFlightApiConfig flightApiConfig;
    private RestTemplate restTemplate;

    SkyscannerFlightApiClient(SkyscannerFlightApiConfig flightApiConfig, RestTemplate restTemplate) {
        this.flightApiConfig = flightApiConfig;
        this.restTemplate = restTemplate;
    }

    BrowseRouteResultDto browseRoutes(FlightParametersDto flightParameters) {
        URI uri = getUri(flightParameters, BROWSE_ROUTES);

        try {
            return restTemplate.getForObject(uri, BrowseRouteResultDto.class);
        } catch (RestClientException e) {
            return new BrowseRouteResultDto();
        }
    }

    BrowseQuotesResultDto browseQuotes(FlightParametersDto flightParameters) {
        URI uri = getUri(flightParameters, BROWSE_QUOTES);

        try {
            return restTemplate.getForObject(uri, BrowseQuotesResultDto.class);
        } catch (RestClientException e) {
            return new BrowseQuotesResultDto();
        }
    }

    BrowseDatesResultDto browseDates(FlightParametersDto flightParameters) {
        URI uri = getUri(flightParameters, BROWSE_DATES);

        try {
            return restTemplate.getForObject(uri, BrowseDatesResultDto.class);
        } catch (RestClientException e) {
            return new BrowseDatesResultDto();
        }
    }

    private URI getUri(FlightParametersDto flightParameters, String browse) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromHttpUrl(flightApiConfig.getSkyscannerFlightApiEndpoint())
                .pathSegment(browse)
                .pathSegment("v1.0")
                .pathSegment(flightParameters.getCountry())
                .pathSegment(flightParameters.getCurrency())
                .pathSegment(flightParameters.getLocale())
                .pathSegment(flightParameters.getOriginPlace())
                .pathSegment(flightParameters.getDestinationPlace())
                .pathSegment(flightParameters.getOutboundPartialDate().toString());
        if (flightParameters.getInboundPartialDate() != null) {
            uriComponentsBuilder.pathSegment(flightParameters.getInboundPartialDate().toString());
        }
        return uriComponentsBuilder.queryParam("apikey", flightApiConfig.getSkyscannerFlightApiKey())
                .build().encode().toUri();
    }
}
