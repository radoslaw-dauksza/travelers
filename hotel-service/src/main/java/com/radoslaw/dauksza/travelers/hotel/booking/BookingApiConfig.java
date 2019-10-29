package com.radoslaw.dauksza.travelers.hotel.booking;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class BookingApiConfig {

    @Value("${booking.hotel.api.endpoint}")
    private String BookingApiEndpoint;

    @Value("${booking.hotel.api.key}")
    private String BookingApiKey;
}
