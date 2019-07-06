package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FacilitiesReviewScoreDto {

    @JsonProperty("review_count")
    private int reviewCount;

    @JsonProperty("rating_message")
    private String ratingMesage;

    @JsonProperty("rating")
    private double rating;
}
