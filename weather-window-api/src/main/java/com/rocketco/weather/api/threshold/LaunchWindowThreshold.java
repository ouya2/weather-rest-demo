package com.rocketco.weather.api.threshold;

public class LaunchWindowThreshold {

  private int cloudiness;
  private int windSpeed;

  public LaunchWindowThreshold(int cloudiness, int windSpeed) {
    this.cloudiness = cloudiness;
    this.windSpeed =  windSpeed;
  }

  public int getCloudiness() {
    return cloudiness;
  }

  public void setCloudiness(int cloudiness) {
    this.cloudiness = cloudiness;
  }

  public int getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(int windSpeed) {
    this.windSpeed = windSpeed;
  }
}
