package com.itacademy.automation.ui_tests.login_tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.itacademy.automation.ui_tests.BaseTest;
import com.itacademy.automation.ui_task.business_objects.Email;
import com.itacademy.automation.ui_task.business_objects.EmailFactory;
import com.itacademy.automation.ui_task.listeners.TestListener;
import com.itacademy.automation.ui_task.screens.MailRuLoginPage;
import com.itacademy.automation.ui_task.services.LoginService;

@Listeners({TestListener.class})
public class LoginWithIncorrectEmailTest extends BaseTest {

    @DataProvider(name = "loginWithIncorrectEmailTest")
    public Object[][] loginWithIncorrectEmailTestData() {
        return new Object[][]{
                {EmailFactory.getIncorrectLogin(), "Неверное имя ящика"},
                {EmailFactory.getIncorrectDomain(), "Неверное имя ящика"},
                {EmailFactory.getEmptyLogin(), "Введите имя ящика"}
        };
    }

    @Test(dataProvider = "loginWithIncorrectEmailTest")
    public void loginWithIncorrectEmailTest(Email email, String expectedErrorMessage) {
        LoginService.enterEmail(email);
        MailRuLoginPage mailRuLoginPage = new MailRuLoginPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailRuLoginPage.isErrorMassageDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(mailRuLoginPage.getErrorMessageText(), expectedErrorMessage, "Unexpected error message when login with incorrect email");
        softAssert.assertAll();
    }
}
