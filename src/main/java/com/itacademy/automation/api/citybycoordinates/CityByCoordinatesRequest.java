package com.itacademy.automation.api.citybycoordinates;

import com.itacademy.automation.api.BaseConfiguration;
import io.restassured.response.Response;

public class CityByCoordinatesRequest {

    private String parameters = "weather?";

    public CityByCoordinatesRequest(String lat, String lon){
        parameters += String.format("lat=%s&lon=%s", lat, lon);
    }

    public CityByCoordinatesRequest withAppid() {
        parameters += "&appid=" + BaseConfiguration.getUserId();
        return this;
    }

    public Response doRequest() {
        return BaseConfiguration.doRequest(parameters);
    }
}
