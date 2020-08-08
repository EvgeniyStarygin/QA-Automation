package ui_task.screens;

import ui_task.entities.Browser;

public class BasePage {

    protected Browser browser;

    public BasePage() {
        browser = Browser.getInstance();
    }
}
