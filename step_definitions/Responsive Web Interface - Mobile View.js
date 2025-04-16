import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import HomePage from '../pageObjects/HomePage';
import SecondaryPage from '../pageObjects/SecondaryPage';

const homePage = new HomePage();
const secondaryPage = new SecondaryPage();

Given('the web application is deployed and accessible', () => {
  cy.visit('/');
});

When('I open the web application URL in a mobile browser', () => {
  cy.viewport('iphone-6');
});

Then('the homepage of the application should load without any errors', () => {
  homePage.verifyHomePageLoad();
});

Given('I am on the homepage of the application', () => {
  cy.visit('/');
});

When('I view the homepage on a mobile screen', () => {
  cy.viewport('iphone-6');
});

Then('the layout should be appropriately aligned and fit the screen without any horizontal scrollbars', () => {
  homePage.verifyLayoutAlignment();
});

When('I check the navigation menu', () => {
  homePage.checkNavigationMenu();
});

Then('the navigation menu should be accessible through a hamburger icon and functional', () => {
  homePage.verifyNavigationMenu();
});

When('I view the images on the homepage', () => {
  homePage.checkImages();
});

Then('images should resize proportionally and maintain clarity', () => {
  homePage.verifyImagesResponsiveness();
});

When('I scroll to the bottom of the page', () => {
  homePage.scrollToFooter();
});

Then('the footer should remain at the bottom of the page and be fully visible', () => {
  homePage.verifyFooterVisibility();
});

When('I navigate to a secondary page from the homepage', () => {
  homePage.navigateToSecondaryPage();
});

Then('the secondary page should load correctly and maintain a responsive layout', () => {
  secondaryPage.verifyPageLoad();
});

Given('I am on a secondary page of the application', () => {
  cy.visit('/secondary-page');
});

When('I view the form elements on the page', () => {
  secondaryPage.checkFormElements();
});

Then('form elements should be properly aligned and usable', () => {
  secondaryPage.verifyFormElements();
});

Given('I am using the web application on a mobile device', () => {
  cy.viewport('iphone-6');
});

When('I interact with the application', () => {
  homePage.interactWithApplication();
});

Then('the application should load within acceptable time limits and respond to user inputs promptly', () => {
  homePage.verifyPerformance();
});

When('I rotate the mobile device to landscape mode', () => {
  cy.viewport('iphone-6', 'landscape');
});

Then('the layout should adjust and remain usable without any overlapping elements', () => {
  homePage.verifyLandscapeLayout();
});

Given('I am logged into the application', () => {
  homePage.login();
});

When('I log out of the application', () => {
  homePage.logout();
});

Then('the user should be logged out successfully without any layout issues', () => {
  homePage.verifyLogout();
});

Then('the login page should appear with all elements properly aligned and without any layout issues', () => {
  homePage.verifyLoginPage();
});

When('I check the accessibility features', () => {
  homePage.checkAccessibilityFeatures();
});

Then('all accessibility features such as screen reader support and text scaling should function correctly', () => {
  homePage.verifyAccessibilityFeatures();
});

When('I use the search functionality', () => {
  homePage.useSearchFunctionality();
});

Then('the search bar should be easily accessible and return relevant results without layout issues', () => {
  homePage.verifySearchFunctionality();
});

When('I interact with buttons and interactive elements', () => {
  homePage.interactWithButtons();
});

Then('all buttons and interactive elements should respond to touch inputs accurately', () => {
  homePage.verifyTouchResponsiveness();
});

Given('I am on a page with video content', () => {
  cy.visit('/video-page');
});

When('I play the video', () => {
  homePage.playVideo();
});

Then('videos should play smoothly, resize correctly, and maintain aspect ratio', () => {
  homePage.verifyVideoResponsiveness();
});