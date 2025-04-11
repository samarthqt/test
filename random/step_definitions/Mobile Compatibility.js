import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import MobilePage from '../page_objects/MobilePage';

const mobilePage = new MobilePage();

Given('the application is accessed on a mobile device', () => {
  mobilePage.accessOnMobileDevice();
});

When('the user views the application on different screen sizes', () => {
  mobilePage.viewOnDifferentScreenSizes();
});

Then('the application should display correctly on all screens', () => {
  mobilePage.verifyDisplayOnAllScreens();
});

Given('the user accesses the app store on their mobile device', () => {
  mobilePage.accessAppStore();
});

When('the user searches for the application', () => {
  mobilePage.searchForApplication();
});

Then('the dedicated app should be available for download on iOS and Android stores', () => {
  mobilePage.verifyAppAvailableOnStores();
});

Given('the user is logged into the mobile application', () => {
  mobilePage.loginToMobileApp();
});

When('the user attempts to complete a transaction', () => {
  mobilePage.attemptTransaction();
});

Then('the transaction should be completed seamlessly without any issues', () => {
  mobilePage.verifyTransactionCompletion();
});

Given('the user opens the mobile application', () => {
  mobilePage.openMobileApp();
});

When('the device is offline', () => {
  mobilePage.deviceGoesOffline();
});

Then('the application should support offline mode for browsing', () => {
  mobilePage.verifyOfflineModeSupport();
});

Given('the mobile application is used by multiple users', () => {
  mobilePage.usedByMultipleUsers();
});

When('user feedback is collected', () => {
  mobilePage.collectUserFeedback();
});

Then('the feedback should indicate a 90% satisfaction rate with mobile usability', () => {
  mobilePage.verifyUserSatisfaction();
});