package com.rocketco.weather.api.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherEntry implements Serializable {

  private Instant timestamp;
  @JsonProperty("main")
  private WeatherDetail weatherDetail;
  @JsonProperty("clouds")
  private Cloudiness cloudiness;

  @JsonProperty("wind")
  private WindDetails windDetails;

  @JsonProperty("dt_txt")
  private String datetimeText;

  @JsonProperty("timestamp")
  public Instant getTimestamp() {
    return this.timestamp;
  }

  @JsonSetter("dt")
  public void setTimestamp(long unixTime) {
    this.timestamp = Instant.ofEpochMilli(unixTime * 1000);
  }

  public WeatherDetail getWeatherDetail() {
    return weatherDetail;
  }

  public void setWeatherDetail(WeatherDetail weatherDetail) {
    this.weatherDetail = weatherDetail;
  }

  public Cloudiness getCloudiness() {
    return cloudiness;
  }

  public void setCloudiness(Cloudiness cloudiness) {
    this.cloudiness = cloudiness;
  }

  public WindDetails getWindDetails() {
    return windDetails;
  }

  public void setWindDetails(WindDetails windDetails) {
    this.windDetails = windDetails;
  }

  public String getDatetimeText() {
    return datetimeText;
  }

  public void setDatetimeText(String datetimeText) {
    this.datetimeText = datetimeText;
  }
}
