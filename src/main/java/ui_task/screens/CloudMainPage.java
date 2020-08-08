package ui_task.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import ui_task.entities.Browser;
import ui_task.loggers.CustomLogger;

public class CloudMainPage extends BasePage {

    private static final String URL = "https://cloud.mail.ru/";
    private static String tabName;

    private static final By ENTER_BUTTON_LOCATOR = By.xpath("//a[contains(text(), 'Войдите')]");
    private static final By USER_ID_LOCATOR = By.xpath("//i[@id='PH_user-email']");
    private static final By CREATE_NEW_DOCUMENT_BUTTON_LOCATOR = By.xpath("//div[@id='cloud_toolbars']//div[@data-name='create']");
    private static final By CREATE_FOLDER_BUTTON_LOCATOR = By.xpath("//div[@data-name='createFolder']");
    private static final By APPROVE_CREATION_BUTTON_LOCATOR = By.xpath("//button[text()='Создать']");
    private static final By NEW_FOLDER_NAME_INPUT_LOCATOR = By.xpath("//input[@value='Новая папка']");
    private static final By SELECT_ALL_BUTTON_LOCATOR = By.xpath("//div[@data-name='selectAll']");
    private static final By DELETE_BUTTON_LOCATOR = By.xpath("//div[@data-name='remove']");
    private static final By NEW_ENTITY_NAME_LOCATOR = By.xpath("//div[@class='VirtualList__col--2WDVs']//a[@data-qa-name]");
    private static final By MY_FILES_LINK_LOCATOR = By.xpath("//span[text()='Мои файлы']//ancestor::a[@role='button']");
    //private static final By FILE_LOCATOR = By.xpath("//div[@role='rowgroup']/div/div");
    private static final By APPROVE_DELETION_BUTTON_LOCATOR = By.xpath("//button[@data-name='remove']");
    private static final By DELETE_CONFIRMATION_WINDOW_LOCATOR = By.xpath("//div[text()='Файлы перемещены в Корзину']//ancestor::div[@class='b-layer__container']");
    private static final By CLOSE_DELETE_CONFIRMATION_WINDOW_BUTTON_LOCATOR = By.xpath("//span[text()='Спасибо, понятно']//parent::button");
    private static final By UPLOAD_BUTTON_LOCATOR = By.xpath("//div[@id='cloud_toolbars']//div[@data-name='upload']");
    private static final By SELECT_FILE_INPUT_LOCATOR = By.xpath("//input[@class='layer_upload__controls__input']");
    private static final By UPLOAD_FILE_STATUS_LOCATOR = By.xpath("//div[@id='upload-promo']/following-sibling::span[@data-bem='b-upload-status']");
    private static final By CLOSE_UPLOAD_RESULT_WINDOW_BUTTON_LOCATOR = By.xpath("//div[@id='upload-promo']/following-sibling::span[contains(@class,'js-upload-panel-header-close')]//span");




    public CloudMainPage openCloudMainPage() {
        browser.openPage(URL);
        tabName = browser.getTabName();
        return this;
    }

    public CloudMainPage typeNewFolderName(String name) {
        browser.typeTo(NEW_FOLDER_NAME_INPUT_LOCATOR, name);
        return this;
    }

    public CloudLoginPage clickEnterButton() {
        browser.clickElement(ENTER_BUTTON_LOCATOR);
        browser.browserSleep(2000);
        return new CloudLoginPage();
    }

    public CloudMainPage clickCreateNewDocumentButton() {
        browser.clickElement(CREATE_NEW_DOCUMENT_BUTTON_LOCATOR);
        return this;
    }

    public CloudMainPage clickUploadButton() {
        browser.clickElement(UPLOAD_BUTTON_LOCATOR);
        return this;
    }

    public CloudMainPage uploadNewFile(String path) {
        browser.uploadFile(SELECT_FILE_INPUT_LOCATOR, path);
        return this;
    }

    public boolean isFileUploaded(){
        browser.waitForPresence(UPLOAD_FILE_STATUS_LOCATOR, Browser.LONG_TIMEOUT);
        String uploadStatus = "Загрузка завершена";
        browser.getTextFrom(UPLOAD_FILE_STATUS_LOCATOR).equals(uploadStatus);
        return true;
    }

    public CloudMainPage clickMyFilesLink() {
        browser.browserSleep(1000);
        browser.clickElement(MY_FILES_LINK_LOCATOR);
        return this;
    }

    public CloudMainPage approveNewFolderCreation() {
        browser.clickElement(APPROVE_CREATION_BUTTON_LOCATOR);
        return this;
    }

    public CloudMainPage closeUploadResultWindow(){
        browser.clickElement(CLOSE_UPLOAD_RESULT_WINDOW_BUTTON_LOCATOR);
        return this;
    }

    public String getUserId() {
        browser.fluentWaitForClickable(USER_ID_LOCATOR, Browser.LONG_TIMEOUT);
        return browser.findElementBy(USER_ID_LOCATOR).getText();
    }

    public void switchToCloudMainPage() {
        browser.switchToTab(tabName);
    }

    public CloudMainPage clickCreateNewFolderButton() {
        browser.clickElement(CREATE_FOLDER_BUTTON_LOCATOR);
        return this;
    }

    public String getNameOfTheCreatedEntity() {
        clickMyFilesLink();
        browser.fluentWaitForVisibility(NEW_ENTITY_NAME_LOCATOR, Browser.LONG_TIMEOUT);
        return browser.getAttributeValue(NEW_ENTITY_NAME_LOCATOR, "data-qa-name");
    }


    public CloudMainPage clickSelectAllButton() {
        browser.waitForClickable(SELECT_ALL_BUTTON_LOCATOR, Browser.LONG_TIMEOUT);
        browser.clickElement(SELECT_ALL_BUTTON_LOCATOR);
        return this;
    }

    public CloudMainPage clickDeleteButton() {
        browser.clickElement(DELETE_BUTTON_LOCATOR);
        return this;
    }

    public CloudMainPage approveFilesDeletion() {
        browser.clickElement(APPROVE_DELETION_BUTTON_LOCATOR);
        return this;
    }

    public CloudMainPage deleteFilesIfExist() {
        clickMyFilesLink();
        if (browser.isElementPresent(NEW_ENTITY_NAME_LOCATOR)) {
            clickSelectAllButton();
            clickDeleteButton();
            approveFilesDeletion();
            closeDeleteConfirmationWindowIfPresence();
        }
        return this;
    }

    private void closeDeleteConfirmationWindowIfPresence() {
        try {
            if (isDeleteConfirmationWindowDisplayed()) {
                сloseDeleteConfirmationWindow();
            }
        } catch (TimeoutException exception) {
            CustomLogger.logException(exception);
        }
    }

    private CloudMainPage сloseDeleteConfirmationWindow() {
        browser.clickElement(CLOSE_DELETE_CONFIRMATION_WINDOW_BUTTON_LOCATOR);
        return this;
    }

    public CloudMainPage createNewFolder(String folderName) {
        clickCreateNewDocumentButton();
        clickCreateNewFolderButton();
        typeNewFolderName(folderName);
        approveNewFolderCreation();
        return this;
    }

    private boolean isDeleteConfirmationWindowDisplayed() {
        return browser.isDisplayed(DELETE_CONFIRMATION_WINDOW_LOCATOR);
    }


    public boolean isEntityExists() {
        return browser.isElementPresent(NEW_ENTITY_NAME_LOCATOR);
    }
}

