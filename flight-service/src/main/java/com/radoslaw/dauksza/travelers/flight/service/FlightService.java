package com.radoslaw.dauksza.travelers.flight.service;

import com.radoslaw.dauksza.travelers.flight.domain.Connection;
import com.radoslaw.dauksza.travelers.flight.domain.Quote;
import com.radoslaw.dauksza.travelers.flight.domain.dto.AutosuggestPlaceDto;
import com.radoslaw.dauksza.travelers.flight.domain.dto.BrowseQuotesResultDto;
import com.radoslaw.dauksza.travelers.flight.domain.dto.QuoteDto;
import com.radoslaw.dauksza.travelers.flight.domain.dto.SearchFlightParametersDto;
import com.radoslaw.dauksza.travelers.flight.mapper.CarrierMapper;
import com.radoslaw.dauksza.travelers.flight.mapper.ConnectionMapper;
import com.radoslaw.dauksza.travelers.flight.mapper.FlightQuoteMapper;
import com.radoslaw.dauksza.travelers.flight.mapper.PlaceMapper;
import com.radoslaw.dauksza.travelers.flight.skyscanner.SkyscannerApiClient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private SkyscannerApiClient client;
    private DbService dbService;
    private PlaceMapper placeMapper;
    private CarrierMapper carrierMapper;
    private ConnectionMapper connectionMapper;
    private FlightQuoteMapper flightQuoteMapper;

    public FlightService(SkyscannerApiClient client,
                         DbService dbService,
                         PlaceMapper placeMapper,
                         CarrierMapper carrierMapper,
                         ConnectionMapper connectionMapper,
                         FlightQuoteMapper flightQuoteMapper) {
        this.client = client;
        this.dbService = dbService;
        this.placeMapper = placeMapper;
        this.carrierMapper = carrierMapper;
        this.connectionMapper = connectionMapper;
        this.flightQuoteMapper = flightQuoteMapper;
    }

    public void updateFlightQuotesFromPoland(LocalDate outboundDate) {
        Locale locale = Locale.forLanguageTag("pl-PL");
        SearchFlightParametersDto flightParametersDto = new SearchFlightParametersDto();
        flightParametersDto.setCountry(locale.getCountry());
        flightParametersDto.setCurrency(Currency.getInstance(locale).getCurrencyCode());
        flightParametersDto.setDestinationPlace("Anywhere");
        flightParametersDto.setLocale(locale.toLanguageTag());
        flightParametersDto.setOriginPlace("PL-sky");
        flightParametersDto.setOutboundDate(outboundDate);

        BrowseQuotesResultDto browseQuotesResultDto = client.browseQuotes(flightParametersDto);
        dbService.saveBrowsePlaces(
                placeMapper.mapToBrowsePlaces(
                        browseQuotesResultDto.getPlaces()));

        dbService.saveCarriers(carrierMapper.mapToCarriers(browseQuotesResultDto.getCarriers()));
        Set<Connection> connections = browseQuotesResultDto.getQuotes()
                .stream()
                .map(QuoteDto::getOutboundLeg)
                .filter(Objects::nonNull)
                .map(connectionMapper::mapToConnection)
                .collect(Collectors.toSet());
        connections.addAll(browseQuotesResultDto.getQuotes()
                .stream()
                .map(QuoteDto::getInboundLeg)
                .filter(Objects::nonNull)
                .map(connectionMapper::mapToConnection)
                .collect(Collectors.toSet()));
        dbService.saveConnections(connections);
        dbService.saveQuotes(
                flightQuoteMapper
                        .mapToQuotes(browseQuotesResultDto));
    }

    public List<Quote> getSuggestedQuotesFromPoland() {
        return dbService.getQuotesByOriginCountryNameAndMaxMinPriceAndDepartureDateBetween(
                "Polska", 100, LocalDate.now(), LocalDate.now().plusDays(12));
    }

    public List<AutosuggestPlaceDto> getPlaces(String query) {
        return client.autosuggest(query);
    }
}
