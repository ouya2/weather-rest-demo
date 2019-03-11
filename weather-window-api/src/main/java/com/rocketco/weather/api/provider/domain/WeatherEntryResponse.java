package com.rocketco.weather.api.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherEntryResponse implements Serializable {
  @JsonProperty("list")
  private List<WeatherEntry> weatherEntries;

  private City city;

  public List<WeatherEntry> getWeatherEntries() {
    return weatherEntries;
  }

  public void setWeatherEntries(List<WeatherEntry> weatherEntries) {
    this.weatherEntries = weatherEntries;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }
}
