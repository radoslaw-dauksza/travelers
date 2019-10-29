package com.radoslaw.dauksza.travelers.weather.mapper;

import com.radoslaw.dauksza.travelers.weather.domain.Snow;
import com.radoslaw.dauksza.travelers.weather.domain.dto.SnowDto;
import org.springframework.stereotype.Component;

@Component
public class SnowMapper {
    public Snow mapToSnow(SnowDto snowDto) {
        if (snowDto != null) {
            return new Snow(snowDto.getVolumeInLast3H());
        }
        return new Snow();
    }

    public SnowDto mapToSnowDto(Snow snow) {
        return new SnowDto(snow.getVolumeInLast3H());
    }
}
