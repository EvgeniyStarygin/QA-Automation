package task6.services;

import task6.businessobjects.Letter;
import task6.businessobjects.User;
import task6.screens.MailRuEmailPage;
import task6.screens.SendNewLetterPage;

public class SendNewLetterService {

    private static MailRuEmailPage mailRuEmailPage;
    private static SendNewLetterPage sendNewLetterPage;

    public static SendNewLetterPage openNewLetterPage(User user)  {
        mailRuEmailPage = new MailRuEmailPage();
        mailRuEmailPage.clickNewLetterButton();
        return new SendNewLetterPage();
    }

    public static void sendNewLetter(Letter letter) {
        sendNewLetterPage = new SendNewLetterPage();
        sendNewLetterPage
                .typeAddress(letter.getAddress())
                .typeSubject(letter.getSubject())
                .typeEmailText(letter.getText())
                .clickSendButton();
    }

    public static void saveNewLetter(Letter letter) {
        sendNewLetterPage = new SendNewLetterPage();
        sendNewLetterPage
                .typeAddress(letter.getAddress())
                .typeSubject(letter.getSubject())
                .typeEmailText(letter.getText())
                .clickSaveButton();
    }

    public static void sendLetterWithIncorrectAddress(Letter letter) {
        sendNewLetterPage = new SendNewLetterPage();
        sendNewLetterPage
                .typeAddress(letter.getAddress())
                .clickSendButton();
    }
}
