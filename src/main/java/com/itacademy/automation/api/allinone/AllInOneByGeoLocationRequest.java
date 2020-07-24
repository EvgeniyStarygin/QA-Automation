package com.itacademy.automation.api.allinone;

import com.itacademy.automation.api.BaseConfiguration;
import io.restassured.response.Response;

public class AllInOneByGeoLocationRequest {

    private String parameters = "onecall?";

    public AllInOneByGeoLocationRequest(String lon, String lat) {
        parameters += String.format("lat=%s&lon=%s", lat, lon);
    }

    public AllInOneByGeoLocationRequest withExcludes(Excludes... excludes) {
        parameters += "&exclude=" + excludes[0].name().toLowerCase();
        if (excludes.length > 1) {
            for (int i = 1; i < excludes.length; ++i) {
                parameters += "," + excludes[i].name().toLowerCase();
            }
        }
        return this;
    }

    public AllInOneByGeoLocationRequest withAppid() {
        parameters += "&appid=" + BaseConfiguration.getUserId();
        return this;
    }

    public Response doRequest() {
        return BaseConfiguration.doRequest(parameters);
    }

    public enum Excludes {
        CURRENT,
        MINUTELY,
        HOURLY,
        DAILY
    }
}
