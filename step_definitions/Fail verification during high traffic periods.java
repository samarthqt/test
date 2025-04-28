package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerificationSteps extends VerificationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is registered and attempting to log in during peak hours")
    public void theUserIsRegisteredAndAttemptingToLogInDuringPeakHours() {
        // Code to simulate user registration and peak hour login attempt
    }

    @When("the user initiates the login process on the mobile application during peak hours")
    public void theUserInitiatesTheLoginProcessOnTheMobileApplicationDuringPeakHours() {
        initiateLoginProcess();
    }

    @Then("the user is prompted to enter their phone number")
    public void theUserIsPromptedToEnterTheirPhoneNumber() {
        verifyPhoneNumberPrompt();
    }

    @When("the user enters the registered phone number {string} and submits")
    public void theUserEntersTheRegisteredPhoneNumberAndSubmits(String phoneNumber) {
        enterPhoneNumber(phoneNumber);
        submitPhoneNumber();
    }

    @Then("the system attempts to send an SMS code to the provided phone number")
    public void theSystemAttemptsToSendAnSMSCodeToTheProvidedPhoneNumber() {
        verifySMSCodeAttempt();
    }

    @When("the user does not receive the SMS code on the phone")
    public void theUserDoesNotReceiveTheSMSCodeOnThePhone() {
        verifyNoSMSCodeReceived();
    }

    @Then("the user does not receive the SMS code within the expected time")
    public void theUserDoesNotReceiveTheSMSCodeWithinTheExpectedTime() {
        verifySMSCodeTimeout();
    }

    @When("the user attempts to log in without the SMS code")
    public void theUserAttemptsToLogInWithoutTheSMSCode() {
        attemptLoginWithoutSMSCode();
    }

    @Then("the system prompts an error message indicating that the SMS code is required")
    public void theSystemPromptsAnErrorMessageIndicatingThatTheSMSCodeIsRequired() {
        verifySMSCodeRequiredError();
    }

    @When("the user checks if the system provides retry options or support contact")
    public void theUserChecksIfTheSystemProvidesRetryOptionsOrSupportContact() {
        checkRetryOrSupportOptions();
    }

    @Then("the system provides options to retry sending the SMS code or contact support")
    public void theSystemProvidesOptionsToRetrySendingTheSMSCodeOrContactSupport() {
        verifyRetryOrSupportOptions();
    }
}