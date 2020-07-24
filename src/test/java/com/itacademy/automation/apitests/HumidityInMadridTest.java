package com.itacademy.automation.apitests;

import com.itacademy.automation.api.allinone.AllInOneByGeoLocationRequest;
import com.itacademy.automation.api.allinone.AllInOneByGeoLocationResponse;
import com.itacademy.automation.api.allinone.ResponseHandler;
import com.itacademy.automation.api.allinone.Weather;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HumidityInMadridTest {

    private Response response;
    private AllInOneByGeoLocationResponse parsedResponse;
    private String testLat = "40.42";
    private String testLon = "-3.7";
    private String testTimezone = "Europe/Madrid";
    private int maxHumidity;
    private int percentageOfHumidity = 89;

    @Test
    public void humidityInMadridTest() {
        response = new AllInOneByGeoLocationRequest(testLon, testLat)
                .withAppid()
                .doRequest();
        parsedResponse = response.as(AllInOneByGeoLocationResponse.class);
        maxHumidity = ResponseHandler.findMaxHumidity(parsedResponse);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(parsedResponse.getTimezone(), testTimezone, "Country for checking is not Madrid");
        softAssert.assertTrue(ResponseHandler.isMaxHumidityInFirstFiveDays(parsedResponse), "Max humidity not expected for five days");
        softAssert.assertTrue(maxHumidity > percentageOfHumidity, String.format("Max humidity not more than %s", percentageOfHumidity));
        softAssert.assertAll();

    }
}
