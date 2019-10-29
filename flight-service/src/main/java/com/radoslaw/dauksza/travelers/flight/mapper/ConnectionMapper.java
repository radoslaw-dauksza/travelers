package com.radoslaw.dauksza.travelers.flight.mapper;

import com.radoslaw.dauksza.travelers.flight.domain.dto.ConnectionDto;
import com.radoslaw.dauksza.travelers.flight.service.DbService;
import com.radoslaw.dauksza.travelers.flight.domain.Carrier;
import com.radoslaw.dauksza.travelers.flight.domain.Connection;
import com.radoslaw.dauksza.travelers.flight.domain.dto.BoundLegDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConnectionMapper {
    private DbService dbService;
    private PlaceMapper placeMapper;


    public ConnectionMapper(DbService dbService, PlaceMapper placeMapper) {
        this.dbService = dbService;
        this.placeMapper = placeMapper;
    }

    public ConnectionDto mapToConnectionDto(Connection connection) {
        if (connection == null) {
            return null;
        }
        return new ConnectionDto(connection
                .getCarriers().stream()
                .map(Carrier::getId).collect(Collectors.toList()),
                connection.getOrigin().getPlaceId(),
                connection.getDestination().getPlaceId(),
                connection.getDepartureDate());
    }

    public Connection mapToConnection(BoundLegDto boundLegDto) {
        if (boundLegDto == null) {
            return null;
        }
        Connection connection = new Connection(dbService.getCarriers(boundLegDto.getCarrierIds()),
                dbService.getBrowsePlace(boundLegDto.getOriginId()),
                dbService.getBrowsePlace(boundLegDto.getDestinationId()),
                LocalDate.from(boundLegDto.getDepartureDate()));
        return connection;
    }

    public List<Connection> mapToConnections(List<BoundLegDto> boundLegDtos) {
        return boundLegDtos.stream().map(this::mapToConnection).collect(Collectors.toList());
    }
}
