import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import FeedbackPage from '../pageObjects/FeedbackPage';

const feedbackPage = new FeedbackPage();

Given('the user is on the shopping application homepage', () => {
  cy.visit('/homepage');
});

And('the user has completed a purchase', () => {
  // Assume purchase completion logic is handled here
});

When('the user navigates to the customer service section', () => {
  feedbackPage.navigateToCustomerService();
});

Then('the user should see a feedback option', () => {
  feedbackPage.verifyFeedbackOptionVisible();
});

Given('the user is on the feedback form', () => {
  feedbackPage.navigateToFeedbackForm();
});

When('the user enters valid feedback comments', () => {
  feedbackPage.enterFeedbackComments('Great service!');
});

And('the user submits the feedback form', () => {
  feedbackPage.submitFeedbackForm();
});

Then('the user should see a confirmation message that the feedback was submitted successfully', () => {
  feedbackPage.verifyFeedbackSubmissionSuccess();
});

When('the user enters invalid feedback comments', () => {
  feedbackPage.enterFeedbackComments('');
});

Then('the user should see an error message indicating the feedback was not submitted', () => {
  feedbackPage.verifyFeedbackSubmissionError();
});

When('the user submits the feedback form without entering any comments', () => {
  feedbackPage.submitFeedbackForm();
});

Then('the user should see a prompt to enter feedback comments', () => {
  feedbackPage.verifyFeedbackPrompt();
});

Given('the user has previously submitted feedback', () => {
  // Assume feedback submission history exists
});

When('the user navigates to the feedback history section', () => {
  feedbackPage.navigateToFeedbackHistory();
});

Then('the user should see a list of all feedback submissions', () => {
  feedbackPage.verifyFeedbackHistoryVisible();
});

Given('the user is on the feedback history page', () => {
  feedbackPage.navigateToFeedbackHistory();
});

When('the user selects a previously submitted feedback entry', () => {
  feedbackPage.selectFeedbackEntry();
});

And('the user edits the feedback comments', () => {
  feedbackPage.editFeedbackComments('Updated feedback');
});

And('the user submits the updated feedback form', () => {
  feedbackPage.submitFeedbackForm();
});

Then('the user should see a confirmation message that the feedback was updated successfully', () => {
  feedbackPage.verifyFeedbackUpdateSuccess();
});