package com.radoslaw.dauksza.travelers.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LivePriceCarrierDto {

    @JsonProperty("Id")
    private long id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Code")
    private String code;

    @JsonProperty("ImageUrl")
    private String imageUrl;

    @JsonProperty("DisplayCode")
    private String displayCode;
}
