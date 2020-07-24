package com.itacademy.automation.api.currentweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryInformation {

    @JsonProperty("country")
    public String countryCode;

    public String getCountryCode() {
        return countryCode;
    }
}
