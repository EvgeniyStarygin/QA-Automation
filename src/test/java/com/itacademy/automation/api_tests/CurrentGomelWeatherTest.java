package com.itacademy.automation.api_tests;


import com.itacademy.automation.api_task.requests.CurrentWeatherRequest;
import com.itacademy.automation.api_task.responses.CurrentWeatherResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CurrentGomelWeatherTest {

    private Response response;
    private CurrentWeatherResponse parsedResponse;
    private String testWeather = "Clouds";
    private String testLat = "52.43";
    private String testLon = "30.98";
    private String testCountryCode = "BY";
    private String testCityName = "Gomel";


    @Test
    public void currentGomelWeatherTest() {
        response = new CurrentWeatherRequest(testCityName)
                .withAppid()
                .doRequest();
        parsedResponse = response.as(CurrentWeatherResponse.class);
        System.out.println(response.getBody().asString());
        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(parsedResponse.getCountryInformation().getCountryCode(), testCountryCode, "Unexpected country code");
        softAssert.assertEquals(parsedResponse.getCityName(), testCityName, "Unexpected country name");
       // softAssert.assertEquals(parsedResponse.getCoordinates().getLatitude(), testLat, "Unexpected latitude");
//        softAssert.assertEquals(parsedResponse.getCoordinates().getLongitude(), testLon, "Unexpected longitude");
//        softAssert.assertNotEquals(parsedResponse.getWeathers().get(0).getWeather(), testWeather, "Unexpected weather");
        softAssert.assertAll();
    }
}
