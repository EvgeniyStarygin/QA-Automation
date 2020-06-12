package com.itacademy.automation;

import com.itacademy.automation.task4.Boy;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MonthTest {

    private Boy boy;
    private boolean expectedResult;

    public MonthTest(Boy boy, boolean expectedResult) {
        this.boy = boy;
        this.expectedResult = expectedResult;
    }

    @Test (description = "using Factory")
    public void isSummerMonthTest() {
        assertEquals(boy.isSummerMonth(), expectedResult);
    }

//    @DataProvider(name = "isRichTest")
//    public Object[][] isRichTestData() {
//        return new Object[][]{
//                {new Boy(generateRandomMonth()), false},
//                {new Boy(generateRandomMonth(), generateRandomWealthBetweenZeroAndMillion()), false},
//                {new Boy(generateRandomMonth(), 1_000_000), true},
//                {new Boy(generateRandomMonth(), generateRandomWealthMoreThanMillion()), true}
//
//        };
//    }
//
//    @Test(dataProvider = "isRichTest")
//    public void isRichTest(Boy boy, boolean expectedResult) {
//        assertEquals(boy.isRich(), expectedResult);
//    }
}
