package com.cucumber.steps;

import com.pageobjects.LoginPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I launch the CoCo URL")
    public void iLaunchTheCoCoURL() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Given("I enter a valid username")
    public void iEnterAValidUsername() {
        String userName = testHarness.getData("LoginData", "ValidUserName");
        enterUserName(userName);
    }

    @Given("I enter a valid password")
    public void iEnterAValidPassword() {
        String password = testHarness.getData("LoginData", "ValidPassword");
        enterPassword(password);
    }

    @Given("I enter an invalid username")
    public void iEnterAnInvalidUsername() {
        String userName = testHarness.getData("LoginData", "InvalidUserName");
        enterUserName(userName);
    }

    @Given("I enter an invalid password")
    public void iEnterAnInvalidPassword() {
        String password = testHarness.getData("LoginData", "InvalidPassword");
        enterPassword(password);
    }

    @When("I click on the Login button")
    public void iClickOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToTheHomepage() {
        String expectedURL = testHarness.getData("LoginData", "ExpectedHomePageURL");
        verifyHomePageRedirection(expectedURL);
    }

    @Then("I should see an appropriate error message")
    public void iShouldSeeAnAppropriateErrorMessage() {
        String expectedErrorMessage = testHarness.getData("LoginData", "ExpectedErrorMessage");
        verifyErrorMessage(expectedErrorMessage);
    }
}