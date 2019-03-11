package com.rocketco.weather.api.provider.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class WindDetails implements Serializable {

  private Double speed;
  @JsonProperty("deg")
  private Double direction;

  public WindDetails(){
  }

  public WindDetails(double speed, double direction) {
    this.speed = speed;
    this.direction = direction;
  }

  public Double getSpeed() {
    return speed;
  }

  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  public Double getDirection() {
    return direction;
  }

  public void setDirection(Double direction) {
    this.direction = direction;
  }
}
