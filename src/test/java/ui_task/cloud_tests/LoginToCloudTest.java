package ui_task.cloud_tests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import ui_task.business_objects.Email;
import ui_task.business_objects.User;
import ui_task.business_objects.UserFactory;
import ui_task.screens.CloudMainPage;
import ui_task.services.LoginService;
import ui_task.BaseTest;

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
