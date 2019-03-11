package com.rocketco.weather.api.utils;

import com.rocketco.weather.api.provider.domain.City;
import com.rocketco.weather.api.provider.domain.Cloudiness;
import com.rocketco.weather.api.provider.domain.WeatherDetail;
import com.rocketco.weather.api.provider.domain.WeatherEntry;
import com.rocketco.weather.api.provider.domain.WeatherEntryResponse;
import com.rocketco.weather.api.provider.domain.WindDetails;
import java.util.Arrays;

public final class TestUtils {

  public static WeatherEntryResponse createOneWeatherEntryResponse(){
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

  public static WeatherEntryResponse createOneWeatherEntryResponseWithExceededValues(){
    WeatherEntryResponse response = new WeatherEntryResponse();
    WeatherEntry weatherEntry = new WeatherEntry();
    weatherEntry.setCloudiness(new Cloudiness(75));
    weatherEntry.setDatetimeText("2019-03-11 06:00:00");
    weatherEntry.setWindDetails(new WindDetails(30, 265.001));
    weatherEntry.setWeatherDetail(new WeatherDetail(23.7, 20.86,23.7));
    response.setWeatherEntries(Arrays.asList(weatherEntry));
    response.setCity(new City("7839805", "Melbourne", "AU"));
    return response;
  }

  public static WeatherEntryResponse createFiveWeatherEntryResponse(){
    WeatherEntry weatherEntry01 = new WeatherEntry();
    weatherEntry01.setCloudiness(new Cloudiness(16));
    weatherEntry01.setDatetimeText("2019-03-11 06:00:00");
    weatherEntry01.setWindDetails(new WindDetails(2.21, 265.001));
    weatherEntry01.setWeatherDetail(new WeatherDetail(23.7, 20.86,23.7));

    WeatherEntry weatherEntry02 = new WeatherEntry();
    weatherEntry02.setCloudiness(new Cloudiness(25));
    weatherEntry02.setDatetimeText("2019-03-12 07:00:00");
    weatherEntry02.setWindDetails(new WindDetails(5.21, 125.001));
    weatherEntry02.setWeatherDetail(new WeatherDetail(25.10, 20.86,30d));

    WeatherEntry weatherEntry03 = new WeatherEntry();
    weatherEntry03.setCloudiness(new Cloudiness(30));
    weatherEntry03.setDatetimeText("2019-03-13 09:00:00");
    weatherEntry03.setWindDetails(new WindDetails(5.21, 265.001));
    weatherEntry03.setWeatherDetail(new WeatherDetail(21.7, 20.86,23.7));

    WeatherEntry weatherEntry04 = new WeatherEntry();
    weatherEntry04.setCloudiness(new Cloudiness(20));
    weatherEntry04.setDatetimeText("2019-03-13 12:00:00");
    weatherEntry04.setWindDetails(new WindDetails(2.21, 265.001));
    weatherEntry04.setWeatherDetail(new WeatherDetail(23.7, 20.86,23.7));

    WeatherEntry weatherEntry05 = new WeatherEntry();
    weatherEntry05.setCloudiness(new Cloudiness(35));
    weatherEntry05.setDatetimeText("2019-03-14 08:00:00");
    weatherEntry05.setWindDetails(new WindDetails(11.4, 210.76));
    weatherEntry05.setWeatherDetail(new WeatherDetail(27.7, 20.86,32.1));

    WeatherEntryResponse response = new WeatherEntryResponse();
    response.setWeatherEntries(Arrays.asList(weatherEntry01, weatherEntry02, weatherEntry03, weatherEntry04, weatherEntry05));
    response.setCity(new City("7839805", "Melbourne", "AU"));
    return response;

  }

}
