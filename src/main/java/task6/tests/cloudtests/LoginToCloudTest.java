package task6.tests.cloudtests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import task6.businessobjects.Email;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.screens.CloudMainPage;
import task6.services.LoginService;
import task6.tests.BaseTest;

public class LoginToCloudTest extends BaseTest {

    private static CloudMainPage cloudMainPage;

    @Test
    public void loginToCloudTest() {
        User user = UserFactory.getUserWithCorrectCredentials();
        Email email = user.getEmail();
        LoginService.loginToCloud(user);
        cloudMainPage = new CloudMainPage();
        assertEquals(cloudMainPage.getUserId(), email.getLogin() + email.getDomain(), "Unexpected user ID");
    }
}
