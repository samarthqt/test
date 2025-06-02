import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ApplicationPage from "../pages/applicationPage";

Given("a device with minimum supported OS version", () => {
 ApplicationPage.verifyDeviceOS();
});

When("the device is powered on", () => {
 ApplicationPage.powerOnDevice();
});

Then("the device powers on successfully", () => {
 ApplicationPage.checkDevicePowerOn();
});

Given("the default browser is available", () => {
 ApplicationPage.checkDefaultBrowser();
});

When("the user navigates to the application's URL", () => {
 ApplicationPage.navigateToURL();
});

Then("the application URL is entered correctly", () => {
 ApplicationPage.verifyURL();
});

When("the user attempts to load the application in the browser", () => {
 ApplicationPage.loadApplication();
});

Then("the application loads successfully without errors", () => {
 ApplicationPage.checkApplicationLoad();
});

When("the user verifies the application's login screen", () => {
 ApplicationPage.verifyLoginScreen();
});

Then("the login screen appears correctly", () => {
 ApplicationPage.checkLoginScreenAppearance();
});

When("the user enters valid user credentials to log in", () => {
 ApplicationPage.enterUserCredentials();
});

Then("the user logs in successfully without errors", () => {
 ApplicationPage.checkLoginSuccess();
});

When("the user navigates through the application menus and features", () => {
 ApplicationPage.navigateMenusAndFeatures();
});

Then("the menus and features are accessible and functional", () => {
 ApplicationPage.checkMenusAndFeatures();
});

When("the user performs a sample transaction within the application", () => {
 ApplicationPage.performSampleTransaction();
});

Then("the transaction completes successfully without errors", () => {
 ApplicationPage.checkTransactionCompletion();
});

When("the user verifies application responsiveness and speed", () => {
 ApplicationPage.verifyResponsivenessAndSpeed();
});

Then("the application responds quickly and efficiently", () => {
 ApplicationPage.checkApplicationResponse();
});

When("the user checks for any OS-specific notifications or warnings", () => {
 ApplicationPage.checkOSNotifications();
});

Then("no OS-specific notifications or warnings appear", () => {
 ApplicationPage.verifyNoOSNotifications();
});

When("the user attempts to update any application settings", () => {
 ApplicationPage.updateApplicationSettings();
});

Then("the settings update successfully without errors", () => {
 ApplicationPage.checkSettingsUpdate();
});

When("the user logs out of the application", () => {
 ApplicationPage.logout();
});

Then("the user logs out successfully", () => {
 ApplicationPage.checkLogoutSuccess();
});

When("the user closes the application and reopens it", () => {
 ApplicationPage.closeAndReopenApplication();
});

Then("the application reopens successfully without errors", () => {
 ApplicationPage.checkApplicationReopen();
});

When("the user verifies application stability over extended use", () => {
 ApplicationPage.verifyStabilityOverExtendedUse();
});

Then("the application remains stable and functional", () => {
 ApplicationPage.checkApplicationStability();
});

When("the user documents any issues encountered during testing", () => {
 ApplicationPage.documentIssues();
});

Then("no issues are documented; application works as expected", () => {
 ApplicationPage.verifyNoIssuesDocumented();
});

When("the user confirms application functionality with the development team", () => {
 ApplicationPage.confirmFunctionalityWithDevTeam();
});

Then("the development team confirms application is supported on minimum OS version", () => {
 ApplicationPage.checkDevTeamConfirmation();
});