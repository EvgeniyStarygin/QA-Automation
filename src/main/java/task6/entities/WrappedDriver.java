package task6.entities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrappedDriver {

    private static WebDriver driver;
    private static final int TIMEOUT = 10;

    private WrappedDriver(){}

    public static WebDriver getInstance(){
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            return driver = new ChromeDriver();
        } else return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }

    public static WebDriverWait waitUntil() {
        return new WebDriverWait(driver, TIMEOUT);
    }

}
