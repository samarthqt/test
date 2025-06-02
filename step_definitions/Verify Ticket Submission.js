import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TicketPage from "../pages/ticketPage";

Given("the user is logged into the application", () => {
 TicketPage.login();
});

When("the user navigates to the support section of the application", () => {
 TicketPage.navigateToSupportSection();
});

Then("the support section is displayed with ticket submission option", () => {
 TicketPage.verifySupportSectionDisplayed();
});

Given("the user is in the support section", () => {
 TicketPage.verifyInSupportSection();
});

When("the user selects the 'Submit a Ticket' option", () => {
 TicketPage.selectSubmitTicketOption();
});

Then("the ticket submission form is displayed with required fields", () => {
 TicketPage.verifyTicketFormDisplayed();
});

Given("the ticket submission form is displayed", () => {
 TicketPage.verifyTicketFormDisplayed();
});

When("the user fills in the required details in the form", () => {
 TicketPage.fillInTicketDetails();
});

Then("the form accepts input and displays entered details", () => {
 TicketPage.verifyFormInputAccepted();
});

Given("the user has filled in the ticket submission form", () => {
 TicketPage.verifyFormFilled();
});

When("the user attaches relevant documents to the ticket submission", () => {
 TicketPage.attachDocuments();
});

Then("the documents are attached successfully without errors", () => {
 TicketPage.verifyDocumentsAttached();
});

Given("the user has completed the ticket submission form", () => {
 TicketPage.verifyFormCompleted();
});

When("the user submits the ticket", () => {
 TicketPage.submitTicket();
});

Then("the ticket is submitted successfully and confirmation message is displayed", () => {
 TicketPage.verifyTicketSubmissionSuccessful();
});

Given("the ticket is submitted successfully", () => {
 TicketPage.verifyTicketSubmissionSuccessful();
});

When("the user checks their email", () => {
 TicketPage.checkEmail();
});

Then("a confirmation email is received with ticket details", () => {
 TicketPage.verifyConfirmationEmailReceived();
});

Given("the user is submitting a ticket", () => {
 TicketPage.startTicketSubmission();
});

When("the user completes the submission process", () => {
 TicketPage.completeSubmissionProcess();
});

Then("no error messages are displayed", () => {
 TicketPage.verifyNoErrorMessages();
});

Given("the user is filling in the ticket submission form", () => {
 TicketPage.startFillingForm();
});

When("the user attempts to submit the form with incomplete details", () => {
 TicketPage.submitIncompleteForm();
});

Then("the system prompts for missing required fields", () => {
 TicketPage.verifyMissingFieldsPrompt();
});

Given("the user is accessing the application on a mobile device", () => {
 TicketPage.accessOnMobileDevice();
});

When("the user navigates to the support section and selects 'Submit a Ticket'", () => {
 TicketPage.navigateAndSelectOnMobile();
});

Then("the ticket submission form is accessible and functional on mobile devices", () => {
 TicketPage.verifyFormOnMobile();
});

Given("the user has submitted a ticket", () => {
 TicketPage.verifyTicketSubmissionSuccessful();
});

When("the system processes the ticket", () => {
 TicketPage.processTicket();
});

Then("the submitted tickets are recorded in CRM systems for future reference", () => {
 TicketPage.verifyTicketLoggedInCRM();
});

Given("the user is accessing the application on different browsers", () => {
 TicketPage.accessOnDifferentBrowsers();
});

When("the user navigates to the ticket submission form", () => {
 TicketPage.navigateToTicketForm();
});

Then("the ticket system functions correctly across different browsers", () => {
 TicketPage.verifyBrowserCompatibility();
});

Given("the user submits a ticket", () => {
 TicketPage.submitTicket();
});

When("the system processes the ticket", () => {
 TicketPage.processTicket();
});

Then("the ticket system processes submissions within expected time frame", () => {
 TicketPage.verifyResponseTime();
});

Given("the system is experiencing peak times", () => {
 TicketPage.simulatePeakTimes();
});

When("the user submits a ticket", () => {
 TicketPage.submitTicket();
});

Then("the system handles ticket submissions without performance degradation", () => {
 TicketPage.verifyPeakPerformance();
});

Given("the user has submitted a ticket", () => {
 TicketPage.verifyTicketSubmissionSuccessful();
});

When("the user accesses the ticket status section", () => {
 TicketPage.accessTicketStatus();
});

Then("users can access and view the status of their submitted tickets", () => {
 TicketPage.verifyTicketStatusViewable();
});

Given("the user is submitting multiple tickets", () => {
 TicketPage.startMultipleTicketSubmission();
});

When("the user submits the tickets simultaneously", () => {
 TicketPage.submitMultipleTickets();
});

Then("the system processes multiple ticket submissions without errors", () => {
 TicketPage.verifyMultipleSubmissionSuccess();
});