package com.itacademy.automation.api.businessobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("main")
    private String weather;

    public String getWeather() {
        return weather;
    }
    public Integer getHumidity() {
        return humidity;
    }
}
