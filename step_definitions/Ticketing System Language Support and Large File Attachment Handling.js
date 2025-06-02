import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TicketingPage from "../pages/ticketingPage";

Given("the user has access to the ticketing system", () => {
 TicketingPage.visit();
});

When("the user navigates to the ticket submission page", () => {
 TicketingPage.navigateToSubmissionPage();
});

Then("the ticket submission page loads successfully", () => {
 TicketingPage.verifySubmissionPageLoaded();
});

Given("the ticket submission page is loaded", () => {
 TicketingPage.verifySubmissionPageLoaded();
});

When("the user selects the language preference as French", () => {
 TicketingPage.selectLanguage('French');
});

Then("the system interface changes to French language", () => {
 TicketingPage.verifyLanguageChange('French');
});

Given("the system interface is in French language", () => {
 TicketingPage.verifyLanguageChange('French');
});

When("the user enters ticket details in French", () => {
 TicketingPage.enterTicketDetails('French');
});

Then("the ticket details are entered in French", () => {
 TicketingPage.verifyTicketDetailsLanguage('French');
});

Given("the ticket details are entered in French", () => {
 TicketingPage.verifyTicketDetailsLanguage('French');
});

When("the user attaches a large file of 50MB to the ticket submission", () => {
 TicketingPage.attachFile('largeFile50MB');
});

Then("the system accepts the large file without error", () => {
 TicketingPage.verifyFileAttachment('largeFile50MB');
});

Given("the large file is attached to the ticket", () => {
 TicketingPage.verifyFileAttachment('largeFile50MB');
});

When("the user submits the ticket with the attached file", () => {
 TicketingPage.submitTicket();
});

Then("the ticket is submitted successfully with the large file attachment", () => {
 TicketingPage.verifySuccessfulSubmission();
});

Given("the ticket is submitted successfully", () => {
 TicketingPage.verifySuccessfulSubmission();
});

When("the system generates a confirmation message", () => {
 TicketingPage.generateConfirmationMessage();
});

Then("the confirmation message is displayed in French", () => {
 TicketingPage.verifyConfirmationMessageLanguage('French');
});

Given("the ticket is submitted", () => {
 TicketingPage.verifyTicketSubmission();
});

When("the user checks the ticket status in the system", () => {
 TicketingPage.checkTicketStatus();
});

Then("the ticket appears in the system with a status indicating successful submission", () => {
 TicketingPage.verifyTicketStatus();
});

Given("the ticket is submitted with an attachment", () => {
 TicketingPage.verifyFileAttachment('largeFile50MB');
});

When("the user attempts to retrieve the attached file", () => {
 TicketingPage.retrieveAttachedFile();
});

Then("the attached file can be retrieved and viewed successfully", () => {
 TicketingPage.verifyFileRetrieval();
});

When("the system logs the submission details", () => {
 TicketingPage.logSubmissionDetails();
});

Then("the system logs include the language preference and file attachment details", () => {
 TicketingPage.verifyLogDetails();
});

Given("the user has completed a ticket submission", () => {
 TicketingPage.verifySuccessfulSubmission();
});

When("the user attempts to submit another ticket in Spanish language", () => {
 TicketingPage.selectLanguage('Spanish');
});

Then("the system interface changes to Spanish language successfully", () => {
 TicketingPage.verifyLanguageChange('Spanish');
});

Given("the system interface is in Spanish language", () => {
 TicketingPage.verifyLanguageChange('Spanish');
});

When("the user attaches a different large file of 75MB to the ticket submission", () => {
 TicketingPage.attachFile('largeFile75MB');
});

Then("the system accepts the 75MB file without error", () => {
 TicketingPage.verifyFileAttachment('largeFile75MB');
});

Given("the new file is attached to the ticket", () => {
 TicketingPage.verifyFileAttachment('largeFile75MB');
});

When("the user submits the ticket with the new file attachment", () => {
 TicketingPage.submitTicket();
});

Then("the ticket is submitted successfully with the new file attachment", () => {
 TicketingPage.verifySuccessfulSubmission();
});

Given("the ticket is submitted in Spanish", () => {
 TicketingPage.verifyLanguageChange('Spanish');
});

When("the user retrieves the ticket", () => {
 TicketingPage.retrieveTicket();
});

Then("the system displays ticket details in the selected language during retrieval", () => {
 TicketingPage.verifyTicketDetailsLanguage('Spanish');
});

Given("large files are being attached to tickets", () => {
 TicketingPage.attachFile('largeFile50MB');
 TicketingPage.attachFile('largeFile75MB');
});

When("the user observes the system performance", () => {
 TicketingPage.observePerformance();
});

Then("the system handles large file attachments efficiently without performance degradation", () => {
 TicketingPage.verifyPerformance();
});

Given("the user has submitted tickets in multiple languages", () => {
 TicketingPage.verifyTicketSubmission();
});

When("the user switches language preferences", () => {
 TicketingPage.switchLanguagePreferences();
});

Then("language switching does not affect the integrity of the ticket data", () => {
 TicketingPage.verifyDataIntegrity();
});