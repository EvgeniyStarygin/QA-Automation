package com.itacademy.automation.unit_task;

import org.testng.TestNG;

import java.util.Arrays;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        List<String> files = Arrays.asList(
                "./src/test/resources/com/itacademy/automation/unit_task/boytestssuite.xml",
                "./src/test/resources/com/itacademy/automation/unit_task/girltestssuite.xml");
        testNG.setTestSuites(files);
        testNG.run();
    }
}
