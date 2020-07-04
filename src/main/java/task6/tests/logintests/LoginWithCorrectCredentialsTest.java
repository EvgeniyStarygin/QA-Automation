package task6.tests.logintests;

import org.testng.annotations.Test;
import task6.businessobjects.Email;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.screens.MailRuEmailPage;
import task6.services.LoginService;
import task6.tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginWithCorrectCredentialsTest extends BaseTest {

    @Test
    public void loginWithCorrectCredentialsTest()  {
        User user = UserFactory.getUserWithCorrectCredentials();
        Email email = user.getEmail();
        LoginService.logIn(user);
        MailRuEmailPage mailRuEmailPage = new MailRuEmailPage();
        assertEquals(mailRuEmailPage.getUserId(), email.getLogin() + email.getDomain());
    }
}
