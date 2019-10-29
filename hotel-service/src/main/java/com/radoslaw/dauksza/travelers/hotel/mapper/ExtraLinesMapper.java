package com.radoslaw.dauksza.travelers.hotel.mapper;

import com.radoslaw.dauksza.travelers.hotel.domain.ExtraLines;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.ExtraLinesDto;
import org.springframework.stereotype.Component;

@Component
public class ExtraLinesMapper {

    public ExtraLines mapToExtraLines(ExtraLinesDto extraLinesDto) {
        return new ExtraLines(extraLinesDto.getImpInfo());
    }

    public ExtraLinesDto mapToExtraLinesDto(ExtraLines extraLines) {
        return new ExtraLinesDto(extraLines.getImpInfo());
    }
}
