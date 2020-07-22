package task6.tests.cloudtests;

import org.testng.annotations.Test;
import task6.businessobjects.Email;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.screens.MailRuEmailPage;
import task6.screens.MailRuMainPage;
import task6.services.LoginService;
import task6.tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginToCloudTest {

    @Test
    public void loginToCloudTest() {
        MailRuMainPage mailRuMainPage = new MailRuMainPage();
        mailRuMainPage.openPage();
        mailRuMainPage.clickCloudIcon();

    }
}
