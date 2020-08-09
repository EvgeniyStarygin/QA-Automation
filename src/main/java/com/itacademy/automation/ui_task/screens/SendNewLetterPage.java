package com.itacademy.automation.ui_task.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.itacademy.automation.ui_task.entities.Browser;

public class SendNewLetterPage extends MailRuEmailPage {

    private static final By ADDRESS_INPUT_LOCATOR = By.xpath("//label[contains(@class, 'container--zU301')]//input[@type='text']");
    private static final By SUBJECT_INPUT_LOCATOR = By.xpath("//input[@name='Subject']");
    private static final By MESSAGE_INPUT_LOCATOR = By.xpath("//div[@role='textbox']");
    private static final By SEND_BUTTON_LOCATOR = By.xpath("//span[@title='Отправить']");
    private static final By SAVE_BUTTON_LOCATOR = By.xpath("//span[@title='Сохранить']");
    private static final By SUCCESS_CONFIRMATION_WINDOW_LOCATOR = By.xpath("//div[@class='layer-sent-page']");
    private static final By EMPTY_EMAIL_ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class, 'rowError--O4k-g')]");
    private static final By WARNING_WINDOW_LOCATOR = By.xpath("//div[contains(@class, 'c2110')]");
    private static final By CLOSE_NEW_LETTER_WINDOW_BUTTON_LOCATOR = By.xpath("//button[@title='Закрыть' and not(@disabled)]");

    public SendNewLetterPage typeAddress(String address) {
        browser.typeTo(ADDRESS_INPUT_LOCATOR, address);
        return this;
    }

    public SendNewLetterPage typeSubject(String subject) {
        browser.typeTo(SUBJECT_INPUT_LOCATOR, subject);
        return this;
    }

    public SendNewLetterPage typeMessage(String message) {
        browser.typeTo(MESSAGE_INPUT_LOCATOR, message);
        return this;
    }

    public SendNewLetterPage clickSendButton() {
        browser.clickElement(SEND_BUTTON_LOCATOR);
        return this;
    }

    public SendNewLetterPage clickSaveButton() {
        browser.clickElement(SAVE_BUTTON_LOCATOR);
        return this;
    }

    public MailRuEmailPage closeSuccessConfirmationWindow() {
        WebElement successConfirmationWindow = browser.findElementBy(SUCCESS_CONFIRMATION_WINDOW_LOCATOR);
        successConfirmationWindow
                .findElement(By.xpath("//span[@title='Закрыть']"))
                .click();
        return new MailRuEmailPage();
    }

    public boolean isSuccessConfirmationWindowDisplayed() {
        return browser.isDisplayed(SUCCESS_CONFIRMATION_WINDOW_LOCATOR);
    }

    public boolean isWarningWindowDisplayed() {
        return browser.isDisplayed(WARNING_WINDOW_LOCATOR);
    }


    public String getEmptyAddressErrorMessageText() {
        browser.waitForVisibility(EMPTY_EMAIL_ERROR_MESSAGE_LOCATOR, Browser.LONG_TIMEOUT);
        return browser.getTextFrom(EMPTY_EMAIL_ERROR_MESSAGE_LOCATOR);
    }

    public String getWarningWindowText() {
        browser.waitForVisibility(WARNING_WINDOW_LOCATOR, Browser.LONG_TIMEOUT);
        WebElement warningWindow = browser.findElementBy(WARNING_WINDOW_LOCATOR);
        return warningWindow.findElement(By.xpath("//h1")).getText();
    }

    public void clickSendButtonOnWarningWindow() {
        WebElement warningWindow = browser.findElementBy(WARNING_WINDOW_LOCATOR);
        warningWindow.findElement(By.xpath("//span[text()='Отправить']//parent::button")).click();
    }


    public MailRuEmailPage closeNewLetterWindow() {
        browser.clickElement(CLOSE_NEW_LETTER_WINDOW_BUTTON_LOCATOR);
        return new MailRuEmailPage();
    }

}
