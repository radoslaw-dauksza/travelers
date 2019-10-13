package com.radoslaw.dauksza.travelers.event.mapper;

import com.radoslaw.dauksza.travelers.event.domain.Result;
import com.radoslaw.dauksza.travelers.event.domain.dto.ResultDto;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {
    private final EventMapper eventMapper;

    public ResultMapper(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    public Result mapToResult(ResultDto resultDto) {
        return new Result(eventMapper.mapToEvents(resultDto.getEventDto()));
    }

    public ResultDto mapToResultDtos(Result result) {
        return new ResultDto(eventMapper.mapToEventDtos(result.getEvents()));
    }
}
