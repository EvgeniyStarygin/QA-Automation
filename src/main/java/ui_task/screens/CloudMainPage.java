package ui_task.screens;

import org.openqa.selenium.By;
import ui_task.entities.Browser;

public class CloudMainPage extends BasePage{

    private static final String URL = "https://cloud.mail.ru/";
    private static String tabName;

    private static final By ENTER_BUTTON_LOCATOR = By.xpath("//a[contains(text(), 'Войдите')]");
    private static final By USER_ID_LOCATOR = By.xpath("//i[@id='PH_user-email']");
    private static final By CREATE_BUTTON_LOCATOR = By.xpath("//div[@data-name='create']");
    private static final By CREATE_FOLDER_BUTTON_LOCATOR = By.xpath("//div[@data-name='createFolder']");
    private static final By CONFIRMATION_BUTTON_LOCATOR = By.xpath("//button[text()='Создать']");
    private static final By NEW_FOLDER_NAME_INPUT_LOCATOR = By.xpath("//input[@value='Новая папка']");
    private static final By SELECT_ALL_BUTTON_LOCATOR = By.xpath("//div[@data-name='selectAll']");
    private static final By DELETE_BUTTON_LOCATOR = By.xpath("//div[@data-name='remove']");


    public CloudMainPage openCloudMainPage() {
        browser.openPage(URL);
        tabName = browser.getTabName();
        return this;
    }

    public CloudMainPage typeNewFolderName(String name){
        browser.typeTo(NEW_FOLDER_NAME_INPUT_LOCATOR, name);
        return this;
    }

    public CloudLoginPage clickEnterButton() {
        browser.clickElement(ENTER_BUTTON_LOCATOR);
        return new CloudLoginPage();
    }

    public CloudMainPage clickCreateButton() {
        browser.clickElement(CREATE_BUTTON_LOCATOR);
        return this;
    }

    public CloudMainPage clickSelectAllButton() {
        browser.clickElement(SELECT_ALL_BUTTON_LOCATOR);
        return this;
    }

    public CloudMainPage clickDeleteButton() {
        browser.clickElement(DELETE_BUTTON_LOCATOR);
        return this;
    }

    public CloudMainPage clickConfirmationButton() {
        browser.clickElement(CONFIRMATION_BUTTON_LOCATOR);
        return this;
    }

    public String getUserId() {
        browser.fluentWaitForClickable(USER_ID_LOCATOR, Browser.LONG_TIMEOUT);
        return browser.findElementBy(USER_ID_LOCATOR).getText();
    }

    public void switchToCloudMainPage(){
        browser.switchToTab(tabName);
    }

    public CloudMainPage clickCreateNewFolderButton() {
        browser.clickElement(CREATE_FOLDER_BUTTON_LOCATOR);
        return this;
    }

}
