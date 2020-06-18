package com.itacademy.automation.task4.girltests;

import com.itacademy.automation.task4.Boy;
import com.itacademy.automation.task4.Girl;
import com.itacademy.automation.task4.Mood;
import org.testng.annotations.DataProvider;

import static com.itacademy.automation.task4helpers.random.RandomGenerator.*;
import static org.testng.Assert.assertEquals;

public class GirlTestData {

    protected Girl girl;
    protected Boy boy;

    @DataProvider(name = "isSlimFriendBecameFatTest")
    public Object[][] isSlimFriendBecameFatTestData() {
        return new Object[][]{
                {new Girl(false, true), true},
                {new Girl(false, false), false},
                {new Girl(true, false), false},
                {new Girl(true, true), false},
        };
    }

    @DataProvider(name = "isBoyFriendWillBuyNewShoesTest")
    public Object[][] isBoyFriendWillBuyNewShoesTestData() {
        return new Object[][]{
                {new Girl(true, generateRandomBooleanValue(), new Boy(generateRandomMonth(), generateRandomWealthMoreThanMillion())), true},
                {new Girl(true, generateRandomBooleanValue(), new Boy(generateRandomMonth(), generateRandomWealthBetweenZeroAndMillion())), false},
                {new Girl(false, generateRandomBooleanValue(), new Boy(generateRandomMonth(), generateRandomWealthBetweenZeroAndMillion())), false},
                {new Girl(false, generateRandomBooleanValue(), new Boy(generateRandomMonth(), generateRandomWealthMoreThanMillion())), false},
                {new Girl(true), false},
        };
    }

    @DataProvider(name = "isBoyfriendRichTest")
    public Object[][] isBoyfriendRichTestData() {
        return new Object[][]{
                {new Girl(), false},
                {new Girl(generateRandomBooleanValue(), generateRandomBooleanValue(), new Boy(generateRandomMonth(), generateRandomWealthMoreThanMillion())), true},
                {new Girl(generateRandomBooleanValue(), generateRandomBooleanValue(), new Boy(generateRandomMonth(), generateRandomWealthBetweenZeroAndMillion())), false},
        };
    }

    @DataProvider(name = "getMoodTest")
    public Object[][] getMoodTestData() {
        return new Object[][]{
                {new Girl(true, generateRandomBooleanValue(), new Boy(generateRandomMonth(), generateRandomWealthMoreThanMillion())), Mood.EXCELLENT},
                {new Girl(false, generateRandomBooleanValue(), new Boy(generateRandomMonth(), generateRandomWealthMoreThanMillion())), Mood.GOOD},
                {new Girl(true, generateRandomBooleanValue(), new Boy(generateRandomMonth(), generateRandomWealthBetweenZeroAndMillion())), Mood.GOOD},
                {new Girl(false, true), Mood.NEUTRAL},
                {new Girl(false, false), Mood.I_HATE_THEM_ALL},
                {new Girl(false, false, new Boy(generateRandomMonth(), generateRandomWealthBetweenZeroAndMillion())), Mood.I_HATE_THEM_ALL},
        };
    }
}
