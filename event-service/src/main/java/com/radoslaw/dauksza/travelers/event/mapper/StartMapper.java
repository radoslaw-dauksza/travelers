package com.radoslaw.dauksza.travelers.event.mapper;

import com.radoslaw.dauksza.travelers.event.domain.Start;
import com.radoslaw.dauksza.travelers.event.domain.dto.StartDto;
import org.springframework.stereotype.Component;

@Component
public class StartMapper {
    public Start mapToStart(StartDto startDto) {
        return new Start(startDto.getTime(),
                startDto.getDate(),
                startDto.getDatetime());
    }

    public StartDto mapToStartDto(Start start) {
        return new StartDto(start.getTime(),
                start.getDate(),
                start.getDatetime());
    }
}
