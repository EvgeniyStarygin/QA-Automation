package com.itacademy.automation.api_task.requests;

import io.restassured.http.Method;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public abstract class BaseRequest {

    private static final String BASE_URI = "https://api.openweathermap.org/data/2.5";
    protected static final String APPID = "&appid=3786cdc715780ebd396de06d63e0bc48" ;

    public static Response doBaseRequest(String parameters) {
        return given()
                .log().all()
                .baseUri(BASE_URI)
                .request(Method.GET, parameters);
    }
}
