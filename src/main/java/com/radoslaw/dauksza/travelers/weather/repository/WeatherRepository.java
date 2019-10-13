package com.radoslaw.dauksza.travelers.weather.repository;

import com.radoslaw.dauksza.travelers.weather.domain.Weather;
import com.radoslaw.dauksza.travelers.weather.domain.WeatherId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, WeatherId> {
}
