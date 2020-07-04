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
import task6.services.LoginService;
import task6.services.SendNewLetterService;

public class SendCorrectLetterTest {

    private static MailRuEmailPage mailRuEmailPage;


    /*@BeforeMethod
    public void deleteLetterIfPresent() throws InterruptedException {
        LoginService.logIn(UserFactory.getUserWithCorrectCredentials());
        mailRuEmailPage = new MailRuEmailPage();
        mailRuEmailPage.deleteInboxLetter();
        mailRuEmailPage.deleteSentLetter();
    }*/

   /*@AfterMethod
    public void deleteLetter() throws InterruptedException {
       mailRuEmailPage.deleteInboxLetter();
       mailRuEmailPage.deleteSentLetter();
    }*/

    @Test
    public void sendCorrectLetterTest()  {
        Letter newLetter = LetterFactory.getCorrectLetter();
        LoginService.logIn(UserFactory.getUserWithCorrectCredentials());
        SendNewLetterPage sendNewLetterPage = SendNewLetterService.openNewLetterPage(UserFactory.getUserWithCorrectCredentials());
        SendNewLetterService.sendNewLetter(newLetter);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(sendNewLetterPage.isSuccessConfirmationWindowDisplayed());
        sendNewLetterPage.closeSuccessConfirmationWindow();
        mailRuEmailPage = new MailRuEmailPage();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubjectInInboxFolder(), newLetter.getSubject());
        softAssert.assertEquals(mailRuEmailPage.getLetterTextInInboxFolder(), newLetter.getText());
        softAssert.assertEquals(mailRuEmailPage.getLetterSubjectInSentFolder(), "Self: " + newLetter.getSubject());
        softAssert.assertEquals(mailRuEmailPage.getLetterTextInSentFolder(),  newLetter.getText());
        softAssert.assertAll();
    }
}
