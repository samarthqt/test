import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import MobileAppPage from "../pages/mobileAppPage";

Given("the mobile app is installed on a supported device", () => {
 MobileAppPage.verifyInstallation();
});

Given("the user has a valid account", () => {
 MobileAppPage.verifyAccount();
});

Given("the user opens the mobile app", () => {
 MobileAppPage.openApp();
});

When("the user logs in with valid credentials", () => {
 MobileAppPage.login();
});

Then("the user should be able to access all features without any issues", () => {
 MobileAppPage.verifyFeatureAccess();
});

Given("the user is logged into the mobile app", () => {
 MobileAppPage.verifyLogin();
});

When("the user navigates through different sections of the app", () => {
 MobileAppPage.navigateSections();
});

Then("the transitions between sections should be smooth and without delays", () => {
 MobileAppPage.verifySmoothTransitions();
});

When("the user performs actions that require data sync with the server", () => {
 MobileAppPage.performDataSyncActions();
});

Then("the data should be synchronized promptly without errors", () => {
 MobileAppPage.verifyDataSync();
});

Given("the mobile app is installed on various supported devices", () => {
 MobileAppPage.verifyInstallationOnDevices();
});

When("the user interacts with the app on each device", () => {
 MobileAppPage.interactOnDevices();
});

Then("the app should respond appropriately and maintain a consistent user experience", () => {
 MobileAppPage.verifyResponsiveExperience();
});

When("an unexpected error occurs", () => {
 MobileAppPage.triggerUnexpectedError();
});

Then("the app should display an appropriate error message and allow the user to continue using the app", () => {
 MobileAppPage.verifyErrorHandling();
});

When("the user chooses to log out", () => {
 MobileAppPage.logout();
});

Then("the user should be logged out successfully and redirected to the login screen", () => {
 MobileAppPage.verifyLogout();
});