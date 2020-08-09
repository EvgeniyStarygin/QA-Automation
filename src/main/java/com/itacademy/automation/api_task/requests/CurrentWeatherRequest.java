package com.itacademy.automation.api_task.requests;

import io.restassured.response.Response;

public class CurrentWeatherRequest extends BaseRequest{

    private String parameters = "weather?";

    public CurrentWeatherRequest(String cityName) {
        parameters += String.format("q=%s", cityName);
    }

    public CurrentWeatherRequest withAppid() {
        parameters += APPID;
        return this;
    }

    public Response doRequest() {
        return doBaseRequest(parameters);
    }
}
