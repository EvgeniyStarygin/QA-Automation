package com.itacademy.automation.apitests;

import com.itacademy.automation.api.citybycoordinates.CityByCoordinatesRequest;
import com.itacademy.automation.api.currentweather.CurrentWeatherRequest;
import com.itacademy.automation.api.currentweather.CurrentWeatherResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

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
        assertEquals(parsedResponse.getCityName(), testCityName, String.format("Сity %s is not located in coordinates lat=%s, lon=%s.", testCityName, testLat, testLon));
    }
}
