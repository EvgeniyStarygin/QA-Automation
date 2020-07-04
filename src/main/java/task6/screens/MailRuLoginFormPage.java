package task6.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import task6.entities.WrappedDriver;

public class MailRuLoginFormPage extends BasePage {

    private static final String URL = "https://mail.ru";

    @FindBy(xpath = "//input[@id='mailbox:login']")
    private WebElement loginInput;
    @FindBy(xpath = "//select[@id='mailbox:domain']")
    private WebElement domainSelector;
    @FindBy(xpath = "//label[@id='mailbox:submit']//input[@type='submit']")
    private WebElement typePasswordButton;
    @FindBy(xpath = "//div[@id='mailbox:error']")
    private WebElement errorMessage;
    @FindBy(xpath = "//div[@id='mailbox:mailHeaderSecondStepEmail']")
    private WebElement passwordFormHeader;
    @FindBy(xpath = "//input[@id='mailbox:password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//label[@id='mailbox:submit']//input[@type='submit']")
    private WebElement loginButton;

    public MailRuLoginFormPage loadPage(){
        driver.get(URL);
        return this;
    }

    public MailRuLoginFormPage typeLogin(String login){
        loginInput.sendKeys(login);
        return this;
    }

    public MailRuLoginFormPage selectDomain(String domain){
        Select select = new Select(domainSelector);
        select.selectByVisibleText(domain);
        return this;
    }

    public MailRuLoginFormPage clickTypePasswordButton(){
        typePasswordButton.click();
        return this;
    }

    public boolean isErrorMassageDisplayed(){
        WrappedDriver.waitUntil().until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.isDisplayed();
    }

    public String getErrorMessageText(){
        return errorMessage.getText();
    }

    public MailRuLoginFormPage typePassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    public MailRuEmailPage clickLoginButton(){
        loginButton.click();
        return new MailRuEmailPage();
    }

    public String getPasswordFormHeader(){
        WrappedDriver.waitUntil().until(ExpectedConditions.visibilityOf(passwordFormHeader));
        return passwordFormHeader.getText();
    }
}
