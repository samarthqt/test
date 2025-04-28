package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorMessageConsistencySteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the system is configured to display error messages")
    public void theSystemIsConfiguredToDisplayErrorMessages() {
        // Configuration setup if needed
    }

    @When("the user navigates to the sign-in page using a {string} device")
    public void theUserNavigatesToTheSignInPageUsingADevice(String deviceType) {
        navigateToSignInPage(deviceType);
    }

    @Then("the sign-in page is displayed on the {string} device")
    public void theSignInPageIsDisplayedOnTheDevice(String deviceType) {
        verifySignInPageDisplayed(deviceType);
    }

    @When("the user enters an invalid email and password")
    public void theUserEntersAnInvalidEmailAndPassword() {
        enterInvalidCredentials();
    }

    @Then("the fields accept input")
    public void theFieldsAcceptInput() {
        verifyFieldsAcceptInput();
    }

    @When("the user clicks 'Sign In' and observes the error message")
    public void theUserClicksSignInAndObservesTheErrorMessage() {
        clickSignInAndObserveErrorMessage();
    }

    @Then("the error message is displayed")
    public void theErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @When("the user repeats steps 1-3 using a {string}")
    public void theUserRepeatsStepsUsingADevice(String deviceType) {
        repeatStepsOnDevice(deviceType);
    }

    @Then("the error message is consistent with the mobile device")
    public void theErrorMessageIsConsistentWithTheMobileDevice() {
        verifyErrorMessageConsistency();
    }

    @When("the user verifies the error message content and format")
    public void theUserVerifiesTheErrorMessageContentAndFormat() {
        verifyErrorMessageContentAndFormat();
    }

    @Then("the content and format are consistent across devices")
    public void theContentAndFormatAreConsistentAcrossDevices() {
        verifyContentAndFormatConsistency();
    }

    @When("the user checks for any device-specific error message issues")
    public void theUserChecksForAnyDeviceSpecificErrorMessageIssues() {
        checkDeviceSpecificIssues();
    }

    @Then("no device-specific issues are found")
    public void noDeviceSpecificIssuesAreFound() {
        verifyNoDeviceSpecificIssues();
    }

    @When("the user verifies system logs for error messages across devices")
    public void theUserVerifiesSystemLogsForErrorMessagesAcrossDevices() {
        verifySystemLogsForErrorMessages();
    }

    @Then("logs accurately reflect error messages")
    public void logsAccuratelyReflectErrorMessages() {
        verifyLogsAccuracy();
    }

    @When("the user checks error message consistency during high traffic conditions")
    public void theUserChecksErrorMessageConsistencyDuringHighTrafficConditions() {
        checkErrorMessageConsistencyHighTraffic();
    }

    @Then("error messages remain consistent")
    public void errorMessagesRemainConsistent() {
        verifyErrorMessageConsistency();
    }

    @When("the user tests error message consistency with different screen resolutions")
    public void theUserTestsErrorMessageConsistencyWithDifferentScreenResolutions() {
        testErrorMessageConsistencyScreenResolutions();
    }

    @Then("error messages are consistent across resolutions")
    public void errorMessagesAreConsistentAcrossResolutions() {
        verifyErrorMessageConsistency();
    }

    @When("the user verifies error messages under high latency conditions")
    public void theUserVerifiesErrorMessagesUnderHighLatencyConditions() {
        verifyErrorMessagesHighLatency();
    }

    @Then("error messages remain consistent")
    public void errorMessagesRemainConsistentUnderLatency() {
        verifyErrorMessageConsistency();
    }

    @When("the user checks for any discrepancies in error message language")
    public void theUserChecksForAnyDiscrepanciesInErrorMessageLanguage() {
        checkErrorMessageLanguageDiscrepancies();
    }

    @Then("language is consistent across devices")
    public void languageIsConsistentAcrossDevices() {
        verifyLanguageConsistency();
    }

    @When("the user verifies error message consistency during server downtime")
    public void theUserVerifiesErrorMessageConsistencyDuringServerDowntime() {
        verifyErrorMessageConsistencyServerDowntime();
    }

    @Then("error messages remain consistent")
    public void errorMessagesRemainConsistentDuringDowntime() {
        verifyErrorMessageConsistency();
    }

    @When("the user tests error message consistency with different network speeds")
    public void theUserTestsErrorMessageConsistencyWithDifferentNetworkSpeeds() {
        testErrorMessageConsistencyNetworkSpeeds();
    }

    @Then("error messages are consistent across speeds")
    public void errorMessagesAreConsistentAcrossSpeeds() {
        verifyErrorMessageConsistency();
    }

    @When("the user verifies error message consistency with different device orientations")
    public void theUserVerifiesErrorMessageConsistencyWithDifferentDeviceOrientations() {
        verifyErrorMessageConsistencyDeviceOrientations();
    }

    @Then("error messages are consistent across orientations")
    public void errorMessagesAreConsistentAcrossOrientations() {
        verifyErrorMessageConsistency();
    }
}