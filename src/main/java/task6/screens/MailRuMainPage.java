package task6.screens;

import org.openqa.selenium.By;
import task6.entities.Browser;

public class MailRuMainPage extends BasePage {

    private static final String URL = "https://mail.ru";

    private static final By LOGIN_INPUT_LOCATOR = By.xpath("//input[@id='mailbox:login']");
    private static final By DOMAIN_SELECTOR_LOCATOR = By.xpath("//select[@id='mailbox:domain']");
    private static final By TYPE_PASSWORD_BUTTON_LOCATOR = By.xpath("//label[@id='mailbox:submit']//input[@type='submit']");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[@id='mailbox:error']");
    private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@id='mailbox:password']");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//label[@id='mailbox:submit']//input[@type='submit']");
    private static final By CLOUD_ICON_LOCATOR = By.xpath("//a[@title='Облако']");

    public MailRuMainPage openPage() {
        browser.openPage(URL);
        return this;
    }

    public MailRuMainPage typeLogin(String login) {
        browser.typeTo(LOGIN_INPUT_LOCATOR, login);
        return this;
    }

    public MailRuMainPage selectDomain(String domain) {
        browser.selectFrom(DOMAIN_SELECTOR_LOCATOR, domain);
        return this;
    }

    public MailRuMainPage clickTypePasswordButton() {
        browser.clickElement(TYPE_PASSWORD_BUTTON_LOCATOR);
        return this;
    }

    public CloudMainPage clickCloudIcon() {
        browser.clickElement(CLOUD_ICON_LOCATOR);
        return new CloudMainPage();
    }

    public boolean isErrorMassageDisplayed() {
        browser.waitForVisibility(ERROR_MESSAGE_LOCATOR, Browser.LONG_TIMEOUT);
        return browser.isDisplayed(ERROR_MESSAGE_LOCATOR);
    }

    public String getErrorMessageText() {
        browser.waitForVisibility(ERROR_MESSAGE_LOCATOR, Browser.LONG_TIMEOUT);
        return browser.getTextFrom(ERROR_MESSAGE_LOCATOR);
    }

    public MailRuMainPage typePassword(String password) {
        browser.typeTo(PASSWORD_INPUT_LOCATOR, password);
        return this;
    }

    public MailRuEmailPage clickLoginButton() {
        browser.clickElement(LOGIN_BUTTON_LOCATOR);
        return new MailRuEmailPage();
    }

}
