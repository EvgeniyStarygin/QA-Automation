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

public class SendLetterWithoutBodyTest  {

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
    public void sendLetterWithoutBodyTest()  {
        Letter newLetter = LetterFactory.getLetterWithoutBody();
        LoginService.logIn(UserFactory.getUserWithCorrectCredentials());
        SendNewLetterPage sendNewLetterPage = SendNewLetterService.openNewLetterPage(UserFactory.getUserWithCorrectCredentials());
        SendNewLetterService.sendNewLetter(newLetter);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(sendNewLetterPage.isWarningWindowDisplayed());
        softAssert.assertEquals(sendNewLetterPage.getWarningWindowText(), "Вы действительно хотите отправить пустое письмо?");
        sendNewLetterPage.clickSendButtonOnWarningWindow();
        sendNewLetterPage.closeSuccessConfirmationWindow();
        mailRuEmailPage = new MailRuEmailPage();
        mailRuEmailPage = new MailRuEmailPage();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubjectInInboxFolder(), newLetter.getSubject());
        softAssert.assertEquals(mailRuEmailPage.getLetterTextInInboxFolder(), " ");
        softAssert.assertEquals(mailRuEmailPage.getLetterSubjectInSentFolder(), "Self: " + newLetter.getSubject());
        softAssert.assertEquals(mailRuEmailPage.getLetterTextInSentFolder(),  " ");
        softAssert.assertAll();
    }
}
