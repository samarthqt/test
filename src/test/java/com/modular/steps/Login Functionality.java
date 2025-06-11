package com.cucumber.steps;

import com.pageobjects.LoginPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunctionalitySteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I launch the CoCo URL")
    public void iLaunchTheCoCoURL() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("I enter a valid username")
    public void iEnterAValidUsername() {
        String userName = testHarness.getData("LoginData", "ValidUserName");
        enterUserName(userName);
    }

    @When("I enter a valid password")
    public void iEnterAValidPassword() {
        String password = testHarness.getData("LoginData", "ValidPassword");
        enterPassword(password);
    }

    @When("I click on the Login button")
    public void iClickOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("I should be successfully logged in")
    public void iShouldBeSuccessfullyLoggedIn() {
        String expectedURL = testHarness.getData("LoginData", "ExpectedHomePageURL");
        verifyHomePageRedirection(expectedURL);
    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToTheHomepage() {
        String expectedURL = testHarness.getData("LoginData", "ExpectedHomePageURL");
        verifyHomePageRedirection(expectedURL);
    }

    @When("I enter an invalid username")
    public void iEnterAnInvalidUsername() {
        String userName = testHarness.getData("LoginData", "InvalidUserName");
        enterUserName(userName);
    }

    @When("I enter an invalid password")
    public void iEnterAnInvalidPassword() {
        String password = testHarness.getData("LoginData", "InvalidPassword");
        enterPassword(password);
    }

    @Then("I should not be logged in")
    public void iShouldNotBeLoggedIn() {
        String expectedErrorMessage = testHarness.getData("LoginData", "ExpectedErrorMessage");
        verifyErrorMessage(expectedErrorMessage);
    }

    @Then("an appropriate error message should be displayed")
    public void anAppropriateErrorMessageShouldBeDisplayed() {
        String expectedErrorMessage = testHarness.getData("LoginData", "ExpectedErrorMessage");
        verifyErrorMessage(expectedErrorMessage);
    }
}