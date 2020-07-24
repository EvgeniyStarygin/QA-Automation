package com.itacademy.automation.api.currentweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherResponse {

    @JsonProperty("coord")
    private Coordinates coordinates;
    @JsonProperty("sys")
    private CountryInformation countryInformation;
    @JsonProperty("name")
    private String cityName;
    @JsonProperty("weather")
    private List<Weather> weathers;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public CountryInformation getCountryInformation() {
        return countryInformation;
    }

    public String getCityName() {
        return cityName;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }
}
