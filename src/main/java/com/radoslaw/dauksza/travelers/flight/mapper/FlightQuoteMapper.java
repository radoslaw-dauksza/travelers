package com.radoslaw.dauksza.travelers.flight.mapper;

import com.radoslaw.dauksza.travelers.flight.service.DbService;
import com.radoslaw.dauksza.travelers.flight.domain.Connection;
import com.radoslaw.dauksza.travelers.flight.domain.Quote;
import com.radoslaw.dauksza.travelers.flight.domain.dto.BrowseQuotesResultDto;
import com.radoslaw.dauksza.travelers.flight.domain.dto.CurrencyDto;
import com.radoslaw.dauksza.travelers.flight.domain.dto.FlightQuoteDto;
import com.radoslaw.dauksza.travelers.flight.domain.dto.QuoteDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightQuoteMapper {
    ConnectionMapper connectionMapper;
    DbService dbService;

    public FlightQuoteMapper(ConnectionMapper connectionMapper, DbService dbService) {
        this.connectionMapper = connectionMapper;
        this.dbService = dbService;
    }

    public FlightQuoteDto mapToFlightQuoteDto(Quote quote) {
        return new FlightQuoteDto(quote.getId(),
                quote.getMinPrice(),
                quote.isDirect(),
                connectionMapper.mapToConnectionDto(quote.getOutboundConnection()),
                connectionMapper.mapToConnectionDto(quote.getInboundConnection()),
                quote.getQuoteDateTime(),
                new CurrencyDto(quote.getCurrency().getCurrencyCode(),
                        quote.getCurrency().getSymbol()));
    }

    public List<Quote> mapToQuotes(BrowseQuotesResultDto browseQuotesResultDto) {
        Currency currency = Currency.getInstance(browseQuotesResultDto.getCurrencies().stream()
                .findFirst()
                .orElse(new CurrencyDto("PLN", "")).getCode());
        List<Quote> quotes = browseQuotesResultDto.getQuotes().stream()
                .map(quoteDto -> mapToQuote(quoteDto, currency))
                .collect(Collectors.toList());
        return quotes;
    }

    public Quote mapToQuote(QuoteDto quoteDto, Currency currency) {
        Connection inboundConnection;
        Connection outboundConnection;
        if (quoteDto.getInboundLeg() != null) {
            inboundConnection = dbService.getConnection(
                    quoteDto.getInboundLeg().getOriginId(),
                    quoteDto.getInboundLeg().getDestinationId(),
                    LocalDate.from(quoteDto.getInboundLeg().getDepartureDate()));
        } else inboundConnection = null;
        outboundConnection = dbService.getConnection(
                quoteDto.getOutboundLeg().getOriginId(),
                quoteDto.getOutboundLeg().getDestinationId(),
                LocalDate.from(quoteDto.getOutboundLeg().getDepartureDate()));
        return new Quote(quoteDto.getMinPrice(),
                quoteDto.isDirect(),
                outboundConnection,
                inboundConnection,
                quoteDto.getQuoteDateTime(),
                currency);
    }

    public List<FlightQuoteDto> mapToFlightQuoteDtos(List<Quote> quotes) {
        return quotes.stream().map(this::mapToFlightQuoteDto).collect(Collectors.toList());
    }


}
