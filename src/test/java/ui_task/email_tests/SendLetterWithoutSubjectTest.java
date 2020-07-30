package ui_task.email_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui_task.BaseTest;
import ui_task.business_objects.Letter;
import ui_task.business_objects.LetterFactory;
import ui_task.business_objects.UserFactory;
import ui_task.listeners.TestListener;
import ui_task.screens.MailRuEmailPage;
import ui_task.screens.SendNewLetterPage;
import ui_task.services.LetterService;
import ui_task.services.LoginService;

@Listeners({TestListener.class})
public class SendLetterWithoutSubjectTest extends BaseTest {

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
    public void sendLetterWithoutSubjectTest() {
        Letter newLetter = LetterFactory.getLetterWithoutSubject();
        LetterService.sendNewLetter(newLetter);
        SendNewLetterPage sendNewLetterPage = new SendNewLetterPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(sendNewLetterPage.isSuccessConfirmationWindowDisplayed());
        sendNewLetterPage.closeSuccessConfirmationWindow();
        MailRuEmailPage mailRuEmailPage = new MailRuEmailPage();
        mailRuEmailPage
                .clickInboxLettersLink()
                .clickLetterLink();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubject(), "<Без темы>");
        softAssert.assertEquals(mailRuEmailPage.getLetterText(), newLetter.getText());
        mailRuEmailPage
                .clickSentLettersLink()
                .clickLetterLink();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubject(), "Self:");
        softAssert.assertEquals(mailRuEmailPage.getLetterText(), newLetter.getText());
        softAssert.assertAll();
    }
}
