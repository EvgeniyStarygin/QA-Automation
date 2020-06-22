package task6.tests;

import org.testng.annotations.AfterClass;
import task6.entities.WrappedDriver;

public class BaseTest {

    @AfterClass
    public void tearDown() {
        WrappedDriver.closeDriver();
    }
}
