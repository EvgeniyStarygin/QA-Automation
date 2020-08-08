package com.itacademy.automation.unit_tests.boytests;

import com.itacademy.automation.unit_tests.Boy;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IsSummerMonthTest {

    private Boy boy;
    private boolean expectedResult;

    public IsSummerMonthTest(Boy boy, boolean expectedResult) {
        this.boy = boy;
        this.expectedResult = expectedResult;
    }

    @Test(description = "using Factory")
    public void isSummerMonthTest() {
        assertEquals(boy.isSummerMonth(), expectedResult, "Boyfriend wasn't born in summer");
    }
}
