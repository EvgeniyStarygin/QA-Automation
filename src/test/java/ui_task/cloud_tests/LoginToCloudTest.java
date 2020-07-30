package ui_task.cloud_tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui_task.BaseTest;
import ui_task.business_objects.Email;
import ui_task.business_objects.User;
import ui_task.business_objects.UserFactory;
import ui_task.listeners.TestListener;
import ui_task.screens.CloudMainPage;
import ui_task.services.LoginService;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class LoginToCloudTest extends BaseTest {

    @Test
    public void loginToCloudTest() {
        User user = UserFactory.getUserWithCorrectCredentials();
        Email email = user.getEmail();
        LoginService.loginToCloud(user);
        assertEquals(new CloudMainPage().getUserId(), email.getLogin() + email.getDomain(), "Unexpected user ID");
    }
}
