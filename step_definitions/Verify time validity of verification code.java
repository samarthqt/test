package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerificationCodeSteps extends VerificationCodePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has received a verification code")
    public void theUserHasReceivedAVerificationCode() {
        receiveVerificationCode();
    }

    @When("the user receives the verification code via SMS")
    public void theUserReceivesTheVerificationCodeViaSMS() {
        verifyCodeReceivedViaSMS("123456");
    }

    @Then("the verification code {string} is received")
    public void theVerificationCodeIsReceived(String code) {
        verifyCodeReceived(code);
    }

    @When("the user waits for 3 minutes before entering the code")
    public void theUserWaitsFor3MinutesBeforeEnteringTheCode() {
        waitForMinutes(3);
    }

    @Then("the code is still valid and accepted by the system")
    public void theCodeIsStillValidAndAcceptedByTheSystem() {
        verifyCodeValidity(true);
    }

    @When("the user waits for 6 minutes before entering the code")
    public void theUserWaitsFor6MinutesBeforeEnteringTheCode() {
        waitForMinutes(6);
    }

    @Then("the code is expired and not accepted by the system")
    public void theCodeIsExpiredAndNotAcceptedByTheSystem() {
        verifyCodeValidity(false);
    }

    @When("the user attempts to enter the code multiple times within 5 minutes")
    public void theUserAttemptsToEnterTheCodeMultipleTimesWithin5Minutes() {
        enterCodeMultipleTimesWithinMinutes(5);
    }

    @Then("the code is accepted each time within the validity period")
    public void theCodeIsAcceptedEachTimeWithinTheValidityPeriod() {
        verifyMultipleCodeAcceptance(true);
    }

    @When("the code expires")
    public void theCodeExpires() {
        expireCode();
    }

    @Then("the system displays {string} message")
    public void theSystemDisplaysMessage(String message) {
        verifyExpirationMessage(message);
    }

    @Then("the system logs show the code expiration timestamp")
    public void theSystemLogsShowTheCodeExpirationTimestamp() {
        verifyCodeExpirationInLogs();
    }

    @When("the user logs out and logs back in within 5 minutes")
    public void theUserLogsOutAndLogsBackInWithin5Minutes() {
        logoutAndLoginWithinMinutes(5);
    }

    @Then("the code is still valid and accepted")
    public void theCodeIsStillValidAndAccepted() {
        verifyCodeValidity(true);
    }

    @When("the system is restarted within 5 minutes")
    public void theSystemIsRestartedWithin5Minutes() {
        restartSystemWithinMinutes(5);
    }

    @Then("the user can request a new code")
    public void theUserCanRequestANewCode() {
        requestNewCode();
    }

    @When("the user enters the code incorrectly during the validity period")
    public void theUserEntersTheCodeIncorrectlyDuringTheValidityPeriod() {
        enterIncorrectCodeDuringValidity();
    }

    @Then("the system prompts for correct code entry without affecting validity")
    public void theSystemPromptsForCorrectCodeEntryWithoutAffectingValidity() {
        verifyPromptForCorrectCodeEntry();
    }

    @Then("the expired code cannot be reused")
    public void theExpiredCodeCannotBeReused() {
        verifyCodeReusePrevention();
    }

    @When("the user enters the code with incorrect formatting during the validity period")
    public void theUserEntersTheCodeWithIncorrectFormattingDuringTheValidityPeriod() {
        enterCodeWithIncorrectFormatting();
    }

    @Then("the system rejects incorrectly formatted code")
    public void theSystemRejectsIncorrectlyFormattedCode() {
        verifyIncorrectFormattingRejection();
    }

    @When("the code is entered simultaneously from different devices within the validity period")
    public void theCodeIsEnteredSimultaneouslyFromDifferentDevicesWithinTheValidityPeriod() {
        enterCodeSimultaneouslyFromDevices();
    }

    @Then("the code is valid on all devices")
    public void theCodeIsValidOnAllDevices() {
        verifyCodeValidityOnDevices();
    }

    @When("there are network delays in code entry")
    public void thereAreNetworkDelaysInCodeEntry() {
        simulateNetworkDelays();
    }

    @Then("the code remains valid despite network delays")
    public void theCodeRemainsValidDespiteNetworkDelays() {
        verifyCodeValidityDespiteDelays();
    }

    @When("the user makes multiple verification requests within the validity period")
    public void theUserMakesMultipleVerificationRequestsWithinTheValidityPeriod() {
        makeMultipleVerificationRequests();
    }

    @Then("the system issues a new code for each request and maintains validity")
    public void theSystemIssuesANewCodeForEachRequestAndMaintainsValidity() {
        verifyNewCodeIssuanceAndValidity();
    }
}