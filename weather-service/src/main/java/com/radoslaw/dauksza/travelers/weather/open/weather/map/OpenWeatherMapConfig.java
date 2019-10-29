package com.radoslaw.dauksza.travelers.weather.open.weather.map;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class OpenWeatherMapConfig {

    @Value("${open.weather.map.api.endpoint}")
    private String openWeatherMapApiEndpoint;

    @Value("${open.weather.map.api.key}")
    private String openWeatherMapApiKey;
}
