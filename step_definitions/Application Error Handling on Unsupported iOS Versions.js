import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UnsupportedIOSPage from "../pages/unsupportedIOSPage";

Given("I have an iPhone 6 with iOS 10", () => {
 UnsupportedIOSPage.setDevice("iPhone 6", "iOS 10");
});

Given("I have an iPhone 5 with iOS 9", () => {
 UnsupportedIOSPage.setDevice("iPhone 5", "iOS 9");
});

Given("I am installing the application on an unsupported iOS version", () => {
 UnsupportedIOSPage.setUnsupportedIOS();
});

Given("I have installed the application on an unsupported iOS version", () => {
 UnsupportedIOSPage.installAppOnUnsupportedIOS();
});

When("I attempt to download the application from the App Store", () => {
 UnsupportedIOSPage.attemptDownload();
});

When("I try to install and open the application", () => {
 UnsupportedIOSPage.attemptInstallAndOpen();
});

When("I attempt to download and install the application", () => {
 UnsupportedIOSPage.attemptDownloadAndInstall();
});

When("I check for system notifications", () => {
 UnsupportedIOSPage.checkSystemNotifications();
});

When("I attempt to load media content", () => {
 UnsupportedIOSPage.loadMediaContent();
});

When("I attempt to load interactive elements", () => {
 UnsupportedIOSPage.loadInteractiveElements();
});

When("I attempt to load accessibility features", () => {
 UnsupportedIOSPage.loadAccessibilityFeatures();
});

When("I verify compatibility with iOS-specific functions", () => {
 UnsupportedIOSPage.verifyIOSFunctionsCompatibility();
});

When("I check for deprecated iOS features", () => {
 UnsupportedIOSPage.checkDeprecatedIOSFeatures();
});

When("I attempt application navigation", () => {
 UnsupportedIOSPage.attemptNavigation();
});

When("I verify application layout consistency", () => {
 UnsupportedIOSPage.verifyLayoutConsistency();
});

When("I check for system-specific warnings or suggestions", () => {
 UnsupportedIOSPage.checkSystemWarningsSuggestions();
});

When("I test application performance", () => {
 UnsupportedIOSPage.testPerformance();
});

When("I verify application responsiveness", () => {
 UnsupportedIOSPage.verifyResponsiveness();
});

When("I check for error handling during installation", () => {
 UnsupportedIOSPage.checkErrorHandlingDuringInstallation();
});

Then("the application download should fail with an error message", () => {
 UnsupportedIOSPage.verifyDownloadFailure();
});

Then("the application installation should fail with an error message", () => {
 UnsupportedIOSPage.verifyInstallationFailure();
});

Then("both download and installation should fail with error messages", () => {
 UnsupportedIOSPage.verifyDownloadAndInstallationFailure();
});

Then("the notifications should indicate unsupported OS version", () => {
 UnsupportedIOSPage.verifyUnsupportedOSNotification();
});

Then("the media content should fail to load", () => {
 UnsupportedIOSPage.verifyMediaContentFailure();
});

Then("the interactive elements should fail to load", () => {
 UnsupportedIOSPage.verifyInteractiveElementsFailure();
});

Then("the accessibility features should fail to load", () => {
 UnsupportedIOSPage.verifyAccessibilityFeaturesFailure();
});

Then("the iOS-specific functions should fail to execute", () => {
 UnsupportedIOSPage.verifyIOSFunctionsFailure();
});

Then("the application should rely on deprecated features", () => {
 UnsupportedIOSPage.verifyRelianceOnDeprecatedFeatures();
});

Then("the navigation should fail with error messages", () => {
 UnsupportedIOSPage.verifyNavigationFailure();
});

Then("the layout should be inconsistent across screens", () => {
 UnsupportedIOSPage.verifyLayoutInconsistency();
});

Then("the warnings should indicate unsupported OS version", () => {
 UnsupportedIOSPage.verifyWarningsForUnsupportedOS();
});

Then("the application should fail to perform", () => {
 UnsupportedIOSPage.verifyPerformanceFailure();
});

Then("the application should fail to be responsive", () => {
 UnsupportedIOSPage.verifyResponsivenessFailure();
});

Then("error messages should indicate unsupported OS version", () => {
 UnsupportedIOSPage.verifyErrorMessagesForUnsupportedOS();
});