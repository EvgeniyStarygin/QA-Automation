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

public class CreateDraftTest {

    private static MailRuEmailPage mailRuEmailPage;


    /*@BeforeMethod
    public void deleteLetterIfPresent() throws InterruptedException {
        LoginService.logIn(UserFactory.getUserWithCorrectCredentials());
        mailRuEmailPage = new MailRuEmailPage();
        mailRuEmailPage.deleteDraftLetter();
        mailRuEmailPage.deleteTrashLetter();
    }*/

    @Test
    public void createDraftTest() throws InterruptedException {
        Letter newLetter = LetterFactory.getCorrectLetter();
        LoginService.logIn(UserFactory.getUserWithCorrectCredentials());
        SendNewLetterPage sendNewLetterPage = SendNewLetterService.openNewLetterPage(UserFactory.getUserWithCorrectCredentials());
        SendNewLetterService.saveNewLetter(newLetter);
        MailRuEmailPage mailRuEmailPage = sendNewLetterPage.closeNewLetterWindow();
        mailRuEmailPage.deleteDraftLetter();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubject(), newLetter.getSubject());
        softAssert.assertEquals(mailRuEmailPage.getLetterText(), newLetter.getText());
        mailRuEmailPage.deleteTrashLetter();
        softAssert.assertFalse(mailRuEmailPage.isLetterPresent());
        softAssert.assertAll();
    }
}
