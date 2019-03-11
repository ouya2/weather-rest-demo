package com.rocketco.weather.api.stub;

import com.rocketco.weather.api.provider.OpenWeatherMapApi;
import com.rocketco.weather.api.provider.domain.City;
import com.rocketco.weather.api.provider.domain.Cloudiness;
import com.rocketco.weather.api.provider.domain.WeatherDetail;
import com.rocketco.weather.api.provider.domain.WeatherEntry;
import com.rocketco.weather.api.provider.domain.WeatherEntryResponse;
import com.rocketco.weather.api.provider.domain.WindDetails;
import java.util.Arrays;

public class OpenWeatherMapApiStub implements OpenWeatherMapApi {

  @Override
  public WeatherEntryResponse getWeatherEntries(Long cityId) {
    WeatherEntryResponse response = new WeatherEntryResponse();
    WeatherEntry weatherEntry = new WeatherEntry();
    weatherEntry.setCloudiness(new Cloudiness(15));
    weatherEntry.setDatetimeText("2019-03-11 06:00:00");
    weatherEntry.setWindDetails(new WindDetails(2.21, 265.001));
    weatherEntry.setWeatherDetail(new WeatherDetail(23.7, 20.86,23.7));
    response.setWeatherEntries(Arrays.asList(weatherEntry));
    response.setCity(new City("7839805", "Melbourne", "AU"));
    return response;
  }
}
