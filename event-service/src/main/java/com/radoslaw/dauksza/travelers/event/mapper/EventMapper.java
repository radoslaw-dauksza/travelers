package com.radoslaw.dauksza.travelers.event.mapper;

import com.radoslaw.dauksza.travelers.event.domain.Event;
import com.radoslaw.dauksza.travelers.event.domain.dto.EventDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {
    private final VenueMapper venueMapper;
    private final LocationMapper locationMapper;
    private final StartMapper startMapper;
    private final PerformanceMapper performanceMapper;

    public EventMapper(VenueMapper venueMapper, LocationMapper locationMapper,
                       StartMapper startMapper, PerformanceMapper performanceMapper) {
        this.venueMapper = venueMapper;
        this.locationMapper = locationMapper;
        this.startMapper = startMapper;
        this.performanceMapper = performanceMapper;
    }

    public Event mapToEvent(EventDto eventDto) {
        return new Event(eventDto.getDisplayName(),
                eventDto.getType(),
                eventDto.getUri(),
                venueMapper.mapToVenue(eventDto.getVenueDto()),
                locationMapper.mapToLocation(eventDto.getLocationDto()),
                startMapper.mapToStart(eventDto.getStartDto()),
                performanceMapper.mapToPerformances(eventDto.getPerformanceDtos()),
                eventDto.getId());
    }

    public EventDto mapToEventDto(Event event) {
        return new EventDto(event.getDisplayName(),
                event.getType(),
                event.getUri(),
                venueMapper.mapToVenueDto(event.getVenue()),
                locationMapper.mapToLocationDto(event.getLocation()),
                startMapper.mapToStartDto(event.getStart()),
                performanceMapper.mapToPerformanceDtos(event.getPerformances()),
                event.getId());
    }

    public List<Event> mapToEvents(List<EventDto> eventDtos) {
        return eventDtos.parallelStream()
                .map(this::mapToEvent)
                .collect(Collectors.toList());
    }

    public List<EventDto> mapToEventDtos(List<Event> events) {
        return events.parallelStream()
                .map(this::mapToEventDto)
                .collect(Collectors.toList());
    }
}
