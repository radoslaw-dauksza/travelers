package com.radoslaw.dauksza.travelers.flight.controller;

import com.radoslaw.dauksza.travelers.skyscanner.SkyscannerApiClient;
import com.radoslaw.dauksza.travelers.flight.domain.dto.AutosuggestPlaceDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PlaceController {
    SkyscannerApiClient client;

    public PlaceController(SkyscannerApiClient client) {
        this.client = client;
    }

    @GetMapping("/places")
    public List<AutosuggestPlaceDto> getPlaces(@RequestParam String query) {
        return client.autosuggest(query);
    }
}
