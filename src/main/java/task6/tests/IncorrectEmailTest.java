package task6.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.screens.MailRuLoginForm;
import task6.services.LoginService;

public class IncorrectEmailTest extends BaseTest{

    @DataProvider(name = "incorrectEmailTest")
    public Object[][] incorrectEmailTestData() {
        return new Object[][]{
                {UserFactory.getUserWithIncorrectEmailName(), "Неверное имя ящика"},
                {UserFactory.getUserWithIncorrectEmailDomain(), "Неверное имя ящика"},
        };
    }

    @Test(dataProvider = "incorrectEmailDataTest")
    public void incorrectEmailTest(User user, String expectedErrorMessage) throws InterruptedException {
        LoginService.enterEmail(user);
        MailRuLoginForm mailRuLoginForm = new MailRuLoginForm();
        Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailRuLoginForm.isErrorMassageDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(mailRuLoginForm.getErrorMessageText(), expectedErrorMessage);
        softAssert.assertAll();
    }
}
