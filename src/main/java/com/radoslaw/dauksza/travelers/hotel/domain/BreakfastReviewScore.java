package com.radoslaw.dauksza.travelers.hotel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "breakfast_review_scores")
@Getter
@NoArgsConstructor
public class BreakfastReviewScore {
    @Id
    @GeneratedValue
    @NotNull
    private long id;
    private int reviewCount;
    private String reviewScoreWord;
    private double rating;

    public BreakfastReviewScore(int reviewCount, String reviewScoreWord, double rating) {
        this.reviewCount = reviewCount;
        this.reviewScoreWord = reviewScoreWord;
        this.rating = rating;
    }
}
