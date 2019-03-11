package com.rocketco.weather.api.provider;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rocketco.weather.api.configuration.properties.OpenWeatherMapProperties;
import com.rocketco.weather.api.provider.domain.WeatherEntryResponse;
import com.rocketco.weather.api.provider.impl.OpenWeatherMapApiImpl;
import java.util.UUID;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class OpenWeatherMapApiImplTest {

  @Mock
  private OpenWeatherMapProperties properties;

  @Mock
  private RestTemplate restTemplate;

  private OpenWeatherMapApi api;

  @Before
  public void setup(){
    api = new OpenWeatherMapApiImpl(properties, restTemplate);
  }

  @Test
  public void testGetWeatherEntries(){
    WeatherEntryResponse response = new WeatherEntryResponse();
    ResponseEntity<WeatherEntryResponse> responseEntity = new ResponseEntity<WeatherEntryResponse>(response,
        HttpStatus.OK);

    when(properties.getApiKey()).thenReturn(UUID.randomUUID().toString());
    when(properties.getUrl()).thenReturn("http://api.openweathermap.org/data/2.5/forecas");
    when(properties.getUnits()).thenReturn("metric");
    when(restTemplate.exchange(any(RequestEntity.class), eq(WeatherEntryResponse.class))).thenReturn(responseEntity);
    api.getWeatherEntries(7839805L);
    verify(restTemplate, times(1)).exchange(any(RequestEntity.class), eq(WeatherEntryResponse.class));
  }

}
