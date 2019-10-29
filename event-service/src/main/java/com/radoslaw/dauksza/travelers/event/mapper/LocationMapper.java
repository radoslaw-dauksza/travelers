package com.radoslaw.dauksza.travelers.event.mapper;

import com.radoslaw.dauksza.travelers.event.domain.Location;
import com.radoslaw.dauksza.travelers.event.domain.dto.LocationDto;
import org.springframework.stereotype.Component;

@Component("EventLocationMapper")
public class LocationMapper {
    public Location mapToLocation(LocationDto locationDto) {
        return new Location(locationDto.getLon(),
                locationDto.getLat(),
                locationDto.getCity());
    }

    public LocationDto mapToLocationDto(Location location) {
        return new LocationDto(location.getLon(),
                location.getLat(),
                location.getCity());
    }
}
