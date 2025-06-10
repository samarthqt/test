import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AIRecommendationsPage from "../pages/aiRecommendationsPage";

Given("a user interacts with the system", () => {
 AIRecommendationsPage.userInteracts();
});

When("the AI system analyzes the user's behavior", () => {
 AIRecommendationsPage.analyzeBehavior();
});

Then("the analysis should be accurate", () => {
 AIRecommendationsPage.verifyAnalysisAccuracy();
});

Given("a user has a history of interactions", () => {
 AIRecommendationsPage.userHasHistory();
});

When("the AI system generates product recommendations", () => {
 AIRecommendationsPage.generateRecommendations();
});

Then("the recommendations should be relevant to the user's preferences", () => {
 AIRecommendationsPage.verifyRecommendationsRelevance();
});

Then("the recommendations should be personalized", () => {
 AIRecommendationsPage.verifyRecommendationsPersonalization();
});

Given("a user has not opted-in for AI recommendations", () => {
 AIRecommendationsPage.userNotOptedIn();
});

When("the user chooses to opt-in", () => {
 AIRecommendationsPage.userOptsIn();
});

Then("the system should start providing AI-based product recommendations", () => {
 AIRecommendationsPage.verifyStartRecommendations();
});

Given("a user has opted-in for AI recommendations", () => {
 AIRecommendationsPage.userOptedIn();
});

When("the user chooses to opt-out", () => {
 AIRecommendationsPage.userOptsOut();
});

Then("the system should stop providing AI-based product recommendations", () => {
 AIRecommendationsPage.verifyStopRecommendations();
});

Given("the AI system has generated recommendations for a user", () => {
 AIRecommendationsPage.recommendationsGenerated();
});

When("new user data becomes available", () => {
 AIRecommendationsPage.newDataAvailable();
});

Then("the system should update the recommendations based on the new data", () => {
 AIRecommendationsPage.verifyRecommendationsUpdate();
});

Given("a user receives AI-based product recommendations", () => {
 AIRecommendationsPage.userReceivesRecommendations();
});

When("the user requests an explanation of the recommendation logic", () => {
 AIRecommendationsPage.requestExplanation();
});

Then("the system should provide a clear and understandable explanation of how recommendations are generated", () => {
 AIRecommendationsPage.verifyExplanationProvided();
});