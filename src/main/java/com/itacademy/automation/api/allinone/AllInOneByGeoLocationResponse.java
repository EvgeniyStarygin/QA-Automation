package com.itacademy.automation.api.allinone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
