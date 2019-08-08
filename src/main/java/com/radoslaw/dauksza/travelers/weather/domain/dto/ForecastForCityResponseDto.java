
package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ForecastForCityResponseDto {

    @JsonProperty("city")
    private CityDto cityDto;
}
