package ui_task.login_tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui_task.BaseTest;
import ui_task.business_objects.User;
import ui_task.business_objects.UserFactory;
import ui_task.listeners.TestListener;
import ui_task.screens.MailRuLoginPage;
import ui_task.services.LoginService;

@Listeners({TestListener.class})
public class LoginWithIncorrectPasswordTest extends BaseTest {

    @DataProvider(name = "loginWithIncorrectPasswordTest")
    public Object[][] loginWithIncorrectPasswordTestData() {
        return new Object[][]{
                {UserFactory.getUserWithIncorrectPassword(), "Неверное имя или пароль"},
                {UserFactory.getUserWithEmptyPassword(), "Введите пароль"},
        };
    }

    @Test(dataProvider = "loginWithIncorrectPasswordTest")
    public void loginWithIncorrectPasswordTest(User user, String expectedErrorMessage) {
        LoginService.loginToMail(user);
        MailRuLoginPage mailRuLoginPage = new MailRuLoginPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailRuLoginPage.isErrorMassageDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(mailRuLoginPage.getErrorMessageText(), expectedErrorMessage, "Unexpected error message when login with incorrect password");
        softAssert.assertAll();
        System.out.println(user);
    }
}
