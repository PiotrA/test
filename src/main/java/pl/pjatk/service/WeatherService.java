package pl.pjatk.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriTemplate;
import pl.pjatk.config.WeatherApiConfig;
import pl.pjatk.model.Result;

import java.net.URI;

@Service
public class WeatherService {

    private final WeatherApiConfig apiConfig;
    private final RestTemplate restTemplate;

    public WeatherService(WeatherApiConfig apiConfig, RestTemplate restTemplate) {
        this.apiConfig = apiConfig;
        this.restTemplate = restTemplate;
    }

    public Result getWeatherForCity(String city)  {
        URI uri = new UriTemplate(apiConfig.getUrl() + "APPID=" + apiConfig.getKey() + "&q={city}").expand(city);
        RequestEntity requestEntity = RequestEntity.get(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                .accept(MediaType.APPLICATION_JSON)
                .build();

        try {
            return restTemplate.exchange(requestEntity, Result.class).getBody();
        } catch (HttpStatusCodeException e) {
            HttpStatus httpStatus = e.getStatusCode();
            throw new ResponseStatusException(httpStatus);
        } catch (RestClientException e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
