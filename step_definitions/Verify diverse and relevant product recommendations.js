import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RecommendationPage from "../pages/recommendationPage";

Given("a user account with User ID: {string}", (userId) => {
 RecommendationPage.setUserId(userId);
});

When("the user logs in to the account", () => {
 RecommendationPage.login();
});

Then("the user is successfully logged in and directed to the homepage", () => {
 RecommendationPage.verifyLoginSuccess();
});

When("the user navigates to the recommendations section on the homepage", () => {
 RecommendationPage.navigateToRecommendations();
});

Then("the recommendation section is visible with product suggestions", () => {
 RecommendationPage.verifyRecommendationsVisible();
});

Then("recommendations include products from {string}, {string}, and {string} categories", (category1, category2, category3) => {
 RecommendationPage.verifyCategories([category1, category2, category3]);
});

When("the user accesses the recommendations section", () => {
 RecommendationPage.accessRecommendations();
});

Then("all recommended products are relevant to the user's past interactions", () => {
 RecommendationPage.verifyRelevance();
});

Given("the user is logged in and viewing the recommendations section", () => {
 RecommendationPage.verifyLoggedInAndViewing();
});

When("the user refreshes the recommendation section", () => {
 RecommendationPage.refreshRecommendations();
});

Then("a new set of recommendations are displayed, maintaining diversity and relevance", () => {
 RecommendationPage.verifyNewRecommendations();
});

Given("the user logs out and logs in with a different user account", () => {
 RecommendationPage.logoutAndLoginDifferentUser();
});

Then("recommendations are personalized for the new user, maintaining diversity and relevance", () => {
 RecommendationPage.verifyPersonalizedForNewUser();
});

When("the user checks for repeated recommendations", () => {
 RecommendationPage.checkRepeatedRecommendations();
});

Then("no repeated recommendations are shown in the same session", () => {
 RecommendationPage.verifyNoRepetitions();
});

Given("the user clears browsing history", () => {
 RecommendationPage.clearBrowsingHistory();
});

When("the user checks recommendations", () => {
 RecommendationPage.checkRecommendations();
});

Then("recommendations are still diverse, but less personalized", () => {
 RecommendationPage.verifyLessPersonalized();
});

Given("the user switches to a new device and logs in to the account", () => {
 RecommendationPage.switchDeviceAndLogin();
});

Then("recommendations are consistent with previous device", () => {
 RecommendationPage.verifyConsistencyAcrossDevices();
});

Given("the user is logged in and browsing new data", () => {
 RecommendationPage.browsingNewData();
});

Then("new browsing data influences the recommendations in real-time", () => {
 RecommendationPage.verifyRealTimeUpdates();
});

When("the user checks for system errors or delays", () => {
 RecommendationPage.checkSystemErrorsOrDelays();
});

Then("no errors or significant delays are observed in generating recommendations", () => {
 RecommendationPage.verifyNoErrorsOrDelays();
});

Given("the user logs in with a user account that has no browsing history", () => {
 RecommendationPage.loginNoBrowsingHistory();
});

Then("recommendations are generic but diverse across categories", () => {
 RecommendationPage.verifyGenericButDiverse();
});

When("the user provides feedback on a recommendation", () => {
 RecommendationPage.provideFeedback();
});

Then("providing feedback influences future recommendations positively", () => {
 RecommendationPage.verifyFeedbackInfluence();
});

Given("the user is logged in and browsing only one category", () => {
 RecommendationPage.browsingOneCategory();
});

Then("the system adjusts recommendations to reflect the user's extreme browsing behavior while maintaining some diversity", () => {
 RecommendationPage.verifyAdjustmentForExtremeBehavior();
});