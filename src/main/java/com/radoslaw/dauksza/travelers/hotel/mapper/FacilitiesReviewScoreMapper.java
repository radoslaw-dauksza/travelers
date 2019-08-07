package com.radoslaw.dauksza.travelers.hotel.mapper;

import com.radoslaw.dauksza.travelers.hotel.domain.FacilitiesReviewScore;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.FacilitiesReviewScoreDto;
import org.springframework.stereotype.Component;

@Component
public class FacilitiesReviewScoreMapper {

    FacilitiesReviewScore mapToFacilitiesReviewScore(FacilitiesReviewScoreDto facilitiesReviewScoreDto) {
        return new FacilitiesReviewScore(
                facilitiesReviewScoreDto.getReviewCount(),
                facilitiesReviewScoreDto.getRatingMessage(),
                facilitiesReviewScoreDto.getRating());
    }

    FacilitiesReviewScoreDto mapToFacilitiesReviewScoreDto(FacilitiesReviewScore facilitiesReviewScore) {
        return new FacilitiesReviewScoreDto(
                facilitiesReviewScore.getReviewCount(),
                facilitiesReviewScore.getRatingMessage(),
                facilitiesReviewScore.getRating());
    }
}
