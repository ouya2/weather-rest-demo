package com.rocketco.weather.api.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@ActiveProfiles("test")
public class LaunchWindowEndpointTest extends EndpointTest {

  @Before
  public void setup() {
    super.setup();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getLaunchWindowById() throws Exception {
    Long cityId = 1235454546L;
    mockMvc.perform(get("/launch-window/city/{id}", cityId))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(JSON_MEDIA_TYPE))
        .andExpect(jsonPath("$.launchWindows[0].location").value("Melbourne - AU"))
        .andExpect(jsonPath("$.launchWindows[0].datetime").value("2019-03-11 06:00:00"))
        .andExpect(jsonPath("$.launchWindows[0].score").value(10));
  }
}
