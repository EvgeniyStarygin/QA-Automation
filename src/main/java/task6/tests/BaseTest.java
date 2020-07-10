package task6.tests;

import org.testng.annotations.AfterClass;
import task6.entities.Browser;

public class BaseTest {

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
