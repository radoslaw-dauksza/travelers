package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.URI;
import java.util.List;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDto {

    @JsonProperty("accommodation_type")
    private int accommodationType;

    @JsonProperty("location_score")
    private double locationScore;

    @JsonProperty("city_in_trans")
    private String translatedCityName;

    @JsonProperty("business_review_score_word")
    private String businessReviewScoreWord;

    @JsonProperty("address")
    private String address;

    @JsonProperty("hotel_id")
    private long hotelId;

    @JsonProperty("block_ids")
    private List<String> blockIds;

    @JsonProperty("ufi")
    private int ufi;

    @JsonProperty("main_photo_url")
    private URI mainPhotoUrl;

    @JsonProperty("location_score_word")
    private String locationScoreWord;

    @JsonProperty("cleanliness_score_word")
    private String cleanlinessScoreWord;

    @JsonProperty("class")
    private int cls;

    @JsonProperty("is_free_cancellable")
    private boolean isFreeCancellable;

    @JsonProperty("checkout")
    private HoursDto checkOut;

    @JsonProperty("address_trans")
    private String translatedAddress;

    @JsonProperty("countrycode")
    private String countryCode;

    @JsonProperty("default_language")
    private String defaultLanguageCode;

    @JsonProperty("price_is_final")
    private boolean isPriceFinal;

    @JsonProperty("url")
    private URI url;

    @JsonProperty("district_id")
    private long districtId;

    @JsonProperty("booking_home")
    private BookingHomeDto bookingHomeDto;

    @JsonProperty("country_trans")
    private String countryTrans;

    @JsonProperty("main_photo_id")
    private long mainPhotoId;

    @JsonProperty("cleanliness_score")
    private double cleanlinessScore;

    @JsonProperty("distance_to_cc")
    private double distanceToCc;

    @JsonProperty("districts")
    private String districts;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("available_rooms")
    private int availableRooms;

    @JsonProperty("hotel_name")
    private String hotelName;

    @JsonProperty("accommodation_type_name")
    private String accommodationTypeName;

    @JsonProperty("cleanliness_score_reviews_nr")
    private int cleanlinessScoreReviewsNr;

    @JsonProperty("is_city_center")
    private boolean isCityCenter;

    @JsonProperty("district")
    private String district;

    @JsonProperty("city")
    private String cityName;

    @JsonProperty("business_review_nr")
    private int businessReviewNr;

    @JsonProperty("facilities_review_score")
    private FacilitiesReviewScoreDto facilitiesReviewScoreDto;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("is_wholesaler_candidate")
    private boolean isWholesalerCandidate;

    @JsonProperty("distance")
    private double distance;

    @JsonProperty("review_nr")
    private int reviewNr;

    @JsonProperty("hotel_name_trans")
    private String hotelNameTrans;

    @JsonProperty("is_no_prepayment_block")
    private boolean isNoPrepaymentBlock;

    @JsonProperty("review_score_word")
    private String reviewScoreWord;

    @JsonProperty("hotel_include_breakfast")
    private boolean isHotelIncludeBreakfast;

    @JsonProperty("extended")
    private boolean isExtended;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("business_review_score")
    private double businessReviewScore;

    @JsonProperty("city_name_en")
    private String cityNameEn;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("breakfast_review_score")
    private BreakfastReviewScoreDto breakfastReviewScoreDto;

    @JsonProperty("location_score_reviews_nr")
    private int locationScoreReviewsNr;

    @JsonProperty("checkin")
    private HoursDto checkIn;

    @JsonProperty("review_score")
    private double reviewScore;

    @JsonProperty("cc_required")
    private boolean ccRequired;

    @JsonProperty("min_total_price")
    private double minTotalPrice;

    @JsonProperty("city_trans")
    private String cityTrans;

    @JsonProperty("zip")
    private String zip;
}
