import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingPage from "../pages/trackingPage";

Given("the user has access to the tracking feature with User ID {string}", (userId) => {
  // Assume user session is set up with the given User ID
  cy.setUserSession(userId);
});

When("the user navigates to the tracking page", () => {
  TrackingPage.visit();
});

Then("the tracking page is displayed", () => {
  TrackingPage.verifyPageDisplayed();
});

Given("the user is on the tracking page", () => {
  TrackingPage.verifyPageDisplayed();
});

When("the user enters an invalid tracking number {string}", (trackingNumber) => {
  TrackingPage.enterTrackingNumber(trackingNumber);
});

Then("the system displays an error message indicating tracking information is unavailable", () => {
  TrackingPage.verifyErrorMessage("Tracking information is unavailable");
});

Given("the user has entered an invalid tracking number {string}", (trackingNumber) => {
  TrackingPage.enterTrackingNumber(trackingNumber);
});

When("the error message is displayed", () => {
  TrackingPage.verifyErrorMessageDisplayed();
});

Then("the error message is clear and suggests alternative actions", () => {
  TrackingPage.verifyErrorMessageContent("Please check the tracking number and try again.");
});

Given("the user is on the tracking page with an error message displayed", () => {
  TrackingPage.verifyPageDisplayed();
  TrackingPage.verifyErrorMessageDisplayed();
});

When("the user attempts to refresh the tracking page", () => {
  cy.reload();
});

Then("the system handles the refresh gracefully without crashing", () => {
  TrackingPage.verifyPageDisplayed();
});

Given("an error message is displayed for unavailable tracking information", () => {
  TrackingPage.verifyErrorMessageDisplayed();
});

When("the error occurs", () => {
  // Simulate error occurrence
});

Then("the error is logged in the system logs", () => {
  cy.verifyLogEntry("Tracking information unavailable error");
});

Given("the user has entered an invalid tracking number", () => {
  TrackingPage.enterTrackingNumber("00000");
});

When("the user decides to retry entering a tracking number", () => {
  TrackingPage.clearTrackingNumberField();
});

Then("the user is allowed to retry entering a tracking number", () => {
  TrackingPage.enterTrackingNumber("12345");
  TrackingPage.verifyTrackingInformationDisplayed();
});

Given("the user is retrieving tracking information", () => {
  TrackingPage.enterTrackingNumber("12345");
});

When("a network failure occurs", () => {
  cy.simulateNetworkFailure();
});

Then("the system displays a network error message and suggests retrying", () => {
  TrackingPage.verifyNetworkErrorMessage("Network error occurred. Please try again.");
});

Given("the tracking service is down", () => {
  cy.simulateServiceDown();
});

When("the user attempts to retrieve tracking information", () => {
  TrackingPage.enterTrackingNumber("12345");
});

Then("the system displays a service unavailable message", () => {
  TrackingPage.verifyServiceUnavailableMessage("Service is currently unavailable.");
});

Given("the system is under high load", () => {
  cy.simulateHighLoad();
});

When("the user attempts to access tracking information", () => {
  TrackingPage.enterTrackingNumber("12345");
});

Then("system performance remains stable and handles errors gracefully", () => {
  TrackingPage.verifyTrackingInformationDisplayed();
});

Given("the tracking service was down", () => {
  cy.simulateServiceDown();
});

When("the tracking service resumes", () => {
  cy.simulateServiceResume();
});

Then("tracking information is displayed correctly once the service resumes", () => {
  TrackingPage.verifyTrackingInformationDisplayed();
});

Given("the tracking service is currently unavailable", () => {
  cy.simulateServiceDown();
});

When("the user reads the error message", () => {
  TrackingPage.verifyErrorMessageDisplayed();
});

Then("estimated recovery time is displayed in the error message", () => {
  TrackingPage.verifyErrorMessageContent("Estimated recovery time: 2 hours");
});

Given("the user enters an invalid tracking format", () => {
  TrackingPage.enterTrackingNumber("invalidFormat");
});

When("the tracking number is submitted", () => {
  TrackingPage.submitTrackingNumber();
});

Then("the system displays an error message for invalid tracking formats", () => {
  TrackingPage.verifyErrorMessage("Invalid tracking format");
});

Given("the user has experienced an error", () => {
  TrackingPage.verifyErrorMessageDisplayed();
});

When("the error message is displayed", () => {
  TrackingPage.verifyErrorMessageDisplayed();
});

Then("the user is prompted to provide feedback on the error handling experience", () => {
  TrackingPage.verifyFeedbackPromptDisplayed();
});