package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HostFeaturedReviewDto {

    @JsonProperty("title")
    private String title;

    @JsonProperty("review_id")
    private long reviewId;

    @JsonProperty("travel_purpose")
    private String travelPurpose;

    @JsonProperty("cons")
    private String cons;

    @JsonProperty("date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @JsonProperty("pros")
    private String pros;

    @JsonProperty("average_score_out_of_10")
    private double averageScoreOutOf10;

    @JsonProperty("author")
    private AuthorDto authorDto;

    @JsonProperty("languagecode")
    private String languageeCode;

}
