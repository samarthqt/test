package com.cucumber.steps;

import com.page_objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimultaneousLoginSteps extends LoginPage {

    @Given("a user account exists with username \"{string}\" and password \"{string}\"")
    public void aUserAccountExists(String username, String password) {
        setUserCredentials(username, password);
    }

    @When("the user attempts to login from Location 1 \(New York, USA\) with valid credentials")
    public void theUserAttemptsToLoginFromLocation1() {
        loginFromLocation("New York, USA");
    }

    @Then("the user is successfully logged in from Location 1")
    public void theUserIsSuccessfullyLoggedInFromLocation1() {
        verifyLoginSuccess("New York, USA");
    }

    @Given("the user is logged in from Location 1")
    public void theUserIsLoggedInFromLocation1() {
        verifyLoginSuccess("New York, USA");
    }

    @When("the user attempts to login from Location 2 \(London, UK\) with the same credentials")
    public void theUserAttemptsToLoginFromLocation2() {
        loginFromLocation("London, UK");
    }

    @Then("the system detects a simultaneous login attempt and prompts for verification")
    public void theSystemDetectsSimultaneousLogin() {
        verifySimultaneousLoginPrompt();
    }

    @When("the user completes the verification process for Location 2")
    public void theUserCompletesVerificationForLocation2() {
        completeVerificationProcess("London, UK");
    }

    @Then("the user is successfully logged in from Location 2")
    public void theUserIsSuccessfullyLoggedInFromLocation2() {
        verifyLoginSuccess("London, UK");
    }

    @Then("the session from Location 1 remains active")
    public void theSessionFromLocation1RemainsActive() {
        verifySessionActive("New York, USA");
    }

    @Given("the user is logged in from Location 1 and Location 2")
    public void theUserIsLoggedInFromLocation1AndLocation2() {
        verifyLoginSuccess("New York, USA");
        verifyLoginSuccess("London, UK");
    }

    @When("the user attempts to login from Location 3 with the same credentials")
    public void theUserAttemptsToLoginFromLocation3() {
        loginFromLocation("Location 3");
    }

    @Then("the system prompts for verification due to multiple active sessions")
    public void theSystemPromptsForVerificationMultipleSessions() {
        verifyMultipleSessionsPrompt();
    }

    @When("the user fails the verification process for Location 3")
    public void theUserFailsVerificationForLocation3() {
        failVerificationProcess("Location 3");
    }

    @Then("the user is not logged in from Location 3")
    public void theUserIsNotLoggedInFromLocation3() {
        verifyLoginFailure("Location 3");
    }

    @When("the user logs out from Location 1")
    public void theUserLogsOutFromLocation1() {
        logoutFromLocation("New York, USA");
    }

    @Then("the user is logged out from Location 1")
    public void theUserIsLoggedOutFromLocation1() {
        verifyLogoutSuccess("New York, USA");
    }

    @Then("the session from Location 2 remains active")
    public void theSessionFromLocation2RemainsActive() {
        verifySessionActive("London, UK");
    }

    @Given("the user is logged in from Location 2")
    public void theUserIsLoggedInFromLocation2() {
        verifyLoginSuccess("London, UK");
    }

    @When("the user attempts to login from a different device at Location 2")
    public void theUserAttemptsToLoginFromDifferentDeviceLocation2() {
        loginFromDifferentDevice("London, UK");
    }

    @Then("the system prompts for verification due to device change")
    public void theSystemPromptsForVerificationDeviceChange() {
        verifyDeviceChangePrompt();
    }

    @When("the user completes the verification process for the new device")
    public void theUserCompletesVerificationForNewDevice() {
        completeVerificationProcessForDevice();
    }

    @Then("the user is successfully logged in from the new device at Location 2")
    public void theUserIsSuccessfullyLoggedInFromNewDeviceLocation2() {
        verifyLoginSuccessFromDevice("London, UK");
    }

    @When("the user attempts to login from Location 4 with incorrect credentials")
    public void theUserAttemptsToLoginFromLocation4IncorrectCredentials() {
        loginWithIncorrectCredentials("Location 4");
    }

    @Then("the system displays an error message indicating incorrect credentials")
    public void theSystemDisplaysErrorMessageIncorrectCredentials() {
        verifyIncorrectCredentialsError();
    }

    @Given("multiple failed login attempts from Location 4")
    public void multipleFailedLoginAttemptsFromLocation4() {
        simulateFailedLoginAttempts("Location 4");
    }

    @When("the user attempts to login from Location 4 with correct credentials")
    public void theUserAttemptsToLoginFromLocation4CorrectCredentials() {
        loginWithCorrectCredentials("Location 4");
    }

    @Then("the system prompts for additional verification due to previous failed attempts")
    public void theSystemPromptsForAdditionalVerification() {
        verifyAdditionalVerificationPrompt();
    }

    @When("monitoring system logs for login attempts")
    public void monitoringSystemLogsForLoginAttempts() {
        monitorLoginAttempts();
    }

    @Then("the system logs capture all login attempts with timestamps and locations")
    public void theSystemLogsCaptureLoginAttempts() {
        verifyLoginAttemptsLogged();
    }

    @When("checking for security alerts generated due to simultaneous login attempts")
    public void checkingForSecurityAlertsSimultaneousLoginAttempts() {
        checkSecurityAlerts();
    }

    @Then("security alerts are generated and sent to the user's registered email or phone")
    public void securityAlertsGeneratedAndSent() {
        verifySecurityAlertsSent();
    }

    @Given("multiple active sessions")
    public void multipleActiveSessions() {
        verifyMultipleActiveSessions();
    }

    @When("verifying session timeout behavior")
    public void verifyingSessionTimeoutBehavior() {
        verifySessionTimeoutBehavior();
    }

    @Then("sessions time out independently based on inactivity")
    public void sessionsTimeOutIndependently() {
        verifyIndependentSessionTimeout();
    }
}