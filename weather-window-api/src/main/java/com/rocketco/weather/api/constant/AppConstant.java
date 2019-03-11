package com.rocketco.weather.api.constant;

import com.google.common.collect.ImmutableMap;
import com.rocketco.weather.api.threshold.LaunchWindowThreshold;

public final class AppConstant {


  public static final int LAUNCH_WINDOW_SIZE = 5;

  public static final int WIND_DIRECTION_DEFAULT = 220;
  public static final int TEMPERATURE_DEFAULT = 20;
  public static final double WIND_COEFFICENT = 0.1;

  /**
   * Pre-defined city launch window threshold
   */
  public static final ImmutableMap<Long, LaunchWindowThreshold> CITY_LAUNCH_WINDOW_THRESHOLD = new ImmutableMap.Builder<Long, LaunchWindowThreshold>()
      .put(7839805L, new LaunchWindowThreshold(50, 20))
      .put(2073124L, new LaunchWindowThreshold(40, 15))
      .put(2163355L, new LaunchWindowThreshold(60,10))
      .put(2063523L, new LaunchWindowThreshold(30,5))
      .build();
}
