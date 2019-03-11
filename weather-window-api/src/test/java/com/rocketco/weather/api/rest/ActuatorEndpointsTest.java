package com.rocketco.weather.api.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = {"management.port="})
public class ActuatorEndpointsTest extends EndpointTest {

  @Before
  public void setup() {
    super.setup();
  }

  @Test
  public void getHealth() throws Exception {
    mockMvc.perform(get("/health"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(JSON_MEDIA_TYPE))
        .andExpect(jsonPath("$.status").value("UP"))
        .andExpect(jsonPath("$.diskSpace.status").value("UP"));
  }

  @Test
  public void getInfo() throws Exception {
    mockMvc.perform(get("/info"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(JSON_MEDIA_TYPE))
        .andExpect(jsonPath("$.build.artifact").value("weather-window-api"))
        .andExpect(jsonPath("$.build.name").value("Weather Window API"))
        .andExpect(jsonPath("$.build.description").value("Weather Window Service"));
  }

  @Test
  public void getEnv() throws Exception {
    mockMvc.perform(get("/env"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(JSON_MEDIA_TYPE))
        .andExpect(jsonPath("$.profiles").exists())
        .andExpect(jsonPath("$.systemProperties").exists())
        .andExpect(jsonPath("$.systemEnvironment").exists());
  }
}
