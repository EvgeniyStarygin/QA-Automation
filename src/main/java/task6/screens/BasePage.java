package task6.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import task6.entities.WrappedDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = WrappedDriver.getInstance();
        PageFactory.initElements(driver, this);
    }
}
