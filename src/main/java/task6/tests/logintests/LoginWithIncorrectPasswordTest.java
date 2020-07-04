package task6.tests.logintests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.screens.MailRuLoginFormPage;
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
        MailRuLoginFormPage mailRuLoginFormPage = new MailRuLoginFormPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailRuLoginFormPage.isErrorMassageDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(mailRuLoginFormPage.getErrorMessageText(), expectedErrorMessage);
        softAssert.assertAll();
    }
}
