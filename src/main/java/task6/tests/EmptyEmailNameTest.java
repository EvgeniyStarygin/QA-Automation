package task6.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.screens.MailRuLoginForm;

public class EmptyEmailNameTest extends BaseTest{

    @Test
    public void emptyEmailNameTest() throws InterruptedException {
        MailRuLoginForm mailRuLoginForm = new MailRuLoginForm();
        mailRuLoginForm
                .loadPage()
                .clickTypePasswordButton();
        Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailRuLoginForm.isErrorMassageDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(mailRuLoginForm.getErrorMessageText(), "Введите имя ящика");
        softAssert.assertAll();
    }
}
