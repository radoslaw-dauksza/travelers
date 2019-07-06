package com.radoslaw.dauksza.travelers.hotel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class HotelSearchParameters {
    String searchType = "city";
    int offset = 0;
    long destinationIdOrUfi;
    int guestQty = 1;
    int roomQty = 1;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    int childrenQty;
    String childrenAge;
    String languageCode = "pl-pl";
    double longitude;
    double latitude;
}
