package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BulkSignInSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("multiple user accounts are active")
    public void multipleUserAccountsAreActive() {
        // Logic to ensure multiple user accounts are active
    }

    @Given("valid credentials for each user are known")
    public void validCredentialsForEachUserAreKnown() {
        // Logic to retrieve valid credentials for each user
    }

    @When("I open the application login page")
    public void iOpenTheApplicationLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the login page is displayed")
    public void theLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
    }

    @When("I enter email {string} and password {string} for {string}")
    public void iEnterEmailAndPasswordForUser(String email, String password, String user) {
        enterUserName(email);
        enterPassword(password);
    }

    @Then("credentials are entered for {string}")
    public void credentialsAreEnteredForUser(String user) {
        // Logic to verify credentials are entered
    }

    @When("I attempt sign-in for {string}")
    public void iAttemptSignInForUser(String user) {
        clickLoginButton();
    }

    @Then("{string} is successfully signed in")
    public void userIsSuccessfullySignedIn(String user) {
        verifyHomePageRedirection(testHarness.getData("LoginData", "ExpectedHomePageURL"));
    }

    @When("I sign out {string}")
    public void iSignOutUser(String user) {
        clickSignOutButton();
    }

    @Then("{string} is successfully signed out")
    public void userIsSuccessfullySignedOut(String user) {
        verifyLoginPageDisplayed();
    }
}