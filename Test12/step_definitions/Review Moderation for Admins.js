import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ReviewModerationPage from "../pages/reviewModerationPage";

Given("the admin is logged into the dashboard", () => {
 ReviewModerationPage.login();
});

When("the admin navigates to the review moderation section", () => {
 ReviewModerationPage.navigateToModerationSection();
});

Then("the admin should see a list of all product reviews", () => {
 ReviewModerationPage.verifyListOfReviews();
});

Given("the admin is on the review moderation page", () => {
 ReviewModerationPage.visitModerationPage();
});

When("the admin selects a review to moderate", () => {
 ReviewModerationPage.selectReviewToModerate();
});

Then("the admin should have the option to approve or reject the review", () => {
 ReviewModerationPage.verifyApproveRejectOptions();
});

Given("an admin attempts to access the review moderation section", () => {
 ReviewModerationPage.attemptAccessToModerationSection();
});

When("the admin's credentials are verified", () => {
 ReviewModerationPage.verifyCredentials();
});

Then("only authorized admins should be granted access", () => {
 ReviewModerationPage.verifyAuthorizedAccess();
});

Given("the admin is moderating a review", () => {
 ReviewModerationPage.startModeratingReview();
});

When("an error occurs during the moderation process", () => {
 ReviewModerationPage.simulateError();
});

Then("the system should display an appropriate error message", () => {
 ReviewModerationPage.verifyErrorMessage();
});

Given("the admin is using a desktop or mobile platform", () => {
 ReviewModerationPage.verifyPlatform();
});

When("the admin accesses the review moderation section", () => {
 ReviewModerationPage.accessModerationSection();
});

Then("the moderation functionality should be fully available", () => {
 ReviewModerationPage.verifyModerationFunctionality();
});

Given("the admin moderates a review", () => {
 ReviewModerationPage.moderateReview();
});

When("the moderation action is completed", () => {
 ReviewModerationPage.completeModerationAction();
});

Then("the system should log the action for auditing", () => {
 ReviewModerationPage.verifyActionLogged();
});

Given("the admin approves or rejects a review", () => {
 ReviewModerationPage.approveOrRejectReview();
});

When("the action is processed", () => {
 ReviewModerationPage.processAction();
});

Then("the review status should be accurately updated in the product database", () => {
 ReviewModerationPage.verifyDatabaseUpdate();
});

Given("the admin performs a moderation action", () => {
 ReviewModerationPage.performModerationAction();
});

When("the action is initiated", () => {
 ReviewModerationPage.initiateAction();
});

Then("the action should be processed within 3 seconds", () => {
 ReviewModerationPage.verifyActionPerformance();
});

Given("a new product review is submitted", () => {
 ReviewModerationPage.submitNewReview();
});

When("the review enters the moderation queue", () => {
 ReviewModerationPage.enterModerationQueue();
});

Then("the system should notify the admin of the new review", () => {
 ReviewModerationPage.verifyNotification();
});

Given("the admin is moderating reviews", () => {
 ReviewModerationPage.startModeratingReviews();
});

When("the admin navigates through the moderation process", () => {
 ReviewModerationPage.navigateModerationProcess();
});

Then("the experience should be seamless and intuitive", () => {
 ReviewModerationPage.verifyUserExperience();
});