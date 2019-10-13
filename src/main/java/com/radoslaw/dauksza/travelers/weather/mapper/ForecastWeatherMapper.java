package com.radoslaw.dauksza.travelers.weather.mapper;

import com.radoslaw.dauksza.travelers.weather.domain.ForecastWeather;
import com.radoslaw.dauksza.travelers.weather.domain.dto.CloudinessDto;
import com.radoslaw.dauksza.travelers.weather.domain.dto.ForecastWeatherDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ForecastWeatherMapper {
    private MainWeatherInfoMapper mainWeatherInfoMapper;
    private WeatherMapper weatherMapper;
    private WindMapper windMapper;
    private SnowMapper snowMapper;
    private RainMapper rainMapper;

    public ForecastWeatherMapper(MainWeatherInfoMapper mainWeatherInfoMapper,
                                 WeatherMapper weatherMapper,
                                 WindMapper windMapper,
                                 SnowMapper snowMapper,
                                 RainMapper rainMapper) {
        this.mainWeatherInfoMapper = mainWeatherInfoMapper;
        this.weatherMapper = weatherMapper;
        this.windMapper = windMapper;
        this.snowMapper = snowMapper;
        this.rainMapper = rainMapper;
    }

    public List<ForecastWeather> mapToForecastWeathers(List<ForecastWeatherDto> forecastWeatherDtos) {
        if (forecastWeatherDtos != null) {
            return forecastWeatherDtos.parallelStream()
                    .map(this::mapToForecastWeather)
                    .collect(Collectors.toList());
        } else return new ArrayList<>();
    }

    public List<ForecastWeatherDto> mapToForecastWeatherDtos(List<ForecastWeather> forecastWeathers) {
        return forecastWeathers.stream()
                .map(this::mapToForecastWeatherDto)
                .collect(Collectors.toList());
    }

    public ForecastWeather mapToForecastWeather(ForecastWeatherDto forecastWeatherDto) {
        return new ForecastWeather(
                forecastWeatherDto.getDateTimeUnixUtc(),
                mainWeatherInfoMapper.mapToMainWeatherInfo(forecastWeatherDto.getMainWeatherInfoDto()),
                weatherMapper.mapToWeatherList(forecastWeatherDto.getWeatherDtos()),
                forecastWeatherDto.getCloudinessDto().getCloudinessInPercent(),
                windMapper.mapToWind(forecastWeatherDto.getWindDto()),
                forecastWeatherDto.getDateTimeUtcTxt(),
                snowMapper.mapToSnow(forecastWeatherDto.getSnowDto()),
                rainMapper.mapToRain(forecastWeatherDto.getRainDto()));
    }

    public ForecastWeatherDto mapToForecastWeatherDto(ForecastWeather forecastWeather) {
        return new ForecastWeatherDto(
                forecastWeather.getDateTimeUnixUtc(),
                mainWeatherInfoMapper.mapToMainWeatherInfoDto(forecastWeather.getMainWeatherInfo()),
                weatherMapper.mapToWeatherDtoList(forecastWeather.getWeathers()),
                new CloudinessDto(forecastWeather.getCloudinessInPercent()),
                windMapper.mapToWindDto(forecastWeather.getWind()),
                forecastWeather.getDateTimeUtcTxt(),
                snowMapper.mapToSnowDto(forecastWeather.getSnow()),
                rainMapper.MapToRainDto(forecastWeather.getRain()));
    }
}
