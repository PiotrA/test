package pl.pjatk.model;

public class Main {

    private Float temp;
    private String pressure;

    public Main() {
    }

    public Main(Float temp, String pressure) {
        this.temp = temp;
        this.pressure = pressure;
    }

    public String getPressure() {
        return pressure;
    }

    public String getTemp() {
        return String.format("%.1f", temp-275.15f);
    }
}
