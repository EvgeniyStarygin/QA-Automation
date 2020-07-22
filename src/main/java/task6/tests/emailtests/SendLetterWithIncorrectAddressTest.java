package task6.tests.emailtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.Letter;
import task6.businessobjects.LetterFactory;
import task6.businessobjects.UserFactory;
import task6.screens.SendNewLetterPage;
import task6.services.LetterService;
import task6.services.LoginService;
import task6.tests.BaseTest;

public class SendLetterWithIncorrectAddressTest extends BaseTest {

    @BeforeMethod
    public void logIn() {
        LoginService.logIn(UserFactory.getUserWithCorrectCredentials());
    }

    @Test
    public void SendLetterWithIncorrectAddressTest() {
        Letter newLetter = LetterFactory.getLetterWithIncorrectAddress();
        SendNewLetterPage sendNewLetterPage = LetterService.openNewLetterPage();
        LetterService.sendLetterWithIncorrectAddress(newLetter);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(sendNewLetterPage.isWarningWindowDisplayed());
        softAssert.assertEquals(sendNewLetterPage.getWarningWindowText(), "Присутствуют некорректные адреса");
        softAssert.assertAll();
    }
}
