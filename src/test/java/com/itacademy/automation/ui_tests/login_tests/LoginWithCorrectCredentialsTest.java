package com.itacademy.automation.ui_tests.login_tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.itacademy.automation.ui_tests.BaseTest;
import com.itacademy.automation.ui_task.business_objects.Email;
import com.itacademy.automation.ui_task.business_objects.User;
import com.itacademy.automation.ui_task.business_objects.UserFactory;
import com.itacademy.automation.ui_task.listeners.TestListener;
import com.itacademy.automation.ui_task.screens.MailRuEmailPage;
import com.itacademy.automation.ui_task.services.LoginService;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class LoginWithCorrectCredentialsTest extends BaseTest {

    @Test
    public void loginWithCorrectCredentialsTest() {
        User user = UserFactory.getUserWithCorrectCredentials();
        Email email = user.getEmail();
        LoginService.loginToMail(user);
        assertEquals(new MailRuEmailPage().getUserId(), email.getLogin() + email.getDomain(), "Unexpected user ID");
    }
}
