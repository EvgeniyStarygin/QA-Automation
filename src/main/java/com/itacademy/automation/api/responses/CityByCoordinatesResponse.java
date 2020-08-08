package com.itacademy.automation.api.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityByCoordinatesResponse {

    @JsonProperty("name")
    private String cityName;

    public String getCityName() {
        return cityName;
    }

}
