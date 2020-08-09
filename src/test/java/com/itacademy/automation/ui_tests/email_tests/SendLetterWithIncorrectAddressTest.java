package com.itacademy.automation.ui_tests.email_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.itacademy.automation.ui_task.business_objects.Letter;
import com.itacademy.automation.ui_task.business_objects.LetterFactory;
import com.itacademy.automation.ui_task.business_objects.UserFactory;
import com.itacademy.automation.ui_task.listeners.TestListener;
import com.itacademy.automation.ui_task.screens.SendNewLetterPage;
import com.itacademy.automation.ui_task.services.LetterService;
import com.itacademy.automation.ui_task.services.LoginService;
import com.itacademy.automation.ui_tests.BaseTest;

@Listeners({TestListener.class})
public class SendLetterWithIncorrectAddressTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        LoginService.loginToMail(UserFactory.getUserWithCorrectCredentials());
    }

    @Test
    public void SendLetterWithIncorrectAddressTest() {
        Letter newLetter = LetterFactory.getLetterWithIncorrectAddress();
        LetterService.sendLetterWithIncorrectAddress(newLetter);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new SendNewLetterPage().isWarningWindowDisplayed());
        softAssert.assertEquals(new SendNewLetterPage().getWarningWindowText(), "Присутствуют некорректные адреса");
        softAssert.assertAll();
    }
}
