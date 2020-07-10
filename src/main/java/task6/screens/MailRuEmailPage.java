package task6.screens;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailRuEmailPage extends BasePage {

    private static final By USER_ID_LOCATOR = By.xpath("//i[@id='PH_user-email']");
    private static final By NEW_LETTER_BUTTON_LOCATOR = By.xpath("//a[@title='Написать письмо']");
    private static final By CHECKBOX_FOR_ONE_LETTER_LOCATOR = By.xpath("//button[contains(@class, 'll-av')]");
    private static final By DELETE_LETTER_BUTTON_LOCATOR = By.xpath("//span[@title='Удалить']");
    private static final By INBOX_LETTERS_LINK_LOCATOR = By.xpath("//a[@data-title='Входящие'] | //a[@title='Входящие']");
    private static final By SENT_LETTERS_LINK_LOCATOR = By.xpath("//a[@data-title='Отправленные'] | //a[@title='Отправленные']");
    private static final By DRAFTS_LINK_LOCATOR = By.xpath("//a[@data-title='Черновики'] | //a[@title='Черновики']");
    private static final By TRASH_LINK_LOCATOR = By.xpath("//a[@data-title='Корзина'] | //a[@title='Корзина']");
    private static final By LETTER_LINK_LOCATOR = By.xpath("//a[contains(@class,'llc_normal')]");


    public MailRuEmailPage clickLetterLink() {
        //fluentWait(By.xpath(LETTER_LINK_XPATH));
        browser.clickElement(LETTER_LINK_LOCATOR);
        return this;
    }

    public SendNewLetterPage clickNewLetterButton() {
        browser.clickElement(NEW_LETTER_BUTTON_LOCATOR);
        return new SendNewLetterPage();
    }

    public String getLetterSubject() {
        browser.waitUntil().until(ExpectedConditions.visibilityOf(browser.findElementBy(By.xpath("//h2"))));
        return browser.getTextFrom(By.xpath("//h2"));
    }

    public String getLetterText() {
        browser.waitUntil().until(ExpectedConditions.visibilityOf(browser.findElementBy(By.xpath("//div[contains(@id, 'BODY')]/div/div[1]"))));
        return browser.getTextFrom(By.xpath("//div[contains(@id, 'BODY')]/div/div[1]"));
    }

    public boolean isLetterPresent() {
        if (browser.findElementsBy(LETTER_LINK_LOCATOR).size() == 0) return false;
        else return true;
    }

    public MailRuEmailPage deleteLetter() {
        if (isLetterPresent()) {
            selectCheckboxForOneLetter();
            clickDeleteLetterButton();
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
        browser.waitForVisibilityOf(USER_ID_LOCATOR);
        return browser.getTextFrom(USER_ID_LOCATOR);
    }

    public void clickDeleteLetterButton() {
        browser.clickElement(DELETE_LETTER_BUTTON_LOCATOR);
    }

    public void selectCheckboxForOneLetter() {
        browser.selectCheckbox(CHECKBOX_FOR_ONE_LETTER_LOCATOR);
    }


}
