package com.radoslaw.dauksza.travelers.weather.mapper;

import com.radoslaw.dauksza.travelers.weather.domain.Wind;
import com.radoslaw.dauksza.travelers.weather.domain.dto.WindDto;
import org.springframework.stereotype.Component;

@Component
public class WindMapper {

    public Wind mapToWind(WindDto windDto) {
        if (windDto != null) {
            return new Wind(
                    windDto.getSpeedInMetersPerSecond(),
                    windDto.getDeg());
        }
        return new Wind();
    }

    public WindDto mapToWindDto(Wind wind) {
        return new WindDto(
                wind.getSpeedInMetersPerSecond(),
                wind.getDeg());
    }
}
