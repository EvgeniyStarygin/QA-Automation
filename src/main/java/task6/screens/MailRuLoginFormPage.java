package task6.screens;

import org.openqa.selenium.By;

public class MailRuLoginFormPage extends BasePage {

    private static final String URL = "https://mail.ru";

    private static final By LOGIN_INPUT_LOCATOR = By.xpath("//input[@id='mailbox:login']");
    private static final By DOMAIN_SELECTOR_LOCATOR = By.xpath("//select[@id='mailbox:domain']");
    private static final By TYPE_PASSWORD_BUTTON_LOCATOR = By.xpath("//label[@id='mailbox:submit']//input[@type='submit']");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[@id='mailbox:error']");
    private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@id='mailbox:password']");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//label[@id='mailbox:submit']//input[@type='submit']");

    public MailRuLoginFormPage openPage() {
        browser.openPage(URL);
        return this;
    }

    public MailRuLoginFormPage typeLogin(String login) {
        browser.typeTo(LOGIN_INPUT_LOCATOR, login);
        return this;
    }

    public MailRuLoginFormPage selectDomain(String domain) {
        browser.selectFrom(DOMAIN_SELECTOR_LOCATOR, domain);
        return this;
    }

    public MailRuLoginFormPage clickTypePasswordButton() {
        browser.clickElement(TYPE_PASSWORD_BUTTON_LOCATOR);
        return this;
    }

    public boolean isErrorMassageDisplayed() {
        return browser.isDisplayed(ERROR_MESSAGE_LOCATOR);
    }

    public String getErrorMessageText() {
        return browser.getTextFrom(ERROR_MESSAGE_LOCATOR);
    }

    public MailRuLoginFormPage typePassword(String password) {
        browser.typeTo(PASSWORD_INPUT_LOCATOR, password);
        return this;
    }

    public MailRuEmailPage clickLoginButton() {
        browser.clickElement(LOGIN_BUTTON_LOCATOR);
        return new MailRuEmailPage();
    }

}
