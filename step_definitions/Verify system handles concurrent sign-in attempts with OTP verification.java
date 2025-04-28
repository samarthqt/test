package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConcurrentSignInSteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User accounts are created and active")
    public void userAccountsAreCreatedAndActive() {
        // Code to ensure user accounts are active
    }

    @Given("OTP service is operational")
    public void otpServiceIsOperational() {
        // Code to ensure OTP service is operational
    }

    @When("User1 initiates sign-in using email {string} and password {string}")
    public void user1InitiatesSignInUsingEmailAndPassword(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignInButton();
    }

    @Then("User1 receives an OTP prompt after entering credentials")
    public void user1ReceivesAnOTPPromptAfterEnteringCredentials() {
        verifyOTPPromptDisplayed();
    }

    @When("User2 initiates sign-in concurrently using email {string} and password {string}")
    public void user2InitiatesSignInConcurrentlyUsingEmailAndPassword(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignInButton();
    }

    @Then("User2 receives an OTP prompt after entering credentials")
    public void user2ReceivesAnOTPPromptAfterEnteringCredentials() {
        verifyOTPPromptDisplayed();
    }

    @When("User1 enters the OTP {string}")
    public void user1EntersTheOTP(String otp) {
        enterOTP(otp);
        clickVerifyOTPButton();
    }

    @Then("User1 successfully signs in")
    public void user1SuccessfullySignsIn() {
        verifySuccessfulSignIn();
    }

    @When("User2 enters the OTP {string}")
    public void user2EntersTheOTP(String otp) {
        enterOTP(otp);
        clickVerifyOTPButton();
    }

    @Then("User2 successfully signs in")
    public void user2SuccessfullySignsIn() {
        verifySuccessfulSignIn();
    }

    @When("User3 attempts sign-in using email {string} and password {string} while User1 and User2 are signing in")
    public void user3AttemptsSignInUsingEmailAndPasswordWhileUser1AndUser2AreSigningIn(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignInButton();
    }

    @Then("User3 receives an OTP prompt after entering credentials")
    public void user3ReceivesAnOTPPromptAfterEnteringCredentials() {
        verifyOTPPromptDisplayed();
    }

    @When("User3 enters an incorrect OTP")
    public void user3EntersAnIncorrectOTP() {
        enterOTP("incorrectOTP");
        clickVerifyOTPButton();
    }

    @Then("User3 receives an error message for incorrect OTP")
    public void user3ReceivesAnErrorMessageForIncorrectOTP() {
        verifyErrorMessageDisplayed("Incorrect OTP");
    }

    @When("User3 retries sign-in with the correct OTP")
    public void user3RetriesSignInWithTheCorrectOTP() {
        enterOTP("correctOTP");
        clickVerifyOTPButton();
    }

    @Then("User3 successfully signs in")
    public void user3SuccessfullySignsIn() {
        verifySuccessfulSignIn();
    }

    @When("User1 attempts concurrent sign-in from different devices")
    public void user1AttemptsConcurrentSignInFromDifferentDevices() {
        // Code to simulate concurrent sign-in from different devices
    }

    @Then("Both devices receive OTP prompts")
    public void bothDevicesReceiveOTPPrompts() {
        verifyOTPPromptDisplayedOnBothDevices();
    }

    @When("User1 enters the OTP on the first device")
    public void user1EntersTheOTPOnTheFirstDevice() {
        enterOTPOnFirstDevice("firstDeviceOTP");
        clickVerifyOTPButtonOnFirstDevice();
    }

    @Then("User1 successfully signs in on the first device")
    public void user1SuccessfullySignsInOnTheFirstDevice() {
        verifySuccessfulSignInOnFirstDevice();
    }

    @When("User1 attempts to enter the same OTP on the second device")
    public void user1AttemptsToEnterTheSameOTPOnTheSecondDevice() {
        enterOTPOnSecondDevice("firstDeviceOTP");
        clickVerifyOTPButtonOnSecondDevice();
    }

    @Then("User1 receives an error message as the OTP is already used")
    public void user1ReceivesAnErrorMessageAsTheOTPIsAlreadyUsed() {
        verifyErrorMessageDisplayedOnSecondDevice("OTP already used");
    }

    @When("User1 requests a new OTP on the second device")
    public void user1RequestsANewOTPOnTheSecondDevice() {
        requestNewOTPOnSecondDevice();
    }

    @Then("User1 receives a new OTP prompt")
    public void user1ReceivesANewOTPPrompt() {
        verifyNewOTPPromptDisplayedOnSecondDevice();
    }

    @When("User1 enters the new OTP on the second device")
    public void user1EntersTheNewOTPOnTheSecondDevice() {
        enterOTPOnSecondDevice("newOTP");
        clickVerifyOTPButtonOnSecondDevice();
    }

    @Then("User1 successfully signs in on the second device")
    public void user1SuccessfullySignsInOnTheSecondDevice() {
        verifySuccessfulSignInOnSecondDevice();
    }

    @When("User2 initiates a sign-in attempt with an expired OTP")
    public void user2InitiatesASignInAttemptWithAnExpiredOTP() {
        enterOTP("expiredOTP");
        clickVerifyOTPButton();
    }

    @Then("User2 receives an error message for expired OTP")
    public void user2ReceivesAnErrorMessageForExpiredOTP() {
        verifyErrorMessageDisplayed("Expired OTP");
    }

    @When("User2 requests a new OTP and enters it")
    public void user2RequestsANewOTPAndEntersIt() {
        requestNewOTP();
        enterOTP("newOTP");
        clickVerifyOTPButton();
    }

    @Then("User2 successfully signs in with the new OTP")
    public void user2SuccessfullySignsInWithTheNewOTP() {
        verifySuccessfulSignIn();
    }

    @Then("Verify system logs for concurrent sign-in attempts")
    public void verifySystemLogsForConcurrentSignInAttempts() {
        verifySystemLogsForConcurrentSignIn();
    }

    @Then("System logs show all concurrent sign-in attempts with timestamps")
    public void systemLogsShowAllConcurrentSignInAttemptsWithTimestamps() {
        verifySystemLogsContainTimestamps();
    }
}