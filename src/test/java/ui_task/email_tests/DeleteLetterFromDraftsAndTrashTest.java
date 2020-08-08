package ui_task.email_tests;

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
public class DeleteLetterFromDraftsAndTrashTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        LoginService.loginToMail(UserFactory.getUserWithCorrectCredentials());
        LetterService.deleteLetterFromDraftsAndTrash();
    }

    @Test
    public void deleteLetterFromDraftsAndTrashTest() {
        Letter newLetter = LetterFactory.getCorrectLetter();
        LetterService.saveNewLetter(newLetter);
        MailRuEmailPage mailRuEmailPage = new SendNewLetterPage().closeNewLetterWindow();
        mailRuEmailPage
                .clickDraftsLink()
                .deleteLettersIfExist()
                .clickTrashLink()
                .clickLetterLink();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mailRuEmailPage.getLetterSubject(), newLetter.getSubject());
        softAssert.assertEquals(mailRuEmailPage.getLetterText(), newLetter.getText());
        mailRuEmailPage
                .clickTrashLink()
                .deleteLettersIfExist();
        softAssert.assertFalse(mailRuEmailPage.isLetterPresent());
        softAssert.assertAll();
    }
}
