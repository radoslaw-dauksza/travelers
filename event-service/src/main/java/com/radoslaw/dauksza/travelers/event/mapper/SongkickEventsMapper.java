package com.radoslaw.dauksza.travelers.event.mapper;

import com.radoslaw.dauksza.travelers.event.domain.SongkickEvents;
import com.radoslaw.dauksza.travelers.event.domain.dto.SongkickEventsDto;
import org.springframework.stereotype.Component;

@Component
public class SongkickEventsMapper {
    private final ResultPageMapper resultPageMapper;

    public SongkickEventsMapper(ResultPageMapper resultPageMapper) {
        this.resultPageMapper = resultPageMapper;
    }

    public SongkickEvents mapToSongkickEvents(SongkickEventsDto songkickEventsDto) {
        return new SongkickEvents(resultPageMapper.mapToResultPage(songkickEventsDto.getResultPageDto()));
    }

    public SongkickEventsDto mapToSongkickEventsDto(SongkickEvents songkickEvents) {
        return new SongkickEventsDto(resultPageMapper.mapToResultPageDto(songkickEvents.getResultPage()));
    }
}
