package com.radoslaw.dauksza.travelers.weather.mapper;

import com.radoslaw.dauksza.travelers.weather.domain.MainWeatherInfo;
import com.radoslaw.dauksza.travelers.weather.domain.dto.MainWeatherInfoDto;
import org.springframework.stereotype.Component;

@Component
public class MainWeatherInfoMapper {

    public MainWeatherInfo mapToMainWeatherInfo(MainWeatherInfoDto mainWeatherInfoDto) {
        return new MainWeatherInfo(
                mainWeatherInfoDto.getTemp(),
                mainWeatherInfoDto.getTempMin(),
                mainWeatherInfoDto.getTempMax(),
                mainWeatherInfoDto.getDefaultPressure(),
                mainWeatherInfoDto.getSeaLevelPressure(),
                mainWeatherInfoDto.getGroundLevelPressure(),
                mainWeatherInfoDto.getHumidity(),
                mainWeatherInfoDto.getTempKf());
    }
    public MainWeatherInfoDto mapToMainWeatherInfoDto(MainWeatherInfo mainWeatherInfo) {
        return new MainWeatherInfoDto(
                mainWeatherInfo.getTemp(),
                mainWeatherInfo.getTempMin(),
                mainWeatherInfo.getTempMax(),
                mainWeatherInfo.getDefaultPressure(),
                mainWeatherInfo.getSeaLevelPressure(),
                mainWeatherInfo.getGroundLevelPressure(),
                mainWeatherInfo.getHumidity(),
                mainWeatherInfo.getTempKf());
    }
}
