package com.itacademy.automation.ui_task.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.itacademy.automation.ui_task.loggers.CustomLogger;

import java.util.List;

public class CloudLoginPage extends BasePage {

    private static final By LOGIN_FRAME_LOCATOR = By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']");
    private static final By LOGIN_INPUT_LOCATOR = By.xpath("//input[@name='username']");
    private static final By DOMAIN_SELECTOR_LOCATOR = By.xpath("//div[@class='domain-select']");
    private static final By DOMAINS_LIST_LOCATOR = By.xpath("//div[@role='option']");
    private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@name='password']");
    private static final By TYPE_PASSWORD_BUTTON_LOCATOR = By.xpath("//div[@class='login-row']//button[@type='submit']");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//div[@class='login-row']//button[@type='submit']");

    public CloudLoginPage typeLogin(String login) {
        browser.typeTo(LOGIN_INPUT_LOCATOR, login);
        return this;
    }

    public CloudLoginPage typePassword(String password) {
        browser.typeTo(PASSWORD_INPUT_LOCATOR, password);
        return this;
    }

    public CloudMainPage clickLoginButton() {
        browser.clickElement(LOGIN_BUTTON_LOCATOR);
        return new CloudMainPage();
    }

    public CloudLoginPage selectDomain(String domain) {
        CustomLogger.logSelect(DOMAINS_LIST_LOCATOR, domain);
        browser.clickElement(DOMAIN_SELECTOR_LOCATOR);
        List<WebElement> domains = browser.findElementsBy(DOMAINS_LIST_LOCATOR);
        for (WebElement element : domains) {
            if (element.getAttribute("aria-label").equals(domain)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public CloudLoginPage switchToLoginForm()  {
        browser.switchToFrame(LOGIN_FRAME_LOCATOR);
        return this;
    }

    public CloudLoginPage clickTypePasswordButton() {
        browser.clickElement(TYPE_PASSWORD_BUTTON_LOCATOR);
        return this;
    }
}
