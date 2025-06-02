import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import NavigationPage from "../pages/navigationPage";

Given("the application is open", () => {
 NavigationPage.visit();
});

When("the user attempts to navigate using the label {string}", (label) => {
 NavigationPage.navigateWithLabel(label);
});

When("the user attempts to navigate without providing a label", () => {
 NavigationPage.navigateWithoutLabel();
});

When("the user attempts navigation with incorrect labels", () => {
 NavigationPage.attemptIncorrectNavigation();
});

When("the user attempts multiple incorrect navigation attempts", () => {
 NavigationPage.attemptMultipleIncorrectNavigations();
});

When("the user attempts navigation using correct labels {string}, {string}, or {string}", (label1, label2, label3) => {
 NavigationPage.navigateWithCorrectLabels(label1, label2, label3);
});

Then("an error message is displayed indicating incorrect navigation label", () => {
 NavigationPage.verifyIncorrectLabelErrorMessage();
});

Then("an error message is displayed indicating missing navigation label", () => {
 NavigationPage.verifyMissingLabelErrorMessage();
});

Then("errors related to incorrect labels are logged appropriately", () => {
 NavigationPage.verifyErrorLogs();
});

Then("the system prevents navigation and maintains stability", () => {
 NavigationPage.verifySystemStability();
});

Then("the user feedback mechanism provides helpful guidance", () => {
 NavigationPage.verifyUserFeedbackMechanism();
});

Then("the system recovers smoothly from incorrect navigation attempts", () => {
 NavigationPage.verifySystemRecovery();
});

Then("the UI remains stable and informative during incorrect navigation attempts", () => {
 NavigationPage.verifyUIStability();
});

Then("navigation functions as expected", () => {
 NavigationPage.verifyCorrectNavigation();
});

Then("the system effectively guides users to correct navigation paths", () => {
 NavigationPage.verifyGuidanceToCorrectPaths();
});

Then("error messages are clear and provide helpful information", () => {
 NavigationPage.verifyErrorMessageClarity();
});

Then("the system handles these attempts without degradation", () => {
 NavigationPage.verifySystemHandlingOfMultipleAttempts();
});

Then("the UI remains unchanged post-error handling", () => {
 NavigationPage.verifyUIUnchangedPostError();
});

Then("error handling is isolated and does not affect other functionalities", () => {
 NavigationPage.verifyIsolatedErrorHandling();
});