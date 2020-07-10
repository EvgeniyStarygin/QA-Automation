package task6.entities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser {

    private static WebDriver driver;
    private static final int TIMEOUT = 20;
    private static Browser browser;

    private Browser() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static Browser getInstance() {
        if (browser == null) {
            return new Browser();
        } else return browser;
    }

    public static void closeDriver() {
        driver.quit();
        browser = null;
    }

    public WebDriverWait waitUntil() {
        return new WebDriverWait(driver, TIMEOUT);
    }

    public Wait fluentWaitUntil() {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        return fluentWait;
    }


    public void openPage(String url) {
        System.out.println(String.format("Open page by URL: [%s]", url));
        driver.get(url);
    }

    public void clickElement(By locator) {
        System.out.println(String.format("Click element located: [%s]", locator));
        driver.findElement(locator).click();
    }

    public void typeTo(By locator, String value) {
        System.out.println(String.format("Type [%s] to element located: [%s]", value, locator));
        driver.findElement(locator).sendKeys(value);
    }

    public String getTextFrom(By locator) {
        System.out.println(String.format("Get text from element located: [%s]", locator));
        return driver.findElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        System.out.println(String.format("Check that element located [%s] is displayed", locator));
        return driver.findElement(locator).isDisplayed();
    }

    public void waitForVisibilityOf(By locator) {
        System.out.println(String.format("Check that element located [%s] is visible", locator));
        waitUntil().until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public WebElement findElementBy(By locator) {
        System.out.println(String.format("Find element located [%s]", locator));
        return driver.findElement(locator);
    }

    public List<WebElement> findElementsBy(By locator) {
        System.out.println(String.format("Find all elements located [%s]", locator));
        return driver.findElements(locator);
    }

    public void selectFrom(By locator, String value) {
        Select select = new Select(findElementBy(locator));
        System.out.println(String.format("Select [%s] from element located: [%s]", value, locator));
        select.selectByVisibleText(value);
    }

    public void selectCheckbox(By locator) {
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(locator))
                .click()
                .build()
                .perform();
    }

}
