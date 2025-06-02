package com.cucumber.steps;

import com.page_objects.TicketSubmissionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketSubmissionSteps extends TicketSubmissionPage {

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

    @When("the user locates the ticket submission form")
    public void theUserLocatesTheTicketSubmissionForm() {
        locateTicketSubmissionForm();
    }

    @Then("the ticket submission form is visible and accessible")
    public void theTicketSubmissionFormIsVisibleAndAccessible() {
        verifyTicketSubmissionFormAccessible();
    }

    @When("the user enters ticket subject {string}")
    public void theUserEntersTicketSubject(String subject) {
        enterTicketSubject(subject);
    }

    @Then("the ticket subject field is populated with {string}")
    public void theTicketSubjectFieldIsPopulatedWith(String subject) {
        verifyTicketSubjectField(subject);
    }

    @When("the user enters ticket description {string}")
    public void theUserEntersTicketDescription(String description) {
        enterTicketDescription(description);
    }

    @Then("the ticket description field is populated correctly")
    public void theTicketDescriptionFieldIsPopulatedCorrectly() {
        verifyTicketDescriptionField();
    }

    @When("the user selects contact method {string}")
    public void theUserSelectsContactMethod(String method) {
        selectContactMethod(method);
    }

    @Then("the {string} contact method is selected")
    public void theContactMethodIsSelected(String method) {
        verifyContactMethodSelected(method);
    }

    @When("the user submits the ticket")
    public void theUserSubmitsTheTicket() {
        submitTicket();
    }

    @Then("the ticket is submitted successfully")
    public void theTicketIsSubmittedSuccessfully() {
        verifyTicketSubmissionSuccess();
    }

    @Then("the user receives confirmation notification {string}")
    public void theUserReceivesConfirmationNotification(String message) {
        verifyConfirmationNotification(message);
    }

    @Given("the user has submitted a ticket")
    public void theUserHasSubmittedATicket() {
        verifyTicketSubmissionLogged();
    }

    @Then("the ticket submission is logged correctly")
    public void theTicketSubmissionIsLoggedCorrectly() {
        verifyTicketSubmissionLog();
    }

    @Given("the user is on the ticket submission form")
    public void theUserIsOnTheTicketSubmissionForm() {
        verifyOnTicketSubmissionForm();
    }

    @When("the user attempts to submit the form with invalid data")
    public void theUserAttemptsToSubmitTheFormWithInvalidData() {
        attemptSubmitInvalidData();
    }

    @Then("validation rules are enforced correctly")
    public void validationRulesAreEnforcedCorrectly() {
        verifyValidationRules();
    }

    @Given("the user has an invalid session")
    public void theUserHasAnInvalidSession() {
        verifyInvalidSession();
    }

    @When("the user attempts to submit a ticket")
    public void theUserAttemptsToSubmitATicket() {
        attemptSubmitTicket();
    }

    @Then("the ticket submission fails due to session error")
    public void theTicketSubmissionFailsDueToSessionError() {
        verifySessionError();
    }

    @Given("the user session has expired")
    public void theUserSessionHasExpired() {
        verifySessionExpired();
    }

    @Then("the system prompts the user to re-login")
    public void theSystemPromptsTheUserToReLogin() {
        verifyReLoginPrompt();
    }

    @Given("the user has incorrect credentials")
    public void theUserHasIncorrectCredentials() {
        verifyIncorrectCredentials();
    }

    @Then("the ticket submission fails and the user is notified")
    public void theTicketSubmissionFailsAndTheUserIsNotified() {
        verifySubmissionFailureNotification();
    }

    @Given("the system is operating during peak hours")
    public void theSystemIsOperatingDuringPeakHours() {
        verifyPeakHoursOperation();
    }

    @Then("the system handles ticket submissions efficiently")
    public void theSystemHandlesTicketSubmissionsEfficiently() {
        verifyEfficientHandling();
    }

    @When("the user checks accessibility features")
    public void theUserChecksAccessibilityFeatures() {
        checkAccessibilityFeatures();
    }

    @Then("accessibility features are functional")
    public void accessibilityFeaturesAreFunctional() {
        verifyAccessibilityFeatures();
    }
}