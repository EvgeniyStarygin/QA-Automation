package ui_task.services;

import ui_task.business_objects.Email;
import ui_task.business_objects.User;
import ui_task.loggers.CustomLogger;
import ui_task.screens.CloudMainPage;
import ui_task.screens.MailRuEmailPage;
import ui_task.screens.MailRuLoginPage;

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
