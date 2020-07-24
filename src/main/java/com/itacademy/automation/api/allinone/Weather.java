package com.itacademy.automation.api.allinone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @JsonProperty("humidity")
    private Integer humidity;

    public Integer getHumidity() {
        return humidity;
    }
}
