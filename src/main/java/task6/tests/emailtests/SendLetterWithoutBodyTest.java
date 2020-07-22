package task6.tests.emailtests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.Letter;
import task6.businessobjects.LetterFactory;
import task6.businessobjects.UserFactory;
import task6.screens.MailRuEmailPage;
import task6.screens.SendNewLetterPage;
import task6.services.LetterService;
import task6.services.LoginService;
import task6.tests.BaseTest;

public class SendLetterWithoutBodyTest extends BaseTest {

    private static MailRuEmailPage mailRuEmailPage;

    @BeforeMethod
    public void deleteLetterIfPresent() {
        LoginService.logIn(UserFactory.getUserWithCorrectCredentials());
        LetterService.deleteLetterFromInboxAndSent();
    }

    @AfterMethod
    public static void deleteLetter() {
        LetterService.deleteLetterFromInboxAndSent();
    }

    @Test
    public void sendLetterWithoutBodyTest() {
        Letter newLetter = LetterFactory.getLetterWithoutBody();
        SendNewLetterPage sendNewLetterPage = LetterService.openNewLetterPage();
        LetterService.sendNewLetter(newLetter);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(sendNewLetterPage.isWarningWindowDisplayed());
        softAssert.assertEquals(sendNewLetterPage.getWarningWindowText(), "Вы действительно хотите отправить пустое письмо?");
        sendNewLetterPage.clickSendButtonOnWarningWindow();
        softAssert.assertTrue(sendNewLetterPage.isSuccessConfirmationWindowDisplayed());
        sendNewLetterPage.closeSuccessConfirmationWindow();
        mailRuEmailPage = new MailRuEmailPage();
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
