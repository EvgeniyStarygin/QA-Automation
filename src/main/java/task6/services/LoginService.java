package task6.services;

import task6.businessobjects.User;
import task6.screens.MailRuLoginForm;

public class LoginService {

    private static MailRuLoginForm mailRuLoginForm;

    public static void enterEmail(User user) {
        mailRuLoginForm = new MailRuLoginForm();
        mailRuLoginForm
                .loadPage()
                .typeLogin(user.getEmail().getLogin())
                .selectDomain(user.getEmail().getDomain())
                .clickTypePasswordButton();
    }

    public static void logIn(User user) throws InterruptedException {
        enterEmail(user);
        Thread.sleep(3000);
        mailRuLoginForm
                .typePassword(user.getPassword())
                .clickLoginButton();
    }
}
