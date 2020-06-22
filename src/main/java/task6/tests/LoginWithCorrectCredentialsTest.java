package task6.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.screens.MailRuLoginForm;
import task6.services.LoginService;

public class LoginWithCorrectCredentialsTest extends BaseTest{

    @Test
    public void incorrectPasswordTest() throws InterruptedException {
        User user = UserFactory.getUserWithCorrectCredentials();
        LoginService.logIn(user);
        MailRuLoginForm mailRuLoginForm = new MailRuLoginForm();
    }
}
