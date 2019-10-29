package com.radoslaw.dauksza.travelers.event.service;

import com.radoslaw.dauksza.travelers.event.domain.*;
import com.radoslaw.dauksza.travelers.event.domain.dto.SongkickEventsDto;
import com.radoslaw.dauksza.travelers.event.domain.dto.StartDto;
import com.radoslaw.dauksza.travelers.event.mapper.SongkickEventsMapper;
import com.radoslaw.dauksza.travelers.event.repository.*;
import com.radoslaw.dauksza.travelers.event.songkick.SongkickClient;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final SongkickEventsMapper songkickEventsMapper;
    private final SongkickClient songkickClient;
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;
    private final VenueRepository venueRepository;
private final ArtistRepository artistRepository;
private final IdentifierRepository identifierRepository;
private final PerformanceRepository performanceRepository;
private final StartRepository startRepository;

    public EventService(SongkickEventsMapper songkickEventsMapper, SongkickClient songkickClient,
                        EventRepository eventRepository, LocationRepository locationRepository,
                        VenueRepository venueRepository, ArtistRepository artistRepository,
                        IdentifierRepository identifierRepository, PerformanceRepository performanceRepository,
                        StartRepository startRepository) {
        this.songkickEventsMapper = songkickEventsMapper;
        this.songkickClient = songkickClient;
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
        this.venueRepository = venueRepository;
        this.artistRepository = artistRepository;
        this.identifierRepository = identifierRepository;
        this.performanceRepository = performanceRepository;
        this.startRepository = startRepository;
    }

    public SongkickEventsDto getSongkickEventsDto(double lat, double lon, LocalDate from, LocalDate to, byte page) {
        SongkickEventsDto songkickEventsDto = songkickClient.getSongkickEventsDto(lat, lon, from, to, page);
        songkickEventsDto.getResultPageDto().getResultDto().getEventDto().forEach(eventDto -> System.out.println(eventDto.getStartDto().getDatetime()));
        SongkickEvents songkickEvents = songkickEventsMapper.mapToSongkickEvents(songkickEventsDto);
        List<Event> l = songkickEvents.getResultPage().getResult().getEvents();
        for(Event e: l) {
            System.out.println(e.getStart().getDatetime());
            List<Performance> performances = e.getPerformances();
            List<Artist> artists = performances.parallelStream()
                    .map(Performance::getArtist)
                    .collect(Collectors.toList());
            List<Identifier> identifiers = artists.parallelStream()
                    .map(Artist::getIdentifier)
                    .flatMap(List::parallelStream)
                    .collect(Collectors.toList());
            System.out.println(e.getLocation());
            locationRepository.save(e.getLocation());
            venueRepository.save(e.getVenue());
            identifierRepository.saveAll(identifiers);
            artistRepository.saveAll(artists);
            performanceRepository.saveAll(performances);
            startRepository.save(e.getStart());
            eventRepository.save(e);
        }
        return songkickEventsDto;
    }
}
