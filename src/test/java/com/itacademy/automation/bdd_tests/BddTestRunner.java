package com.itacademy.automation.bdd_tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/com/itacademy/automation/bdd_task")
public class BddTestRunner extends AbstractTestNGCucumberTests {

}
