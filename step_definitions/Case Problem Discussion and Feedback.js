import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import DiscussionPage from '../pageObjects/DiscussionPage';

const discussionPage = new DiscussionPage();

Given('the player is logged into the system', () => {
  cy.login();
});

Given('the player has completed a case problem', () => {
  cy.completeCaseProblem();
});

When('the player navigates to the discussion section', () => {
  discussionPage.navigateToDiscussionSection();
});

When('the player initiates a discussion on their case problem-solving approach', () => {
  discussionPage.initiateDiscussion();
});

Then('the system should allow the player to post their discussion', () => {
  discussionPage.verifyDiscussionPostAllowed();
});

Given('the player has posted a discussion on their case problem-solving approach', () => {
  discussionPage.postDiscussion();
});

When('other players or mentors view the discussion', () => {
  discussionPage.viewDiscussion();
});

When('they provide feedback on the player's approach', () => {
  discussionPage.provideFeedback();
});

Then('the player should receive notifications of feedback', () => {
  discussionPage.verifyFeedbackNotification();
});

Then('the feedback should be visible in the discussion thread', () => {
  discussionPage.verifyFeedbackVisible();
});

Given('the player has received feedback on their case problem-solving discussion', () => {
  discussionPage.receiveFeedback();
});

When('the player reviews the feedback', () => {
  discussionPage.reviewFeedback();
});

When('the player decides to update their problem-solving approach based on the feedback', () => {
  discussionPage.updateApproach();
});

Then('the player should be able to post an updated approach in the discussion thread', () => {
  discussionPage.verifyUpdatedApproachPost();
});

Then('the updated approach should be visible to other players and mentors', () => {
  discussionPage.verifyUpdatedApproachVisible();
});

Given('the player has received multiple feedback entries', () => {
  discussionPage.receiveMultipleFeedback();
});

When('the player finds a feedback entry helpful', () => {
  discussionPage.findHelpfulFeedback();
});

Then('the player should be able to mark the feedback as helpful', () => {
  discussionPage.markFeedbackHelpful();
});

Then('the feedback should be highlighted as helpful in the discussion thread', () => {
  discussionPage.verifyFeedbackHighlighted();
});

Given('the player has received feedback on multiple discussions', () => {
  discussionPage.receiveMultipleDiscussionFeedback();
});

When('the player navigates to the feedback summary section', () => {
  discussionPage.navigateToFeedbackSummary();
});

Then('the player should see a summary of all feedback received', () => {
  discussionPage.verifyFeedbackSummary();
});

Then('the summary should include feedback statistics such as most helpful feedback and feedback trends', () => {
  discussionPage.verifyFeedbackStatistics();
});