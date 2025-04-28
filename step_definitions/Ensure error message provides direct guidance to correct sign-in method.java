package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorMessageSteps extends ErrorMessagePage {

    private TestHarness testHarness = new TestHarness();

    @Given("access to the application where sign-in errors can be triggered")
    public void accessToApplicationWhereSignInErrorsCanBeTriggered() {
        launchApplication();
    }

    @When("the user attempts to sign in using an incorrect method")
    public void userAttemptsSignInUsingIncorrectMethod() {
        attemptIncorrectSignIn();
    }

    @Then("the sign-in attempt fails, and an error message is displayed")
    public void signInAttemptFailsAndErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Given("access to the application where the error message is displayed")
    public void accessToApplicationWhereErrorMessageIsDisplayed() {
        launchApplication();
    }

    @When("the error message is shown")
    public void errorMessageIsShown() {
        triggerErrorMessage();
    }

    @Then("a clear screenshot of the error message is captured")
    public void clearScreenshotOfErrorMessageIsCaptured() {
        captureScreenshot();
    }

    @When("the error message is displayed")
    public void errorMessageIsDisplayed() {
        triggerErrorMessage();
    }

    @Then("the error message clearly states the correct sign-in method")
    public void errorMessageClearlyStatesCorrectSignInMethod() {
        verifyErrorMessageClarity();
    }

    @Then("the error message provides a link or instructions for credential recovery")
    public void errorMessageProvidesLinkOrInstructionsForCredentialRecovery() {
        verifyCredentialRecoveryGuidance();
    }

    @Then("alternative sign-in options are mentioned in the error message")
    public void alternativeSignInOptionsMentionedInErrorMessage() {
        verifyAlternativeSignInOptions();
    }

    @Then("the error message is brief and easily comprehensible")
    public void errorMessageIsBriefAndEasilyComprehensible() {
        verifyErrorMessageConciseness();
    }

    @Then("the error message aligns with the style and tone of other guidance messages")
    public void errorMessageAlignsWithStyleAndToneOfOtherGuidanceMessages() {
        verifyErrorMessageConsistency();
    }

    @Then("screen readers announce the error message correctly")
    public void screenReadersAnnounceErrorMessageCorrectly() {
        verifyScreenReaderAccessibility();
    }

    @Then("the error message is displayed correctly across all tested devices and screen sizes")
    public void errorMessageDisplayedCorrectlyAcrossAllTestedDevicesAndScreenSizes() {
        verifyErrorMessageResponsiveness();
    }

    @Then("the error message is free of technical terms that may confuse users")
    public void errorMessageIsFreeOfTechnicalTermsThatMayConfuseUsers() {
        verifyErrorMessageSimplicity();
    }

    @Then("the error message appears immediately after the failed attempt")
    public void errorMessageAppearsImmediatelyAfterFailedAttempt() {
        verifyPromptDisplayOfErrorMessage();
    }

    @Then("the error message is visible in all tested browser settings")
    public void errorMessageVisibleInAllTestedBrowserSettings() {
        verifyErrorMessageVisibility();
    }

    @Then("the error message is recorded in the system logs")
    public void errorMessageRecordedInSystemLogs() {
        logErrorMessage();
    }

    @When("the user successfully signs in")
    public void userSuccessfullySignsIn() {
        performSuccessfulSignIn();
    }

    @Then("the error message is cleared")
    public void errorMessageIsCleared() {
        verifyErrorMessageClearance();
    }

    @When("the correct sign-in method changes")
    public void correctSignInMethodChanges() {
        updateSignInMethod();
    }

    @Then("the error message reflects the current correct sign-in method")
    public void errorMessageReflectsCurrentCorrectSignInMethod() {
        verifyRealTimeUpdateOfErrorMessage();
    }
}