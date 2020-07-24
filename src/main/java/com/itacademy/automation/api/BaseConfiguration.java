package com.itacademy.automation.api;

import io.restassured.http.Method;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseConfiguration {

    private static final String BASE_URI = "https://api.openweathermap.org/data/2.5";
    private static final String USER_ID = "3786cdc715780ebd396de06d63e0bc48";

    public static String getUserId() {
        return USER_ID;
    }

    public static String getBaseUri() {
        return BASE_URI;
    }

    public static Response doRequest(String parameters) {
        return given()
                .log().all()
                .baseUri(BaseConfiguration.getBaseUri())
                .request(Method.GET, parameters);
    }

}
