package com.radoslaw.dauksza.travelers.hotel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "facility_review_scores")
@Getter
@NoArgsConstructor
public class FacilitiesReviewScore {
    @Id
    @GeneratedValue
    @NotNull
    private long id;
    private int reviewCount;
    private String ratingMessage;
    private double rating;

    public FacilitiesReviewScore(int reviewCount, String ratingMessage, double rating) {
        this.reviewCount = reviewCount;
        this.ratingMessage = ratingMessage;
        this.rating = rating;
    }
}
