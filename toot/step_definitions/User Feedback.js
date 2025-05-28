import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import FeedbackPage from "../pages/feedbackPage";

Given("the user is on the shopping application homepage", () => {
 FeedbackPage.visitHomepage();
});

Given("the user has completed a purchase", () => {
 FeedbackPage.completePurchase();
});

When("the user navigates to the customer service section", () => {
 FeedbackPage.navigateToCustomerService();
});

Then("the user should see a feedback option", () => {
 FeedbackPage.verifyFeedbackOption();
});

Given("the user is on the feedback form", () => {
 FeedbackPage.visitFeedbackForm();
});

When("the user enters valid feedback comments", () => {
 FeedbackPage.enterFeedbackComments("Great service!");
});

When("the user submits the feedback form", () => {
 FeedbackPage.submitFeedbackForm();
});

Then("the user should see a confirmation message that the feedback was submitted successfully", () => {
 FeedbackPage.verifyFeedbackSubmissionSuccess();
});

When("the user enters invalid feedback comments", () => {
 FeedbackPage.enterFeedbackComments("");
});

Then("the user should see an error message indicating the feedback was not submitted", () => {
 FeedbackPage.verifyFeedbackSubmissionError();
});

When("the user submits the feedback form without entering any comments", () => {
 FeedbackPage.submitFeedbackFormWithoutComments();
});

Then("the user should see a prompt to enter feedback comments", () => {
 FeedbackPage.verifyPromptToEnterComments();
});

Given("the user has previously submitted feedback", () => {
 FeedbackPage.submitPreviousFeedback();
});

When("the user navigates to the feedback history section", () => {
 FeedbackPage.navigateToFeedbackHistory();
});

Then("the user should see a list of all feedback submissions", () => {
 FeedbackPage.verifyFeedbackHistoryList();
});

Given("the user is on the feedback history page", () => {
 FeedbackPage.visitFeedbackHistoryPage();
});

When("the user selects a previously submitted feedback entry", () => {
 FeedbackPage.selectFeedbackEntry();
});

When("the user edits the feedback comments", () => {
 FeedbackPage.editFeedbackComments("Updated feedback");
});

When("the user submits the updated feedback form", () => {
 FeedbackPage.submitUpdatedFeedbackForm();
});

Then("the user should see a confirmation message that the feedback was updated successfully", () => {
 FeedbackPage.verifyFeedbackUpdateSuccess();
});