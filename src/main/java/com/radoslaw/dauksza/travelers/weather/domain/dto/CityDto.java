package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CityDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("coord")
    private CoordDto coordDto;

    @JsonProperty("country")
    private String countryCode;

    @JsonProperty("timezone")
    private long timezoneShiftFromUtcInSeconds;
}
