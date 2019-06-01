package com.radoslaw.dauksza.travelers.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BrowsePlaceDto {

    @JsonProperty("PlaceId")
    private long placeId;

    @JsonProperty("IataCode")
    private String iataCode;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("SkyscannerCode")
    private String skyscannerCode;

    @JsonProperty("CityName")
    private String cityName;

    @JsonProperty("CityId")
    private String cityId;

    @JsonProperty("CountryName")
    private String countryName;
}
