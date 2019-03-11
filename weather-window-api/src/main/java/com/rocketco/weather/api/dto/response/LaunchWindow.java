package com.rocketco.weather.api.dto.response;

import java.io.Serializable;

/**
 * The launch window DTO.
 */
public class LaunchWindow implements Serializable {

  private String location;
  private String datetime;
  private long score;

  public LaunchWindow(String location, String datetime, long score) {
    this.location = location;
    this.datetime = datetime;
    this.score = score;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getDatetime() {
    return datetime;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }

  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "LaunchWindow{" +
        "location='" + location + '\'' +
        ", datetime='" + datetime + '\'' +
        ", score=" + score +
        '}';
  }
}
