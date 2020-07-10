package task6.tests.emailtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import task6.businessobjects.Letter;
import task6.businessobjects.LetterFactory;
import task6.businessobjects.UserFactory;
import task6.screens.SendNewLetterPage;
import task6.services.LoginService;
import task6.services.LetterService;
import task6.tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class SendLetterWithoutAddressTest extends BaseTest {

    @BeforeMethod
    public void logIn() {
        LoginService.logIn(UserFactory.getUserWithCorrectCredentials());
    }

    @Test
    public void SendLetterWithoutAddressTest() {
        Letter newLetter = LetterFactory.getLetterWithoutAddress();
        SendNewLetterPage sendNewLetterPage = LetterService.openNewLetterPage();
        LetterService.sendLetterWithIncorrectAddress(newLetter);
        assertEquals(sendNewLetterPage.getEmptyAddressErrorMessageText(), "Не указан адрес получателя");
    }
}
