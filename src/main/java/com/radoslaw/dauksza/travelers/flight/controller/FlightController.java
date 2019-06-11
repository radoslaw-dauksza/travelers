package com.radoslaw.dauksza.travelers.flight.controller;

import com.radoslaw.dauksza.travelers.flight.DbService;
import com.radoslaw.dauksza.travelers.flight.domain.dto.FlightLivePricesResponseDto;
import com.radoslaw.dauksza.travelers.flight.mapper.CarrierMapper;
import com.radoslaw.dauksza.travelers.flight.mapper.ConnectionMapper;
import com.radoslaw.dauksza.travelers.flight.mapper.FlightQuoteMapper;
import com.radoslaw.dauksza.travelers.flight.mapper.PlaceMapper;
import com.radoslaw.dauksza.travelers.skyscanner.SkyscannerApiClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class FlightController {
    SkyscannerApiClient client;
    FlightQuoteMapper flightQuoteMapper;
    DbService dbService;
    PlaceMapper placeMapper;
    ConnectionMapper connectionMapper;
    CarrierMapper carrierMapper;

    FlightController(SkyscannerApiClient client,
                     FlightQuoteMapper flightQuoteMapper,
                     DbService dbService,
                     PlaceMapper placeMapper,
                     ConnectionMapper connectionMapper,
                     CarrierMapper carrierMapper) {
        this.client = client;
        this.flightQuoteMapper = flightQuoteMapper;
        this.dbService = dbService;
        this.placeMapper = placeMapper;
        this.connectionMapper = connectionMapper;
        this.carrierMapper = carrierMapper;
    }

    @GetMapping("/flights")
    public List<FlightQuoteDto> getChe() {
//        SearchFlightParametersDto flightParametersDto = new SearchFlightParametersDto();
//        flightParametersDto.setCountry("PL");
//        flightParametersDto.setCurrency("PLN");
//        flightParametersDto.setDestinationPlace("Anywhere");
//        flightParametersDto.setLocale("pl-PL");
//        flightParametersDto.setOriginPlace("PL-sky");
//        flightParametersDto.setOutboundDate(LocalDate.now().plusMonths(1));
//
//        BrowseQuotesResultDto browseQuotesResultDto = client.browseQuotes(flightParametersDto);
//        dbService.saveBrowsePlaces(
//                placeMapper.mapToBrowsePlaces(
//                        browseQuotesResultDto.getPlaces()));
//
//        dbService.saveCarriers(carrierMapper.mapToCarriers(browseQuotesResultDto.getCarriers()));
//        Set<Connection> connections = browseQuotesResultDto.getQuotes()
//                .stream()
//                .map(QuoteDto::getOutboundLeg)
//                .map(connectionMapper::mapToConnection)
//                .collect(Collectors.toSet());
//        connections.addAll(browseQuotesResultDto.getQuotes()
//                .stream()
//        .map(QuoteDto::getInboundLeg)
//        .map(connectionMapper::mapToConnection)
//        .collect(Collectors.toSet()));
//        connections = connections.stream().filter(Objects::nonNull).collect(Collectors.toSet());
//        dbService.saveConnections(connections);
//        List<FlightQuoteDto> flightQuoteDtos= flightQuoteMapper
//                .mapToQuoteDtos(
//                        dbService.saveQuotes(
//                                flightQuoteMapper.mapToQuotes(
//                                        browseQuotesResultDto)));
//        System.out.println(flightQuoteDtos);

        return flightQuoteMapper.mapToQuoteDtos(dbService.getQuotesByOriginIdAndDepartureDateBetweene(
                90711L, LocalDate.now().plusMonths(1L), LocalDate.now().plusMonths(1L).plusDays(12L)
        ));
    }

    @GetMapping("/flights/prices")
    public FlightLivePricesResponseDto getFlightLivePrices() {
        return new FlightLivePricesResponseDto();
    }
}
