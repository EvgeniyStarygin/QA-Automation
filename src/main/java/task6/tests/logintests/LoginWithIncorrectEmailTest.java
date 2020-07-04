package task6.tests.logintests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.Email;
import task6.businessobjects.EmailFactory;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.entities.WrappedDriver;
import task6.screens.MailRuLoginFormPage;
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
    public void loginWithIncorrectEmailTest(Email email, String expectedErrorMessage)  {
        LoginService.enterEmail(email);
        MailRuLoginFormPage mailRuLoginFormPage = new MailRuLoginFormPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailRuLoginFormPage.isErrorMassageDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(mailRuLoginFormPage.getErrorMessageText(), expectedErrorMessage);
        softAssert.assertAll();
    }
}
