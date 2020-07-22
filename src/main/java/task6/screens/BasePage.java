package task6.screens;

import task6.entities.Browser;

public class BasePage {

    protected Browser browser;

    public BasePage() {
        browser = Browser.getInstance();
    }
}
