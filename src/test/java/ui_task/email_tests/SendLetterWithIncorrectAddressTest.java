package ui_task.email_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui_task.business_objects.Letter;
import ui_task.business_objects.LetterFactory;
import ui_task.business_objects.UserFactory;
import ui_task.listeners.TestListener;
import ui_task.screens.SendNewLetterPage;
import ui_task.services.LetterService;
import ui_task.services.LoginService;
import ui_task.BaseTest;

@Listeners({TestListener.class})
public class SendLetterWithIncorrectAddressTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        LoginService.loginToMail(UserFactory.getUserWithCorrectCredentials());
    }

    @Test
    public void SendLetterWithIncorrectAddressTest() {
        Letter newLetter = LetterFactory.getLetterWithIncorrectAddress();
        LetterService.sendLetterWithIncorrectAddress(newLetter);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new SendNewLetterPage().isWarningWindowDisplayed());
        softAssert.assertEquals(new SendNewLetterPage().getWarningWindowText(), "Присутствуют некорректные адреса");
        softAssert.assertAll();
    }
}
