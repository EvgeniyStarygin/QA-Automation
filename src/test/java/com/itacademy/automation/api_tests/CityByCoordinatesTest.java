package com.itacademy.automation.api_tests;

import com.itacademy.automation.api.requests.CityByCoordinatesRequest;
import com.itacademy.automation.api.responses.CurrentWeatherResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

public class CityByCoordinatesTest {

    private Response response;
    private CurrentWeatherResponse parsedResponse;
    private String testLat = "37";
    private String testLon = "52.01";
    private String testCityName = "Fereydun Kenar";

    @Test
    public void cityByCoordinatesTest() {
        response = new CityByCoordinatesRequest(testLat, testLon)
                .withAppid()
                .doRequest();
        parsedResponse = response.as(CurrentWeatherResponse.class);
        assertEquals(parsedResponse.getCityName(), testCityName,
                format("Сity %s is not located in coordinates lat=%s, lon=%s.", testCityName, testLat, testLon));
    }
}
