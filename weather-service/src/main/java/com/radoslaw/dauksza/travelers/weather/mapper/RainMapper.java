package com.radoslaw.dauksza.travelers.weather.mapper;

import com.radoslaw.dauksza.travelers.weather.domain.Rain;
import com.radoslaw.dauksza.travelers.weather.domain.dto.RainDto;
import org.springframework.stereotype.Component;

@Component
public class RainMapper {
    public Rain mapToRain(RainDto rainDto) {
        if (rainDto != null) {
            return new Rain(rainDto.getVolumeInLast3H());
        }
        return new Rain();
    }
    public RainDto MapToRainDto(Rain rain) {
        return new RainDto(rain.getVolumeInLast3H());
    }
}
