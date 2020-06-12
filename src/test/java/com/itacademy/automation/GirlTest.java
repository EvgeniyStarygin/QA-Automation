package com.itacademy.automation;

import com.itacademy.automation.task4.Boy;
import com.itacademy.automation.task4.Girl;
import com.itacademy.automation.task4.Mood;
import com.itacademy.automation.task4helpers.exception.BoyfriendIsNullException;
import org.testng.annotations.Test;
import static com.itacademy.automation.task4helpers.random.RandomGenerator.*;
import static org.testng.Assert.assertEquals;

public class GirlTest extends GirlTestData {



    @Test(dataProvider = "getMoodTest", groups = "getMoodTestGroup")
    public void getMoodTest(Girl girl, Mood expectedMood) {
        assertEquals(girl.getMood(), expectedMood);
    }

    @Test(dataProvider = "isSlimFriendBecameFatTest")
    public void isSlimFriendBecameFatTest(Girl girl, boolean expectedResult) {
        assertEquals(girl.isSlimFriendBecameFat(), expectedResult);
    }

    @Test(dataProvider = "isBoyFriendWillBuyNewShoesTest")
    public void isBoyFriendWillBuyNewShoesTest(Girl girl, boolean expectedResult) {
        assertEquals(girl.isBoyFriendWillBuyNewShoes(), expectedResult);
    }


    @Test(dataProvider = "isBoyfriendRichTest")
    public void isBoyfriendRichTest(Girl girl, boolean expectedResult) {
        assertEquals(girl.isBoyfriendRich(), expectedResult);
    }


    @Test(description = "isBoyFriendRich() = false")
    public void spendBoyFriendMoneyTest1() {
        double boyWealth = generateRandomWealthBetweenZeroAndMillion();
        boy = new Boy(generateRandomMonth(), boyWealth);
        girl = new Girl(generateRandomBooleanValue(), generateRandomBooleanValue(), boy);
        girl.spendBoyFriendMoney(generateRandomWealthBetweenZeroAndMillion());
        assertEquals(boy.getWealth(), boyWealth);
    }

    @Test(description = "amount for spending > wealth", expectedExceptions = RuntimeException.class)
    public void spendBoyFriendMoneyTest4() {
        double boyWealth = generateRandomWealthMoreThanMillion();
        boy = new Boy(generateRandomMonth(), boyWealth);
        girl = new Girl(generateRandomBooleanValue(), generateRandomBooleanValue(), boy);
        double amountForSpending = boyWealth + generateRandomPositiveWealth();
        girl.spendBoyFriendMoney(amountForSpending);
    }

    @Test(description = "boyfriend = null", expectedExceptions = BoyfriendIsNullException.class)
    public void spendBoyFriendMoneyTest2() {
        girl = new Girl(generateRandomBooleanValue(), generateRandomBooleanValue());
        double amountForSpending = generateRandomWealthBetweenZeroAndMillion();
        girl.spendBoyFriendMoney(amountForSpending);
    }

    @Test(description = "amount for spending < wealth")
    public void spendBoyFriendMoneyTest3() {
        double boyWealth = generateRandomWealthMoreThanMillion();
        boy = new Boy(generateRandomMonth(), boyWealth);
        girl = new Girl(generateRandomBooleanValue(), generateRandomBooleanValue(), boy);
        double amountForSpending = generateRandomWealthBetweenZeroAndMillion();
        girl.spendBoyFriendMoney(amountForSpending);
        assertEquals(boy.getWealth(), boyWealth - amountForSpending);
    }

}
