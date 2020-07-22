package task6.tests.logintests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.Email;
import task6.businessobjects.EmailFactory;
import task6.screens.MailRuMainPage;
import task6.services.LoginService;
import task6.tests.BaseTest;

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
        MailRuMainPage mailRuMainPage = new MailRuMainPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailRuMainPage.isErrorMassageDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(mailRuMainPage.getErrorMessageText(), expectedErrorMessage, "Unexpected error message when login with incorrect email");
        softAssert.assertAll();
    }
}
