package ui_task;

import org.testng.annotations.AfterClass;
import ui_task.entities.Browser;

public class BaseTest {

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
