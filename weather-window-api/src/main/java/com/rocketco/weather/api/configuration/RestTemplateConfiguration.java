package com.rocketco.weather.api.configuration;

import com.rocketco.weather.api.configuration.properties.RestTemplateProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(RestTemplateProperties.class)
public class RestTemplateConfiguration {

  @Autowired
  private RestTemplateProperties restTemplateProperties;

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplateBuilder().setConnectTimeout(restTemplateProperties.getConnectionTimeout())
                                    .setReadTimeout(restTemplateProperties.getReadTimeout())
                                    .build();
  }
}
