package com.radoslaw.dauksza.travelers.hotel.mapper;

import com.radoslaw.dauksza.travelers.hotel.domain.BookingHome;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.BookingHomeDto;
import org.springframework.stereotype.Component;

@Component
public class BookingHomeMapper {

    BookingHome mapToBookingHome(BookingHomeDto bookingHomeDto) {
        return new BookingHome(
                bookingHomeDto.isSingleProperty(),
                bookingHomeDto.getIsBookingHome(),
                bookingHomeDto.getGroup(),
                bookingHomeDto.getSegment());
    }

    BookingHomeDto mapToBookingHomeDto(BookingHome bookingHome) {
        return new BookingHomeDto(
                bookingHome.isSingleProperty(),
                bookingHome.getIsBookingHome(),
                bookingHome.getGroup(),
                bookingHome.getSegment());
    }
}
