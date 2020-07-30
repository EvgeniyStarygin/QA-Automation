package ui_task.email_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui_task.business_objects.Letter;
import ui_task.business_objects.LetterFactory;
import ui_task.business_objects.UserFactory;
import ui_task.listeners.TestListener;
import ui_task.screens.SendNewLetterPage;
import ui_task.services.LetterService;
import ui_task.services.LoginService;
import ui_task.BaseTest;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class SendLetterWithoutAddressTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        LoginService.loginToMail(UserFactory.getUserWithCorrectCredentials());
    }

    @Test
    public void SendLetterWithoutAddressTest() {
        Letter newLetter = LetterFactory.getLetterWithoutAddress();
        LetterService.sendLetterWithIncorrectAddress(newLetter);
        assertEquals(new SendNewLetterPage().getEmptyAddressErrorMessageText(), "Не указан адрес получателя");
    }
}
