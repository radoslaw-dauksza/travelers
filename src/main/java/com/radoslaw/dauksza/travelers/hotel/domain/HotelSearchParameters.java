package com.radoslaw.dauksza.travelers.hotel.domain;

import com.radoslaw.dauksza.travelers.hotel.validator.SearchParametersValidator;
import lombok.Value;

import java.time.LocalDate;

import static com.radoslaw.dauksza.travelers.hotel.domain.HotelSearchParametersOrderBy.POPULARITY;
import static com.radoslaw.dauksza.travelers.hotel.validator.SearchParametersValidator.validateChildren;
import static com.radoslaw.dauksza.travelers.hotel.validator.SearchParametersValidator.validateOrderBy;

@Value
public class HotelSearchParameters {
    String searchType;
    int offset;
    long destinationIdOrUfi;
    int guestQty;
    int roomQty;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    int childrenQty;
    String childrenAge;
    String languageCode;
    double longitude;
    double latitude;
    String orderBy;

    public HotelSearchParameters(String searchType, int offset, long destinationIdOrUfi,
                                 int guestQty, int roomQty, LocalDate checkInDate, LocalDate checkOutDate,
                                 int childrenQty, String childrenAge, String languageCode,
                                 double longitude, double latitude, String orderBy) {

        this.searchType = searchType;
        this.offset = Math.max(offset, 0);
        this.destinationIdOrUfi = destinationIdOrUfi;
        if (guestQty <= 0) {
            this.guestQty = 1;
        } else {
            this.guestQty = guestQty;
        }
        if (roomQty <= 0) {
            this.roomQty = 1;
        } else {
            this.roomQty = guestQty;
        }
        if (SearchParametersValidator.validateBookingDates(checkInDate, checkOutDate)) {
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
        } else {
            throw new IllegalArgumentException("the check in date must be at least today," +
                    " and the check out date must be after the check in date.");
        }
        if (validateChildren(childrenAge, childrenQty)) {
            this.childrenQty = childrenQty;
            this.childrenAge = childrenAge;
        } else {
            throw new IllegalArgumentException("wrong children age: " + childrenAge + "\n" +
                    "or children quantity: " + childrenAge);
        }
        if (languageCode.isEmpty()) {
            this.languageCode = "pl-pl";
        } else {
            this.languageCode = languageCode;
        }
        if (searchType.equals("latlong")) {
            this.longitude = longitude;
            this.latitude = latitude;
        } else {
            this.longitude = 0;
            this.latitude = 0;
        }
        if (validateOrderBy(orderBy)) {
            this.orderBy = orderBy;
        } else {
            this.orderBy = POPULARITY;
        }
    }
}
