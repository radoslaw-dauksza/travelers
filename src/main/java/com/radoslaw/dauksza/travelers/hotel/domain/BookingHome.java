package com.radoslaw.dauksza.travelers.hotel.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "booking_homes")
@NoArgsConstructor
public class BookingHome {
    @Id
    @GeneratedValue
    @NotNull
    private long id;
    private boolean isSingleProperty;
    private String isBookingHome;
    @Column(name = "family")
    private String group;
    private int segment;

    public BookingHome(boolean isSingleProperty, String isBookingHome, String group, int segment) {
        this.isSingleProperty = isSingleProperty;
        this.isBookingHome = isBookingHome;
        this.group = group;
        this.segment = segment;
    }
}
