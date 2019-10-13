package com.radoslaw.dauksza.travelers.weather.service;

import com.radoslaw.dauksza.travelers.weather.domain.ForecastForCity;
import com.radoslaw.dauksza.travelers.weather.domain.dto.ForecastForCityDto;
import com.radoslaw.dauksza.travelers.weather.domain.dto.ForecastWeatherDto;
import com.radoslaw.dauksza.travelers.weather.domain.dto.WeatherDto;
import com.radoslaw.dauksza.travelers.weather.mapper.ForecastForCityMapper;
import com.radoslaw.dauksza.travelers.weather.mapper.WeatherMapper;
import com.radoslaw.dauksza.travelers.weather.open.weather.map.OpenWeatherMapClient;
import com.radoslaw.dauksza.travelers.weather.repository.ForecastForCityRepository;
import com.radoslaw.dauksza.travelers.weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WeatherService {
    private final OpenWeatherMapClient openWeatherMapClient;
    private final ForecastForCityMapper forecastForCityMapper;
    private final ForecastForCityRepository forecastForCityRepository;
    private final WeatherMapper weatherMapper;
    private final WeatherRepository weatherRepository;

    public WeatherService(OpenWeatherMapClient openWeatherMapClient,
                          ForecastForCityMapper forecastForCityMapper,
                          ForecastForCityRepository forecastForCityRepository,
                          WeatherMapper weatherMapper,
                          WeatherRepository weatherRepository) {
        this.openWeatherMapClient = openWeatherMapClient;
        this.forecastForCityMapper = forecastForCityMapper;
        this.forecastForCityRepository = forecastForCityRepository;
        this.weatherMapper = weatherMapper;
        this.weatherRepository = weatherRepository;
    }

    public ForecastForCity get5DayForecastForCity(double lat, double lon) {
        Optional<ForecastForCity> optionalForecastForCity =
                Stream.of(forecastForCityRepository.findByCity_LatAndCity_Lon(lat, lon))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .filter(forecast -> forecast.getLastForecastingDateTime()
                                .isAfter(LocalDateTime.now().minusHours(3)))
                        .findFirst();

        Optional<ForecastForCityDto> optionalForecastForCityDto = openWeatherMapClient.get5DayForecastForCity(lat, lon);
        List<WeatherDto> weatherDtos = optionalForecastForCityDto.orElse(new ForecastForCityDto())
                .getForecastWeatherDtos()
                .parallelStream()
                .map(ForecastWeatherDto::getWeatherDtos)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());

        weatherRepository.saveAll(weatherMapper.mapToWeatherList(weatherDtos));

        return optionalForecastForCity.orElseGet(() ->
                forecastForCityRepository.save(
                        forecastForCityMapper.mapToForecastForCity(
                                optionalForecastForCityDto
                                        .orElse(new ForecastForCityDto()), LocalDateTime.now())));
    }
}
