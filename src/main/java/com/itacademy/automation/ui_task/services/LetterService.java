package com.itacademy.automation.ui_task.services;

import com.itacademy.automation.ui_task.business_objects.Letter;
import com.itacademy.automation.ui_task.loggers.CustomLogger;
import com.itacademy.automation.ui_task.screens.MailRuEmailPage;
import com.itacademy.automation.ui_task.screens.SendNewLetterPage;

public class LetterService {

    public static SendNewLetterPage fillNewLetterFields(Letter letter) {
        new MailRuEmailPage()
                .clickNewLetterButton()
                .typeAddress(letter.getAddress())
                .typeSubject(letter.getSubject())
                .typeMessage(letter.getText());
        return new SendNewLetterPage();
    }

    public static void sendNewLetter(Letter letter) {
        CustomLogger.logSendNewLetter(letter);
        fillNewLetterFields(letter)
                .clickSendButton();
    }

    public static void saveNewLetter(Letter letter) {
        CustomLogger.logSaveNewLetter(letter);
        fillNewLetterFields(letter)
                .clickSaveButton();
    }

    public static void sendLetterWithIncorrectAddress(Letter letter) {
        CustomLogger.logSendNewLetterWithIncorrectAddress(letter);
        new MailRuEmailPage()
                .clickNewLetterButton()
                .typeAddress(letter.getAddress())
                .clickSendButton();
    }

    public static void deleteLetterFromInboxAndSent() {
        CustomLogger.logDeleteLetterFromInboxAndSent();
        new MailRuEmailPage()
                .clickInboxLettersLink()
                .deleteLettersIfExist()
                .clickSentLettersLink()
                .deleteLettersIfExist();
    }

    public static void deleteLetterFromDraftsAndTrash() {
        CustomLogger.logDeleteLetterFromDraftsAndTrash();
        new MailRuEmailPage()
                .clickDraftsLink()
                .deleteLettersIfExist()
                .clickTrashLink()
                .deleteLettersIfExist();
    }
}
