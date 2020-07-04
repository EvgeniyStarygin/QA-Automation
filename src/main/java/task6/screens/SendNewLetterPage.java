package task6.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendNewLetterPage extends MailRuEmailPage {

    @FindBy(xpath = "//label[contains(@class, 'container--zU301')]//input[@type='text']")
    private WebElement addressInput;
    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement subjectInput;
    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement emailTextInput;
    @FindBy(xpath = "//span[@title='Отправить']")
    private WebElement sendButton;
    @FindBy(xpath = "//span[@title='Сохранить']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@class='layer-sent-page']")
    private WebElement successConfirmationWindow;
    @FindBy(xpath = "//div[contains(@class, 'rowError--O4k-g')]")
    private WebElement emptyAddressErrorMessage;
    @FindBy(xpath = "//div[contains(@class, 'c2110')]")
    private WebElement warningWindow;
    @FindBy(xpath = "//button[@title='Закрыть' and not(@disabled)]")
    private WebElement closeNewLetterWindowButton;


    public SendNewLetterPage typeAddress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    public SendNewLetterPage typeSubject(String subject) {
        subjectInput.sendKeys(subject);
        return this;
    }

    public SendNewLetterPage typeEmailText(String text) {
        emailTextInput.sendKeys(text);
        return this;
    }

    public SendNewLetterPage clickSendButton() {
        sendButton.click();
        return this;
    }


    public MailRuEmailPage closeSuccessConfirmationWindow() {
        successConfirmationWindow
                .findElement(By.xpath("//span[@title='Закрыть']"))
                .click();
        return new MailRuEmailPage();
    }

    public boolean isSuccessConfirmationWindowDisplayed() {
        return successConfirmationWindow.isDisplayed();
    }

    public boolean isWarningWindowDisplayed() {
        return warningWindow.isDisplayed();
    }


    public String getEmptyAddressErrorMessageText() {
        return emptyAddressErrorMessage.getText();
    }

    public String getWarningWindowText() {
        return warningWindow.findElement(By.xpath("//h1")).getText();
    }

    public void clickSendButtonOnWarningWindow() {
        warningWindow.findElement(By.xpath("//span[text()='Отправить']//parent::button")).click();
    }


    public SendNewLetterPage clickSaveButton() {
        saveButton.click();
        return this;
    }

    public MailRuEmailPage closeNewLetterWindow() {
        closeNewLetterWindowButton.click();
        return new MailRuEmailPage();
    }

}
