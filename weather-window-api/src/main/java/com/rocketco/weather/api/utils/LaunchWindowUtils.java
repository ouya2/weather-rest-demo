package com.rocketco.weather.api.utils;

import static com.rocketco.weather.api.constant.AppConstant.TEMPERATURE_DEFAULT;
import static com.rocketco.weather.api.constant.AppConstant.WIND_COEFFICENT;
import static com.rocketco.weather.api.constant.AppConstant.WIND_DIRECTION_DEFAULT;

import com.rocketco.weather.api.dto.response.LaunchWindow;
import com.rocketco.weather.api.exception.WeatherWindowApiException;
import com.rocketco.weather.api.provider.domain.City;
import com.rocketco.weather.api.provider.domain.WeatherEntry;
import com.rocketco.weather.api.threshold.LaunchWindowThreshold;

public final class LaunchWindowUtils {

  /**
   * Check if the weather entry has exceeded the threshold.
   *
   * @param threshold
   * @param weatherEntry
   * @return boolean
   */
  public static boolean isNotExceeded(LaunchWindowThreshold threshold, WeatherEntry weatherEntry) {
    if (weatherEntry == null) {
      throw new WeatherWindowApiException("Cannot check threshold without weather information");
    }

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

  /**
   * Create a launch window based on the given weather entry.
   *
   * @param weatherEntry {@link WeatherEntry}
   * @param city The location city.
   * @return LaunchWindow
   */
  public static LaunchWindow createLaunchWindow(WeatherEntry weatherEntry, City city) {
    Double score = Math.abs(TEMPERATURE_DEFAULT - weatherEntry.getWeatherDetail().getTemperature()) +
        weatherEntry.getWindDetails().getSpeed() + WIND_COEFFICENT * Math.abs(
        WIND_DIRECTION_DEFAULT - weatherEntry.getWindDetails().getDirection());

    return new LaunchWindow(city.getName() + " - " + city.getCountry(),
                                    weatherEntry.getDatetimeText(),
                                    Math.round(score));
  }
}
