package com.radoslaw.dauksza.travelers.weather.controller;

import com.radoslaw.dauksza.travelers.weather.domain.dto.ForecastForCityDto;
import com.radoslaw.dauksza.travelers.weather.mapper.ForecastForCityMapper;
import com.radoslaw.dauksza.travelers.weather.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class weatherController {
    private final WeatherService weatherService;
    private final ForecastForCityMapper forecastForCityMapper;

    public weatherController(WeatherService weatherService, ForecastForCityMapper forecastForCityMapper) {
        this.weatherService = weatherService;
        this.forecastForCityMapper = forecastForCityMapper;
    }

    @GetMapping("weather")
    public ForecastForCityDto getForecastForCityDto(@RequestParam double lat, @RequestParam double lon) {
       return forecastForCityMapper.mapToForecastForCityDto(weatherService.get5DayForecastForCity(lat, lon));
    }
}
