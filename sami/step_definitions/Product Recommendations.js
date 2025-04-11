import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import RecommendationPage from '../pageObjects/RecommendationPage';

const recommendationPage = new RecommendationPage();

Given('a user is logged into the system', () => {
  cy.login();
});

Given('the user has a history of interactions with products', () => {
  cy.interactWithProducts();
});

When('the user visits the product recommendation page', () => {
  recommendationPage.visit();
});

Then('the system should display personalized product recommendations', () => {
  recommendationPage.verifyPersonalizedRecommendations();
});

Then("the recommendations should be based on the user's past behavior", () => {
  recommendationPage.verifyRecommendationsBasedOnHistory();
});

Given('a new user is logged into the system', () => {
  cy.loginAsNewUser();
});

Given('the user has no history of interactions with products', () => {
  cy.clearInteractionHistory();
});

Then('the system should display default product recommendations', () => {
  recommendationPage.verifyDefaultRecommendations();
});

Then('the recommendations should be based on popular products', () => {
  recommendationPage.verifyRecommendationsBasedOnPopularity();
});

Given('a user is viewing personalized product recommendations', () => {
  recommendationPage.viewPersonalizedRecommendations();
});

When('the user interacts with a recommended product', () => {
  recommendationPage.interactWithRecommendedProduct();
});

Then('the system should update the product recommendations', () => {
  recommendationPage.verifyUpdatedRecommendations();
});

Then("the new recommendations should reflect the user's recent interaction", () => {
  recommendationPage.verifyRecommendationsReflectRecentInteraction();
});

Given('a user has a diverse interaction history', () => {
  cy.setDiverseInteractionHistory();
});

Then('the system should display a variety of personalized product recommendations', () => {
  recommendationPage.verifyVarietyOfRecommendations();
});

Then("the recommendations should accurately reflect the user's interests", () => {
  recommendationPage.verifyRecommendationsReflectInterests();
});

Given('there is no available data to generate recommendations', () => {
  cy.clearRecommendationData();
});

Then('the system should inform the user that no recommendations are available', () => {
  recommendationPage.verifyNoRecommendationsMessage();
});

Then('suggest actions to generate recommendations, such as browsing popular products', () => {
  recommendationPage.verifySuggestionsForGeneratingRecommendations();
});