import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import HomePage from '../pageObjects/HomePage';
import SecondaryPage from '../pageObjects/SecondaryPage';

const homePage = new HomePage();
const secondaryPage = new SecondaryPage();

Given('the application server is running', () => {
  // Code to ensure server is running
});

Given('a compatible desktop browser is installed', () => {
  // Code to check browser compatibility
});

Given('the user has valid login credentials', () => {
  // Code to set valid login credentials
});

When('the user opens the web application URL in a desktop browser', () => {
  homePage.visit();
});

Then('the homepage of the application should load without any errors', () => {
  homePage.verifyHomepageLoads();
});

Given('the homepage is loaded in a desktop browser', () => {
  homePage.verifyHomepageLoads();
});

When('the user views the layout of the homepage', () => {
  homePage.checkLayout();
});

Then('the layout should be appropriately aligned and fit the screen without any horizontal scrollbars', () => {
  homePage.verifyLayoutAlignment();
});

When('the user checks the navigation menu', () => {
  homePage.checkNavigationMenu();
});

Then('the navigation menu should be fully visible and functional', () => {
  homePage.verifyNavigationMenu();
});

When('the user resizes the browser window to half the screen size', () => {
  homePage.resizeWindow();
});

Then('the layout should adjust and remain usable without any overlapping elements', () => {
  homePage.verifyResponsiveLayout();
});

When('the user checks the images on the homepage', () => {
  homePage.checkImages();
});

Then('images should resize proportionally and maintain clarity', () => {
  homePage.verifyImageResponsiveness();
});

When('the user checks the footer section', () => {
  homePage.checkFooter();
});

Then('the footer should remain at the bottom of the page and be fully visible', () => {
  homePage.verifyFooterPosition();
});

When('the user navigates to a secondary page', () => {
  homePage.navigateToSecondaryPage();
});

Then('the secondary page should load correctly and maintain a responsive layout', () => {
  secondaryPage.verifyPageLoad();
});

Given('the secondary page is loaded', () => {
  secondaryPage.verifyPageLoad();
});

When('the user checks the form elements', () => {
  secondaryPage.checkFormElements();
});

Then('form elements should be properly aligned and usable', () => {
  secondaryPage.verifyFormElements();
});

Given('the application is running', () => {
  // Code to ensure application is running
});

When('the user interacts with the web application', () => {
  homePage.interactWithApplication();
});

Then('the application should load within acceptable time limits and respond to user inputs promptly', () => {
  homePage.verifyPerformance();
});

When('the user logs in using the provided credentials', () => {
  homePage.login();
});

Then('the user should be logged in successfully and redirected to the homepage', () => {
  homePage.verifyLoginSuccess();
});

Given('the user is logged in and on the homepage', () => {
  homePage.verifyLoginSuccess();
});

When('the user interacts with buttons, links, and other elements', () => {
  homePage.interactWithElements();
});

Then('all interactive elements should be clickable and lead to the correct pages or actions', () => {
  homePage.verifyInteractiveElements();
});

When('the user views the application on different screen resolutions', () => {
  homePage.checkDifferentResolutions();
});

Then('the application should maintain a responsive and user-friendly layout across different resolutions', () => {
  homePage.verifyResponsiveLayoutAcrossResolutions();
});

When('the user opens the application in different desktop browsers', () => {
  homePage.checkDifferentBrowsers();
});

Then('the application should function consistently and responsively across different browsers', () => {
  homePage.verifyCrossBrowserFunctionality();
});

When('the user checks the accessibility features', () => {
  homePage.checkAccessibilityFeatures();
});

Then('the application should be accessible to users with disabilities, providing features like keyboard navigation and screen reader compatibility', () => {
  homePage.verifyAccessibility();
});

When('the user logs out of the application', () => {
  homePage.logout();
});

Then('the user should be logged out successfully without any layout issues', () => {
  homePage.verifyLogoutSuccess();
});