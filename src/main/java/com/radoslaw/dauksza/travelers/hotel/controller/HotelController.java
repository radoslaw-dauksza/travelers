package com.radoslaw.dauksza.travelers.hotel.controller;


import com.radoslaw.dauksza.travelers.hotel.domain.HotelSearchParameters;
import com.radoslaw.dauksza.travelers.hotel.domain.SearchRoomParameters;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.BookedRoomDetailsDto;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.LocationDto;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.PropertiesListResponseDto;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.PropertyDescriptionDto;
import com.radoslaw.dauksza.travelers.hotel.service.HotelService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class HotelController {
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public PropertiesListResponseDto findProperties(
            @RequestParam String searchType, @RequestParam(required = false) int offset,
            @RequestParam long destinationIdOrUfi, @RequestParam(required = false) int guestQty,
            @RequestParam(required = false) int roomQty, @RequestParam LocalDate checkInDate,
            @RequestParam LocalDate checkOutDate, @RequestParam(required = false) int childrenQty,
            @RequestParam(required = false) String childrenAge, @RequestParam(required = false) String languageCode,
            @RequestParam(required = false) double longitude, @RequestParam(required = false) double latitude,
            @RequestParam(required = false) String orderBy) {

        HotelSearchParameters searchParameters = new HotelSearchParameters(
                searchType, offset, destinationIdOrUfi, guestQty, roomQty, checkInDate,
                checkOutDate, childrenQty, childrenAge, languageCode, longitude, latitude, orderBy);

        return hotelService.findProperties(searchParameters);
    }

    @GetMapping("hotels/places")
    public List<LocationDto> getAutocompletePlaces(@RequestParam String languageCode, @RequestParam String text) {

        return hotelService.getAutocompletePlaces(languageCode, text);
    }

    @GetMapping("/rooms")
    public List<BookedRoomDetailsDto> getRoomsDetails(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate,
            @RequestParam String searchId, @RequestParam long hotelId,
            @RequestParam String recGuestQty, @RequestParam(required = false) String recChildrenQty,
            @RequestParam(required = false) String recChildrenAge) {

        SearchRoomParameters searchRoomParameters = new SearchRoomParameters(
                checkInDate, checkOutDate, searchId, hotelId, recGuestQty, recChildrenQty, recChildrenAge);

        return hotelService.getRoomsDetails(searchRoomParameters);
    }

    @GetMapping("/hotels/details/{hotelId}")
    public List<PropertyDescriptionDto> getHotelDescription(@PathVariable long hotelId) {
        return hotelService.getHotelDescription(hotelId);
    }
}
