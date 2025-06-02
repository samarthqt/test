import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UnsupportedAndroidPage from "../pages/unsupportedAndroidPage";

Given("I have a Samsung Galaxy S5 with Android 5.0", () => {
 UnsupportedAndroidPage.setDevice("Samsung Galaxy S5", "Android 5.0");
});

Given("I have a Google Nexus 5 with Android 6.0", () => {
 UnsupportedAndroidPage.setDevice("Google Nexus 5", "Android 6.0");
});

Given("I am attempting to install the application", () => {
 UnsupportedAndroidPage.attemptInstallation();
});

Given("I am attempting to load media content", () => {
 UnsupportedAndroidPage.attemptLoadMediaContent();
});

Given("I am attempting to load interactive elements", () => {
 UnsupportedAndroidPage.attemptLoadInteractiveElements();
});

Given("I am attempting to load accessibility features", () => {
 UnsupportedAndroidPage.attemptLoadAccessibilityFeatures();
});

Given("I am attempting to execute Android-specific functions", () => {
 UnsupportedAndroidPage.attemptExecuteAndroidFunctions();
});

Given("the application relies on Android features", () => {
 UnsupportedAndroidPage.relyOnAndroidFeatures();
});

Given("I am attempting to navigate through the application", () => {
 UnsupportedAndroidPage.attemptNavigation();
});

Given("I am checking the application layout across screens", () => {
 UnsupportedAndroidPage.checkLayoutAcrossScreens();
});

Given("I am testing application performance", () => {
 UnsupportedAndroidPage.testApplicationPerformance();
});

Given("I am testing application responsiveness", () => {
 UnsupportedAndroidPage.testApplicationResponsiveness();
});

When("I attempt to download the application from the Google Play Store", () => {
 UnsupportedAndroidPage.downloadFromPlayStore();
});

When("I attempt to install the application and open it", () => {
 UnsupportedAndroidPage.installAndOpenApplication();
});

When("I attempt to download and install the application", () => {
 UnsupportedAndroidPage.downloadAndInstallApplication();
});

When("system notifications are checked", () => {
 UnsupportedAndroidPage.checkSystemNotifications();
});

When("media content is checked", () => {
 UnsupportedAndroidPage.checkMediaContent();
});

When("interactive elements are checked", () => {
 UnsupportedAndroidPage.checkInteractiveElements();
});

When("accessibility features are checked", () => {
 UnsupportedAndroidPage.checkAccessibilityFeatures();
});

When("Android-specific functions are checked", () => {
 UnsupportedAndroidPage.checkAndroidFunctions();
});

When("checking for deprecated Android features", () => {
 UnsupportedAndroidPage.checkDeprecatedFeatures();
});

When("navigation is checked", () => {
 UnsupportedAndroidPage.checkNavigation();
});

When("layout consistency is checked", () => {
 UnsupportedAndroidPage.checkLayoutConsistency();
});

When("system-specific warnings or suggestions are checked", () => {
 UnsupportedAndroidPage.checkSystemWarnings();
});

When("application performance is checked", () => {
 UnsupportedAndroidPage.checkApplicationPerformance();
});

When("application responsiveness is checked", () => {
 UnsupportedAndroidPage.checkApplicationResponsiveness();
});

When("error handling is checked during installation", () => {
 UnsupportedAndroidPage.checkErrorHandling();
});

Then("the application download should fail with an error message", () => {
 UnsupportedAndroidPage.verifyDownloadError();
});

Then("the application installation should fail with an error message", () => {
 UnsupportedAndroidPage.verifyInstallationError();
});

Then("the application download and installation should fail with error messages", () => {
 UnsupportedAndroidPage.verifyDownloadAndInstallationErrors();
});

Then("notifications should indicate unsupported OS version", () => {
 UnsupportedAndroidPage.verifyUnsupportedOSNotification();
});

Then("media content should fail to load", () => {
 UnsupportedAndroidPage.verifyMediaContentLoadFailure();
});

Then("interactive elements should fail to load", () => {
 UnsupportedAndroidPage.verifyInteractiveElementsLoadFailure();
});

Then("accessibility features should fail to load", () => {
 UnsupportedAndroidPage.verifyAccessibilityFeaturesLoadFailure();
});

Then("Android-specific functions should fail to execute", () => {
 UnsupportedAndroidPage.verifyAndroidFunctionsExecutionFailure();
});

Then("the application should rely on deprecated features", () => {
 UnsupportedAndroidPage.verifyDeprecatedFeaturesReliance();
});

Then("navigation should fail with error messages", () => {
 UnsupportedAndroidPage.verifyNavigationFailure();
});

Then("layout should be inconsistent across screens", () => {
 UnsupportedAndroidPage.verifyLayoutInconsistency();
});

Then("system-specific warnings should indicate unsupported OS version", () => {
 UnsupportedAndroidPage.verifySystemWarningsForUnsupportedOS();
});

Then("the application should fail to perform", () => {
 UnsupportedAndroidPage.verifyPerformanceFailure();
});

Then("the application should fail to be responsive", () => {
 UnsupportedAndroidPage.verifyResponsivenessFailure();
});

Then("error messages should indicate unsupported OS version", () => {
 UnsupportedAndroidPage.verifyErrorMessagesForUnsupportedOS();
});