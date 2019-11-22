package pl.pjatk.model;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private Main main;
    private String name;
    private Wind wind;
    private Clouds clouds;
    private List<Weather> weather;

    public Result() {
    }

    public Result(Main main, String name, Wind wind, Clouds clouds, List<Weather> weather) {
        this.main = main;
        this.name = name;
        this.wind = wind;
        this.clouds = clouds;
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getName() {
        if (name.equals("Warsaw")) {
            return "Warszawa";
        }
        return name;
    }

    public Main getMain() {
        return main;
    }
}
