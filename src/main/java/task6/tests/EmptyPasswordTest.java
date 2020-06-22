package task6.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.screens.MailRuLoginForm;
import task6.services.LoginService;

public class EmptyPasswordTest extends BaseTest{

    @Test
    public void emptyPasswordTest() throws InterruptedException {
        User user = UserFactory.getUserWithCorrectEmail();
        LoginService.enterEmail(user);
        MailRuLoginForm mailRuLoginForm = new MailRuLoginForm();
        mailRuLoginForm
                .clickLoginButton();
        Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailRuLoginForm.isErrorMassageDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(mailRuLoginForm.getErrorMessageText(), "Введите пароль");
        softAssert.assertAll();
    }
}
