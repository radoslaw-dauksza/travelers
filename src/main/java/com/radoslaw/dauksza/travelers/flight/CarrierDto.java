package com.radoslaw.dauksza.travelers.flight;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CarrierDto {

    @JsonProperty("CarrierId")
    private long id;

    @JsonProperty("Name")
    private String name;
}
