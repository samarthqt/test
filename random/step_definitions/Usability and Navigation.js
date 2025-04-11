const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const NavigationPage = require('../../pages/NavigationPage');

Given('the application is live', () => {
  cy.visit('/');
});

When('users navigate through the application', () => {
  NavigationPage.navigateThroughApplication();
});

Then('user feedback should indicate an 85% satisfaction rate for navigation ease', () => {
  NavigationPage.verifyUserSatisfactionRate(85);
});

Given('the application has product categories and filters', () => {
  NavigationPage.verifyCategoriesAndFiltersExist();
});

When('a user views the categories and filters', () => {
  NavigationPage.viewCategoriesAndFilters();
});

Then('categories and filters should be clearly labeled', () => {
  NavigationPage.verifyCategoriesAndFiltersLabeling();
});

Then('categories and filters should be functional', () => {
  NavigationPage.verifyCategoriesAndFiltersFunctionality();
});

Given('the application has multiple pages', () => {
  NavigationPage.verifyMultiplePagesExist();
});

When('a user navigates through different pages', () => {
  NavigationPage.navigateThroughDifferentPages();
});

Then('the application should provide a consistent user interface across all pages', () => {
  NavigationPage.verifyConsistentUserInterface();
});

Given('the application is in use', () => {
  NavigationPage.verifyApplicationInUse();
});

When('the quarter ends', () => {
  NavigationPage.waitForQuarterEnd();
});

Then('usability tests should be conducted to gather user feedback', () => {
  NavigationPage.conductUsabilityTests();
});

Given('the application has key features', () => {
  NavigationPage.verifyKeyFeaturesExist();
});

When('a user attempts to access a key feature', () => {
  NavigationPage.accessKeyFeature();
});

Then('navigation paths should be optimized to require minimal clicks to reach the key feature', () => {
  NavigationPage.verifyOptimizedNavigationPaths();
});