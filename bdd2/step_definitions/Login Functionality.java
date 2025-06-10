package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageobjects.LoginPage;

public class LoginFunctionalitySteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I have launched the CoCo URL")
    public void iHaveLaunchedTheCoCoURL() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("I enter a valid username and password")
    public void iEnterAValidUsernameAndPassword() {
        String userName = testHarness.getData("LoginData", "ValidUserName");
        String password = testHarness.getData("LoginData", "ValidPassword");
        enterUserName(userName);
        enterPassword(password);
    }

    @When("I enter an invalid username and password")
    public void iEnterAnInvalidUsernameAndPassword() {
        String userName = testHarness.getData("LoginData", "InvalidUserName");
        String password = testHarness.getData("LoginData", "InvalidPassword");
        enterUserName(userName);
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

    @Then("I should see an appropriate error message indicating unsuccessful login")
    public void iShouldSeeAnAppropriateErrorMessageIndicatingUnsuccessfulLogin() {
        String expectedErrorMessage = testHarness.getData("LoginData", "ExpectedErrorMessage");
        verifyErrorMessage(expectedErrorMessage);
    }

    @Then("I should see a button labeled \"Login with SSO\" on the login screen")
    public void iShouldSeeALoginWithSSOButton() {
        verifyLoginWithSSOButton();
    }
}