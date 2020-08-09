package com.itacademy.automation.ui_task.screens;

import com.itacademy.automation.ui_task.entities.Browser;

public class BasePage {

    protected Browser browser;

    public BasePage() {
        browser = Browser.getInstance();
    }
}
