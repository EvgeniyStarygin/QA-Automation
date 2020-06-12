package com.itacademy.automation;

import com.itacademy.automation.task4.Boy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import java.time.Month;

public class MonthTestFactory {

    @DataProvider(name = "isSummerMonthTest")
    public Object[][] isSummerMonthTestData() {
        return new Object[][]{
                {new Boy(Month.JUNE), true},
                {new Boy(Month.JULY), true},
                {new Boy(Month.AUGUST), true},
                {new Boy(Month.SEPTEMBER), false},
                {new Boy(Month.OCTOBER), false},
                {new Boy(Month.NOVEMBER), false},
                {new Boy(Month.DECEMBER), false},
                {new Boy(Month.JANUARY), false},
                {new Boy(Month.FEBRUARY), false},
                {new Boy(Month.MARCH), false},
                {new Boy(Month.APRIL), false},
                {new Boy(Month.MAY), false}
        };
    }

    @Factory(dataProvider = "isSummerMonthTest")
    public Object[] createTest(Boy boy, boolean expectedResult){
        return new Object[]{new MonthTest(boy, expectedResult)};
    }


}
