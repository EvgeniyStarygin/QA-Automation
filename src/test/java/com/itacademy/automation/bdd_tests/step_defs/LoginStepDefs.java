package com.itacademy.automation.bdd_tests.step_defs;

import com.itacademy.automation.ui_task.entities.Browser;
import com.itacademy.automation.ui_task.screens.MailRuEmailPage;
import com.itacademy.automation.ui_task.screens.MailRuLoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginStepDefs {
    private MailRuLoginPage page = new MailRuLoginPage();

    @Given("browser started")
    public void browserStarted() {
        Browser.getInstance();
    }

    @And("mail.ru page is loaded")
    public void mailRuPageIsLoaded() {
        page.openMailRuMainPage();
    }


    @And("I click password button")
    public void iClickPasswordButton() {
        page.clickTypePasswordButton();
    }

    @And("I type {string} to password input")
    public void iTypeToPasswordInput(String password) {
        page.typePassword(password);
    }

    @When("I type {string} to id input")
    public void iTypeToIdInput(String login) {
        page.typeLogin(login);
    }

    @And("I select {string} in dropdown list")
    public void iSelectInDropdownList(String domain) {
        page.selectDomain(domain);
    }


    @And("I click submit button")
    public void iClickSubmitButton() {
        page.clickLoginButton();
    }

    @Then("I see {string}")
    public void iSee(String arg0) {
        SoftAssert anAssert = new SoftAssert();
        anAssert.assertTrue(page.isErrorMassageDisplayed(), "Error message is not displayed");
        anAssert.assertEquals(page.getErrorMessageText(), arg0,
                String.format("Error message on the page differs from message '%s'", arg0));
        anAssert.assertAll();
    }

    @Then("I see {string} id")
    public void iSeeMyId(String arg0) {
        Assert.assertEquals(new MailRuEmailPage().getUserId(), arg0,
                "Unexpected user id");
    }

    @After
    public void tearDown() {
        Browser.closeDriver();
    }
}