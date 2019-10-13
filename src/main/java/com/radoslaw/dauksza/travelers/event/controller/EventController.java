package com.radoslaw.dauksza.travelers.event.controller;

import com.radoslaw.dauksza.travelers.event.domain.dto.SongkickEventsDto;
import com.radoslaw.dauksza.travelers.event.service.EventService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("event")
    public SongkickEventsDto getEvents(@RequestParam double lat, @RequestParam double lon,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
                                       @RequestParam byte page) {
        return eventService.getSongkickEventsDto(lat, lon, from, to, page);
    }
}
