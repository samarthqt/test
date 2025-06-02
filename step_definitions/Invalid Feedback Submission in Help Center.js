import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HelpCenterPage from "../pages/helpCenterPage";

Given("the user is logged in", () => {
 cy.login();
});

When("the user navigates to the Help Center page", () => {
 HelpCenterPage.visit();
});

Then("the Help Center page is displayed", () => {
 HelpCenterPage.isDisplayed();
});

Given("the user is on the Help Center page", () => {
 HelpCenterPage.visit();
});

When("the user locates the feedback form", () => {
 HelpCenterPage.locateFeedbackForm();
});

Then("the feedback form is visible and accessible", () => {
 HelpCenterPage.isFeedbackFormAccessible();
});

Given("the user has accessed the feedback form", () => {
 HelpCenterPage.accessFeedbackForm();
});

When("the user enters invalid feedback text {string} and submits", (text) => {
 HelpCenterPage.enterFeedbackText(text);
 HelpCenterPage.submitFeedback();
});

Then("the system rejects feedback and displays an error message", () => {
 HelpCenterPage.verifyFeedbackError();
});

Given("feedback submission errors have occurred", () => {
 cy.triggerFeedbackErrors();
});

When("checking the system logs", () => {
 cy.checkSystemLogs();
});

Then("errors are logged appropriately", () => {
 cy.verifyLogsContainErrors();
});

Given("the feedback form is accessible", () => {
 HelpCenterPage.isFeedbackFormAccessible();
});

When("verifying the validation rules", () => {
 HelpCenterPage.verifyValidationRules();
});

Then("validation rules are enforced correctly", () => {
 HelpCenterPage.verifyValidationEnforcement();
});

Given("the user session is invalid", () => {
 cy.invalidateSession();
});

When("attempting feedback submission", () => {
 HelpCenterPage.submitFeedback();
});

Then("feedback submission fails due to session error", () => {
 HelpCenterPage.verifySessionError();
});

Given("the user session has expired", () => {
 cy.expireSession();
});

Then("the system prompts the user to re-login", () => {
 cy.verifyReLoginPrompt();
});

Given("the user has incorrect credentials", () => {
 cy.useIncorrectCredentials();
});

Then("feedback submission fails and user is notified", () => {
 HelpCenterPage.verifyCredentialError();
});

Given("it is peak hours", () => {
 cy.setPeakHours();
});

Then("the system handles feedback submissions efficiently", () => {
 cy.verifyEfficientSubmissionHandling();
});

When("testing accessibility features", () => {
 HelpCenterPage.testAccessibilityFeatures();
});

Then("accessibility features are functional", () => {
 HelpCenterPage.verifyAccessibilityFunctionality();
});

Given("the user is using an unsupported browser", () => {
 cy.useUnsupportedBrowser();
});

Then("the system displays compatibility error message", () => {
 HelpCenterPage.verifyCompatibilityError();
});