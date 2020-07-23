package task6.services;

import task6.businessobjects.Email;
import task6.businessobjects.User;
import task6.screens.CloudMainPage;
import task6.screens.MailRuLoginPage;

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
