package com.radoslaw.dauksza.travelers.weather.repository;

import com.radoslaw.dauksza.travelers.weather.domain.MainWeatherInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainWeatherInfoRepository extends CrudRepository<MainWeatherInfo, Long> {
}
