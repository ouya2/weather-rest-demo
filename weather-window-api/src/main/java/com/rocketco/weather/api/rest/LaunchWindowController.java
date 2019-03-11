package com.rocketco.weather.api.rest;

import com.rocketco.weather.api.dto.response.LaunchWindow;
import com.rocketco.weather.api.dto.response.LaunchWindows;
import com.rocketco.weather.api.service.LaunchWindowService;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/launch-window")
@Api(value = "WeatherWindowAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class LaunchWindowController {

  @Autowired
  private LaunchWindowService service;

  public LaunchWindowController(LaunchWindowService service) {
    this.service = service;
  }

  @RequestMapping(value = "/city/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public LaunchWindows getLaunchWindows(@ApiParam(value = "ID of the city", required = true)
      @PathVariable("id") Long id) {
    List<LaunchWindow> launchWindowList = service.getLaunchWindows(id);
    return new LaunchWindows(launchWindowList);
  }
}
