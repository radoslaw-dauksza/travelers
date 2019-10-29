package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookedRoomDetailsDto {

    @JsonProperty("host_score")
    private double hostScore;

    @JsonProperty("host_profile")
    private HostProfileDto hostProfileDto;

    @JsonProperty("average_room_size_for_ufi_m2")
    private double averageRoomSizeForUfiM2;

    @JsonProperty("arrival_date")
    private LocalDate arrivalDate;

    @JsonProperty("nr_bookings_today")
    private int nrOfBookingsToday;

    @JsonProperty("city_trans")
    private String cityTrans;

    @JsonProperty("is_single_unit_vr")
    private boolean isSingleUnitVr;

    @JsonProperty("hotel_id")
    private long hotelId;

    @JsonProperty("default_language")
    private String defaultLanguage;

    @JsonProperty("top_ufi_benefits")
    private List<UfiBenefitDto> topUfiBenefitDtos;

    @JsonProperty("max_rooms_in_reservation")
    private int maxRoomsInReservation;

    @JsonProperty("spoken_languages")
    private List<String> spokenLanguages;

    @JsonProperty("hotel_include_breakfast")
    private boolean hotelIncludeBreakfast;

    @JsonProperty("is_crimea")
    private boolean isCrimea;

    @JsonProperty("family_facilities")
    private List<String> familyFacilities;

    @JsonProperty("host_name")
    private List<String> hostName;

    @JsonProperty("block")
    private List<BlockDto> blockDtos;

    @JsonProperty("departure_date")
    private LocalDate departureDate;

    @JsonProperty("wifi_review_score")
    private WifiReviewScoreDto wifiRewiewScore;

    @JsonProperty("timezone")
    private String timeZone;

    @JsonProperty("hotel_text")
    private HotelTextDto hotelTextDto;

    @JsonProperty("booking_home")
    private BookedRoomDetailsBookingHomeDto bookingHome;

    @JsonProperty("rooms")
    private RoomsDto roomsDto;

    @JsonProperty("host_score_count")
    private int hostScoreCount;
}
