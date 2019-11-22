package pl.pjatk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pjatk.model.Result;
import pl.pjatk.service.WeatherService;

@Controller
@RequestMapping(path = "/api")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String test(@RequestParam(required = false) String city, Model model) {

        if (city==null) {
            city = "Warsaw";
        }

        Result result = weatherService.getWeatherForCity(city);

        model.addAttribute("result", result);
        return "main";
    }
}
