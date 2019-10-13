package com.radoslaw.dauksza.travelers.weather.mapper;

import com.radoslaw.dauksza.travelers.weather.domain.Weather;
import com.radoslaw.dauksza.travelers.weather.domain.dto.WeatherDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherMapper {
    public List<Weather> mapToWeatherList(List<WeatherDto> weatherDtos) {
        return weatherDtos.stream()
                .map(this::mapToWeather)
                .collect(Collectors.toList());
    }

    public List<WeatherDto> mapToWeatherDtoList(List<Weather> weathers) {
        return weathers.stream()
                .map(this::mapToWeatherDto)
                .collect(Collectors.toList());
    }

    public Weather mapToWeather(WeatherDto weatherDto) {
        return new Weather(
                weatherDto.getId(),
                weatherDto.getMain(),
                weatherDto.getDescription(),
                weatherDto.getIcon());
    }

    public WeatherDto mapToWeatherDto(Weather weather) {
        return new WeatherDto(
                weather.getId(),
                weather.getMain(),
                weather.getDescription(),
                weather.getIcon());
    }
}
