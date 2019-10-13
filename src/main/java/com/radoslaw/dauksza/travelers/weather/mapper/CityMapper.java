package com.radoslaw.dauksza.travelers.weather.mapper;

import com.radoslaw.dauksza.travelers.weather.domain.City;
import com.radoslaw.dauksza.travelers.weather.domain.dto.CityDto;
import com.radoslaw.dauksza.travelers.weather.domain.dto.CoordDto;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    public City mapToCity(CityDto cityDto) {
        if (cityDto != null) {
            return new City(
                    cityDto.getId(),
                    cityDto.getName(),
                    cityDto.getCoordDto().getLat(),
                    cityDto.getCoordDto().getLon(),
                    cityDto.getCountryCode(),
                    cityDto.getTimezoneShiftFromUtcInSeconds());
        }
        return new City();
    }

    public CityDto mapToCityDto(City city) {
        return new CityDto(
                city.getId(),
                city.getName(),
                new CoordDto(city.getLon(), city.getLat()),
                city.getCountryCode(),
                city.getTimezoneShiftFromUtcInSeconds());
    }
}
