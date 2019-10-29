package com.radoslaw.dauksza.travelers.hotel.booking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.radoslaw.dauksza.travelers.hotel.domain.HotelSearchParameters;
import com.radoslaw.dauksza.travelers.hotel.domain.SearchRoomParameters;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.*;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingApiClient {
    private BookingApiConfig bookingApiConfig;
    private ObjectMapper objectMapper;

    public BookingApiClient(BookingApiConfig bookingApiConfig, ObjectMapper objectMapper) {
        this.bookingApiConfig = bookingApiConfig;
        this.objectMapper = objectMapper;
    }

    public List<LocationDto> getAutoCompleteLocations(String languageCode, String text) {
        String uri = UriComponentsBuilder
                .fromHttpUrl(bookingApiConfig.getBookingApiEndpoint())
                .pathSegment("locations")
                .pathSegment("auto-complete")
                .queryParam("text", text)
                .queryParam("languecode", languageCode)
                .build().encode().toUriString();

        return Unirest.get(uri)
                .header("X-RapidAPI-Key", bookingApiConfig.getBookingApiKey())
                .asJson()
                .getBody().getArray().toList().stream()
                .map(o -> objectMapper.convertValue(o, LocationDto.class))
                .collect(Collectors.toList());
    }

    public PropertiesListResponseDto getProppertiesList(HotelSearchParameters searchParameters) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromHttpUrl(bookingApiConfig.getBookingApiEndpoint())
                .pathSegment("properties")
                .pathSegment("list")
                .queryParam("search_type", searchParameters.getSearchType())
                .queryParam("offset", searchParameters.getOffset())
                .queryParam("dest_ids", searchParameters.getDestinationIdOrUfi())
                .queryParam("guest_qty", searchParameters.getGuestQty())
                .queryParam("arrival_date", searchParameters.getCheckInDate())
                .queryParam("departure_date", searchParameters.getCheckOutDate())
                .queryParam("room_qty", searchParameters.getRoomQty())
                .queryParam("languagecode", searchParameters.getLanguageCode())
                .queryParam("price_filter_currencycode", "PLN")
                .queryParam("search_id", "none");

        if (searchParameters.getChildrenQty() != 0 && searchParameters.getChildrenAge().isEmpty()) {
            uriComponentsBuilder = uriComponentsBuilder
                    .queryParam("children_qty", searchParameters.getChildrenQty())
                    .queryParam("children_age", searchParameters.getChildrenAge());
        }

        String uri = uriComponentsBuilder.build().encode().toUriString();

        JsonNode response = Unirest.get(uri)
                .header("X-RapidAPI-Key", bookingApiConfig.getBookingApiKey())
                .asJson().getBody();

        try {
            return objectMapper.readValue(response.toString(), PropertiesListResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new PropertiesListResponseDto();
    }

    public List<BookedRoomDetailsDto> getRoomDetails(SearchRoomParameters searchRoomParameters) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(bookingApiConfig.getBookingApiEndpoint())
                .pathSegment("properties")
                .pathSegment("get-rooms")
                .queryParam("departure_date", searchRoomParameters.getCheckOutDate())
                .queryParam("arrival_date", searchRoomParameters.getCheckInDate())
                .queryParam("search_id", searchRoomParameters.getSearchId())
                .queryParam("hotel_id", searchRoomParameters.getHotelId())
                .queryParam("rec_guest_qty", searchRoomParameters.getRecGuestQty())
                .queryParam("languagecode", "pl-pl");
        if (true) {
            uriComponentsBuilder = uriComponentsBuilder
                    .queryParam("rec_children_qty", searchRoomParameters.getRecChildrenQty())
                    .queryParam("rec_children_age", searchRoomParameters.getRecChildrenAge());
        }

        String uri = uriComponentsBuilder.build().encode().toUriString();

        JsonNode response = Unirest.get(uri)
                .header("X-RapidAPI-Key", bookingApiConfig.getBookingApiKey())
                .asJson().getBody();
        return response.getArray().toList().stream()
                .map(o -> objectMapper.convertValue(o, BookedRoomDetailsDto.class))
                .collect(Collectors.toList());
    }

    public List<PropertyDescriptionDto> getPropertiesDescriptions(long hotelId) {
        String uri = UriComponentsBuilder
                .fromHttpUrl(bookingApiConfig.getBookingApiEndpoint())
                .pathSegment("properties")
                .pathSegment("get-description")
                .queryParam("hotel_ids", hotelId)
                .queryParam("languagecode", "pl-pl")
                .build()
                .toUriString();

        JsonNode response = Unirest.get(uri)
                .header("X-RapidAPI-Key", bookingApiConfig.getBookingApiKey())
                .asJson().getBody();

        return response.getArray().toList().stream()
                .map(o -> objectMapper.convertValue(o, PropertyDescriptionDto.class))
                .collect(Collectors.toList());
    }

}
