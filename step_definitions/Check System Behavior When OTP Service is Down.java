package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OTPServiceSteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("OTP service is temporarily disabled")
    public void otpServiceIsTemporarilyDisabled() {
        disableOTPService();
    }

    @When("the user navigates to the sign-in page")
    public void theUserNavigatesToTheSignInPage() {
        navigateToSignInPage();
    }

    @Then("the user is presented with the sign-in page")
    public void theUserIsPresentedWithTheSignInPage() {
        verifySignInPageDisplayed();
    }

    @Given("the user is on the sign-in page")
    public void theUserIsOnTheSignInPage() {
        navigateToSignInPage();
    }

    @When("the user enters the registered email {string} and password {string}")
    public void theUserEntersTheRegisteredEmailAndPassword(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    @Then("the system validates the email and password")
    public void theSystemValidatesTheEmailAndPassword() {
        validateCredentials();
    }

    @Given("the user has entered valid credentials")
    public void theUserHasEnteredValidCredentials() {
        enterValidCredentials();
    }

    @When("the user clicks on the 'Sign In' button")
    public void theUserClicksOnTheSignInButton() {
        clickSignInButton();
    }

    @Then("the system attempts to send an OTP")
    public void theSystemAttemptsToSendAnOTP() {
        attemptToSendOTP();
    }

    @Given("the OTP service is down")
    public void theOTPServiceIsDown() {
        simulateOTPServiceDown();
    }

    @When("the system attempts to send an OTP")
    public void theSystemAttemptsToSendAnOTP() {
        attemptToSendOTP();
    }

    @Then("the system displays an error message indicating OTP service is unavailable")
    public void theSystemDisplaysAnErrorMessageIndicatingOTPServiceIsUnavailable() {
        verifyOTPServiceUnavailableMessage();
    }

    @When("the system cannot send an OTP")
    public void theSystemCannotSendAnOTP() {
        attemptToSendOTP();
    }

    @Then("the system suggests alternative authentication methods")
    public void theSystemSuggestsAlternativeAuthenticationMethods() {
        suggestAlternativeAuthenticationMethods();
    }

    @When("the user attempts to resend OTP")
    public void theUserAttemptsToResendOTP() {
        attemptToResendOTP();
    }

    @Then("the system displays a consistent error message for failed OTP resend")
    public void theSystemDisplaysAConsistentErrorMessageForFailedOTPResend() {
        verifyFailedOTPResendMessage();
    }

    @When("checking system logs")
    public void checkingSystemLogs() {
        checkSystemLogs();
    }

    @Then("logs reflect OTP service downtime")
    public void logsReflectOTPServiceDowntime() {
        verifyLogsForOTPServiceDowntime();
    }

    @When("the user attempts to sign in")
    public void theUserAttemptsToSignIn() {
        attemptSignIn();
    }

    @Then("the user receives a notification about the OTP service issue")
    public void theUserReceivesANotificationAboutTheOTPServiceIssue() {
        verifyUserNotificationForOTPServiceIssue();
    }

    @When("the system activates a fallback mechanism")
    public void theSystemActivatesAFallbackMechanism() {
        activateFallbackMechanism();
    }

    @Then("the fallback mechanism is activated successfully")
    public void theFallbackMechanismIsActivatedSuccessfully() {
        verifyFallbackMechanismActivation();
    }

    @Given("the OTP service is restored")
    public void theOTPServiceIsRestored() {
        restoreOTPService();
    }

    @When("the system resumes normal operations")
    public void theSystemResumesNormalOperations() {
        resumeNormalOperations();
    }

    @Then("the system resumes normal OTP dispatch post-recovery")
    public void theSystemResumesNormalOTPDispatchPostRecovery() {
        verifyNormalOTPDispatchPostRecovery();
    }

    @Given("the OTP service is temporarily restored")
    public void theOTPServiceIsTemporarilyRestored() {
        temporarilyRestoreOTPService();
    }

    @When("the system handles the restoration")
    public void theSystemHandlesTheRestoration() {
        handleRestoration();
    }

    @Then("the system handles temporary restoration gracefully")
    public void theSystemHandlesTemporaryRestorationGracefully() {
        verifyGracefulHandlingOfTemporaryRestoration();
    }

    @When("the system processes requests")
    public void theSystemProcessesRequests() {
        processRequestsDuringOutage();
    }

    @Then("the response time aligns with expected standards during the outage")
    public void theResponseTimeAlignsWithExpectedStandardsDuringTheOutage() {
        verifyResponseTimeDuringOutage();
    }

    @When("the user attempts sign-in with an incorrect OTP")
    public void theUserAttemptsSignInWithAnIncorrectOTP() {
        attemptSignInWithIncorrectOTP();
    }

    @Then("the system consistently prompts an error for incorrect OTP")
    public void theSystemConsistentlyPromptsAnErrorForIncorrectOTP() {
        verifyErrorForIncorrectOTP();
    }

    @When("the user provides feedback")
    public void theUserProvidesFeedback() {
        captureUserFeedback();
    }

    @Then("user feedback is captured for service improvement")
    public void userFeedbackIsCapturedForServiceImprovement() {
        verifyFeedbackCapture();
    }

    @When("peak sign-in attempts occur")
    public void peakSignInAttemptsOccur() {
        simulatePeakSignInAttempts();
    }

    @Then("the system manages peak attempts without crashing")
    public void theSystemManagesPeakAttemptsWithoutCrashing() {
        verifySystemStabilityDuringPeakAttempts();
    }
}