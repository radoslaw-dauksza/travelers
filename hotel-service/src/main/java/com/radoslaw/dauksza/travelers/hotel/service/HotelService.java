package com.radoslaw.dauksza.travelers.hotel.service;

import com.radoslaw.dauksza.travelers.hotel.booking.BookingApiClient;
import com.radoslaw.dauksza.travelers.hotel.domain.HotelSearchParameters;
import com.radoslaw.dauksza.travelers.hotel.domain.Location;
import com.radoslaw.dauksza.travelers.hotel.domain.SearchRoomParameters;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.BookedRoomDetailsDto;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.LocationDto;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.PropertiesListResponseDto;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.PropertyDescriptionDto;
import com.radoslaw.dauksza.travelers.hotel.mapper.LocationMapper;
import com.radoslaw.dauksza.travelers.hotel.mapper.PropertyMapper;
import com.radoslaw.dauksza.travelers.hotel.repository.LocationRepository;
import com.radoslaw.dauksza.travelers.hotel.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private BookingApiClient client;
    private LocationRepository locationRepository;
    private PropertyRepository propertyRepository;
    private LocationMapper locationMapper;
    private PropertyMapper propertyMapper;

    public HotelService(BookingApiClient client, LocationRepository locationRepository,
                        PropertyRepository propertyRepository, LocationMapper locationMapper,
                        PropertyMapper propertyMapper) {
        this.client = client;
        this.locationRepository = locationRepository;
        this.propertyRepository = propertyRepository;
        this.locationMapper = locationMapper;
        this.propertyMapper = propertyMapper;
    }

    public PropertiesListResponseDto findProperties(HotelSearchParameters searchParameters) {
        PropertiesListResponseDto result = client.getProppertiesList(searchParameters);
        propertyRepository.saveAll(propertyMapper.mapToProperties(result.getResultDtos()));
        return result;
    }

    public List<LocationDto> getAutocompletePlaces(String languageCode, String text) {
        return locationMapper.mapToLocationDtos(
                (List<Location>) locationRepository.saveAll(
                        locationMapper.mapToLocations(
                                client.getAutoCompleteLocations(languageCode, text))));
    }

    public List<BookedRoomDetailsDto> getRoomsDetails(SearchRoomParameters searchRoomParameters) {
        return client.getRoomDetails(searchRoomParameters);
    }

    public List<PropertyDescriptionDto> getHotelDescription(long hotelId) {
        return client.getPropertiesDescriptions(hotelId);
    }
}
