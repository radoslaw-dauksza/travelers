package com.radoslaw.dauksza.travelers.hotel.domain;

import lombok.Value;

import java.time.LocalDate;

import static com.radoslaw.dauksza.travelers.hotel.validator.SearchParametersValidator.validateBookingDates;
import static com.radoslaw.dauksza.travelers.hotel.validator.SearchParametersValidator.validateChildren;

@Value
public class SearchRoomParameters {
    LocalDate checkInDate;
    LocalDate checkOutDate;
    String searchId;
    long hotelId;
    String recGuestQty;
    String recChildrenQty;
    String recChildrenAge;

    public SearchRoomParameters(LocalDate checkInDate, LocalDate checkOutDate,
                                String searchId, long hotelId, String recGuestQty,
                                String recChildrenQty, String recChildrenAge) {
        if (validateBookingDates(checkInDate, checkOutDate)) {
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
        } else {
            throw new IllegalArgumentException("the check in date must be at least today," +
                    " and the check out date must be after the check in date.");
        }
        this.searchId = searchId;
        this.hotelId = hotelId;
        this.recGuestQty = recGuestQty;
        if (validateChildren(recChildrenAge, recChildrenQty)) {
            this.recChildrenQty = recChildrenQty;
            this.recChildrenAge = recChildrenAge;
        } else {
            throw new IllegalArgumentException("wrong children age: " + recChildrenAge + "\n" +
                    "or children quantity: " + recChildrenQty);
        }
    }
}
