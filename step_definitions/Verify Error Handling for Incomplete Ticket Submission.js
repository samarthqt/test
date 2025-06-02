import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SupportPage from "../pages/supportPage";

Given("the user is logged into the application", () => {
 cy.login();
});

When("the user navigates to the support section of the application", () => {
 SupportPage.navigateToSupportSection();
});

Then("the support section is displayed with ticket submission option", () => {
 SupportPage.verifySupportSectionDisplayed();
});

Given("the user is on the support section", () => {
 SupportPage.verifySupportSectionDisplayed();
});

When("the user selects the 'Submit a Ticket' option", () => {
 SupportPage.selectSubmitTicketOption();
});

Then("the ticket submission form is displayed with required fields", () => {
 SupportPage.verifyTicketFormDisplayed();
});

Given("the ticket submission form is displayed", () => {
 SupportPage.verifyTicketFormDisplayed();
});

When("the user leaves required fields blank and attempts to submit the ticket", () => {
 SupportPage.submitTicketWithBlankFields();
});

Then("the system prevents submission and displays error messages for missing fields", () => {
 SupportPage.verifyErrorMessagesForMissingFields();
});

When("the user enters invalid data in the ticket submission form", () => {
 SupportPage.enterInvalidDataInTicketForm();
});

Then("the system validates input and displays error messages for invalid data", () => {
 SupportPage.verifyErrorMessagesForInvalidData();
});

When("the user attempts to submit a ticket without attaching required documents", () => {
 SupportPage.submitTicketWithoutAttachments();
});

Then("the system prompts for missing attachments", () => {
 SupportPage.verifyPromptForMissingAttachments();
});

When("the user attempts to submit the ticket", () => {
 SupportPage.submitTicket();
});

Then("error messages are displayed for missing or invalid data", () => {
 SupportPage.verifyErrorMessagesForSubmission();
});

Given("the user is on a mobile device", () => {
 cy.viewport('iphone-x');
});

When("the user attempts to submit a ticket with incomplete details", () => {
 SupportPage.submitTicketWithIncompleteDetails();
});

Then("error handling messages are displayed correctly on mobile devices", () => {
 SupportPage.verifyErrorMessagesOnMobile();
});

When("the user enters an incorrect email format and submits the ticket", () => {
 SupportPage.enterIncorrectEmailFormat();
});

Then("the system displays error message for invalid email format", () => {
 SupportPage.verifyErrorMessageForInvalidEmail();
});

When("the user attempts to submit a ticket during peak times", () => {
 SupportPage.submitTicketDuringPeakTimes();
});

Then("the system maintains error handling consistency during peak times", () => {
 SupportPage.verifyErrorHandlingDuringPeakTimes();
});

When("the user encounters an error during ticket submission", () => {
 SupportPage.simulateErrorDuringSubmission();
});

Then("error instances are recorded in CRM systems", () => {
 SupportPage.verifyErrorLoggingInCRM();
});

When("the user submits a ticket with incomplete details", () => {
 SupportPage.submitTicketWithIncompleteDetails();
});

Then("users receive prompt feedback for incomplete submissions", () => {
 SupportPage.verifyFeedbackForIncompleteSubmission();
});

When("the user attempts to submit a ticket with unsupported file formats", () => {
 SupportPage.submitTicketWithUnsupportedFormats();
});

Then("the system displays error message for unsupported file formats", () => {
 SupportPage.verifyErrorMessageForUnsupportedFormats();
});

When("there is a network interruption during ticket submission", () => {
 SupportPage.simulateNetworkInterruption();
});

Then("the system displays appropriate error messages for network issues", () => {
 SupportPage.verifyErrorMessagesForNetworkIssues();
});

When("the user encounters an error during ticket submission", () => {
 SupportPage.simulateErrorDuringSubmission();
});

Then("error messages provide clear and informative feedback to users", () => {
 SupportPage.verifyClearErrorMessages();
});