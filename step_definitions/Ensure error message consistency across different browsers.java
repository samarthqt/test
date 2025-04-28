package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorMessageConsistencySteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the system is configured to display error messages")
    public void theSystemIsConfiguredToDisplayErrorMessages() {
        configureErrorMessageSettings();
    }

    @When("the user navigates to the sign-in page using {string}")
    public void theUserNavigatesToTheSignInPageUsingBrowser(String browser) {
        launchSignInPage(browser);
    }

    @Then("the sign-in page is displayed on {string}")
    public void theSignInPageIsDisplayedOnBrowser(String browser) {
        verifySignInPageDisplayed(browser);
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

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @When("the user repeats steps 1-3 using {string}")
    public void theUserRepeatsStepsUsingBrowser(String browser) {
        repeatStepsUsingBrowser(browser);
    }

    @Then("the error message is consistent with Chrome")
    public void theErrorMessageIsConsistentWithChrome() {
        verifyErrorMessageConsistencyWithChrome();
    }

    @Then("verify error message content and format")
    public void verifyErrorMessageContentAndFormat() {
        verifyErrorMessageContentAndFormatAcrossBrowsers();
    }

    @Then("content and format are consistent across browsers")
    public void contentAndFormatAreConsistentAcrossBrowsers() {
        verifyContentAndFormatConsistency();
    }

    @Then("check for any browser-specific error message issues")
    public void checkForAnyBrowserSpecificErrorMessageIssues() {
        checkBrowserSpecificErrorMessageIssues();
    }

    @Then("no browser-specific issues are found")
    public void noBrowserSpecificIssuesAreFound() {
        verifyNoBrowserSpecificIssues();
    }

    @Then("verify system logs for error messages across browsers")
    public void verifySystemLogsForErrorMessagesAcrossBrowsers() {
        verifySystemLogsForErrorMessages();
    }

    @Then("logs accurately reflect error messages")
    public void logsAccuratelyReflectErrorMessages() {
        verifyLogsAccuracy();
    }

    @Then("check error message consistency during high traffic conditions")
    public void checkErrorMessageConsistencyDuringHighTrafficConditions() {
        verifyErrorMessageConsistencyUnderHighTraffic();
    }

    @Then("error messages remain consistent")
    public void errorMessagesRemainConsistent() {
        verifyErrorMessageConsistency();
    }

    @Then("test error message consistency with different screen resolutions")
    public void testErrorMessageConsistencyWithDifferentScreenResolutions() {
        verifyErrorMessageConsistencyAcrossResolutions();
    }

    @Then("error messages are consistent across resolutions")
    public void errorMessagesAreConsistentAcrossResolutions() {
        verifyResolutionConsistency();
    }

    @Then("verify error messages under high latency conditions")
    public void verifyErrorMessagesUnderHighLatencyConditions() {
        verifyErrorMessageConsistencyUnderHighLatency();
    }

    @Then("check for any discrepancies in error message language")
    public void checkForAnyDiscrepanciesInErrorMessageLanguage() {
        verifyErrorMessageLanguageConsistency();
    }

    @Then("language is consistent across browsers")
    public void languageIsConsistentAcrossBrowsers() {
        verifyLanguageConsistency();
    }

    @Then("verify error message consistency during server downtime")
    public void verifyErrorMessageConsistencyDuringServerDowntime() {
        verifyErrorMessageConsistencyDuringDowntime();
    }

    @Then("test error message consistency with different network speeds")
    public void testErrorMessageConsistencyWithDifferentNetworkSpeeds() {
        verifyErrorMessageConsistencyAcrossNetworkSpeeds();
    }
}