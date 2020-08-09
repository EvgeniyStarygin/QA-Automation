package com.itacademy.automation.ui_task.services;

import com.itacademy.automation.ui_task.business_objects.Email;
import com.itacademy.automation.ui_task.business_objects.User;
import com.itacademy.automation.ui_task.loggers.CustomLogger;
import com.itacademy.automation.ui_task.screens.CloudMainPage;
import com.itacademy.automation.ui_task.screens.MailRuEmailPage;
import com.itacademy.automation.ui_task.screens.MailRuLoginPage;

public class LoginService {

    public static MailRuLoginPage enterEmail(Email email) {
        CustomLogger.logEnterEmail(email);
        new MailRuLoginPage()
                .openMailRuMainPage()
                .typeLogin(email.getLogin())
                .selectDomain(email.getDomain())
                .clickTypePasswordButton();
        return new MailRuLoginPage();
    }

    public static MailRuEmailPage loginToMail(User user) {
        CustomLogger.logLoginToMail(user);
        new MailRuLoginPage()
                .openMailRuMainPage()
                .typeLogin(user.getEmail().getLogin())
                .selectDomain(user.getEmail().getDomain())
                .clickTypePasswordButton()
                .typePassword(user.getPassword())
                .clickLoginButton();
        return new MailRuEmailPage();
    }

    public static void loginToCloud(User user) {
        CustomLogger.logLoginToCloud(user);
        new CloudMainPage()
                .openCloudMainPage()
                .clickEnterButton()
                .switchToLoginForm()
                .typeLogin(user.getEmail().getLogin())
                .selectDomain(user.getEmail().getDomain())
                .clickTypePasswordButton()
                .typePassword(user.getPassword())
                .clickLoginButton()
                .switchToCloudMainPage();
    }
}
