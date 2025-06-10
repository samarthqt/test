package com.cucumber.steps;

import com.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunctionalitySteps extends LoginPage {

    @Given("I launch the CoCo URL")
    public void iLaunchTheCoCoURL() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        String userName = testHarness.getData("LoginData", "ValidUserName");
        String password = testHarness.getData("LoginData", "ValidPassword");
        enterUserName(userName);
        enterPassword(password);
    }

    @When("I enter invalid username and/or password")
    public void iEnterInvalidUsernameAndOrPassword() {
        String userName = testHarness.getData("LoginData", "InvalidUserName");
        String password = testHarness.getData("LoginData", "InvalidPassword");
        enterUserName(userName);
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

    @Then("I should not be logged in")
    public void iShouldNotBeLoggedIn() {
        String currentURL = getCurrentURL();
        String loginPageURL = getAppUrl();
        Assert.assertEquals(currentURL, loginPageURL, "User is incorrectly redirected from login page.");
    }

    @Then("an appropriate error message should be displayed on the login page")
    public void anAppropriateErrorMessageShouldBeDisplayedOnTheLoginPage() {
        String expectedErrorMessage = testHarness.getData("LoginData", "ExpectedErrorMessage");
        String actualErrorMessage = getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match.");
    }
}