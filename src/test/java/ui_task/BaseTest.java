package ui_task;

import org.testng.annotations.AfterClass;
import ui_task.entities.Browser;
import ui_task.loggers.CustomLogger;

public class BaseTest {

    @AfterClass
    public void closeDriver() {
        Browser.closeDriver();
    }
}
