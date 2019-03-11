package com.rocketco.weather.api.provider.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Cloudiness implements Serializable {

  @JsonProperty("all")
  private Integer cloudinessValue;

  public Cloudiness(){
  }

  public Cloudiness(Integer cloudinessValue) {
    this.cloudinessValue = cloudinessValue;
  }

  public Integer getCloudinessValue() {
    return cloudinessValue;
  }

  public void setCloudinessValue(Integer cloudinessValue) {
    this.cloudinessValue = cloudinessValue;
  }
}
