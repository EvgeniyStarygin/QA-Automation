package task6.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MailRuLoginForm extends BasePage {

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

    public MailRuLoginForm loadPage(){
        driver.get(URL);
        return this;
    }

    public MailRuLoginForm typeLogin(String login){
        loginInput.sendKeys(login);
        return this;
    }

    public MailRuLoginForm selectDomain(String domain){
        Select select = new Select(domainSelector);
        select.selectByVisibleText(domain);
        return this;
    }

    public MailRuLoginForm clickTypePasswordButton(){
        typePasswordButton.click();
        return this;
    }

    public boolean isErrorMassageDisplayed(){
        return errorMessage.isDisplayed();
    }

    public String getErrorMessageText(){
        return errorMessage.getText();
    }

    public MailRuLoginForm typePassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getPasswordFormHeader(){
        return passwordFormHeader.getText();
    }
}
