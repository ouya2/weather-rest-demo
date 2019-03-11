package com.rocketco.weather.api.service;

import static com.rocketco.weather.api.constant.AppConstant.CITY_LAUNCH_WINDOW_THRESHOLD;
import static com.rocketco.weather.api.constant.AppConstant.LAUNCH_WINDOW_SIZE;
import static com.rocketco.weather.api.utils.LaunchWindowUtils.createLaunchWindow;
import static com.rocketco.weather.api.utils.LaunchWindowUtils.isNotExceeded;

import com.rocketco.weather.api.dto.response.LaunchWindow;
import com.rocketco.weather.api.exception.WeatherWindowApiException;
import com.rocketco.weather.api.provider.OpenWeatherMapApi;
import com.rocketco.weather.api.provider.domain.WeatherEntry;
import com.rocketco.weather.api.provider.domain.WeatherEntryResponse;
import com.rocketco.weather.api.threshold.LaunchWindowThreshold;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaunchWindowService {

  private OpenWeatherMapApi openWeatherMapApi;

  @Autowired
  public LaunchWindowService(OpenWeatherMapApi openWeatherMapApi) {
    this.openWeatherMapApi = openWeatherMapApi;
  }

  /**
   * Get the top launch windows
   *
   * @param id Given city id
   * @return List of launch windows
   */
  public List<LaunchWindow> getLaunchWindows(Long id) {
    if (id == null) {
      throw new WeatherWindowApiException("City id cannot be null");
    }

    WeatherEntryResponse response = openWeatherMapApi.getWeatherEntries(id);
    List<WeatherEntry> weatherEntries = response.getWeatherEntries();
    List<LaunchWindow> launchWindowList = Collections.emptyList();
    if (CollectionUtils.isNotEmpty(weatherEntries)) {
      LaunchWindowThreshold threshold = CITY_LAUNCH_WINDOW_THRESHOLD.get(id);
      launchWindowList = weatherEntries.stream()
                        .filter(weatherEntry -> isNotExceeded(threshold, weatherEntry))
                        .map(weatherEntry -> createLaunchWindow(weatherEntry, response.getCity()))
                        .sorted(Comparator.comparing(LaunchWindow::getScore).reversed())
                        .limit(LAUNCH_WINDOW_SIZE)
                        .collect(Collectors.toList());
    }
    return launchWindowList;
  }
}
