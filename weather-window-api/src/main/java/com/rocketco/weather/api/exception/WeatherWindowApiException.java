package com.rocketco.weather.api.exception;

/**
 * Weather window api exception.
 */
public class WeatherWindowApiException extends RuntimeException {
  public WeatherWindowApiException() {
    super();
  }

  public WeatherWindowApiException(String message, Throwable cause) {
    super(message, cause);
  }

  public WeatherWindowApiException(String message) {
    super(message);
  }

  public WeatherWindowApiException(Throwable cause) {
    super(cause);
  }
}
