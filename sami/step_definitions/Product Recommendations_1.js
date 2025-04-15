import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import HomePage from '../pageObjects/HomePage';
import ProductDetailPage from '../pageObjects/ProductDetailPage';

const homePage = new HomePage();
const productDetailPage = new ProductDetailPage();

Given('a user is logged into the application', () => {
  // Implement login functionality
  cy.login();
});

Given('the user has a history of interactions with various products', () => {
  // Mock or ensure user has interaction history
  cy.intercept('GET', '/api/user/history', { fixture: 'userHistory.json' });
});

When('the user navigates to the homepage', () => {
  homePage.visit();
});

Then('the system should display personalized product recommendations', () => {
  homePage.verifyPersonalizedRecommendations();
});

Then('the recommendations should be based on the user's past behavior and preferences', () => {
  homePage.verifyRecommendationsBasedOnHistory();
});

Given('a new user has registered and logged into the application', () => {
  // Implement new user registration and login
  cy.registerAndLogin();
});

Then('the system should not display any product recommendations', () => {
  homePage.verifyNoRecommendations();
});

Then('a message should be shown encouraging the user to explore products', () => {
  homePage.verifyExploreProductsMessage();
});

Given('a user is viewing personalized product recommendations', () => {
  homePage.visit();
  homePage.verifyPersonalizedRecommendations();
});

When('the user interacts with a product', () => {
  homePage.interactWithProduct();
});

Then('the system should update the recommendations based on the latest interaction', () => {
  homePage.verifyUpdatedRecommendations();
});

Given('a user is viewing a product detail page', () => {
  productDetailPage.visit();
});

When('the user scrolls down the page', () => {
  productDetailPage.scrollDown();
});

Then('the system should display additional product recommendations', () => {
  productDetailPage.verifyAdditionalRecommendations();
});

Then('these recommendations should be related to the product being viewed', () => {
  productDetailPage.verifyRelatedRecommendations();
});

Given('a user with similar behavior to the current user has interacted with certain products', () => {
  // Mock similar user behavior data
  cy.intercept('GET', '/api/user/similar', { fixture: 'similarUserBehavior.json' });
});

When('the current user views their personalized recommendations', () => {
  homePage.visit();
  homePage.viewPersonalizedRecommendations();
});

Then('the system should include products that were popular among users with similar behavior', () => {
  homePage.verifyRecommendationsFromSimilarUsers();
});

Given('a user has opted out of personalized product recommendations', () => {
  // Mock opt-out status
  cy.setOptOutStatus(true);
});

Then('the system should not display personalized product recommendations', () => {
  homePage.verifyNoPersonalizedRecommendations();
});

Then('the user should have an option to opt back in for personalized recommendations', () => {
  homePage.verifyOptInOption();
});