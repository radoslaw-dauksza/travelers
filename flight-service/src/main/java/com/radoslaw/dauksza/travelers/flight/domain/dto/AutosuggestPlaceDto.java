package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AutosuggestPlaceDto {

    @JsonProperty("PlaceId")
    private String placeId;

    @JsonProperty("PlaceName")
    private String placeName;

    @JsonProperty("CountryId")
    private String countryId;

    @JsonProperty("RegionId")
    private String regionId;

    @JsonProperty("CityId")
    private String cityId;

    @JsonProperty("CountryName")
    private String countryName;
}
