package ui_task.email_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui_task.business_objects.Letter;
import ui_task.business_objects.LetterFactory;
import ui_task.business_objects.UserFactory;
import ui_task.screens.SendNewLetterPage;
import ui_task.services.LetterService;
import ui_task.services.LoginService;
import ui_task.BaseTest;

import static org.testng.Assert.assertEquals;

public class SendLetterWithoutAddressTest extends BaseTest {

    @BeforeMethod
    public void logIn() {
        LoginService.loginToMail(UserFactory.getUserWithCorrectCredentials());
    }

    @Test
    public void SendLetterWithoutAddressTest() {
        Letter newLetter = LetterFactory.getLetterWithoutAddress();
        SendNewLetterPage sendNewLetterPage = LetterService.openNewLetterPage();
        LetterService.sendLetterWithIncorrectAddress(newLetter);
        assertEquals(sendNewLetterPage.getEmptyAddressErrorMessageText(), "Не указан адрес получателя");
    }
}
