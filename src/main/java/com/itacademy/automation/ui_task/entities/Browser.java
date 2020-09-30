package com.itacademy.automation.ui_task.entities;

import com.itacademy.automation.ui_task.loggers.CustomLogger;
import com.itacademy.automation.ui_task.services.FileCreator;
import com.itacademy.automation.ui_task.services.RandomGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Browser {

    private static final String PATH_TO_SCREENSHOT = "test-output" + FileCreator.getSeparator() + "screenshots" + FileCreator.getSeparator();
    private static String ScreenshotFileName;
    public static String browserType;
    public static final int LONG_TIMEOUT = 10;
    public static final int SHORT_TIMEOUT = 2;
    public static final int POLLING_TIME = 1;
    private static WebDriver driver;
    private static Browser browser;

    private Browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        /*browserType = System.getProperty("browser");
        switch (browserType) {
            case ("chrome"):
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/com.itacademy.automation.ui_task/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case ("mozilla"):
                System.setProperty("webdriver.gecko.driver", "./src/test/resources/com.itacademy.automation.ui_task/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            default:
                throw new IllegalArgumentException("Incorrect type of browser");
        }*/
    }

    public static Browser getInstance() {
        if (browser == null) {
            return browser = new Browser();
        } else {
            return browser;
        }
    }

    public static void closeDriver() {
        CustomLogger.logCloseBrowser();
        driver.quit();
        browser = null;
    }

    public void openPage(String url) {
        CustomLogger.logOpenPage(url);
        driver.get(url);
    }

    public void clickElement(By locator) {
        CustomLogger.logClick(locator);
        driver.findElement(locator).click();
    }

    public void typeTo(By locator, String value) {
        CustomLogger.logTypeTo(locator, value);
        driver.findElement(locator).sendKeys(value);
    }

    public String getTextFrom(By locator) {
        CustomLogger.logGetTextFrom(locator);
        return driver.findElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        CustomLogger.logIsDisplayed(locator);
        waitForVisibility(locator, SHORT_TIMEOUT);
        return driver.findElement(locator).isDisplayed();
    }

    public WebElement findElementBy(By locator) {
        CustomLogger.logFindElement(locator);
        return driver.findElement(locator);
    }

    public List<WebElement> findElementsBy(By locator) {
        CustomLogger.logFindElements(locator);
        return driver.findElements(locator);
    }

    public void selectFrom(By locator, String value) {
        CustomLogger.logSelect(locator, value);
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(value);
    }

    public void selectCheckbox(By locator) {
        CustomLogger.logSelectCheckbox(locator);
        fluentWaitForClickable(locator, LONG_TIMEOUT);
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(locator))
                .click()
                .build()
                .perform();
    }

    public void waitForVisibility(By locator, int seconds) {
        CustomLogger.logWaitForVisibility(locator, seconds);
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public void fluentWaitForVisibility(By locator, int timeout) {
        CustomLogger.logWaitForVisibility(locator, timeout);
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(POLLING_TIME))
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(findElementBy(locator)));
    }

    public void fluentWaitForClickable(By locator, int timeout) {
        CustomLogger.logWaitForClickable(locator, timeout);
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(POLLING_TIME))
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isElementPresent(By locator) {
        CustomLogger.logIsElementPresent(locator);
        driver.manage().timeouts().implicitlyWait(SHORT_TIMEOUT, TimeUnit.SECONDS);
        boolean result = findElementsBy(locator).size() != 0;
        driver.manage().timeouts().implicitlyWait(LONG_TIMEOUT, TimeUnit.SECONDS);
        return result;
    }

    public void switchToLastTab() {
        CustomLogger.logSwitchToLastTab();
        ArrayList<String> tabs = new ArrayList(getAllTabsNames());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public Set<String> getAllTabsNames() {
        return driver.getWindowHandles();
    }

    public void switchToFrame(By locator) {
        CustomLogger.logSwitchToFrame(locator);
        waitForVisibility(locator, LONG_TIMEOUT);
        driver.switchTo().frame(findElementBy(locator));
    }

    public void switchToTab(String tabName) {
        CustomLogger.logSwitchToTab(tabName);
        driver.switchTo().window(tabName);
    }

    public String getTabName() {
        return driver.getWindowHandle();
    }

    public void waitForClickable(By locator, int seconds) {
        CustomLogger.logWaitForClickable(locator, seconds);
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.elementToBeClickable((locator)));
    }

    public void browserSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            CustomLogger.logException(e);
        }
    }

    public void uploadFile(By locator, String path) {
        CustomLogger.logUploadFile(locator, path);
        typeTo(locator, path);
    }

    public void waitForPresence(By locator, int seconds) {
        CustomLogger.logWaitForPresence(locator, seconds);
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getAttributeValue(By locator, String attributeName) {
        CustomLogger.logGetAttributeValue(locator, attributeName);
        return findElementBy(locator).getAttribute(attributeName);
    }

    public void takeScreenshot() {
        ScreenshotFileName = RandomGenerator.generateRandomScreenshotName();
        File screenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(PATH_TO_SCREENSHOT, ScreenshotFileName);
        try {
            FileUtils.copyFile(screenFile, destinationFile);
        } catch (IOException e) {
            CustomLogger.logException(e);
        }
        CustomLogger.logTakeScreenshot(destinationFile);
    }
}
