package com.radoslaw.dauksza.travelers.hotel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@Data
@Entity(name = "properties")
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    private int accommodationType;
    private double locationScore;
    private String translatedCityName;
    private String businessReviewScoreWord;
    private String address;
    @Id
    @NotNull
    private long hotelId;
    @ElementCollection(targetClass = String.class)
    private List<String> blockIds;
    private int ufi;
    private URI mainPhotoUrl;
    private String locationScoreWord;
    private String cleanlinessScoreWord;
    @Column(name = "class")
    private int cls;
    private boolean isFreeCancellable;
    @OneToOne
    @JoinColumn
    private Hours checkOut;
    private String translatedAddress;
    private String countryCode;
    private String defaultLanguageCode;
    private boolean isPriceFinal;
    private URI url;
    private long districtId;
    @OneToOne
    @JoinColumn
    private BookingHome bookingHome;
    private String countryTrans;
    private long mainPhotoId;
    private double cleanlinessScore;
    private double distanceToCc;
    private String districts;
    private double latitude;
    private int availableRooms;
    private String hotelName;
    private String accommodationTypeName;
    private int cleanlinessScoreReviewsNr;
    private boolean isCityCenter;
    private String district;
    private String cityName;
    private int businessReviewNr;
    @OneToOne
    @JoinColumn
    private FacilitiesReviewScore facilitiesReviewScore;
    private String timezone;
    private boolean isWholesalerCandidate;
    private double distance;
    private int reviewNr;
    private String hotelNameTrans;
    private boolean isNoPrepaymentBlock;
    private String reviewScoreWord;
    private boolean hotelIncludeBreakfast;
    private boolean isExtended;
    private String currencyCode;
    private double businessReviewScore;
    private String cityNameEn;
    private double longitude;
    @OneToOne
    @JoinColumn
    private BreakfastReviewScore breakfastReviewScore;
    private int locationScoreReviewsNr;
    @OneToOne
    @JoinColumn
    private Hours checkIn;
    private double reviewScore;
    private boolean ccRequired;
    private double minTotalPrice;
    private String cityTrans;
    private String zip;
}
