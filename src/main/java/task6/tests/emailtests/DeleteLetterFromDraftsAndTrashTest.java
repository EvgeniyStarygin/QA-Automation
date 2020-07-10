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

public class DeleteLetterFromDraftsAndTrashTest {

    private static MailRuEmailPage mailRuEmailPage;

    @BeforeMethod
    public void deleteLetterIfPresent() {
        LoginService.logIn(UserFactory.getUserWithCorrectCredentials());
        LetterService.deleteLetterFromDraftsAndTrash();
    }

    @AfterMethod
    public static void deleteLetter() {
        LetterService.deleteLetterFromDraftsAndTrash();
    }

    @Test
    public void deleteLetterFromDraftsAndTrashTest() {
        Letter newLetter = LetterFactory.getCorrectLetter();
        SendNewLetterPage sendNewLetterPage = LetterService.openNewLetterPage();
        LetterService.saveNewLetter(newLetter);
        mailRuEmailPage = sendNewLetterPage.closeNewLetterWindow();
        mailRuEmailPage
                .clickDraftsLink()
                .deleteLetter()
                .clickTrashLink()
                .clickLetterLink();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubject(), newLetter.getSubject());
        softAssert.assertEquals(mailRuEmailPage.getLetterText(), newLetter.getText());
        mailRuEmailPage
                .clickTrashLink()
                .deleteLetter();
        softAssert.assertFalse(mailRuEmailPage.isLetterNotPresent());
        softAssert.assertAll();
    }
}
