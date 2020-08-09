package com.itacademy.automation.ui_tests;

import org.testng.annotations.AfterClass;
import com.itacademy.automation.ui_task.entities.Browser;

public class BaseTest {

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        Browser.closeDriver();
    }
}
