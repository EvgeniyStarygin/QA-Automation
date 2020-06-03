package com.itacademy.automation;

import com.itacademy.automation.task4.Boy;
import com.itacademy.automation.task4.Girl;
import com.itacademy.automation.task4.RandomGenerator;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BoyTest {


    @DataProvider
    public Object[][] isPrettyGirlFriendTestData() {
        return new Object[][]{
                {new Boy(RandomGenerator.generateRandomMonth(),
                         RandomGenerator.generateRandomWealth(),
                        null), false},
                {new Boy(RandomGenerator.generateRandomMonth(),
                         RandomGenerator.generateRandomWealth(),
                         new Girl(false,
                                RandomGenerator.generateRandomBooleanValue(),
                                null)), false},


        };
    }


    @Test(dataProvider = "isPrettyGirlFriendTestData")
    public void isPrettyGirlFriendTest(Boy boy, boolean expectedResult) {
        assertFalse(boy.isPrettyGirlFriend());
    }


}
