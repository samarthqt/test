package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.TicketSubmissionPage;

public class TicketSubmissionSteps extends TicketSubmissionPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the support section of the application")
    public void theUserNavigatesToTheSupportSection() {
        navigateToSupportSection();
    }

    @Then("the support section is displayed with ticket submission option")
    public void theSupportSectionIsDisplayed() {
        verifySupportSectionDisplayed();
    }

    @Given("the user is on the support section")
    public void theUserIsOnTheSupportSection() {
        verifySupportSectionDisplayed();
    }

    @When("the user selects the 'Submit a Ticket' option")
    public void theUserSelectsSubmitATicketOption() {
        selectSubmitTicketOption();
    }

    @Then("the ticket submission form is displayed with required fields")
    public void theTicketSubmissionFormIsDisplayed() {
        verifyTicketSubmissionFormDisplayed();
    }

    @Given("the ticket submission form is displayed")
    public void theTicketSubmissionFormIsDisplayedAgain() {
        verifyTicketSubmissionFormDisplayed();
    }

    @When("the user leaves required fields blank and attempts to submit the ticket")
    public void theUserLeavesRequiredFieldsBlank() {
        submitTicketWithBlankFields();
    }

    @Then("the system prevents submission and displays error messages for missing fields")
    public void theSystemPreventsSubmission() {
        verifyErrorMessagesForMissingFields();
    }

    @When("the user enters invalid data in the ticket submission form")
    public void theUserEntersInvalidData() {
        enterInvalidDataInForm();
    }

    @Then("the system validates input and displays error messages for invalid data")
    public void theSystemValidatesInput() {
        verifyErrorMessagesForInvalidData();
    }

    @When("the user attempts to submit a ticket without attaching required documents")
    public void theUserSubmitsWithoutDocuments() {
        submitTicketWithoutDocuments();
    }

    @Then("the system prompts for missing attachments")
    public void theSystemPromptsForAttachments() {
        verifyPromptForMissingAttachments();
    }

    @When("the user attempts to submit the ticket")
    public void theUserAttemptsToSubmitTheTicket() {
        attemptToSubmitTicket();
    }

    @Then("error messages are displayed for missing or invalid data")
    public void errorMessagesAreDisplayed() {
        verifyErrorMessagesForSubmission();
    }

    @Given("the user is on a mobile device")
    public void theUserIsOnAMobileDevice() {
        verifyMobileDeviceView();
    }

    @When("the user attempts to submit a ticket with incomplete details")
    public void theUserSubmitsIncompleteDetails() {
        submitTicketWithIncompleteDetails();
    }

    @Then("error handling messages are displayed correctly on mobile devices")
    public void errorMessagesOnMobile() {
        verifyErrorMessagesOnMobile();
    }

    @When("the user enters an incorrect email format and submits the ticket")
    public void theUserEntersIncorrectEmail() {
        enterIncorrectEmailFormat();
    }

    @Then("the system displays error message for invalid email format")
    public void errorMessageForInvalidEmail() {
        verifyErrorMessageForInvalidEmail();
    }

    @When("the user attempts to submit a ticket during peak times")
    public void theUserSubmitsDuringPeakTimes() {
        submitTicketDuringPeakTimes();
    }

    @Then("the system maintains error handling consistency during peak times")
    public void errorHandlingDuringPeakTimes() {
        verifyErrorHandlingDuringPeakTimes();
    }

    @When("the user encounters an error during ticket submission")
    public void theUserEncountersError() {
        encounterErrorDuringSubmission();
    }

    @Then("error instances are recorded in CRM systems")
    public void errorInstancesRecorded() {
        verifyErrorInstancesRecorded();
    }

    @When("the user submits a ticket with incomplete details")
    public void theUserSubmitsIncompleteTicket() {
        submitIncompleteTicket();
    }

    @Then("users receive prompt feedback for incomplete submissions")
    public void feedbackForIncompleteSubmissions() {
        verifyFeedbackForIncompleteSubmissions();
    }

    @When("the user attempts to submit a ticket with unsupported file formats")
    public void theUserSubmitsUnsupportedFiles() {
        submitTicketWithUnsupportedFiles();
    }

    @Then("the system displays error message for unsupported file formats")
    public void errorMessageForUnsupportedFiles() {
        verifyErrorMessageForUnsupportedFiles();
    }

    @When("there is a network interruption during ticket submission")
    public void networkInterruptionDuringSubmission() {
        simulateNetworkInterruption();
    }

    @Then("the system displays appropriate error messages for network issues")
    public void errorMessagesForNetworkIssues() {
        verifyErrorMessagesForNetworkIssues();
    }

    @Then("error messages provide clear and informative feedback to users")
    public void clearAndInformativeErrorMessages() {
        verifyClearAndInformativeErrorMessages();
    }
}