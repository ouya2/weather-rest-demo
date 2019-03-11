package com.rocketco.weather.api.provider;

import com.rocketco.weather.api.provider.domain.WeatherEntryResponse;

/**
 * The API interface to open weather map
 */
public interface OpenWeatherMapApi {

  /**
   * Retrieve the weather details for a given city id.
   *
   * @param cityId
   * @return WeatherEntryResponse
   */
  WeatherEntryResponse getWeatherEntries(Long cityId);
}
