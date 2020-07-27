package ui_task.services;

import ui_task.business_objects.Email;
import ui_task.business_objects.User;
import ui_task.screens.CloudMainPage;
import ui_task.screens.MailRuLoginPage;

public class LoginService {

    private static MailRuLoginPage mailRuLoginPage;
    private static CloudMainPage cloudMainPage;

    public static void enterEmail(Email email) {
        mailRuLoginPage = new MailRuLoginPage();
        mailRuLoginPage
                .openMailRuMainPage()
                .typeLogin(email.getLogin())
                .selectDomain(email.getDomain())
                .clickTypePasswordButton();
    }

    public static void loginToMail(User user) {
        enterEmail(user.getEmail());
        mailRuLoginPage
                .typePassword(user.getPassword())
                .clickLoginButton();
    }

    public static void loginToCloud(User user) {
        cloudMainPage = new CloudMainPage();
        cloudMainPage
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
