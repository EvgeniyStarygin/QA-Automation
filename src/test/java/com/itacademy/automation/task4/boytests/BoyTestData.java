package com.itacademy.automation.task4.boytests;

import com.itacademy.automation.task4.Boy;
import com.itacademy.automation.task4.Girl;
import com.itacademy.automation.task4.Mood;
import org.testng.annotations.DataProvider;

import static com.itacademy.automation.task4helpers.random.RandomGenerator.*;


public class BoyTestData {

    protected Boy boy;

    @DataProvider(name = "isPrettyGirlFriendTest")
    public Object[][] isPrettyGirlFriendTestData() {
        return new Object[][]{
                {new Boy(generateRandomMonth()), false},
                {new Boy(generateRandomMonth(), generateRandomPositiveWealth(), new Girl(false)), false},
                {new Boy(generateRandomMonth(), generateRandomPositiveWealth(), new Girl(true)), true}
        };
    }

    @DataProvider(name = "isRichTest")
    public Object[][] isRichTestData() {
        return new Object[][]{
                {new Boy(generateRandomMonth()), false},
                {new Boy(generateRandomMonth(), generateRandomWealthBetweenZeroAndMillion()), false},
                {new Boy(generateRandomMonth(), 1_000_000), true},
                {new Boy(generateRandomMonth(), generateRandomWealthMoreThanMillion()), true}
        };
    }

    @DataProvider(name = "getMoodTest")
    public Object[][] getMoodTestData() {
        return new Object[][]{
                {new Boy(generateRandomSummerMonth(), generateRandomWealthMoreThanMillion(), new Girl(true)), Mood.EXCELLENT},
                {new Boy(generateRandomNotSummerMonth(), generateRandomWealthMoreThanMillion(), new Girl(true)), Mood.GOOD},
                {new Boy(generateRandomSummerMonth(), generateRandomWealthMoreThanMillion()), Mood.NEUTRAL},
                {new Boy(generateRandomSummerMonth(), generateRandomWealthMoreThanMillion(), new Girl(false)), Mood.NEUTRAL},
                {new Boy(generateRandomSummerMonth(), generateRandomWealthBetweenZeroAndMillion()), Mood.BAD},
                {new Boy(generateRandomSummerMonth(), generateRandomWealthBetweenZeroAndMillion(), new Girl(false)), Mood.BAD},
                {new Boy(generateRandomNotSummerMonth(), generateRandomWealthBetweenZeroAndMillion(), new Girl(true)), Mood.BAD},
                {new Boy(generateRandomNotSummerMonth(), generateRandomWealthMoreThanMillion(), new Girl(false)), Mood.BAD},
                {new Boy(generateRandomNotSummerMonth(), generateRandomWealthMoreThanMillion()), Mood.BAD},
                {new Boy(generateRandomNotSummerMonth(), generateRandomWealthBetweenZeroAndMillion()), Mood.HORRIBLE},
                {new Boy(generateRandomNotSummerMonth(), generateRandomWealthBetweenZeroAndMillion(), new Girl(false)), Mood.HORRIBLE},

        };
    }
}
