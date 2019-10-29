package com.radoslaw.dauksza.travelers.event.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StartDto {

    @JsonProperty("time")
    private LocalTime time;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("datetime")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private ZonedDateTime datetime;
}
