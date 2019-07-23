package com.radoslaw.dauksza.travelers.hotel.validator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.radoslaw.dauksza.travelers.hotel.domain.HotelSearchParametersOrderBy.*;

public interface SearchParametersValidator {

    static boolean validateChildren(String childrenAge, int childrenQty) {
        List<String> ages = Arrays.asList(childrenAge.split("[,]"));
        List<Integer> childrenAgeList = ages.stream()
                .map(Integer::getInteger)
                .filter(integer -> 0 < integer && integer < 18)
                .collect(Collectors.toList());
        if (ages.size() != childrenAgeList.size()) {
            return false;
        }
        return childrenAgeList.size() == childrenQty;
    }

    static boolean validateChildren(String childrenAge, String childrenQty) {
        List<String> ages = Arrays.asList(childrenAge.split("[,]"));
        List<Integer> childrenAgeList = ages.stream()
                .map(Integer::getInteger)
                .filter(integer -> 0 < integer && integer < 18)
                .collect(Collectors.toList());

        List<String> qty = Arrays.asList(childrenQty.split("[,]"));
        int childrenQuantity = qty.stream()
                .map(Integer::getInteger)
                .mapToInt(Integer::intValue)
                .sum();

        if (qty.size() != childrenQuantity) {
            return false;
        }
        if (ages.size() != childrenAgeList.size()) {
            return false;
        }
        return childrenAgeList.size() == childrenQuantity;
    }

    static boolean validateOrderBy(String orderBy) {
        return orderBy.equals(POPULARITY) ||
                orderBy.equals(DISTANCE) ||
                orderBy.equals(CLASS_DESC) ||
                orderBy.equals(CLASS_ASC) ||
                orderBy.equals(DEALS) ||
                orderBy.equals(REVIEW_SCORE) ||
                orderBy.equals(PRICE);
    }

    static boolean validateBookingDates(LocalDate checkInDate, LocalDate checkOutDate) {
        return checkInDate.isBefore(checkOutDate) && checkInDate.isAfter(LocalDate.now().minusDays(1));
    }
}
