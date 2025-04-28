package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClockSkewSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user account is active")
    public void theUserAccountIsActive() {
        // Code to ensure user account is active
    }

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        // Code to ensure user has valid credentials
    }

    @When("the user opens the application login page")
    public void theUserOpensTheApplicationLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the login page should be displayed")
    public void theLoginPageShouldBeDisplayed() {
        verifyLoginPageDisplayed();
    }

    @When("the user enters valid email {string}")
    public void theUserEntersValidEmail(String email) {
        enterEmail(email);
    }

    @Then("the email should be entered in the email field")
    public void theEmailShouldBeEnteredInTheEmailField() {
        verifyEmailEntered();
    }

    @When("the user enters valid password {string}")
    public void theUserEntersValidPassword(String password) {
        enterPassword(password);
    }

    @Then("the password should be entered in the password field")
    public void thePasswordShouldBeEnteredInThePasswordField() {
        verifyPasswordEntered();
    }

    @When("the system clock is set 5 minutes ahead")
    public void theSystemClockIsSet5MinutesAhead() {
        adjustSystemClock(5);
    }

    @Then("the system clock should be set 5 minutes ahead")
    public void theSystemClockShouldBeSet5MinutesAhead() {
        verifySystemClockAdjusted(5);
    }

    @When("the user attempts to sign-in with adjusted clock")
    public void theUserAttemptsToSignInWithAdjustedClock() {
        clickLoginButton();
    }

    @Then("the user should be successfully signed in")
    public void theUserShouldBeSuccessfullySignedIn() {
        verifyHomePageRedirection();
    }

    @When("the user signs out from the application")
    public void theUserSignsOutFromTheApplication() {
        signOut();
    }

    @Then("the user should be successfully signed out")
    public void theUserShouldBeSuccessfullySignedOut() {
        verifySignOut();
    }

    @When("the system clock is set 5 minutes behind")
    public void theSystemClockIsSet5MinutesBehind() {
        adjustSystemClock(-5);
    }

    @Then("the system clock should be set 5 minutes behind")
    public void theSystemClockShouldBeSet5MinutesBehind() {
        verifySystemClockAdjusted(-5);
    }

    @When("the user repeats sign-in process with adjusted clock")
    public void theUserRepeatsSignInProcessWithAdjustedClock() {
        clickLoginButton();
    }

    @When("the system clock is reset to current time")
    public void theSystemClockIsResetToCurrentTime() {
        resetSystemClock();
    }

    @Then("the system clock should be reset to current time")
    public void theSystemClockShouldBeResetToCurrentTime() {
        verifySystemClockReset();
    }

    @When("the user attempts to sign-in with correct system time")
    public void theUserAttemptsToSignInWithCorrectSystemTime() {
        clickLoginButton();
    }

    @When("the system logs are verified for any clock skew warnings")
    public void theSystemLogsAreVerifiedForAnyClockSkewWarnings() {
        verifyNoClockSkewWarnings();
    }

    @Then("no clock skew warnings should be logged")
    public void noClockSkewWarningsShouldBeLogged() {
        verifyNoClockSkewWarnings();
    }

    @When("the system is checked for any error messages related to clock skew")
    public void theSystemIsCheckedForAnyErrorMessagesRelatedToClockSkew() {
        verifyNoClockSkewErrors();
    }

    @Then("no error messages related to clock skew should be displayed")
    public void noErrorMessagesRelatedToClockSkewShouldBeDisplayed() {
        verifyNoClockSkewErrors();
    }

    @When("the user repeats sign-in process with normal clock settings")
    public void theUserRepeatsSignInProcessWithNormalClockSettings() {
        clickLoginButton();
    }
}