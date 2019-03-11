package com.rocketco.weather.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import com.rocketco.weather.api.dto.response.LaunchWindow;
import com.rocketco.weather.api.exception.WeatherWindowApiException;
import com.rocketco.weather.api.provider.OpenWeatherMapApi;
import com.rocketco.weather.api.provider.domain.WeatherEntryResponse;
import com.rocketco.weather.api.utils.TestUtils;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LaunchWindowServiceTest {

  @Mock
  private OpenWeatherMapApi openWeatherMapApi;

  private LaunchWindowService service;

  @Before
  public void setup(){
    service = new LaunchWindowService(openWeatherMapApi);
  }

  @Test
  public void testEmptyList(){
    WeatherEntryResponse response = new WeatherEntryResponse();
    when(openWeatherMapApi.getWeatherEntries(anyLong())).thenReturn(response);
    List<LaunchWindow> launchWindowList = service.getLaunchWindows(1235456789L);
    assertNotNull(launchWindowList);
    assertTrue(launchWindowList.isEmpty());
  }

  @Test (expected = WeatherWindowApiException.class)
  public void testInvalidId(){
    service.getLaunchWindows(null);
  }

  @Test
  public void testOneEntryOnly(){
    WeatherEntryResponse response = TestUtils.createOneWeatherEntryResponse();
    when(openWeatherMapApi.getWeatherEntries(anyLong())).thenReturn(response);
    List<LaunchWindow> launchWindowList = service.getLaunchWindows(7839805L);
    assertEquals(1, launchWindowList.size());
    assertEquals(10, launchWindowList.get(0).getScore());
    assertTrue(launchWindowList.get(0).getLocation().contains("Melbourne"));
  }

  @Test
  public void testOneEntryExceedThreshold(){
    WeatherEntryResponse response = TestUtils.createOneWeatherEntryResponseWithExceededValues();
    when(openWeatherMapApi.getWeatherEntries(anyLong())).thenReturn(response);
    List<LaunchWindow> launchWindowList = service.getLaunchWindows(7839805L);
    assertEquals(0, launchWindowList.size());
  }

  @Test
  public void testCityIdNotInScope(){
    WeatherEntryResponse response = TestUtils.createFiveWeatherEntryResponse();
    when(openWeatherMapApi.getWeatherEntries(anyLong())).thenReturn(response);
    List<LaunchWindow> launchWindowList = service.getLaunchWindows(123545678L);
    assertEquals(5, launchWindowList.size());
    assertEquals(20, launchWindowList.get(0).getScore());
    assertEquals(20, launchWindowList.get(1).getScore());
  }

  @Test
  public void testCityInScope(){
    WeatherEntryResponse response = TestUtils.createFiveWeatherEntryResponse();
    when(openWeatherMapApi.getWeatherEntries(anyLong())).thenReturn(response);
    List<LaunchWindow> launchWindowList = service.getLaunchWindows(2063523L);
    assertEquals(2, launchWindowList.size());
  }

}
