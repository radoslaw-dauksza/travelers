package com.radoslaw.dauksza.travelers.hotel.mapper;

import com.radoslaw.dauksza.travelers.hotel.domain.Property;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.ResultDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PropertyMapper {
    private HoursMapper hoursMapper;
    private BookingHomeMapper bookingHomeMapper;
    private FacilitiesReviewScoreMapper facilitiesReviewScoreMapper;
    private BreakfastReviewScoreMapper breakfastReviewScoreMapper;

    public PropertyMapper(HoursMapper hoursMapper,
                          BookingHomeMapper bookingHomeMapper,
                          FacilitiesReviewScoreMapper facilitiesReviewScoreMapper,
                          BreakfastReviewScoreMapper breakfastReviewScoreMapper) {
        this.hoursMapper = hoursMapper;
        this.bookingHomeMapper = bookingHomeMapper;
        this.facilitiesReviewScoreMapper = facilitiesReviewScoreMapper;
        this.breakfastReviewScoreMapper = breakfastReviewScoreMapper;
    }

    public List<ResultDto> mapToResultDtoList(List<Property> properties) {
        return properties.stream()
                .map(this::mapToResultDto)
                .collect(Collectors.toList());
    }

    public List<Property> mapToProperties(List<ResultDto> resultDtoList) {
        return resultDtoList.stream()
                .map(this::mapToProperty)
                .collect(Collectors.toList());
    }

    public Property mapToProperty(ResultDto propertyDto) {
        return new Property(
                propertyDto.getAccommodationType(),
                propertyDto.getLocationScore(),
                propertyDto.getTranslatedCityName(),
                propertyDto.getBusinessReviewScoreWord(),
                propertyDto.getAddress(),
                propertyDto.getHotelId(),
                propertyDto.getBlockIds(),
                propertyDto.getUfi(),
                propertyDto.getMainPhotoUrl(),
                propertyDto.getLocationScoreWord(),
                propertyDto.getCleanlinessScoreWord(),
                propertyDto.getCls(),
                propertyDto.isFreeCancellable(),
                hoursMapper.mapToHours(propertyDto.getCheckOut()),
                propertyDto.getTranslatedAddress(),
                propertyDto.getCountryCode(),
                propertyDto.getDefaultLanguageCode(),
                propertyDto.isPriceFinal(),
                propertyDto.getUrl(),
                propertyDto.getDistrictId(),
                bookingHomeMapper.mapToBookingHome(propertyDto.getBookingHomeDto()),
                propertyDto.getCountryTrans(),
                propertyDto.getMainPhotoId(),
                propertyDto.getCleanlinessScore(),
                propertyDto.getDistanceToCc(),
                propertyDto.getDistricts(),
                propertyDto.getLatitude(),
                propertyDto.getAvailableRooms(),
                propertyDto.getHotelName(),
                propertyDto.getAccommodationTypeName(),
                propertyDto.getCleanlinessScoreReviewsNr(),
                propertyDto.isCityCenter(),
                propertyDto.getDistrict(),
                propertyDto.getCityName(),
                propertyDto.getBusinessReviewNr(),
                facilitiesReviewScoreMapper.mapToFacilitiesReviewScore(propertyDto.getFacilitiesReviewScoreDto()),
                propertyDto.getTimezone(),
                propertyDto.isWholesalerCandidate(),
                propertyDto.getDistance(),
                propertyDto.getReviewNr(),
                propertyDto.getHotelNameTrans(),
                propertyDto.isNoPrepaymentBlock(),
                propertyDto.getReviewScoreWord(),
                propertyDto.isHotelIncludeBreakfast(),
                propertyDto.isExtended(),
                propertyDto.getCurrencyCode(),
                propertyDto.getBusinessReviewScore(),
                propertyDto.getCityNameEn(),
                propertyDto.getLongitude(),
                breakfastReviewScoreMapper.mapToBreakfastReviewScore(propertyDto.getBreakfastReviewScoreDto()),
                propertyDto.getLocationScoreReviewsNr(),
                hoursMapper.mapToHours(propertyDto.getCheckIn()),
                propertyDto.getReviewScore(),
                propertyDto.isCcRequired(),
                propertyDto.getMinTotalPrice(),
                propertyDto.getCityTrans(),
                propertyDto.getZip());
    }

    public ResultDto mapToResultDto(Property property) {
        return new ResultDto(
                property.getAccommodationType(),
                property.getLocationScore(),
                property.getTranslatedCityName(),
                property.getBusinessReviewScoreWord(),
                property.getAddress(),
                property.getHotelId(),
                property.getBlockIds(),
                property.getUfi(),
                property.getMainPhotoUrl(),
                property.getLocationScoreWord(),
                property.getCleanlinessScoreWord(),
                property.getCls(),
                property.isFreeCancellable(),
                hoursMapper.mapToHoursDto(property.getCheckOut()),
                property.getTranslatedAddress(),
                property.getCountryCode(),
                property.getDefaultLanguageCode(),
                property.isPriceFinal(),
                property.getUrl(),
                property.getDistrictId(),
                bookingHomeMapper.mapToBookingHomeDto(property.getBookingHome()),
                property.getCountryTrans(),
                property.getMainPhotoId(),
                property.getCleanlinessScore(),
                property.getDistanceToCc(),
                property.getDistricts(),
                property.getLatitude(),
                property.getAvailableRooms(),
                property.getHotelName(),
                property.getAccommodationTypeName(),
                property.getCleanlinessScoreReviewsNr(),
                property.isCityCenter(),
                property.getDistrict(),
                property.getCityName(),
                property.getBusinessReviewNr(),
                facilitiesReviewScoreMapper.mapToFacilitiesReviewScoreDto(property.getFacilitiesReviewScore()),
                property.getTimezone(),
                property.isWholesalerCandidate(),
                property.getDistance(),
                property.getReviewNr(),
                property.getHotelNameTrans(),
                property.isNoPrepaymentBlock(),
                property.getReviewScoreWord(),
                property.isHotelIncludeBreakfast(),
                property.isExtended(),
                property.getCurrencyCode(),
                property.getBusinessReviewScore(),
                property.getCityNameEn(),
                property.getLongitude(),
                breakfastReviewScoreMapper.mapToBreakfastReviewScoreDto(property.getBreakfastReviewScore()),
                property.getLocationScoreReviewsNr(),
                hoursMapper.mapToHoursDto(property.getCheckIn()),
                property.getReviewScore(),
                property.isCcRequired(),
                property.getMinTotalPrice(),
                property.getCityTrans(),
                property.getZip()
        );
    }
}
