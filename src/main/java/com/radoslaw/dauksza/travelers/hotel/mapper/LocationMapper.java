package com.radoslaw.dauksza.travelers.hotel.mapper;

import com.radoslaw.dauksza.travelers.hotel.domain.Location;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.LocationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationMapper {

    public Location mapToLocation(LocationDto locationDto) {
        return new Location(
                locationDto.getCityUfi(),
                locationDto.getLongitude(),
                locationDto.getLatitude(),
                locationDto.getCityName(),
                locationDto.getHotels(),
                locationDto.getRegion(),
                locationDto.getDestId(),
                locationDto.getCountry(),
                locationDto.getImageUrl(),
                locationDto.getLabel(),
                locationDto.getType(),
                locationDto.getName(),
                locationDto.getDestType(),
                locationDto.getNrHotels(),
                locationDto.getTimezone(),
                locationDto.getLc(),
                locationDto.getRtl(),
                locationDto.getCc1());
    }

    public LocationDto mapToLocationDto(Location location) {
        return new LocationDto(
                location.getCityUfi(),
                location.getLongitude(),
                location.getLatitude(),
                location.getCityName(),
                location.getHotels(),
                location.getRegion(),
                location.getDestId(),
                location.getCountry(),
                location.getImageUrl(),
                location.getLabel(),
                location.getType(),
                location.getName(),
                location.getDestType(),
                location.getNrHotels(),
                location.getTimezone(),
                location.getLc(),
                location.getRtl(),
                location.getCc1());
    }

    public List<Location> mapToLocations(List<LocationDto> locationDtos) {
        return locationDtos.stream()
                .map(this::mapToLocation)
                .collect(Collectors.toList());
    }

    public List<LocationDto> mapToLocationDtos(List<Location> locations) {
        return locations.stream()
                .map(this::mapToLocationDto)
                .collect(Collectors.toList());
    }
}
