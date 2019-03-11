package com.rocketco.weather.api.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

/**
 * Launch windows contains list of {@link LaunchWindow}
 */
public class LaunchWindows implements Serializable {

  private List<LaunchWindow> launchWindows;

  public LaunchWindows(){
  }

  public LaunchWindows(List<LaunchWindow> launchWindowss) {
    this.launchWindows = launchWindowss;
  }

  public List<LaunchWindow> getLaunchWindows() {
    return launchWindows;
  }

  public void setLaunchWindows(List<LaunchWindow> launchWindows) {
    this.launchWindows = launchWindows;
  }

  public void addLaunchWindow(LaunchWindow launchWindow) {
    if(CollectionUtils.isNotEmpty(launchWindows)) {
      launchWindows = new ArrayList<>();
    }
    launchWindows.add(launchWindow);
  }

}
