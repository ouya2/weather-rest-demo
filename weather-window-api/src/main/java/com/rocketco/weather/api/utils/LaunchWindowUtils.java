package com.rocketco.weather.api.utils;

import com.rocketco.weather.api.dto.response.LaunchWindow;
import com.rocketco.weather.api.provider.domain.City;
import com.rocketco.weather.api.provider.domain.WeatherEntry;
import com.rocketco.weather.api.threshold.LaunchWindowThreshold;

public final class LaunchWindowUtils {


  public static boolean isNotExceeded(LaunchWindowThreshold threshold, WeatherEntry weatherEntry) {
    boolean result = true;
    if (threshold == null) {
      return result;
    }

    if (weatherEntry.getCloudiness().getCloudinessValue() > threshold.getCloudiness() ||
        weatherEntry.getWindDetails().getSpeed() > threshold.getWindSpeed()) {
      result = false;
    }

    return result;
  }

  public static LaunchWindow createLaunchWindow(WeatherEntry weatherEntry, City city) {
    Double score = Math.abs(20 - weatherEntry.getWeatherDetail().getTemperature()) +
        weatherEntry.getWindDetails().getSpeed() + 0.1 * Math.abs(220 - weatherEntry.getWindDetails().getDirection());


    return new LaunchWindow(city.getName() + " - " + city.getCountry(),
        weatherEntry.getDatetimeText(), Math.round(score));
  }
}
