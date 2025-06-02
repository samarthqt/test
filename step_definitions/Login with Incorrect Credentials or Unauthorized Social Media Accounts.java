package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.LoginPage;

public class LoginSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        launchLoginPage();
    }

    @When("the user attempts to login using email {string} and password {string}")
    public void theUserAttemptsToLoginUsingEmailAndPassword(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    @Then("the login should fail")
    public void theLoginShouldFail() {
        verifyLoginFailure();
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String errorMessage) {
        verifyErrorMessage(errorMessage);
    }

    @When("the user attempts to login using an unauthorized Google account")
    public void theUserAttemptsToLoginUsingAnUnauthorizedGoogleAccount() {
        clickGoogleLoginButton();
        verifyGoogleLoginFailure();
    }

    @When("the user attempts to login using an unauthorized Facebook account")
    public void theUserAttemptsToLoginUsingAnUnauthorizedFacebookAccount() {
        clickFacebookLoginButton();
        verifyFacebookLoginFailure();
    }

    @Given("the user has failed login attempts exceeding the allowed limit")
    public void theUserHasFailedLoginAttemptsExceedingTheAllowedLimit() {
        simulateFailedLoginAttempts();
    }

    @Then("the account should be locked")
    public void theAccountShouldBeLocked() {
        verifyAccountLockout();
    }

    @Given("the account is locked")
    public void theAccountIsLocked() {
        ensureAccountIsLocked();
    }

    @When("the user checks for recovery options")
    public void theUserChecksForRecoveryOptions() {
        checkRecoveryOptions();
    }

    @Then("account recovery options should be provided")
    public void accountRecoveryOptionsShouldBeProvided() {
        verifyRecoveryOptions();
    }

    @When("the user attempts to login with valid credentials")
    public void theUserAttemptsToLoginWithValidCredentials() {
        enterValidCredentials();
        clickLoginButton();
    }

    @Then("the login should fail due to account lockout")
    public void theLoginShouldFailDueToAccountLockout() {
        verifyLoginFailureDueToLockout();
    }

    @When("the user attempts to login")
    public void theUserAttemptsToLogin() {
        attemptLogin();
    }

    @Then("no unexpected errors should be logged in the browser console")
    public void noUnexpectedErrorsShouldBeLoggedInTheBrowserConsole() {
        verifyNoConsoleErrors();
    }

    @Given("multiple failed login attempts")
    public void multipleFailedLoginAttempts() {
        simulateMultipleFailedLogins();
    }

    @Then("CAPTCHA should be presented")
    public void captchaShouldBePresented() {
        verifyCaptchaPresentation();
    }

    @Given("the user navigates to the login page on a different device")
    public void theUserNavigatesToTheLoginPageOnADifferentDevice() {
        launchLoginPageOnDifferentDevice();
    }

    @When("the user attempts to login using incorrect credentials")
    public void theUserAttemptsToLoginUsingIncorrectCredentials() {
        enterIncorrectCredentials();
        clickLoginButton();
    }

    @Then("the system should perform efficiently without lag")
    public void theSystemShouldPerformEfficientlyWithoutLag() {
        verifySystemPerformance();
    }

    @Given("the user has attempted multiple failed logins")
    public void theUserHasAttemptedMultipleFailedLogins() {
        simulateMultipleFailedLogins();
    }

    @Then("the user should remain logged out")
    public void theUserShouldRemainLoggedOut() {
        verifyUserIsLoggedOut();
    }
}