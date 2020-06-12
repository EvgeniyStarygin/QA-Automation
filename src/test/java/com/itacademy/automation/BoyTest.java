package com.itacademy.automation;

import com.itacademy.automation.task4.Boy;
import static com.itacademy.automation.task4helpers.random.RandomGenerator.*;
import static org.testng.Assert.*;

import com.itacademy.automation.task4.Mood;
import org.testng.annotations.Test;


public class BoyTest extends BoyTestData {


    @Test(dataProvider = "getMoodTest", groups = "getMoodTestGroup")
    public void getMoodTest(Boy boy, Mood expectedMood) {
        assertEquals(boy.getMood(), expectedMood);
    }

    @Test(dataProvider = "isPrettyGirlFriendTest")
    public void isPrettyGirlFriendTest(Boy boy, boolean expectedResult) {
        assertEquals(boy.isPrettyGirlFriend(), expectedResult);
    }


    @Test(dataProvider = "isRichTest")
    public void isRichTest(Boy boy, boolean expectedResult) {
        assertEquals(boy.isRich(), expectedResult);
    }

    @Test(description = "amount for spending > wealth", expectedExceptions = RuntimeException.class)
    public void spendSomeMoneyTest1() {
        new Boy(generateRandomMonth(), 1_000_000).spendSomeMoney(generateRandomWealthMoreThanMillion());
    }


    @Test(description = "amount for spending = wealth")
    public void spendSomeMoneyTest2() {
        boy = new Boy(generateRandomMonth(), 1_000_000);
        boy.spendSomeMoney(1_000_000);
        assertEquals(boy.getWealth(), 0.0);

    }

    @Test(description = "amount for spending < wealth")
    public void spendSomeMoneyTest3() {
        double amountForSpending = generateRandomWealthBetweenZeroAndMillion();
        boy = new Boy(generateRandomMonth(), 1_000_000);
        boy.spendSomeMoney(amountForSpending);
        assertEquals(boy.getWealth(), 1_000_000 - amountForSpending);
    }


}
