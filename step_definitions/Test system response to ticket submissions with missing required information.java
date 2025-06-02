package com.cucumber.steps;

import com.page_objects.TicketSubmissionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketSubmissionSteps extends TicketSubmissionPage {

    @Given("the user has access to the ticket submission system")
    public void theUserHasAccessToTheTicketSubmissionSystem() {
        verifyUserAccess();
    }

    @When("the user navigates to the ticket submission page")
    public void theUserNavigatesToTheTicketSubmissionPage() {
        navigateToSubmissionPage();
    }

    @Then("the ticket submission page loads successfully")
    public void theTicketSubmissionPageLoadsSuccessfully() {
        verifyPageLoad();
    }

    @Then("the user enters the ticket ID {string} and user ID {string}")
    public void theUserEntersTheTicketIDAndUserID(String ticketID, String userID) {
        enterTicketDetails(ticketID, userID);
    }

    @Then("leaves the 'Description' field empty")
    public void leavesTheDescriptionFieldEmpty() {
        leaveDescriptionEmpty();
    }

    @When("the user attempts to submit the ticket")
    public void theUserAttemptsToSubmitTheTicket() {
        submitTicket();
    }

    @Then("the system displays an error message indicating that the 'Description' field is required")
    public void theSystemDisplaysAnErrorMessageIndicatingThatTheDescriptionFieldIsRequired() {
        verifyDescriptionErrorMessage();
    }

    @Then("error logs are generated indicating a submission attempt with missing information")
    public void errorLogsAreGeneratedIndicatingASubmissionAttemptWithMissingInformation() {
        verifyErrorLogs();
    }

    @Then("the system does not accept the ticket submission")
    public void theSystemDoesNotAcceptTheTicketSubmission() {
        verifySubmissionNotAccepted();
    }

    @Then("the user is prompted to correct the missing information")
    public void theUserIsPromptedToCorrectTheMissingInformation() {
        verifyPromptForCorrection();
    }

    @When("the user enters a valid description and resubmits the ticket")
    public void theUserEntersAValidDescriptionAndResubmitsTheTicket() {
        enterValidDescriptionAndResubmit();
    }

    @Then("the ticket is successfully submitted with all required fields completed")
    public void theTicketIsSuccessfullySubmittedWithAllRequiredFieldsCompleted() {
        verifySuccessfulSubmission();
    }

    @Then("the ticket appears in the system with a status indicating successful submission")
    public void theTicketAppearsInTheSystemWithAStatusIndicatingSuccessfulSubmission() {
        verifyTicketStatus();
    }

    @Then("the user receives confirmation of the ticket submission")
    public void theUserReceivesConfirmationOfTheTicketSubmission() {
        verifySubmissionConfirmation();
    }

    @When("the user attempts to submit another ticket with a different missing field")
    public void theUserAttemptsToSubmitAnotherTicketWithADifferentMissingField() {
        submitTicketWithDifferentMissingField();
    }

    @Then("the system displays an error message indicating the missing field is required")
    public void theSystemDisplaysAnErrorMessageIndicatingTheMissingFieldIsRequired() {
        verifyMissingFieldErrorMessage();
    }

    @When("the user attempts to submit a ticket")
    public void theUserAttemptsToSubmitATicket() {
        attemptTicketSubmission();
    }

    @Then("the system responds promptly to the submission attempt")
    public void theSystemRespondsPromptlyToTheSubmissionAttempt() {
        verifyPromptResponse();
    }

    @Then("the system handles the submission process efficiently without performance degradation")
    public void theSystemHandlesTheSubmissionProcessEfficientlyWithoutPerformanceDegradation() {
        verifyEfficientSubmissionHandling();
    }

    @When("the user attempts multiple submissions with missing information")
    public void theUserAttemptsMultipleSubmissionsWithMissingInformation() {
        attemptMultipleSubmissionsWithMissingInfo();
    }

    @Then("the system consistently prompts for missing information across multiple submission attempts")
    public void theSystemConsistentlyPromptsForMissingInformationAcrossMultipleSubmissionAttempts() {
        verifyConsistentPromptsForMissingInfo();
    }

    @Then("all submission attempts are logged, including those with missing information")
    public void allSubmissionAttemptsAreLoggedIncludingThoseWithMissingInformation() {
        verifySubmissionLogging();
    }
}