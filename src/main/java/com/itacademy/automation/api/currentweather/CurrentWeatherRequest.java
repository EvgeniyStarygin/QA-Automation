package com.itacademy.automation.api.currentweather;

import com.itacademy.automation.api.BaseConfiguration;
import io.restassured.response.Response;

public class CurrentWeatherRequest {

    private String parameters = "weather?";

    public CurrentWeatherRequest(String cityName) {
        parameters += String.format("q=%s", cityName);
    }

    public CurrentWeatherRequest withAppid() {
        parameters += "&appid=" + BaseConfiguration.getUserId();
        return this;
    }

    public Response doRequest() {
        return BaseConfiguration.doRequest(parameters);
    }
}
