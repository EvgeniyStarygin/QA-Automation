package ui_task.entities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Browser {

    public static final int LONG_TIMEOUT = 20;
    public static final int SHORT_TIMEOUT = 1;
    public static final int POLLING_TIME = 1;
    private static WebDriver driver;
    private static Browser browser;

    private Browser() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/ui_task/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static Browser getInstance() {
        if (browser == null) {
            return browser = new Browser();
        } else {
            return browser;
        }
    }

    public static void closeDriver() {
        driver.quit();
        browser = null;
    }

    public void openPage(String url) {
        System.out.println(String.format("Open page by URL: [%s]", url));
        driver.get(url);
        driver.manage().window().maximize();
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
        waitForVisibility(locator, LONG_TIMEOUT);
        System.out.println(String.format("Check that element located [%s] is displayed", locator));
        return driver.findElement(locator).isDisplayed();
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
        fluentWaitForClickable(locator, LONG_TIMEOUT);
        System.out.println(String.format("Select checkbox from element located: [%s]", locator));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(locator))
                .click()
                .build()
                .perform();
    }

    public void waitForVisibility(By locator, int seconds) {
        System.out.println(String.format("Check that element located [%s] is visible for [%s] seconds", locator, seconds));
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public void fluentWaitForVisibility(By locator, int timeout) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(POLLING_TIME))
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(findElementBy(locator)));
    }

    public void fluentWaitForClickable(By locator, int timeout) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(POLLING_TIME))
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isElementPresent(By locator) {
        System.out.println(String.format("Check that element located [%s] is not present", locator));
        driver.manage().timeouts().implicitlyWait(SHORT_TIMEOUT, TimeUnit.SECONDS);
        boolean result = findElementsBy(locator).size() != 0;
        driver.manage().timeouts().implicitlyWait(LONG_TIMEOUT, TimeUnit.SECONDS);
        return result;
    }

    public void switchToLastTab() {
        System.out.println(String.format("Switch to last opened tab"));
        ArrayList<String> tabs = new ArrayList(getAllTabsNames());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public Set<String> getAllTabsNames(){
        return driver.getWindowHandles();
    }


    public void switchToFrame(WebElement element){
        driver.switchTo().frame(element);
        System.out.println(String.format("Switched to frame [%s]", element));
    }

    public void switchToTab(String tabName){
        driver.switchTo().window(tabName);
        System.out.println(String.format("Switched to tab [%s]", tabName));
    }

    public String getTabName() {
        return driver.getWindowHandle();
    }
}
