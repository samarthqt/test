import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RecommendationsPage from "../pages/recommendationsPage";

Given("{string} frequently purchases electronics", (user) => {
 RecommendationsPage.setUserPurchases(user, 'electronics');
});

Given("{string} browses fashion items regularly", (user) => {
 RecommendationsPage.setUserBrowsing(user, 'fashion');
});

Given("{string} is interested in home appliances", (user) => {
 RecommendationsPage.setUserInterest(user, 'home appliances');
});

Given("{string}'s browsing history is modified to include {string}", (user, category) => {
 RecommendationsPage.modifyUserBrowsingHistory(user, category);
});

Given("{string} has multiple interactions with the recommendations", (user) => {
 RecommendationsPage.simulateUserInteractions(user);
});

Given("there is a sudden change in user behavior", () => {
 RecommendationsPage.suddenUserBehaviorChange();
});

Given("the algorithm processes user interests", () => {
 RecommendationsPage.processUserInterests();
});

Given("there are relevant promotions available", () => {
 RecommendationsPage.setAvailablePromotions();
});

When("{string} logs in and navigates to the recommendations section", (user) => {
 RecommendationsPage.loginAndNavigate(user);
});

When("{string} checks the recommendation accuracy", (user) => {
 RecommendationsPage.checkRecommendationAccuracy(user);
});

When("the algorithm processes the new behavior", () => {
 RecommendationsPage.processNewBehavior();
});

When("{string} checks the diversity of recommendations", (user) => {
 RecommendationsPage.checkRecommendationDiversity(user);
});

When("the recommendations are generated", () => {
 RecommendationsPage.generateRecommendations();
});

When("the algorithm incorporates external factors", () => {
 RecommendationsPage.incorporateExternalFactors();
});

Then("Recommendations should primarily include {string}", (category) => {
 RecommendationsPage.verifyPrimaryRecommendations(category);
});

Then("Recommendations should adjust to include {string}", (category) => {
 RecommendationsPage.verifyAdjustedRecommendations(category);
});

Then("Recommendations should become more accurate and personalized over time", () => {
 RecommendationsPage.verifyAccuracyAndPersonalization();
});

Then("Recommendations should quickly adapt to reflect new interests", () => {
 RecommendationsPage.verifyAdaptationToNewInterests();
});

Then("Recommendations should include a variety of {string} brands and types", (category) => {
 RecommendationsPage.verifyDiversityInRecommendations(category);
});

Then("Recommendations should not include items unrelated to user interests", () => {
 RecommendationsPage.verifyExclusionOfIrrelevantProducts();
});

Then("Recommendations should incorporate relevant promotions without losing personalization", () => {
 RecommendationsPage.verifyIncorporationOfPromotions();
});