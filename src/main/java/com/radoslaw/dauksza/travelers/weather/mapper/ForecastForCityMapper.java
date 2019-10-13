package com.radoslaw.dauksza.travelers.weather.mapper;

import com.radoslaw.dauksza.travelers.weather.domain.ForecastForCity;
import com.radoslaw.dauksza.travelers.weather.domain.dto.ForecastForCityDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ForecastForCityMapper {
    private CityMapper cityMapper;
    private ForecastWeatherMapper forecastWeatherMapper;

    public ForecastForCityMapper(CityMapper cityMapper, ForecastWeatherMapper forecastWeatherMapper) {
        this.cityMapper = cityMapper;
        this.forecastWeatherMapper = forecastWeatherMapper;
    }

    public ForecastForCity mapToForecastForCity(ForecastForCityDto forecastForCityDto, LocalDateTime forecastingDateTime) {
        ForecastForCity forecastForCity = new ForecastForCity(
                cityMapper.mapToCity(forecastForCityDto.getCityDto()),
                forecastForCityDto.getCod(),
                forecastForCityDto.getMessage(),
                forecastForCityDto.getCnt(),
                forecastWeatherMapper.mapToForecastWeathers(forecastForCityDto.getForecastWeatherDtos()),
                forecastingDateTime);
        System.out.println(forecastForCity);
        return forecastForCity;
    }

    public ForecastForCityDto mapToForecastForCityDto(ForecastForCity forecastForCity) {
        return new ForecastForCityDto(
                cityMapper.mapToCityDto(forecastForCity.getCity()),
                        forecastForCity.getCod(),
                        forecastForCity.getMessage(),
                        forecastForCity.getCnt(),
                        forecastWeatherMapper.mapToForecastWeatherDtos(forecastForCity.getForecastWeathers()));
    }
}
