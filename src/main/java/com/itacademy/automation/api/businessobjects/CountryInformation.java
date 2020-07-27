package com.itacademy.automation.api.businessobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryInformation {

    @JsonProperty("country")
    private String countryCode;

    public String getCountryCode() {
        return countryCode;
    }
}
