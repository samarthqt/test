package com.cucumber.steps;

import com.page_objects.HelpCenterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeedbackSubmissionSteps extends HelpCenterPage {

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the Help Center page")
    public void theUserNavigatesToTheHelpCenterPage() {
        navigateToHelpCenter();
    }

    @Then("the Help Center page is displayed")
    public void theHelpCenterPageIsDisplayed() {
        verifyHelpCenterPageDisplayed();
    }

    @Given("the user is on the Help Center page")
    public void theUserIsOnTheHelpCenterPage() {
        verifyHelpCenterPageDisplayed();
    }

    @When("the user locates the feedback form")
    public void theUserLocatesTheFeedbackForm() {
        locateFeedbackForm();
    }

    @Then("the feedback form is visible and accessible")
    public void theFeedbackFormIsVisibleAndAccessible() {
        verifyFeedbackFormAccessible();
    }

    @Given("the user has accessed the feedback form")
    public void theUserHasAccessedTheFeedbackForm() {
        verifyFeedbackFormAccessible();
    }

    @When("the user enters invalid feedback text {string} and submits")
    public void theUserEntersInvalidFeedbackTextAndSubmits(String feedbackText) {
        enterFeedbackText(feedbackText);
        submitFeedback();
    }

    @Then("the system rejects feedback and displays an error message")
    public void theSystemRejectsFeedbackAndDisplaysAnErrorMessage() {
        verifyFeedbackRejected();
    }

    @When("the user enters empty feedback text and submits")
    public void theUserEntersEmptyFeedbackTextAndSubmits() {
        enterFeedbackText("");
        submitFeedback();
    }

    @When("the user enters overly long feedback text {string} and submits")
    public void theUserEntersOverlyLongFeedbackTextAndSubmits(String feedbackText) {
        enterFeedbackText(feedbackText);
        submitFeedback();
    }

    @When("the user enters numeric feedback text {string} and submits")
    public void theUserEntersNumericFeedbackTextAndSubmits(String feedbackText) {
        enterFeedbackText(feedbackText);
        submitFeedback();
    }

    @When("the user enters feedback text with special characters {string} and submits")
    public void theUserEntersFeedbackTextWithSpecialCharactersAndSubmits(String feedbackText) {
        enterFeedbackText(feedbackText);
        submitFeedback();
    }

    @Given("feedback submission errors have occurred")
    public void feedbackSubmissionErrorsHaveOccurred() {
        simulateFeedbackErrors();
    }

    @When("checking the system logs")
    public void checkingTheSystemLogs() {
        checkSystemLogs();
    }

    @Then("errors are logged appropriately")
    public void errorsAreLoggedAppropriately() {
        verifyErrorsLogged();
    }

    @Given("the feedback form is accessible")
    public void theFeedbackFormIsAccessible() {
        verifyFeedbackFormAccessible();
    }

    @When("verifying the validation rules")
    public void verifyingTheValidationRules() {
        verifyValidationRules();
    }

    @Then("validation rules are enforced correctly")
    public void validationRulesAreEnforcedCorrectly() {
        verifyValidationRulesEnforced();
    }

    @Given("the user session is invalid")
    public void theUserSessionIsInvalid() {
        invalidateUserSession();
    }

    @When("attempting feedback submission")
    public void attemptingFeedbackSubmission() {
        submitFeedback();
    }

    @Then("feedback submission fails due to session error")
    public void feedbackSubmissionFailsDueToSessionError() {
        verifySessionError();
    }

    @Given("the user session has expired")
    public void theUserSessionHasExpired() {
        expireUserSession();
    }

    @Then("the system prompts the user to re-login")
    public void theSystemPromptsTheUserToReLogin() {
        verifyReLoginPrompt();
    }

    @Given("the user has incorrect credentials")
    public void theUserHasIncorrectCredentials() {
        setIncorrectCredentials();
    }

    @Then("feedback submission fails and user is notified")
    public void feedbackSubmissionFailsAndUserIsNotified() {
        verifyIncorrectCredentialsNotification();
    }

    @Given("it is peak hours")
    public void itIsPeakHours() {
        simulatePeakHours();
    }

    @Then("the system handles feedback submissions efficiently")
    public void theSystemHandlesFeedbackSubmissionsEfficiently() {
        verifyEfficientHandling();
    }

    @When("testing accessibility features")
    public void testingAccessibilityFeatures() {
        testAccessibilityFeatures();
    }

    @Then("accessibility features are functional")
    public void accessibilityFeaturesAreFunctional() {
        verifyAccessibilityFeatures();
    }

    @Given("the user is using an unsupported browser")
    public void theUserIsUsingAnUnsupportedBrowser() {
        setUnsupportedBrowser();
    }

    @Then("the system displays compatibility error message")
    public void theSystemDisplaysCompatibilityErrorMessage() {
        verifyCompatibilityErrorMessage();
    }
}