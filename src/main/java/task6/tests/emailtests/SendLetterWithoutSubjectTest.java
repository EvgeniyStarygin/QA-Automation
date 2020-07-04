package task6.tests.emailtests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.Letter;
import task6.businessobjects.LetterFactory;
import task6.businessobjects.UserFactory;
import task6.screens.MailRuEmailPage;
import task6.screens.SendNewLetterPage;
import task6.services.LoginService;
import task6.services.SendNewLetterService;
import task6.tests.BaseTest;

public class SendLetterWithoutSubjectTest {

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
    public void sendLetterWithoutSubjectTest() {
        Letter newLetter = LetterFactory.getLetterWithoutSubject();
        LoginService.logIn(UserFactory.getUserWithCorrectCredentials());
        SendNewLetterPage sendNewLetterPage = SendNewLetterService.openNewLetterPage(UserFactory.getUserWithCorrectCredentials());
        SendNewLetterService.sendNewLetter(newLetter);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(sendNewLetterPage.isSuccessConfirmationWindowDisplayed());
        sendNewLetterPage.closeSuccessConfirmationWindow();
        mailRuEmailPage = new MailRuEmailPage();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubjectInInboxFolder(), "<Без темы>");
        softAssert.assertEquals(mailRuEmailPage.getLetterTextInInboxFolder(), newLetter.getText());
        softAssert.assertEquals(mailRuEmailPage.getLetterSubjectInSentFolder(), "Self:");
        softAssert.assertEquals(mailRuEmailPage.getLetterTextInSentFolder(),  newLetter.getText());
        softAssert.assertAll();
    }
}
