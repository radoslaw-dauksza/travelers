package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BrowseCarrierDto {

    @JsonProperty("CarrierId")
    private long carrierId;

    @JsonProperty("Name")
    private String name;
}
