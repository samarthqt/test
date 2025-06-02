import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RecommendationsPage from "../pages/recommendationsPage";

Given("a user account with User ID: 67890", () => {
 // Mock user account setup if necessary
});

When("the user logs in to the account", () => {
 RecommendationsPage.login();
});

Then("the user is successfully logged in and directed to the homepage", () => {
 cy.url().should("include", "/homepage");
});

Then("the recommendations section is visible with product suggestions", () => {
 RecommendationsPage.verifyRecommendationsSection();
});

Given("the user is on the recommendations section", () => {
 RecommendationsPage.visit();
});

When("the user selects a recommended product and provides feedback using the 'Like' option", () => {
 RecommendationsPage.provideFeedback('like');
});

Then("the feedback is submitted successfully and the system acknowledges the input", () => {
 RecommendationsPage.verifyFeedbackAcknowledgement();
});

When("the user selects another recommended product and provides feedback using the 'Dislike' option", () => {
 RecommendationsPage.provideFeedback('dislike');
});

When("the user selects a third recommended product and provides feedback using the 'Not Relevant' option", () => {
 RecommendationsPage.provideFeedback('not-relevant');
});

Given("the user has provided feedback on recommendations", () => {
 RecommendationsPage.provideMultipleFeedback();
});

When("the user checks future recommendations", () => {
 RecommendationsPage.checkFutureRecommendations();
});

Then("future recommendations are adjusted based on the feedback provided", () => {
 RecommendationsPage.verifyFutureRecommendations();
});

Given("the user has logged out", () => {
 RecommendationsPage.logout();
});

When("the user logs in again", () => {
 RecommendationsPage.login();
});

Then("the feedback impact persists across sessions", () => {
 RecommendationsPage.verifyFeedbackPersistence();
});

When("the user provides feedback on multiple recommendations quickly", () => {
 RecommendationsPage.provideFeedbackQuickly();
});

Then("the system handles multiple feedback inputs without errors", () => {
 RecommendationsPage.verifyNoErrors();
});

When("the user attempts to provide feedback on the same recommendation multiple times", () => {
 RecommendationsPage.attemptDuplicateFeedback();
});

Then("the system prevents duplicate feedback submissions for the same recommendation", () => {
 RecommendationsPage.verifyNoDuplicateFeedback();
});

When("the user checks feedback options for all recommendations", () => {
 RecommendationsPage.checkFeedbackOptions();
});

Then("feedback options are consistently available for all recommendations", () => {
 RecommendationsPage.verifyFeedbackOptionsAvailability();
});

When("the user interacts with the feedback interface", () => {
 RecommendationsPage.interactWithFeedbackInterface();
});

Then("the feedback interface is user-friendly and accessible", () => {
 RecommendationsPage.verifyInterfaceAccessibility();
});

When("the user submits feedback", () => {
 RecommendationsPage.submitFeedback();
});

Then("no system errors occur during feedback submission", () => {
 RecommendationsPage.verifyNoSystemErrors();
});

Given("the user accesses the recommendations section using a mobile device", () => {
 RecommendationsPage.visitMobile();
});

Then("feedback submission is smooth and consistent with desktop experience", () => {
 RecommendationsPage.verifyMobileFeedbackConsistency();
});

Given("a new user account", () => {
 RecommendationsPage.setupNewUserAccount();
});

When("the user provides feedback on recommendations", () => {
 RecommendationsPage.provideFeedback();
});

Then("feedback influences recommendations even for new users", () => {
 RecommendationsPage.verifyFeedbackInfluence();
});

Given("the user provides conflicting feedback on similar products", () => {
 RecommendationsPage.provideConflictingFeedback();
});

When("the user checks the system's response", () => {
 RecommendationsPage.checkSystemResponse();
});

Then("the system balances conflicting feedback to optimize recommendations", () => {
 RecommendationsPage.verifyBalancedRecommendations();
});