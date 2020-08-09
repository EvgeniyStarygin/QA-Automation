package com.itacademy.automation.ui_tests.email_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.itacademy.automation.ui_tests.BaseTest;
import com.itacademy.automation.ui_task.business_objects.Letter;
import com.itacademy.automation.ui_task.business_objects.LetterFactory;
import com.itacademy.automation.ui_task.business_objects.UserFactory;
import com.itacademy.automation.ui_task.listeners.TestListener;
import com.itacademy.automation.ui_task.screens.MailRuEmailPage;
import com.itacademy.automation.ui_task.screens.SendNewLetterPage;
import com.itacademy.automation.ui_task.services.LetterService;
import com.itacademy.automation.ui_task.services.LoginService;

@Listeners({TestListener.class})
public class SendLetterWithoutBodyTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        LoginService.loginToMail(UserFactory.getUserWithCorrectCredentials());
        LetterService.deleteLetterFromInboxAndSent();
    }

    @AfterMethod
    public static void tearDown() {
        LetterService.deleteLetterFromInboxAndSent();
    }

    @Test
    public void sendLetterWithoutBodyTest() {
        Letter newLetter = LetterFactory.getLetterWithoutBody();
        LetterService.sendNewLetter(newLetter);
        SendNewLetterPage sendNewLetterPage = new SendNewLetterPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(sendNewLetterPage.isWarningWindowDisplayed());
        softAssert.assertEquals(sendNewLetterPage.getWarningWindowText(), "Вы действительно хотите отправить пустое письмо?");
        sendNewLetterPage.clickSendButtonOnWarningWindow();
        softAssert.assertTrue(sendNewLetterPage.isSuccessConfirmationWindowDisplayed());
        sendNewLetterPage.closeSuccessConfirmationWindow();
        MailRuEmailPage mailRuEmailPage = new MailRuEmailPage();
        mailRuEmailPage
                .clickInboxLettersLink()
                .clickLetterLink();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubject(), newLetter.getSubject());
        softAssert.assertEquals(mailRuEmailPage.getLetterText(), " ");
        mailRuEmailPage
                .clickSentLettersLink()
                .clickLetterLink();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubject(), "Self: " + newLetter.getSubject());
        softAssert.assertEquals(mailRuEmailPage.getLetterText(), " ");
        softAssert.assertAll();
    }
}
