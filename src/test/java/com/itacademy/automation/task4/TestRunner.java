package com.itacademy.automation.task4;

import org.testng.TestNG;

import java.util.Arrays;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        List<String> files = Arrays.asList(
                "./src/test/resources/boytestssuite.xml",
                "./src/test/resources/girltestssuite.xml");
        testNG.setTestSuites(files);
        testNG.run();
    }
}
