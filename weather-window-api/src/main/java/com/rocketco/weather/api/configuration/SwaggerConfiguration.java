package com.rocketco.weather.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.rocketco.weather.api.rest")
public class SwaggerConfiguration {
  private static final String SWAGGER_API_VERSION = "1.0";
  private static final String LICENSE_TEXT = "License";
  private static final String title = "Weather Window API";
  private static final String description = "RESTful API for Customers";

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title(title)
        .description(description)
        .license(LICENSE_TEXT)
        .version(SWAGGER_API_VERSION)
        .build();
  }

  @Bean
  public Docket customersApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .pathMapping("/")
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.regex("/api.*"))
        .build();
  }
}
