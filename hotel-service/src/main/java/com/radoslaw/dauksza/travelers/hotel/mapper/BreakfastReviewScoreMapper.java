package com.radoslaw.dauksza.travelers.hotel.mapper;

import com.radoslaw.dauksza.travelers.hotel.domain.BreakfastReviewScore;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.BreakfastReviewScoreDto;
import org.springframework.stereotype.Component;

@Component
public class BreakfastReviewScoreMapper {

    BreakfastReviewScore mapToBreakfastReviewScore(BreakfastReviewScoreDto breakfastReviewScoreDto) {
        return new BreakfastReviewScore(
                breakfastReviewScoreDto.getReviewCount(),
                breakfastReviewScoreDto.getReviewScoreWord(),
                breakfastReviewScoreDto.getRating());
    }

    BreakfastReviewScoreDto mapToBreakfastReviewScoreDto(BreakfastReviewScore breakfastReviewScore) {
        return new BreakfastReviewScoreDto(
                breakfastReviewScore.getReviewScoreWord(),
                breakfastReviewScore.getRating(),
                breakfastReviewScore.getReviewCount());
    }
}
