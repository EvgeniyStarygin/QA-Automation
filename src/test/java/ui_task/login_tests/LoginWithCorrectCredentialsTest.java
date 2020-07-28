package ui_task.login_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui_task.business_objects.Email;
import ui_task.business_objects.User;
import ui_task.business_objects.UserFactory;
import ui_task.loggers.MailRuLogger;
import ui_task.screens.MailRuEmailPage;
import ui_task.services.LoginService;
import ui_task.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginWithCorrectCredentialsTest extends BaseTest {

    @BeforeMethod
    public void setUp(){
        MailRuLogger.logInfo("Test started");
    }

    @Test
    public void loginWithCorrectCredentialsTest() {
        User user = UserFactory.getUserWithCorrectCredentials();
        Email email = user.getEmail();
        LoginService.loginToMail(user);
        MailRuEmailPage mailRuEmailPage = new MailRuEmailPage();
        assertEquals(mailRuEmailPage.getUserId(), email.getLogin() + email.getDomain(), "Unexpected user ID");
    }
}
