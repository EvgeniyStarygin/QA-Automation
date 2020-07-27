package ui_task.email_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui_task.business_objects.Letter;
import ui_task.business_objects.LetterFactory;
import ui_task.business_objects.UserFactory;
import ui_task.screens.MailRuEmailPage;
import ui_task.screens.SendNewLetterPage;
import ui_task.services.LetterService;
import ui_task.services.LoginService;
import ui_task.BaseTest;

public class SendCorrectLetterTest extends BaseTest {

    private static MailRuEmailPage mailRuEmailPage;

    @BeforeMethod
    public void deleteLetterIfPresent() {
        LoginService.loginToMail(UserFactory.getUserWithCorrectCredentials());
        LetterService.deleteLetterFromInboxAndSent();
    }

    @AfterMethod
    public static void deleteLetter() {
        LetterService.deleteLetterFromInboxAndSent();
    }

    @Test
    public void sendCorrectLetterTest() {
        Letter newLetter = LetterFactory.getCorrectLetter();
        SendNewLetterPage sendNewLetterPage = LetterService.openNewLetterPage();
        LetterService.sendNewLetter(newLetter);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(sendNewLetterPage.isSuccessConfirmationWindowDisplayed());
        sendNewLetterPage.closeSuccessConfirmationWindow();
        mailRuEmailPage = new MailRuEmailPage();
        mailRuEmailPage
                .clickInboxLettersLink()
                .clickLetterLink();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubject(), newLetter.getSubject());
        softAssert.assertEquals(mailRuEmailPage.getLetterText(), newLetter.getText());
        mailRuEmailPage
                .clickSentLettersLink()
                .clickLetterLink();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubject(), "Self: " + newLetter.getSubject());
        softAssert.assertEquals(mailRuEmailPage.getLetterText(), newLetter.getText());
        softAssert.assertAll();
    }
}
