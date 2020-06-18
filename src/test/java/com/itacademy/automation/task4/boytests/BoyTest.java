package com.itacademy.automation.task4.boytests;

import com.itacademy.automation.task4.Boy;
import com.itacademy.automation.task4.Mood;
import com.itacademy.automation.task4helpers.exception.BirthdayIsNullException;
import com.itacademy.automation.task4helpers.exception.NegativeWealthException;
import org.testng.annotations.Test;

import static com.itacademy.automation.task4helpers.random.RandomGenerator.*;
import static org.testng.Assert.assertEquals;

public class BoyTest extends BoyTestData {

    @Test(dataProvider = "getMoodTest")
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

    @Test(description = "amount for spending > wealth", expectedExceptions = RuntimeException.class, groups = "spendSomeMoneyTest")
    public void spendSomeMoneyIfAmountForSpendingMoreThanWealth() {
        new Boy(generateRandomMonth(), 1_000_000).spendSomeMoney(generateRandomWealthMoreThanMillion());
    }

    @Test(description = "amount for spending = wealth", groups = "spendSomeMoneyTest")
    public void spendSomeMoneyIfAmountForSpendingEqualsToWealth() {
        boy = new Boy(generateRandomMonth(), 1_000_000);
        boy.spendSomeMoney(1_000_000);
        assertEquals(boy.getWealth(), 0.0);

    }

    @Test(description = "amount for spending < wealth", groups = "spendSomeMoneyTest")
    public void spendSomeMoneyIfAmountForSpendingLessThanWealth() {
        double amountForSpending = generateRandomWealthBetweenZeroAndMillion();
        boy = new Boy(generateRandomMonth(), 1_000_000);
        boy.spendSomeMoney(amountForSpending);
        assertEquals(boy.getWealth(), 1_000_000 - amountForSpending);
    }

    @Test(expectedExceptions = BirthdayIsNullException.class, groups = "constructorExceptions")
    public void birthdayIsNullTest() {
        Boy boy = new Boy(null);
    }

    @Test(expectedExceptions = NegativeWealthException.class, groups = "constructorExceptions")
    public void negativeWealthTest() {
        Boy boy = new Boy(generateRandomMonth(), generateRandomNegativeWealth());
    }
}
