package com.radoslaw.dauksza.travelers.flight.service;

import com.radoslaw.dauksza.travelers.flight.domain.BrowsePlace;
import com.radoslaw.dauksza.travelers.flight.domain.Carrier;
import com.radoslaw.dauksza.travelers.flight.domain.Connection;
import com.radoslaw.dauksza.travelers.flight.domain.Quote;
import com.radoslaw.dauksza.travelers.flight.repository.BrowsePlaceRepository;
import com.radoslaw.dauksza.travelers.flight.repository.CarrierRepository;
import com.radoslaw.dauksza.travelers.flight.repository.ConnectionRepository;
import com.radoslaw.dauksza.travelers.flight.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DbService {
    private ConnectionRepository connectionRepository;
    private CarrierRepository carrierRepository;
    private QuoteRepository quoteRepository;
    private BrowsePlaceRepository browsePlaceRepository;

    public DbService(ConnectionRepository connectionRepository,
                     CarrierRepository carrierRepository,
                     QuoteRepository quoteRepository,
                     BrowsePlaceRepository browsePlaceRepository) {
        this.connectionRepository = connectionRepository;
        this.carrierRepository = carrierRepository;
        this.quoteRepository = quoteRepository;
        this.browsePlaceRepository = browsePlaceRepository;
    }

    public Connection saveConnection(final Connection connection) {
        return connectionRepository.save(connection);
    }


    public Carrier saveCarrier(final Carrier carrier) {
        return carrierRepository.save(carrier);
    }

    public Quote saveQuote(final Quote quote) {
        return quoteRepository.save(quote);
    }

    public List<Quote> saveQuotes(List<Quote> quotes) {
        return (List<Quote>) quoteRepository.saveAll(quotes);
    }

    public BrowsePlace saveBrowsePlace(final BrowsePlace browsePlace) {
        return browsePlaceRepository.save(browsePlace);
    }

    public List<BrowsePlace> saveBrowsePlaces(final List<BrowsePlace> browsePlaces) {
        Set<BrowsePlace> a = new HashSet<>(browsePlaces);
        return (List<BrowsePlace>) browsePlaceRepository.saveAll(a);
    }

    public Optional<Connection> getConnection(long id) {
        return connectionRepository.findById(id);
    }

    public Optional<Connection> getConnection() {
        List<Connection> c = (List<Connection>) connectionRepository.findAll();
        return c.stream().findAny();
    }

    public Connection getConnection(long originId, long destinationId, LocalDate departure) {
        return connectionRepository
                .findByOriginPlaceIdAndDestinationPlaceIdAndDepartureDate(
                        originId,
                        destinationId,
                        departure)
                .stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public Optional<Carrier> getCarrier(long id) {
        return carrierRepository.findById(id);
    }

    public Optional<Quote> getQuote(long id) {
        return quoteRepository.findById(id);
    }

    public BrowsePlace getBrowsePlace(long id) {
        return browsePlaceRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Carrier> getCarriers(List<Long> ids) {
        return (List<Carrier>) carrierRepository.findAllById(ids);
    }

    public List<Quote> getQuotes() {
        return (List<Quote>) quoteRepository.findAll();
    }

    public List<Connection> saveConnections(Iterable<Connection> connections) {
        return (List<Connection>)
                connectionRepository
                        .saveAll(connections);
    }

    public List<Carrier> saveCarriers(Iterable<Carrier> carriers) {
        return (List<Carrier>) carrierRepository.saveAll(carriers);
    }

    public List<BrowsePlace> getBrowsePlaces() {
        return (List<BrowsePlace>) browsePlaceRepository.findAll();
    }

    public List<Quote> getQuotesByOriginIdAndDepartureDateBetween(long placeId, LocalDate minDate, LocalDate maxDate) {
        return quoteRepository.getQuotesByOriginIdAndDepartureDateBetween(placeId, minDate, maxDate);
    }

    public List<Quote> getQuotesByOriginCountryNameAndMaxMinPriceAndDepartureDateBetween(
            String countryName, double maxMinPrice, LocalDate minDate, LocalDate maxDate) {
        return quoteRepository.getQuotesWhereOriginCountryNameLikeAndMaxMinPriceAndDepartureDateBetween(
                countryName, maxMinPrice, minDate, maxDate);
    }
}
