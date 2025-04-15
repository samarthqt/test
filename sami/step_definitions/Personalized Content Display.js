import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import HomePage from '../page_objects/HomePage';
import PromotionsPage from '../page_objects/PromotionsPage';

const homePage = new HomePage();
const promotionsPage = new PromotionsPage();

Given('the user is logged into the application', () => {
  // Implement login functionality
  cy.login();
});

Given('the user has previously interacted with specific categories', () => {
  // Set up user interactions with categories
  cy.setUserCategories(['electronics', 'fashion']);
});

When('the user visits the homepage', () => {
  homePage.visit();
});

Then('personalized banners related to those categories should be displayed', () => {
  homePage.verifyPersonalizedBanners(['electronics', 'fashion']);
});

Given('the user has a history of purchasing specific types of products', () => {
  // Set up user purchase history
  cy.setUserPurchaseHistory(['gadgets', 'clothing']);
});

When('the user navigates to the promotions page', () => {
  promotionsPage.visit();
});

Then('promotions related to the user's purchase history should be displayed', () => {
  promotionsPage.verifyPersonalizedPromotions(['gadgets', 'clothing']);
});

Given('the user has no recorded behavior data', () => {
  // Clear user behavior data
  cy.clearUserBehaviorData();
});

Then('default banners and promotions should be displayed', () => {
  homePage.verifyDefaultBannersAndPromotions();
});

Given('the user has interacted with new categories', () => {
  // Update user interactions
  cy.setUserCategories(['sports', 'books']);
});

Then('the personalized banners should reflect the new interactions', () => {
  homePage.verifyPersonalizedBanners(['sports', 'books']);
});

Given('the user is not logged into the application', () => {
  // Implement logout functionality
  cy.logout();
});

Then('only default banners and promotions should be displayed', () => {
  homePage.verifyDefaultBannersAndPromotions();
});