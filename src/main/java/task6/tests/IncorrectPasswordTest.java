package task6.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.screens.MailRuLoginForm;
import task6.services.LoginService;

public class IncorrectPasswordTest extends BaseTest{

    @Test
    public void incorrectPasswordTest() throws InterruptedException {
        User user = UserFactory.getUserWithIncorrectPassword();
        LoginService.logIn(user);
        //Thread.sleep(3000);
        MailRuLoginForm mailRuLoginForm = new MailRuLoginForm();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailRuLoginForm.isErrorMassageDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(mailRuLoginForm.getErrorMessageText(), "Неверное имя или пароль");
        softAssert.assertAll();
    }
}
