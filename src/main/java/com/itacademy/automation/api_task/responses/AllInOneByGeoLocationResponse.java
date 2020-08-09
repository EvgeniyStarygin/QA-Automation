package com.itacademy.automation.api_task.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itacademy.automation.api_task.business_objects.Weather;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllInOneByGeoLocationResponse {

    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("daily")
    private List<Weather> weathers;

    public String getTimezone() {
        return timezone;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }
}
