package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OTPVerificationSteps extends OTPVerificationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has initiated an OTP verification process")
    public void theUserHasInitiatedAnOTPVerificationProcess() {
        initiateOTPVerification();
    }

    @Given("the user has received an OTP")
    public void theUserHasReceivedAnOTP() {
        receiveOTP();
    }

    @When("the user navigates to the OTP verification screen")
    public void theUserNavigatesToTheOTPVerificationScreen() {
        navigateToOTPVerificationScreen();
    }

    @Then("the OTP verification screen is displayed")
    public void theOTPVerificationScreenIsDisplayed() {
        verifyOTPVerificationScreenDisplayed();
    }

    @When("the user enters an incorrect OTP {string} in the OTP field")
    public void theUserEntersAnIncorrectOTPInTheOTPField(String otp) {
        enterOTP(otp);
    }

    @Then("the system accepts the input and allows submission")
    public void theSystemAcceptsTheInputAndAllowsSubmission() {
        verifyOTPSubmissionAllowed();
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        clickVerifyButton(button);
    }

    @Then("the system processes the OTP")
    public void theSystemProcessesTheOTP() {
        processOTP();
    }

    @Then("the system displays an error message indicating incorrect OTP")
    public void theSystemDisplaysAnErrorMessageIndicatingIncorrectOTP() {
        verifyErrorMessageDisplayed();
    }

    @When("the user attempts to re-enter the OTP")
    public void theUserAttemptsToReEnterTheOTP() {
        attemptReEnterOTP();
    }

    @Then("the user is allowed to re-enter the OTP")
    public void theUserIsAllowedToReEnterTheOTP() {
        verifyReEnterOTPAllowed();
    }

    @When("the user enters the correct OTP {string} in the OTP field")
    public void theUserEntersTheCorrectOTPInTheOTPField(String otp) {
        enterOTP(otp);
    }

    @Then("the system successfully verifies the OTP and proceeds to the next step")
    public void theSystemSuccessfullyVerifiesTheOTPAndProceedsToTheNextStep() {
        verifyOTPAndProceed();
    }

    @Given("the user attempts to enter the incorrect OTP multiple times")
    public void theUserAttemptsToEnterTheIncorrectOTPMultipleTimes() {
        attemptMultipleIncorrectOTPEntries();
    }

    @Then("the system should limit the number of attempts")
    public void theSystemShouldLimitTheNumberOfAttempts() {
        verifyAttemptLimit();
    }

    @Then("display a warning after several failed attempts")
    public void displayAWarningAfterSeveralFailedAttempts() {
        verifyWarningDisplayed();
    }

    @When("the user checks if the account gets locked after multiple incorrect OTP attempts")
    public void theUserChecksIfTheAccountGetsLockedAfterMultipleIncorrectOTPAttempts() {
        checkAccountLockStatus();
    }

    @Then("the account remains unlocked")
    public void theAccountRemainsUnlocked() {
        verifyAccountUnlocked();
    }

    @Then("the system may impose a temporary block on further OTP attempts")
    public void theSystemMayImposeATemporaryBlockOnFurtherOTPAttempts() {
        verifyTemporaryBlock();
    }

    @When("the user checks system logs for error logging when incorrect OTP is entered")
    public void theUserChecksSystemLogsForErrorLoggingWhenIncorrectOTPIsEntered() {
        checkErrorLogging();
    }

    @Then("the system logs the incorrect OTP attempt in the logs")
    public void theSystemLogsTheIncorrectOTPAttemptInTheLogs() {
        verifyErrorLogged();
    }

    @When("the user verifies if the {string} option is available")
    public void theUserVerifiesIfTheOptionIsAvailable(String option) {
        verifyResendOTPOptionAvailable(option);
    }

    @Then("the {string} option is available for the user")
    public void theOptionIsAvailableForTheUser(String option) {
        verifyOptionAvailable(option);
    }

    @When("the user clicks on {string}")
    public void theUserClicksOn(String option) {
        clickResendOTP(option);
    }

    @Then("a new OTP is sent to the registered phone number")
    public void aNewOTPIsSentToTheRegisteredPhoneNumber() {
        verifyNewOTPSent();
    }

    @Given("a new OTP is sent after clicking {string}")
    public void aNewOTPIsSentAfterClicking(String option) {
        verifyNewOTPSentAfterResend(option);
    }

    @When("the user enters an incorrect OTP after the new OTP is sent")
    public void theUserEntersAnIncorrectOTPAfterTheNewOTPIsSent() {
        enterIncorrectOTPAfterResend();
    }

    @Then("the system should validate the new OTP and not accept the old incorrect OTP")
    public void theSystemShouldValidateTheNewOTPAndNotAcceptTheOldIncorrectOTP() {
        verifyNewOTPValidation();
    }

    @When("the user checks if they receive any notification or alert for incorrect OTP entries")
    public void theUserChecksIfTheyReceiveAnyNotificationOrAlertForIncorrectOTPEntries() {
        checkNotificationForIncorrectOTP();
    }

    @Then("the user receives an alert or notification for repeated incorrect OTP entries")
    public void theUserReceivesAnAlertOrNotificationForRepeatedIncorrectOTPEntries() {
        verifyNotificationReceived();
    }
}