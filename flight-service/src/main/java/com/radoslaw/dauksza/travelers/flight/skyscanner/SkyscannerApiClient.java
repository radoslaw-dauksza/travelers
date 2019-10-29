package com.radoslaw.dauksza.travelers.flight.skyscanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.radoslaw.dauksza.travelers.flight.domain.dto.*;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SkyscannerApiClient {
    public static final String BROWSE_ROUTES = "browseroutes";
    public static final String BROWSE_DATES = "browsedates";
    public static final String BROWSE_QUOTES = "browsequotes";
    public static final String AUTOSUGGEST = "autosuggest";
    private SkyscannerApiConfig flightApiConfig;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public SkyscannerApiClient(SkyscannerApiConfig flightApiConfig, RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.flightApiConfig = flightApiConfig;
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    public BrowseRouteResultDto browseRoutes(SearchFlightParametersDto flightParameters) {
        URI uri = getBrowseUri(flightParameters, BROWSE_ROUTES);

        try {
            return restTemplate.getForObject(uri, BrowseRouteResultDto.class);
        } catch (RestClientException e) {
            return new BrowseRouteResultDto();
        }
    }

    public BrowseQuotesResultDto browseQuotes(SearchFlightParametersDto flightParameters) {
        URI uri = getBrowseUri(flightParameters, BROWSE_QUOTES);

        try {
            return restTemplate.getForObject(uri, BrowseQuotesResultDto.class);
        } catch (RestClientException e) {
            return new BrowseQuotesResultDto();
        }
    }

    public BrowseDatesResultDto browseDates(SearchFlightParametersDto flightParameters) {
        URI uri = getBrowseUri(flightParameters, BROWSE_DATES);

        try {
            return restTemplate.getForObject(uri, BrowseDatesResultDto.class);
        } catch (RestClientException e) {
            return new BrowseDatesResultDto();
        }
    }

    public List<AutosuggestPlaceDto> autosuggest(String query) {
        URI uri = getAutosuggestUri(query, AUTOSUGGEST);

        HttpResponse<JsonNode> response = Unirest.get(uri.toString())
                .header("X-RapidAPI-Host", flightApiConfig.getSkyscannerFlightApiEndpoint())
                .header("X-RapidAPI-Key", flightApiConfig.getSkyscannerFlightApiKey())
                .asJson();
        System.out.println(response.getBody().getArray().toString());

        return response.getBody()
                .getObject()
                .getJSONArray("Places")
                .toList()
                .stream()
                .map(o -> objectMapper.convertValue(o, AutosuggestPlaceDto.class))
                .collect(Collectors.toList());
    }

    private URI getBrowseUri(SearchFlightParametersDto flightParameters, String action) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromHttpUrl(flightApiConfig.getSkyscannerFlightApiEndpoint())
                .pathSegment(action)
                .pathSegment("v1.0")
                .pathSegment(flightParameters.getCountry())
                .pathSegment(flightParameters.getCurrency())
                .pathSegment(flightParameters.getLocale())
                .pathSegment(flightParameters.getOriginPlace())
                .pathSegment(flightParameters.getDestinationPlace())
                .pathSegment(YearMonth.from(flightParameters.getOutboundDate()).toString());
        if (flightParameters.getInboundDate() != null) {
            uriComponentsBuilder.pathSegment(flightParameters.getInboundDate().toString());
        }
        return uriComponentsBuilder.queryParam("apikey", flightApiConfig.getSkyscannerFlightApiKey())
                .build().encode().toUri();
    }

    private URI getAutosuggestUri(String query, String action) {

        return UriComponentsBuilder
                .fromHttpUrl(flightApiConfig.getSkyscannerFlightApiEndpoint())
                .pathSegment(action)
                .pathSegment("v1.0")
                .pathSegment("PL")
                .pathSegment("PLN")
                .pathSegment("pl-PL")
                .queryParam("query", query)
                .queryParam("apikey", flightApiConfig.getSkyscannerFlightApiKey())
                .build().encode().toUri();
    }
}
