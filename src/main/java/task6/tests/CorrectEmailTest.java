package task6.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.entities.WrappedDriver;
import task6.screens.MailRuLoginForm;
import task6.services.LoginService;

public class CorrectEmailTest extends BaseTest{

    @Test
    public void correctEmailTest() throws InterruptedException {
        User user = UserFactory.getUserWithCorrectEmail();
        LoginService.enterEmail(user);
        MailRuLoginForm mailRuLoginForm = new MailRuLoginForm();
        //Thread.sleep(3000);
        //WrappedDriver.webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mailbox:mailHeaderSecondStepEmail']")));
        Assert.assertEquals(mailRuLoginForm.getPasswordFormHeader(), user.getEmail().getLogin() + user.getEmail().getDomain());
    }
}
