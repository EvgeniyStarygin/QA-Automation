package com.itacademy.automation.unit_tests.boytests;

import com.itacademy.automation.unit_tests.Boy;
import com.itacademy.automation.unit_tests.Girl;
import com.itacademy.automation.unit_tests.Mood;
import com.itacademy.automation.unit_tests.helpers.exceptions.BirthdayIsNullException;
import com.itacademy.automation.unit_tests.helpers.exceptions.NegativeWealthException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.itacademy.automation.unit_tests.helpers.random.RandomGenerator.*;
import static org.testng.Assert.assertEquals;

public class BoyTest {

    private Boy boy;

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

    @Test(dataProvider = "getMoodTest")
    public void getMoodTest(Boy boy, Mood expectedMood) {
        assertEquals(boy.getMood(), expectedMood, "Unexpected  boyfriend's mood");
    }

    @DataProvider(name = "isPrettyGirlFriendTest")
    public Object[][] isPrettyGirlFriendTestData() {
        return new Object[][]{
                {new Boy(generateRandomMonth()), false},
                {new Boy(generateRandomMonth(), generateRandomPositiveWealth(), new Girl(false)), false},
                {new Boy(generateRandomMonth(), generateRandomPositiveWealth(), new Girl(true)), true}
        };
    }

    @Test(dataProvider = "isPrettyGirlFriendTest")
    public void isPrettyGirlFriendTest(Boy boy, boolean expectedResult) {
        assertEquals(boy.isPrettyGirlFriend(), expectedResult, "Unexpected girlfriend's prettiness");
    }

    @DataProvider(name = "isRichTest")
    public Object[][] isRichTestData() {
        double wealth = 1_000_000.0;
        return new Object[][]{
                {new Boy(generateRandomMonth()), false},
                {new Boy(generateRandomMonth(), generateRandomWealthBetweenZeroAndMillion()), false},
                {new Boy(generateRandomMonth(), wealth), true},
                {new Boy(generateRandomMonth(), generateRandomWealthMoreThanMillion()), true}
        };
    }

    @Test(dataProvider = "isRichTest")
    public void isRichTest(Boy boy, boolean expectedResult) {
        assertEquals(boy.isRich(), expectedResult, "Unexpected boyfriend's richness");
    }

    @Test(description = "amount for spending > wealth", expectedExceptions = RuntimeException.class, groups = "spendSomeMoneyTest")
    public void spendSomeMoneyIfAmountForSpendingMoreThanWealth() {
        double wealth = 1_000_000.0;
        new Boy(generateRandomMonth(), wealth).spendSomeMoney(generateRandomWealthMoreThanMillion());
    }

    @Test(description = "amount for spending = wealth", groups = "spendSomeMoneyTest")
    public void spendSomeMoneyIfAmountForSpendingEqualsToWealth() {
        double wealth = 1_000_000.0;
        double amountForSpending = 1_000_000.0;
        double expectedWealth = 0.0;
        boy = new Boy(generateRandomMonth(), wealth);
        boy.spendSomeMoney(amountForSpending);
        assertEquals(boy.getWealth(), expectedWealth, "Unexpected wealth after spending of money");
    }

    @Test(description = "amount for spending < wealth", groups = "spendSomeMoneyTest")
    public void spendSomeMoneyIfAmountForSpendingLessThanWealth() {
        double wealth = 1_000_000.0;
        double amountForSpending = generateRandomWealthBetweenZeroAndMillion();
        boy = new Boy(generateRandomMonth(), wealth);
        boy.spendSomeMoney(amountForSpending);
        assertEquals(boy.getWealth(), wealth - amountForSpending, "Unexpected wealth after spending of money");
    }

    @Test(expectedExceptions = BirthdayIsNullException.class, groups = "constructorExceptions")
    public void birthdayIsNullTest() {
        new Boy(null);
    }

    @Test(expectedExceptions = NegativeWealthException.class, groups = "constructorExceptions")
    public void negativeWealthTest() {
        new Boy(generateRandomMonth(), generateRandomNegativeWealth());
    }
}
