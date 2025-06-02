import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RecommendationsPage from "../pages/recommendationsPage";

Given("User ID {int} is logged in", (userId) => {
 RecommendationsPage.login(userId);
});

Given("a user is logged in", () => {
 RecommendationsPage.loginGenericUser();
});

Given("a user is logged in on multiple devices", () => {
 RecommendationsPage.loginOnMultipleDevices();
});

Given("multiple users are logged in simultaneously", () => {
 RecommendationsPage.loginMultipleUsers();
});

Given("User ID {int} has cleared browsing history", (userId) => {
 RecommendationsPage.clearBrowsingHistory(userId);
});

Given("a new user account is created", () => {
 RecommendationsPage.createNewUserAccount();
});

Given("a user is logged in on a mobile device", () => {
 RecommendationsPage.loginOnMobileDevice();
});

Given("the system is experiencing peak usage", () => {
 RecommendationsPage.simulatePeakUsage();
});

Given("a user has a large dataset", () => {
 RecommendationsPage.prepareLargeDataset();
});

When("the user navigates to the recommendations section", () => {
 RecommendationsPage.navigateToRecommendations();
});

When("the user refreshes the recommendations section", () => {
 RecommendationsPage.refreshRecommendations();
});

When("the user provides feedback on recommendations", () => {
 RecommendationsPage.provideFeedback();
});

When("the user checks recommendations on each device", () => {
 RecommendationsPage.checkRecommendationsOnDevices();
});

When("each user checks their recommendations", () => {
 RecommendationsPage.checkRecommendationsForUsers();
});

When("the user checks recommendations", () => {
 RecommendationsPage.checkRecommendations();
});

Then("user-specific recommendations for User ID {int} are displayed", (userId) => {
 RecommendationsPage.verifyUserSpecificRecommendations(userId);
});

Then("user-specific recommendations for User ID {int} are displayed, different from User ID {int}", (userId, otherUserId) => {
 RecommendationsPage.verifyDistinctRecommendations(userId, otherUserId);
});

Then("recommendations reflect the browsing history and preferences of the logged-in user", () => {
 RecommendationsPage.verifyBrowsingHistoryRecommendations();
});

Then("user-specific recommendations are maintained", () => {
 RecommendationsPage.verifyRecommendationsMaintained();
});

Then("feedback influences recommendations for User ID {int} only", (userId) => {
 RecommendationsPage.verifyFeedbackInfluence(userId);
});

Then("recommendations remain personalized and consistent across different devices", () => {
 RecommendationsPage.verifyConsistencyAcrossDevices();
});

Then("each account receives personalized recommendations without cross-account influence", () => {
 RecommendationsPage.verifyNoCrossAccountInfluence();
});

Then("recommendations become more generic but remain unique to User ID {int}", (userId) => {
 RecommendationsPage.verifyGenericRecommendations(userId);
});

Then("no system errors occur during personalization", () => {
 RecommendationsPage.verifyNoSystemErrors();
});

Then("recommendations are personalized even for new users", () => {
 RecommendationsPage.verifyPersonalizedForNewUser();
});

Then("feedback submission is smooth and consistent with desktop experience", () => {
 RecommendationsPage.verifyFeedbackSubmissionConsistency();
});

Then("the system consistently provides personalized recommendations", () => {
 RecommendationsPage.verifyConsistentRecommendations();
});

Then("the system efficiently handles large datasets and maintains personalized recommendations", () => {
 RecommendationsPage.verifyPerformanceWithLargeDataset();
});