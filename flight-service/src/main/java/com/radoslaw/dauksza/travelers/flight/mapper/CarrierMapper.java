package com.radoslaw.dauksza.travelers.flight.mapper;

import com.radoslaw.dauksza.travelers.flight.domain.Carrier;
import com.radoslaw.dauksza.travelers.flight.domain.dto.BrowseCarrierDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarrierMapper {
    public Carrier mapToCarier(BrowseCarrierDto browseCarrierDto) {
        return new Carrier(browseCarrierDto.getCarrierId(), browseCarrierDto.getName());
    }

    public List<Carrier> mapToCarriers(List<BrowseCarrierDto> browseCarrierDtos) {
        return browseCarrierDtos.stream().map(this::mapToCarier).collect(Collectors.toList());
    }
}
