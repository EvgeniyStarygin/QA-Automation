package ui_task.login_tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui_task.BaseTest;
import ui_task.business_objects.Email;
import ui_task.business_objects.User;
import ui_task.business_objects.UserFactory;
import ui_task.listeners.TestListener;
import ui_task.screens.MailRuEmailPage;
import ui_task.services.LoginService;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class LoginWithCorrectCredentialsTest extends BaseTest {

    @Test
    public void loginWithCorrectCredentialsTest() {
        User user = UserFactory.getUserWithCorrectCredentials();
        Email email = user.getEmail();
        LoginService.loginToMail(user);
        MailRuEmailPage mailRuEmailPage = new MailRuEmailPage();
        assertEquals(mailRuEmailPage.getUserId(), email.getLogin() + email.getDomain(), "Unexpected user ID");
    }
}
