package ui_task.login_tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui_task.business_objects.Email;
import ui_task.business_objects.EmailFactory;
import ui_task.screens.MailRuLoginPage;
import ui_task.services.LoginService;
import ui_task.BaseTest;

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
