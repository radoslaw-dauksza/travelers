package com.radoslaw.dauksza.travelers.weather.repository;

import com.radoslaw.dauksza.travelers.weather.domain.ForecastForCity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ForecastForCityRepository extends CrudRepository<ForecastForCity, Long> {

    Optional<ForecastForCity> findByCity_LatAndCity_Lon(double lat, double lon);
}
