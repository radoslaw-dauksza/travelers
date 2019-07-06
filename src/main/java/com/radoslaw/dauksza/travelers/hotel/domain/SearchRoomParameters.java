package com.radoslaw.dauksza.travelers.hotel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class SearchRoomParameters {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String searchId;
    private long hotelId;
    private String recGuestQty;
    private String recChildrenQty;
    private String recChildrenAge;
}
