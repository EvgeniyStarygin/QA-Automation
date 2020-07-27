package com.itacademy.automation.apitests;

import com.itacademy.automation.api.requests.AllInOneByGeoLocationRequest;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class RequestWithoutKeyTest {

    private String testLon = "-94.037689";
    private String testLat = "33.441792";

    @Test
    public void requestWithoutKeyTest() {
        Response response = new AllInOneByGeoLocationRequest(testLon, testLat)
                .doRequest();
        assertEquals(response.getStatusCode(), 401, "Unexpected status code");
    }
}
