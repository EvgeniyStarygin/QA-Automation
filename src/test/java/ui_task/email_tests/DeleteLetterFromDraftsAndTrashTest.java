package ui_task.email_tests;

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

public class DeleteLetterFromDraftsAndTrashTest {

    private static MailRuEmailPage mailRuEmailPage;

    @BeforeMethod
    public void deleteLetterIfPresent() {
        LoginService.loginToMail(UserFactory.getUserWithCorrectCredentials());
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
        softAssert.assertFalse(mailRuEmailPage.isLetterPresent());
        softAssert.assertAll();
    }
}
