package com.radoslaw.dauksza.travelers.skyscanner;

import com.radoslaw.dauksza.travelers.flight.domain.dto.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Component
public class SkyscannerApiClient {
    public static final String BROWSE_ROUTES = "browseroutes";
    public static final String BROWSE_DATES = "browsedates";
    public static final String BROWSE_QUOTES = "browsequotes";
    public static final String AUTOSUGGEST = "autosuggest";
    private SkyscannerApiConfig flightApiConfig;
    private RestTemplate restTemplate;

    public SkyscannerApiClient(SkyscannerApiConfig flightApiConfig, RestTemplate restTemplate) {
        this.flightApiConfig = flightApiConfig;
        this.restTemplate = restTemplate;
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

        try {

            ResponseEntity<List<AutosuggestPlaceDto>> response = restTemplate.exchange(uri,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<AutosuggestPlaceDto>>() {
                    });
            List<AutosuggestPlaceDto> l = response.getBody();
            System.out.println(l);
            return l;
        } catch (RestClientException e) {
            System.out.println(e);
            List<AutosuggestPlaceDto> a = new ArrayList<>();

            AutosuggestPlaceDto s = new AutosuggestPlaceDto();
            s.setCityId("WAW-sky");
            s.setCountryId("PL-sky");
            s.setCountryName("Polska");
            s.setPlaceName("Warszawa Chopina");
            s.setPlaceId("WARS-sky");
            s.setRegionId("");
            a.add(s);
            return a;
        }
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
