package com.itacademy.automation.api_task.requests;

import io.restassured.response.Response;

public class CityByCoordinatesRequest extends BaseRequest{

    private String parameters = "weather?";

    public CityByCoordinatesRequest(String lat, String lon){
        parameters += String.format("lat=%s&lon=%s", lat, lon);
    }

    public CityByCoordinatesRequest withAppid() {
        parameters += APPID;
        return this;
    }

    public Response doRequest() {
        return doBaseRequest(parameters);
    }
}
