package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FacilitiesReviewScoreDto {

    @JsonProperty("review_count")
    private int reviewCount;

    @JsonProperty("rating_message")
    private String ratingMessage;

    @JsonProperty("rating")
    private double rating;
}
