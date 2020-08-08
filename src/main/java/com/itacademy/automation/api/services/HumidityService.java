package com.itacademy.automation.api.services;

import com.itacademy.automation.api.responses.AllInOneByGeoLocationResponse;

public class HumidityService {

    private static int maxHumidity;
    private static int currentHumidity;

    public static int findMaxHumidity(AllInOneByGeoLocationResponse response) {
        maxHumidity = response.getWeathers().get(0).getHumidity();
        for (int i = 1; i < response.getWeathers().size(); i++) {
            currentHumidity = response.getWeathers().get(i).getHumidity();
            if (currentHumidity > maxHumidity) {
                maxHumidity = currentHumidity;
            }
        }
        return maxHumidity;
    }

    public static boolean isMaxHumidityInFirstFiveDays(AllInOneByGeoLocationResponse response) {
        boolean result = false;
        for (int i = 0; i < 5; i++) {
            if (response.getWeathers().get(i).getHumidity() == maxHumidity) {
                result = true;
                break;
            }
        } return result;
    }



}
