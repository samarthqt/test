import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TicketSubmissionPage from "../pages/ticketSubmissionPage";

Given("the user has access to the ticket submission system", () => {
 TicketSubmissionPage.visit();
});

When("the user navigates to the ticket submission page", () => {
 TicketSubmissionPage.navigate();
});

Then("the ticket submission page loads successfully", () => {
 TicketSubmissionPage.verifyPageLoad();
});

When("the user enters the ticket ID {string} and user ID {string}", (ticketId, userId) => {
 TicketSubmissionPage.enterTicketId(ticketId);
 TicketSubmissionPage.enterUserId(userId);
});

And("leaves the 'Description' field empty", () => {
 TicketSubmissionPage.leaveDescriptionEmpty();
});

When("the user attempts to submit the ticket", () => {
 TicketSubmissionPage.submitTicket();
});

Then("the system displays an error message indicating that the 'Description' field is required", () => {
 TicketSubmissionPage.verifyDescriptionError();
});

And("error logs are generated indicating a submission attempt with missing information", () => {
 TicketSubmissionPage.verifyErrorLogs();
});

And("the system does not accept the ticket submission", () => {
 TicketSubmissionPage.verifySubmissionNotAccepted();
});

And("the user is prompted to correct the missing information", () => {
 TicketSubmissionPage.verifyPromptForCorrection();
});

When("the user enters a valid description and resubmits the ticket", () => {
 TicketSubmissionPage.enterValidDescription();
 TicketSubmissionPage.resubmitTicket();
});

Then("the ticket is successfully submitted with all required fields completed", () => {
 TicketSubmissionPage.verifySuccessfulSubmission();
});

And("the ticket appears in the system with a status indicating successful submission", () => {
 TicketSubmissionPage.verifyTicketStatus();
});

And("the user receives confirmation of the ticket submission", () => {
 TicketSubmissionPage.verifySubmissionConfirmation();
});

When("the user attempts to submit another ticket with a different missing field", () => {
 TicketSubmissionPage.submitWithDifferentMissingField();
});

Then("the system displays an error message indicating the missing field is required", () => {
 TicketSubmissionPage.verifyDifferentFieldError();
});

When("the user attempts to submit a ticket", () => {
 TicketSubmissionPage.submitTicket();
});

Then("the system responds promptly to the submission attempt", () => {
 TicketSubmissionPage.verifyPromptResponse();
});

Then("the system handles the submission process efficiently without performance degradation", () => {
 TicketSubmissionPage.verifyEfficientHandling();
});

When("the user attempts multiple submissions with missing information", () => {
 TicketSubmissionPage.submitMultipleWithMissingInfo();
});

Then("the system consistently prompts for missing information across multiple submission attempts", () => {
 TicketSubmissionPage.verifyConsistentPrompts();
});

Then("all submission attempts are logged, including those with missing information", () => {
 TicketSubmissionPage.verifyLoggingOfAttempts();
});