import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import MobileAppPage from '../pageObjects/MobileAppPage';

const mobileAppPage = new MobileAppPage();

Given('the mobile app is installed on a supported device', () => {
    mobileAppPage.verifyAppInstallation();
});

Given('the user has a valid account', () => {
    mobileAppPage.verifyUserAccount();
});

Given('the user opens the mobile app', () => {
    mobileAppPage.openApp();
});

When('the user logs in with valid credentials', () => {
    mobileAppPage.login();
});

Then('the user should be able to access all features without any issues', () => {
    mobileAppPage.verifyFeatureAccess();
});

Given('the user is logged into the mobile app', () => {
    mobileAppPage.verifyUserLoggedIn();
});

When('the user navigates through different sections of the app', () => {
    mobileAppPage.navigateSections();
});

Then('the transitions between sections should be smooth and without delays', () => {
    mobileAppPage.verifySmoothTransitions();
});

When('the user performs actions that require data sync with the server', () => {
    mobileAppPage.performDataSyncActions();
});

Then('the data should be synchronized promptly without errors', () => {
    mobileAppPage.verifyDataSync();
});

Given('the mobile app is installed on various supported devices', () => {
    mobileAppPage.verifyAppInstallationOnDevices();
});

When('the user interacts with the app on each device', () => {
    mobileAppPage.interactOnDevices();
});

Then('the app should respond appropriately and maintain a consistent user experience', () => {
    mobileAppPage.verifyResponsiveUX();
});

When('an unexpected error occurs', () => {
    mobileAppPage.triggerUnexpectedError();
});

Then('the app should display an appropriate error message and allow the user to continue using the app', () => {
    mobileAppPage.verifyErrorHandling();
});

When('the user chooses to log out', () => {
    mobileAppPage.logout();
});

Then('the user should be logged out successfully and redirected to the login screen', () => {
    mobileAppPage.verifyLogout();
});