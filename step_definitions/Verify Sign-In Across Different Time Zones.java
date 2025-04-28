package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TimeZoneSignInSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user account is active")
    public void theUserAccountIsActive() {
        // Assume user account is active
    }

    @Given("the user has valid credentials with email {string} and password {string}")
    public void theUserHasValidCredentials(String email, String password) {
        testHarness.setData("LoginData", "Email", email);
        testHarness.setData("LoginData", "Password", password);
    }

    @When("the user opens the application login page")
    public void theUserOpensTheApplicationLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the login page is displayed")
    public void theLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
    }

    @When("the user enters the valid email {string}")
    public void theUserEntersTheValidEmail(String email) {
        enterEmail(email);
    }

    @Then("the email is entered in the email field")
    public void theEmailIsEnteredInTheEmailField() {
        verifyEmailEntered();
    }

    @When("the user enters the valid password {string}")
    public void theUserEntersTheValidPassword(String password) {
        enterPassword(password);
    }

    @Then("the password is entered in the password field")
    public void thePasswordIsEnteredInThePasswordField() {
        verifyPasswordEntered();
    }

    @When("the user attempts sign-in from {string} time zone")
    public void theUserAttemptsSignInFromTimeZone(String timeZone) {
        setTimeZone(timeZone);
        clickLoginButton();
    }

    @Then("the user is successfully signed in")
    public void theUserIsSuccessfullySignedIn() {
        verifyHomePageRedirection(testHarness.getData("LoginData", "ExpectedHomePageURL"));
    }

    @When("the user signs out from the application")
    public void theUserSignsOutFromTheApplication() {
        clickSignOutButton();
    }

    @Then("the user is successfully signed out")
    public void theUserIsSuccessfullySignedOut() {
        verifySignOut();
    }

    @When("the system time is changed to {string} time zone")
    public void theSystemTimeIsChangedToTimeZone(String timeZone) {
        setTimeZone(timeZone);
    }

    @Then("the system time is updated to {string}")
    public void theSystemTimeIsUpdatedTo(String timeZone) {
        verifyTimeZoneUpdated(timeZone);
    }

    @When("the user repeats the sign-in process with updated time zone")
    public void theUserRepeatsTheSignInProcessWithUpdatedTimeZone() {
        clickLoginButton();
    }
}