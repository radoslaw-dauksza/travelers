package com.radoslaw.dauksza.travelers.flight;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
class SkyscannerFlightApiClient {
    private SkyscannerFlightApiConfig flightApiConfig;
    private RestTemplate restTemplate;

    SkyscannerFlightApiClient(SkyscannerFlightApiConfig flightApiConfig, RestTemplate restTemplate) {
        this.flightApiConfig = flightApiConfig;
        this.restTemplate = restTemplate;
    }

    SearchRouteResultDto serchRoutes(FlightParametersDto flightParameters) {
        URI uri = getUri(flightParameters);

        try {
            return restTemplate.getForObject(uri, SearchRouteResultDto.class);
        } catch (RestClientException e) {
            return new SearchRouteResultDto();
        }
    }

    private URI getUri(FlightParametersDto flightParameters) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromHttpUrl(flightApiConfig.getSkyscannerFlightApiEndpoint())
                .pathSegment("browseroutes")
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
