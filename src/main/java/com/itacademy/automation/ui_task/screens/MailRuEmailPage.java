package com.itacademy.automation.ui_task.screens;

import org.openqa.selenium.By;
import com.itacademy.automation.ui_task.entities.Browser;

public class MailRuEmailPage extends BasePage {

    private static final By USER_ID_LOCATOR = By.xpath("//i[@id='PH_user-email']");
    private static final By NEW_LETTER_BUTTON_LOCATOR = By.xpath("//a[@title='Написать письмо']");
    private static final By CHECKBOX_FOR_ONE_LETTER_LOCATOR = By.xpath("//button[contains(@class, 'll-av')]");
    private static final By DELETE_LETTER_BUTTON_LOCATOR = By.xpath("//span[@title='Удалить']");
    private static final By SELECT_ALL_BUTTON_LOCATOR = By.xpath("//span[@title='Выделить все']");
    private static final By CLEAR_FOLDER_WINDOW_LOCATOR = By.xpath("//div[contains(@class, 'layer-confirm-folder-clear')]");
    private static final By CLEAR_BUTTON_LOCATOR = By.xpath("//span[text()='Очистить']//parent::span[@class='button2__wrapper']");
    private static final By INBOX_LETTERS_LINK_LOCATOR = By.xpath("//a[@data-title='Входящие'] | //a[@title='Входящие']");
    private static final By SENT_LETTERS_LINK_LOCATOR = By.xpath("//a[@data-title='Отправленные'] | //a[@title='Отправленные']");
    private static final By DRAFTS_LINK_LOCATOR = By.xpath("//a[@data-title='Черновики'] | //a[@title='Черновики']");
    private static final By TRASH_LINK_LOCATOR = By.xpath("//a[@data-title='Корзина'] | //a[@title='Корзина']");
    private static final By LETTER_LINK_LOCATOR = By.xpath("//a[contains(@class,'llc_normal')]");


    public MailRuEmailPage clickLetterLink() {
        browser.fluentWaitForClickable(LETTER_LINK_LOCATOR, Browser.LONG_TIMEOUT);
        browser.clickElement(LETTER_LINK_LOCATOR);
        return this;
    }

    public SendNewLetterPage clickNewLetterButton() {
        browser.clickElement(NEW_LETTER_BUTTON_LOCATOR);
        return new SendNewLetterPage();
    }

    public MailRuEmailPage clickSelectAllLettersButton() {
        browser.clickElement(SELECT_ALL_BUTTON_LOCATOR);
        return this;
    }

    public boolean isClearFolderWindowPresent() {
        return browser.isElementPresent(CLEAR_FOLDER_WINDOW_LOCATOR);
    }

    public MailRuEmailPage clickClearButton() {
        browser.clickElement(CLEAR_BUTTON_LOCATOR);
        return this;
    }

    public String getLetterSubject() {
        return browser.getTextFrom(By.xpath("//h2"));
    }

    public String getLetterText() {
        return browser.getTextFrom(By.xpath("//div[contains(@id, 'BODY')]/div/div[1]"));
    }

    public MailRuEmailPage deleteLettersIfExist() {
        if (browser.isElementPresent(LETTER_LINK_LOCATOR)) {
            selectCheckboxForOneLetter();
            clickSelectAllLettersButton();
            clickDeleteLetterButton();
            if (isClearFolderWindowPresent()) clickClearButton();
        }
        return this;
    }

    public MailRuEmailPage clickInboxLettersLink() {
        browser.clickElement(INBOX_LETTERS_LINK_LOCATOR);
        return this;
    }

    public MailRuEmailPage clickSentLettersLink() {
        browser.clickElement(SENT_LETTERS_LINK_LOCATOR);
        return this;
    }

    public MailRuEmailPage clickDraftsLink() {
        browser.clickElement(DRAFTS_LINK_LOCATOR);
        return this;
    }

    public MailRuEmailPage clickTrashLink() {
        browser.clickElement(TRASH_LINK_LOCATOR);
        return this;
    }

    public String getUserId() {
        browser.fluentWaitForClickable(USER_ID_LOCATOR, Browser.LONG_TIMEOUT);
        return browser.findElementBy(USER_ID_LOCATOR).getText();
    }

    public boolean isLetterPresent() {
        return browser.isElementPresent(LETTER_LINK_LOCATOR);
    }

    public void clickDeleteLetterButton() {
        browser.clickElement(DELETE_LETTER_BUTTON_LOCATOR);
    }

    public void selectCheckboxForOneLetter() {
        browser.selectCheckbox(CHECKBOX_FOR_ONE_LETTER_LOCATOR);
    }


}
