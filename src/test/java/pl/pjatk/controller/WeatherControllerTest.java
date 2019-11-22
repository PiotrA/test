package pl.pjatk.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;
import pl.pjatk.model.*;
import pl.pjatk.service.WeatherService;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static sun.nio.cs.Surrogate.is;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;

    @Test
    public void checkIfReturnsCorrectResult() throws Exception {

        Result res = new Result(new Main(15.4f, "1000"), "Warsaw",
                new Wind("24"), new Clouds("fog"), Arrays.asList(new Weather(1L, "rain")));

        given(weatherService.getWeatherForCity("warsaw")).willReturn(res);

        mockMvc.perform(get("/api")
                .param("city", "warsaw")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(model().attribute("result", equalTo(res)));
    }
}
