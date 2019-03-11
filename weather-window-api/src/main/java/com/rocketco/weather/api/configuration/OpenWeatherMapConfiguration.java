package com.rocketco.weather.api.configuration;

import com.rocketco.weather.api.configuration.properties.OpenWeatherMapProperties;
import com.rocketco.weather.api.provider.OpenWeatherMapApi;
import com.rocketco.weather.api.provider.impl.OpenWeatherMapApiImpl;
import com.rocketco.weather.api.stub.OpenWeatherMapApiStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(OpenWeatherMapProperties.class)
public class OpenWeatherMapConfiguration {

  private OpenWeatherMapProperties openWeatherMapProperties;
  private RestTemplate restTemplate;

  @Autowired
  public OpenWeatherMapConfiguration(OpenWeatherMapProperties openWeatherMapProperties,
      RestTemplate restTemplate) {
    this.openWeatherMapProperties = openWeatherMapProperties;
    this.restTemplate = restTemplate;
  }


  @Bean
  @Profile("!test")
  public OpenWeatherMapApi openWeatherMapApi(){
    return new OpenWeatherMapApiImpl(openWeatherMapProperties, restTemplate);
  }


  @Bean
  @Profile("test")
  public OpenWeatherMapApi openWeatherMapApiStub() {
    return new OpenWeatherMapApiStub();
  }

}
