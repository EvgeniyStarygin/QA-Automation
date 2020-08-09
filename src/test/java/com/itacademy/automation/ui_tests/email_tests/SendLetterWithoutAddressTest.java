package com.itacademy.automation.ui_tests.email_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.itacademy.automation.ui_task.business_objects.Letter;
import com.itacademy.automation.ui_task.business_objects.LetterFactory;
import com.itacademy.automation.ui_task.business_objects.UserFactory;
import com.itacademy.automation.ui_task.listeners.TestListener;
import com.itacademy.automation.ui_task.screens.SendNewLetterPage;
import com.itacademy.automation.ui_task.services.LetterService;
import com.itacademy.automation.ui_task.services.LoginService;
import com.itacademy.automation.ui_tests.BaseTest;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class SendLetterWithoutAddressTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        LoginService.loginToMail(UserFactory.getUserWithCorrectCredentials());
    }

    @Test
    public void SendLetterWithoutAddressTest() {
        Letter newLetter = LetterFactory.getLetterWithoutAddress();
        LetterService.sendLetterWithIncorrectAddress(newLetter);
        assertEquals(new SendNewLetterPage().getEmptyAddressErrorMessageText(), "Не указан адрес получателя");
    }
}
