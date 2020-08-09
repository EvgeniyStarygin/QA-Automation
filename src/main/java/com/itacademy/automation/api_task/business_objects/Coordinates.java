package com.itacademy.automation.api_task.business_objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {

    @JsonProperty("lon")
    private String longitude;
    @JsonProperty("lat")
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }
}
