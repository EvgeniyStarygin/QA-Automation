package task6.tests.logintests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.screens.MailRuMainPage;
import task6.services.LoginService;
import task6.tests.BaseTest;

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
        LoginService.logIn(user);
        MailRuMainPage mailRuMainPage = new MailRuMainPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailRuMainPage.isErrorMassageDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(mailRuMainPage.getErrorMessageText(), expectedErrorMessage, "Unexpected error message when login with incorrect password");
        softAssert.assertAll();
    }
}
