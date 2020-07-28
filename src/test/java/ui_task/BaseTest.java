package ui_task;

import org.testng.annotations.AfterClass;
import ui_task.entities.Browser;
import ui_task.loggers.MailRuLogger;

public class BaseTest {

    @AfterClass
    public void tearDown() {
        MailRuLogger.logInfo("Test finished");
        Browser.closeDriver();
    }
}
