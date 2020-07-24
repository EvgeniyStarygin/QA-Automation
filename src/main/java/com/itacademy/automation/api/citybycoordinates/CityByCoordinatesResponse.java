package com.itacademy.automation.api.citybycoordinates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itacademy.automation.api.currentweather.Coordinates;
import com.itacademy.automation.api.currentweather.CountryInformation;
import com.itacademy.automation.api.currentweather.Weather;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityByCoordinatesResponse {

    @JsonProperty("name")
    private String cityName;

    public String getCityName() {
        return cityName;
    }

}
