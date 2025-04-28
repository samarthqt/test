package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SmsCodeSteps extends SmsCodePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is registered and attempting to log in from a location at the network boundary")
    public void theUserIsRegisteredAndAttemptingToLogInFromALocationAtTheNetworkBoundary() {
        // Implement logic to simulate user login attempt from network boundary
    }

    @When("the user initiates the login process on the mobile application")
    public void theUserInitiatesTheLoginProcessOnTheMobileApplication() {
        initiateLoginProcess();
    }

    @Then("the user is prompted to enter their phone number")
    public void theUserIsPromptedToEnterTheirPhoneNumber() {
        verifyPhoneNumberPrompt();
    }

    @Given("the user enters their registered phone number \"\+1234567890\" and submits")
    public void theUserEntersTheirRegisteredPhoneNumberAndSubmits() {
        enterPhoneNumber("+1234567890");
        submitPhoneNumber();
    }

    @When("the system attempts to send an SMS code to the provided phone number")
    public void theSystemAttemptsToSendAnSmsCodeToTheProvidedPhoneNumber() {
        attemptToSendSmsCode();
    }

    @Then("the network coverage is a boundary area")
    public void theNetworkCoverageIsABoundaryArea() {
        verifyNetworkBoundaryArea();
    }

    @Given("the user does not receive the SMS code within the expected time")
    public void theUserDoesNotReceiveTheSmsCodeWithinTheExpectedTime() {
        verifySmsCodeNotReceived();
    }

    @Then("the expected SMS code is \"123456\"")
    public void theExpectedSmsCodeIs() {
        verifyExpectedSmsCode("123456");
    }

    @Given("the user attempts to log in without the SMS code")
    public void theUserAttemptsToLogInWithoutTheSmsCode() {
        attemptLoginWithoutSmsCode();
    }

    @Then("the system prompts an error message indicating that the SMS code is required")
    public void theSystemPromptsAnErrorMessageIndicatingThatTheSmsCodeIsRequired() {
        verifySmsCodeRequiredError();
    }

    @When("the user checks for any retry or support options provided by the system")
    public void theUserChecksForAnyRetryOrSupportOptionsProvidedByTheSystem() {
        checkRetryOrSupportOptions();
    }

    @Then("the system provides options to retry sending the SMS code or contact support")
    public void theSystemProvidesOptionsToRetrySendingTheSmsCodeOrContactSupport() {
        verifyRetryOrSupportOptions();
    }
}