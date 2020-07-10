package task6.services;

import task6.businessobjects.Email;
import task6.businessobjects.User;
import task6.screens.MailRuLoginFormPage;

public class LoginService {

    private static MailRuLoginFormPage mailRuLoginFormPage;

    public static void enterEmail(Email email) {
        mailRuLoginFormPage = new MailRuLoginFormPage();
        mailRuLoginFormPage
                .openPage()
                .typeLogin(email.getLogin())
                .selectDomain(email.getDomain())
                .clickTypePasswordButton();
    }

    public static void logIn(User user)  {
        enterEmail(user.getEmail());
        mailRuLoginFormPage
                .typePassword(user.getPassword())
                .clickLoginButton();
    }
}
