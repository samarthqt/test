import { SupportPage } from '../pageObjects/SupportPage';

const supportPage = new SupportPage();

Given('the user is on the customer support page', () => {
  supportPage.navigateToSupportPage();
});

When('the user fills in the contact details and issue description fields', () => {
  supportPage.fillContactDetails();
  supportPage.fillIssueDescription();
});

And('the user submits the ticket form', () => {
  supportPage.submitTicketForm();
});

Then('the user should receive a confirmation email upon ticket submission', () => {
  supportPage.verifyConfirmationEmail();
});

Given('the support staff has access to the ticket management system', () => {
  supportPage.accessTicketManagementSystem();
});

When('a new ticket is submitted', () => {
  supportPage.verifyTicketSubmission();
});

Then('the support staff should be able to view the ticket', () => {
  supportPage.viewSubmittedTicket();
});

And('respond to the ticket within 24 hours', () => {
  supportPage.respondToTicket();
});

Given('the user has submitted a ticket', () => {
  supportPage.verifyTicketSubmission();
});

When('the user navigates to the ticket tracking page', () => {
  supportPage.navigateToTicketTrackingPage();
});

Then('the user should be able to view the status of their submitted ticket', () => {
  supportPage.viewTicketStatus();
});

Given('multiple users are submitting tickets simultaneously', () => {
  supportPage.simulateConcurrentSubmissions();
});

When('the system receives up to 500 concurrent ticket submissions', () => {
  supportPage.verifyConcurrentSubmissionsHandling();
});

Then('the system should handle the submissions without performance issues', () => {
  supportPage.verifyPerformanceUnderLoad();
});