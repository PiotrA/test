package pl.pjatk.model;

public class Weather {

    private Long id;
    private String main;

    public Weather() {
    }

    public Weather(Long id, String main) {
        this.id = id;
        this.main = main;
    }

    public Long getId() {
        return id;
    }

    public String getMain() {
        switch (main) {
            case "Rain": return "Deszczowo";
            case "Fog": return "Mgliście";
            case "Clouds": return "Pochmurno";
            case "Clear": return "Pogodnie";
            case "Mist": return "Mżawka";
            case "Thunderstorm": return "Burzowo";
            default: return main;
        }
    }
}
