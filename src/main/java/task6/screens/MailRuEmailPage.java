package task6.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import task6.entities.WrappedDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MailRuEmailPage extends BasePage {

    private WebElement userId;
    private WebElement newLetterButton;
    private WebElement checkboxForOneLetter;
    private WebElement deleteLetterButton;
    private WebElement inboxLettersLink;
    private WebElement sentLettersLink;
    private WebElement draftsLink;
    private WebElement trashLink;
    private WebElement letterLink;


    public MailRuEmailPage clickLetterLink() {
        letterLink = driver.findElement(By.xpath("//a[contains(@class,'llc_normal')]"));
        letterLink.click();
        return this;
    }

    public SendNewLetterPage clickNewLetterButton() {
        newLetterButton = driver.findElement(By.xpath("//a[@title='Написать письмо']"));
        newLetterButton.click();
        return new SendNewLetterPage();
    }


    public String getLetterSubjectInInboxFolder()  {
        clickInboxLettersLink();
        return getLetterSubject();
    }

    public String getLetterTextInInboxFolder() {
        clickInboxLettersLink();
        return getLetterText();
    }

    public String getLetterSubjectInSentFolder()  {
        clickSentLettersLink();
        return getLetterSubject();
    }

    public String getLetterTextInSentFolder() {
        clickSentLettersLink();
        return getLetterText();
    }

    public String getLetterSubjectInTrashFolder()  {
        clickTrashLink();
        return getLetterSubject();
    }

    public String getLetterTextInTrashFolder() {
        clickTrashLink();
        return getLetterText();
    }

    public String getLetterSubject(){
        clickLetterLink();
        WrappedDriver.waitUntil().until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2"))));
        WebElement lastLetterSubject = driver.findElement(By.xpath("//h2"));
        return lastLetterSubject.getText();
    }

    public String getLetterText(){
        clickLetterLink();
        WrappedDriver.waitUntil().until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id, 'BODY')]/div/div[1]"))));
        WebElement lastLetterText = driver.findElement(By.xpath("//div[contains(@id, 'BODY')]/div/div[1]"));
        return lastLetterText.getText();
    }

    public boolean isLetterPresent() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        List<WebElement> lettersLinks = driver.findElements(By.xpath("//a[contains(@class,'llc_normal')]"));
        if (lettersLinks.size() == 0) return false;
        else return true;
    }

    public void deleteInboxLetter() throws InterruptedException {
        clickInboxLettersLink();
        if (isLetterPresent()) {
            selectCheckboxForOneLetter();
            clickDeleteLetterButton();
        }
    }

    public void deleteSentLetter() throws InterruptedException {
        clickSentLettersLink();
        if (isLetterPresent()) {
            selectCheckboxForOneLetter();
            clickDeleteLetterButton();
        }
    }

    public void deleteDraftLetter() throws InterruptedException {
        clickDraftsLink();
        if (isLetterPresent()) {
            selectCheckboxForOneLetter();
            clickDeleteLetterButton();
        }
    }

    public void deleteTrashLetter() throws InterruptedException {
        clickTrashLink();
        if (isLetterPresent()) {
            selectCheckboxForOneLetter();
            clickDeleteLetterButton();
        }
    }


    public MailRuEmailPage clickInboxLettersLink() {
        inboxLettersLink = driver.findElement(By.xpath("//a[@data-title='Входящие'] | //a[@title='Входящие']"));
        inboxLettersLink.click();
        return this;
    }

    public MailRuEmailPage clickSentLettersLink() {
        sentLettersLink = driver.findElement(By.xpath("//a[@data-title='Отправленные'] | //a[@title='Отправленные']"));
        sentLettersLink.click();
        return this;
    }

    public MailRuEmailPage clickDraftsLink() {
        draftsLink = driver.findElement(By.xpath("//a[@data-title='Черновики'] | //a[@title='Черновики']"));
        draftsLink.click();
        return this;
    }

    public MailRuEmailPage clickTrashLink() {
        trashLink = driver.findElement(By.xpath("//a[@data-title='Корзина'] | //a[@title='Корзина']"));
        trashLink.click();
        return this;
    }

    public String getUserId() {
        WrappedDriver.waitUntil().until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[@id='PH_user-email']"))));
        userId = driver.findElement(By.xpath("//i[@id='PH_user-email']"));
        return userId.getText();
    }

    public void clickDeleteLetterButton() {
        deleteLetterButton = driver.findElement(By.xpath("//span[@title='Удалить']"));
        deleteLetterButton.click();
    }

    public void selectCheckboxForOneLetter() throws InterruptedException {
        WrappedDriver.waitUntil().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class, 'll-av__checkbox')]//input[@type='checkbox']")));
        checkboxForOneLetter = driver.findElement(By.xpath("//span[contains(@class, 'll-av__checkbox')]//input[@type='checkbox']"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(checkboxForOneLetter)
                .click()
                .build()
                .perform();
    }


}
