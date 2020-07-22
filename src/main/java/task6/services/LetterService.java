package task6.services;

import task6.businessobjects.Letter;
import task6.screens.MailRuEmailPage;
import task6.screens.SendNewLetterPage;

public class LetterService {

    private static MailRuEmailPage mailRuEmailPage;
    private static SendNewLetterPage sendNewLetterPage;

    public static SendNewLetterPage openNewLetterPage()  {
        mailRuEmailPage = new MailRuEmailPage();
        mailRuEmailPage.clickNewLetterButton();
        return new SendNewLetterPage();
    }

    public static void sendNewLetter(Letter letter) {
        sendNewLetterPage = new SendNewLetterPage();
        sendNewLetterPage
                .typeAddress(letter.getAddress())
                .typeSubject(letter.getSubject())
                .typeMessage(letter.getText())
                .clickSendButton();
    }

    public static void saveNewLetter(Letter letter) {
        sendNewLetterPage = new SendNewLetterPage();
        sendNewLetterPage
                .typeAddress(letter.getAddress())
                .typeSubject(letter.getSubject())
                .typeMessage(letter.getText())
                .clickSaveButton();
    }

    public static void sendLetterWithIncorrectAddress(Letter letter) {
        sendNewLetterPage = new SendNewLetterPage();
        sendNewLetterPage
                .typeAddress(letter.getAddress())
                .clickSendButton();
    }

    public static void deleteLetterFromInboxAndSent() {
        mailRuEmailPage = new MailRuEmailPage();
        mailRuEmailPage
                .clickInboxLettersLink()
                .deleteLetter()
                .clickSentLettersLink()
                .deleteLetter();
    }

    public static void deleteLetterFromDraftsAndTrash() {
        mailRuEmailPage = new MailRuEmailPage();
        mailRuEmailPage
                .clickDraftsLink()
                .deleteLetter()
                .clickTrashLink()
                .deleteLetter();
    }
}
