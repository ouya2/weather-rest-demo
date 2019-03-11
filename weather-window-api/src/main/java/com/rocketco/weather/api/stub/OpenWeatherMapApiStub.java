package com.rocketco.weather.api.stub;

import com.rocketco.weather.api.provider.OpenWeatherMapApi;
import com.rocketco.weather.api.provider.domain.WeatherEntryResponse;

public class OpenWeatherMapApiStub implements OpenWeatherMapApi {

  @Override
  public WeatherEntryResponse getWeatherEntries(Long cityId) {
    WeatherEntryResponse response = new WeatherEntryResponse();
    return response;
  }
}
