import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import HelpCenterPage from '../pageObjects/HelpCenterPage';

const helpCenterPage = new HelpCenterPage();

Given('a user navigates to the help center', () => {
  helpCenterPage.navigateToHelpCenter();
});

When('the user views the FAQs section', () => {
  helpCenterPage.viewFAQsSection();
});

Then('the user should see a list of comprehensive FAQs', () => {
  helpCenterPage.verifyFAQsList();
});

Given('a user has an unresolved issue', () => {
  helpCenterPage.ensureUnresolvedIssueExists();
});

When('the user submits a support ticket in the help center', () => {
  helpCenterPage.submitSupportTicket();
});

Then('the user should receive a notification confirming ticket submission', () => {
  helpCenterPage.verifyTicketSubmissionNotification();
});

Given('a user attempts to submit a support ticket', () => {
  helpCenterPage.attemptToSubmitTicket();
});

When('the submission fails due to an error', () => {
  helpCenterPage.simulateSubmissionError();
});

Then('the user should see an error message indicating the failure', () => {
  helpCenterPage.verifyErrorMessage();
});

Given('a user interacts with the help center', () => {
  helpCenterPage.interactWithHelpCenter();
});

When('the user performs actions like viewing FAQs or submitting tickets', () => {
  helpCenterPage.performUserActions();
});

Then('the system should log these interactions for tracking purposes', () => {
  helpCenterPage.verifyInteractionsLogged();
});