package com.radoslaw.dauksza.travelers.hotel.mapper;

import com.radoslaw.dauksza.travelers.hotel.domain.Hours;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.HoursDto;
import org.springframework.stereotype.Component;

@Component
public class HoursMapper {

    Hours mapToHours(HoursDto hoursDto) {
        return new Hours(
                hoursDto.getFrom(),
                hoursDto.getUntil());
    }

    HoursDto mapToHoursDto(Hours hours) {
        return new HoursDto(
                hours.getFrom(),
                hours.getUntil());
    }
}
