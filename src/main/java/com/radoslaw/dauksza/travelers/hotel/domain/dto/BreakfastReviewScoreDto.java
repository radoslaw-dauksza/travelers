package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BreakfastReviewScoreDto {

    @JsonProperty("review_score_word")
    private String reviewScoreWord;

    @JsonProperty("rating")
    private double rating;

    @JsonProperty("review_count")
    private int reviewCount;
}
