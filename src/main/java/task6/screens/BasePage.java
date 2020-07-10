package task6.screens;

import org.openqa.selenium.support.PageFactory;
import task6.entities.Browser;

public class BasePage {

    protected static Browser browser;

    public BasePage() {
        browser = Browser.getInstance();
    }
}
