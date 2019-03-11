package com.rocketco.weather.api.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDetail implements Serializable {

  @JsonProperty("temp")
  private Double temperature;
  @JsonProperty("temp_min")
  private Double minimumTemperature;
  @JsonProperty("temp_max")
  private Double maximumTemperature;
  private Double pressure;
  @JsonProperty("sea_level")
  private Double seaLevelPressure;
  @JsonProperty("grnd_level")
  private Double groundLevelPressure;
  private Integer humidity;

  public WeatherDetail(){
  }

  public WeatherDetail(Double temperature, Double minimumTemperature, Double maximumTemperature) {
    this.temperature = temperature;
    this.minimumTemperature = minimumTemperature;
    this.maximumTemperature = maximumTemperature;
  }

  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  public Double getMinimumTemperature() {
    return minimumTemperature;
  }

  public void setMinimumTemperature(Double minimumTemperature) {
    this.minimumTemperature = minimumTemperature;
  }

  public Double getMaximumTemperature() {
    return maximumTemperature;
  }

  public void setMaximumTemperature(Double maximumTemperature) {
    this.maximumTemperature = maximumTemperature;
  }

  public Double getPressure() {
    return pressure;
  }

  public void setPressure(Double pressure) {
    this.pressure = pressure;
  }

  public Double getSeaLevelPressure() {
    return seaLevelPressure;
  }

  public void setSeaLevelPressure(Double seaLevelPressure) {
    this.seaLevelPressure = seaLevelPressure;
  }

  public Double getGroundLevelPressure() {
    return groundLevelPressure;
  }

  public void setGroundLevelPressure(Double groundLevelPressure) {
    this.groundLevelPressure = groundLevelPressure;
  }

  public Integer getHumidity() {
    return humidity;
  }

  public void setHumidity(Integer humidity) {
    this.humidity = humidity;
  }
}
