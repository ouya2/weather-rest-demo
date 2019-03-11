package com.rocketco.weather.api.provider.impl;

import com.rocketco.weather.api.configuration.properties.OpenWeatherMapProperties;
import com.rocketco.weather.api.provider.OpenWeatherMapApi;
import com.rocketco.weather.api.provider.domain.WeatherEntryResponse;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

public class OpenWeatherMapApiImpl implements OpenWeatherMapApi {

  private OpenWeatherMapProperties openWeatherMapProperties;
  private RestTemplate restTemplate;

  public OpenWeatherMapApiImpl(OpenWeatherMapProperties openWeatherMapProperties, RestTemplate restTemplate) {
    this.openWeatherMapProperties = openWeatherMapProperties;
    this.restTemplate = restTemplate;
  }

  @Override
  public WeatherEntryResponse getWeatherEntries(Long cityId) {
    URI url = new UriTemplate(openWeatherMapProperties.getUrl()).expand(cityId,
        openWeatherMapProperties.getApiKey(), openWeatherMapProperties.getUnits());
    RequestEntity requestEntity = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
    ResponseEntity<WeatherEntryResponse> exchange = restTemplate.exchange(requestEntity, WeatherEntryResponse.class);
    return exchange.getBody();
  }
}
