package com.rocketco.weather.api.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.rocketco.weather.api.dto.response.LaunchWindow;
import com.rocketco.weather.api.provider.domain.City;
import com.rocketco.weather.api.provider.domain.Cloudiness;
import com.rocketco.weather.api.provider.domain.WeatherDetail;
import com.rocketco.weather.api.provider.domain.WeatherEntry;
import com.rocketco.weather.api.provider.domain.WindDetails;
import com.rocketco.weather.api.threshold.LaunchWindowThreshold;
import org.junit.Test;

public class LaunchWindowUtilsTest {

  @Test
  public void testNotExceed(){
    LaunchWindowThreshold threshold = new LaunchWindowThreshold(50, 12);
    WeatherEntry entry = new WeatherEntry();
    entry.setCloudiness(new Cloudiness(45));
    entry.setWindDetails(new WindDetails(11, 235.6));

    assertTrue(LaunchWindowUtils.isNotExceeded(threshold, entry));
  }

  @Test
  public void testNoThreshold(){
    WeatherEntry entry = new WeatherEntry();
    entry.setCloudiness(new Cloudiness(45));
    entry.setWindDetails(new WindDetails(11, 235.6));

    assertTrue(LaunchWindowUtils.isNotExceeded(null, entry));

  }

  @Test
  public void testExceedCloudiness(){
    LaunchWindowThreshold threshold = new LaunchWindowThreshold(50, 12);
    WeatherEntry entry = new WeatherEntry();
    entry.setCloudiness(new Cloudiness(51));
    entry.setWindDetails(new WindDetails(11, 235.6));

    assertFalse(LaunchWindowUtils.isNotExceeded(threshold, entry));
  }

  @Test
  public void testExceedWindSpeed(){
    LaunchWindowThreshold threshold = new LaunchWindowThreshold(50, 20);
    WeatherEntry entry = new WeatherEntry();
    entry.setCloudiness(new Cloudiness(48));
    entry.setWindDetails(new WindDetails(21, 235.6));

    assertFalse(LaunchWindowUtils.isNotExceeded(threshold, entry));
  }

  @Test
  public void testSameAsThreshold(){
    LaunchWindowThreshold threshold = new LaunchWindowThreshold(50, 20);
    WeatherEntry entry = new WeatherEntry();
    entry.setCloudiness(new Cloudiness(50));
    entry.setWindDetails(new WindDetails(20, 235.6));

    assertTrue(LaunchWindowUtils.isNotExceeded(threshold, entry));
  }

  @Test
  public void testCreateLaunchWindow(){
    WeatherEntry entry = new WeatherEntry();
    entry.setWindDetails(new WindDetails(20, 215.256));
    entry.setWeatherDetail(new WeatherDetail(25.48, 17.15, 30.02));
    LaunchWindow result = LaunchWindowUtils.createLaunchWindow(entry, new City("2073124", "Darwin", "AU"));
    assertEquals("Darwin - AU", result.getLocation());
    assertEquals(26 , result.getScore());
  }
}
