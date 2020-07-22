package task6.services;

import task6.businessobjects.Email;
import task6.businessobjects.User;
import task6.screens.MailRuMainPage;

public class LoginService {

    private static MailRuMainPage mailRuMainPage;

    public static void enterEmail(Email email) {
        mailRuMainPage = new MailRuMainPage();
        mailRuMainPage
                .openPage()
                .typeLogin(email.getLogin())
                .selectDomain(email.getDomain())
                .clickTypePasswordButton();
    }

    public static void logIn(User user)  {
        enterEmail(user.getEmail());
        mailRuMainPage
                .typePassword(user.getPassword())
                .clickLoginButton();
    }
}
