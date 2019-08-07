package com.radoslaw.dauksza.travelers.flight.mapper;

import com.radoslaw.dauksza.travelers.flight.domain.BrowsePlace;
import com.radoslaw.dauksza.travelers.flight.domain.dto.BrowsePlaceDto;
import com.radoslaw.dauksza.travelers.flight.skyscanner.SkyscannerApiClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaceMapper {
    SkyscannerApiClient skyscannerApiClient;

    public PlaceMapper(SkyscannerApiClient skyscannerApiClient) {
        this.skyscannerApiClient = skyscannerApiClient;
    }

//    Place mapToPlace(BrowsePlace browsePlace) {
//        List<AutosuggestPlaceDto> a = skyscannerApiClient.autosuggest(browsePlace.getName());
//                System.out.println(a);
//                return a.stream()
//                .filter(autosuggestPlaceDto -> autosuggestPlaceDto.getPlaceName().equals(browsePlace.getName()))
//                .map(autosuggestPlaceDto -> mapToPlace(autosuggestPlaceDto))
//                .findFirst()
//                .orElseThrow(RuntimeException::new);
//    }
//
//    Place mapToPlace(AutosuggestPlaceDto autosuggestPlaceDto) {
//        return new Place(autosuggestPlaceDto.getPlace(),
//                autosuggestPlaceDto.getPlaceName(),
//                autosuggestPlaceDto.getCountryId(),
//                autosuggestPlaceDto.getRegionId(),
//                autosuggestPlaceDto.getCityId(),
//                autosuggestPlaceDto.getCountryName());
//    }
//
//    List<Place> mapToPlaces(List<BrowsePlace> browsePlaces) {
//        return browsePlaces.stream().map(this::mapToPlace).collect(Collectors.toList());
//    }

    public BrowsePlace mapToBrowsePlace(BrowsePlaceDto browsePlaceDto) {
        String countryName;
        if (browsePlaceDto.getType().equals("Country")) {
            countryName = browsePlaceDto.getName();
        } else countryName = browsePlaceDto.getCountryName();
        return new BrowsePlace(browsePlaceDto.getPlaceId(),
                browsePlaceDto.getIataCode(),
                browsePlaceDto.getName(),
                browsePlaceDto.getType(),
                browsePlaceDto.getSkyscannerCode(),
                browsePlaceDto.getCityName(),
                browsePlaceDto.getCityId(),
                countryName);
    }

    public List<BrowsePlace> mapToBrowsePlaces(List<BrowsePlaceDto> browsePlaceDtos) {
        return browsePlaceDtos.stream().map(this::mapToBrowsePlace).collect(Collectors.toList());
    }
}
