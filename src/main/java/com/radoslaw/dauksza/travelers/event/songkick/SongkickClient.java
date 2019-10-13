package com.radoslaw.dauksza.travelers.event.songkick;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.radoslaw.dauksza.travelers.event.domain.dto.ResultDto;
import com.radoslaw.dauksza.travelers.event.domain.dto.ResultPageDto;
import com.radoslaw.dauksza.travelers.event.domain.dto.SongkickEventsDto;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class SongkickClient {
    private final SongkickConfig songkickConfig;
    private final RestTemplate restTemplate;
    ObjectMapper objectMapper;

    public SongkickClient(SongkickConfig songkickConfig, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.songkickConfig = songkickConfig;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public SongkickEventsDto getSongkickEventsDto(double lat, double lon, LocalDate from, LocalDate to, byte page) {
        String uri = UriComponentsBuilder.fromUriString(songkickConfig.getSongkickEndPoint())
                .queryParam("apikey", songkickConfig.getSongkickApiKey())
                .queryParam("location", "geo:" + lat + "," + lon)
                .queryParam("min_date", from)
                .queryParam("max_date", to)
                .queryParam("page", page)
                .toUriString();

        try {
            return restTemplate.getForObject(uri, SongkickEventsDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new SongkickEventsDto(new ResultPageDto(
                    new ResultDto(new ArrayList<>()),
                    1,
                    0L,
                    (byte) 50
            ));
        }
    }
}
