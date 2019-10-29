package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LivePricePlaceDto {

    @JsonProperty("Id")
    private long id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Code")
    private String code;

    @JsonProperty("ParentId")
    private String parentId;
}
