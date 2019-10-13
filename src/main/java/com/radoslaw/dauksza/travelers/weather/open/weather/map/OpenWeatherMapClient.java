package com.radoslaw.dauksza.travelers.weather.open.weather.map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.radoslaw.dauksza.travelers.weather.domain.dto.ForecastForCityDto;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Component
public class OpenWeatherMapClient {
    private final OpenWeatherMapConfig config;
    private final ObjectMapper objectMapper;

    public OpenWeatherMapClient(OpenWeatherMapConfig config, ObjectMapper objectMapper) {
        this.config = config;
        this.objectMapper = objectMapper;
    }

    public Optional<ForecastForCityDto> get5DayForecastForCity(double lat, double lon) {
        String uri = UriComponentsBuilder
                .fromHttpUrl(config.getOpenWeatherMapApiEndpoint())
                .pathSegment("forecast")
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("APPID", config.getOpenWeatherMapApiKey())
                .build()
                .encode().toUriString();
        String response = Unirest.get(uri)
                .asJson()
                .getBody()
                .getObject()
                .toString();
        try {
            return Optional.of(objectMapper.readValue(response, ForecastForCityDto.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
