package com.rocketco.weather.api.constant;

import com.google.common.collect.ImmutableMap;
import com.rocketco.weather.api.threshold.LaunchWindowThreshold;

public final class AppConstant {


  public static final int LAUNCH_WINDOW_SIZE = 5;

  /**
   * Pre-defined city launch window threshold
   */
  public static final ImmutableMap<Integer, LaunchWindowThreshold> CITY_LAUNCH_WINDOW_THRESHOLD = new ImmutableMap.Builder<Integer, LaunchWindowThreshold>()
      .put(7839805, new LaunchWindowThreshold(50, 20))
      .put(2073124, new LaunchWindowThreshold(40, 15))
      .put(2163355, new LaunchWindowThreshold(60,10))
      .put(2063523, new LaunchWindowThreshold(30,5))
      .build();
}
