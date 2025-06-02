import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import EdgeCaseTestingPage from "../pages/edgeCaseTestingPage";

Given("the application is available for download", () => {
 EdgeCaseTestingPage.checkAvailability();
});

Given("the application is downloaded", () => {
 EdgeCaseTestingPage.checkDownloaded();
});

Given("the application is open", () => {
 EdgeCaseTestingPage.checkOpen();
});

When("the user downloads the application from the App Store on iPhone 8 with iOS 12 under network throttling", () => {
 EdgeCaseTestingPage.downloadAppStoreThrottling();
});

When("the user installs the application and opens it on Samsung Galaxy S9 with Android 8.0", () => {
 EdgeCaseTestingPage.installAndOpenSamsungGalaxyS9();
});

When("the user navigates through the application with low battery settings", () => {
 EdgeCaseTestingPage.navigateLowBattery();
});

When("the user repeats steps 1-3 on Samsung Galaxy S9 with Android 8.0", () => {
 EdgeCaseTestingPage.repeatStepsSamsungGalaxyS9();
});

When("the user checks for system notifications under network throttling", () => {
 EdgeCaseTestingPage.checkSystemNotificationsThrottling();
});

When("the user verifies media content loading with low battery settings", () => {
 EdgeCaseTestingPage.verifyMediaContentLowBattery();
});

When("the user tests interactive elements with network throttling", () => {
 EdgeCaseTestingPage.testInteractiveElementsThrottling();
});

When("the user checks accessibility features with low battery settings", () => {
 EdgeCaseTestingPage.checkAccessibilityFeaturesLowBattery();
});

When("the user verifies compatibility with system-specific functions under network throttling", () => {
 EdgeCaseTestingPage.verifyCompatibilitySystemFunctionsThrottling();
});

When("the user checks for deprecated features with low battery settings", () => {
 EdgeCaseTestingPage.checkDeprecatedFeaturesLowBattery();
});

When("the user tests application navigation under network throttling", () => {
 EdgeCaseTestingPage.testNavigationThrottling();
});

When("the user verifies application layout consistency with low battery settings", () => {
 EdgeCaseTestingPage.verifyLayoutConsistencyLowBattery();
});

When("the user checks for system-specific warnings under network throttling", () => {
 EdgeCaseTestingPage.checkSystemWarningsThrottling();
});

When("the user tests application performance with low battery settings", () => {
 EdgeCaseTestingPage.testPerformanceLowBattery();
});

When("the user verifies application responsiveness under network throttling", () => {
 EdgeCaseTestingPage.verifyResponsivenessThrottling();
});

Then("the application should download with potential errors", () => {
 EdgeCaseTestingPage.verifyDownloadErrors();
});

Then("the application should install with potential errors", () => {
 EdgeCaseTestingPage.verifyInstallErrors();
});

Then("the application may exhibit unexpected behavior", () => {
 EdgeCaseTestingPage.verifyUnexpectedBehavior();
});

Then("unexpected notifications may be shown", () => {
 EdgeCaseTestingPage.verifyUnexpectedNotifications();
});

Then("media content may not load correctly", () => {
 EdgeCaseTestingPage.verifyMediaContentErrors();
});

Then("interactive elements may not function correctly", () => {
 EdgeCaseTestingPage.verifyInteractiveElementsErrors();
});

Then("accessibility features may not be functional", () => {
 EdgeCaseTestingPage.verifyAccessibilityFeaturesErrors();
});

Then("system-specific functions may not execute correctly", () => {
 EdgeCaseTestingPage.verifySystemFunctionsErrors();
});

Then("the application may rely on deprecated features", () => {
 EdgeCaseTestingPage.verifyDeprecatedFeaturesErrors();
});

Then("navigation may not be smooth or intuitive", () => {
 EdgeCaseTestingPage.verifyNavigationErrors();
});

Then("layout may be inconsistent across screens", () => {
 EdgeCaseTestingPage.verifyLayoutInconsistency();
});

Then("system-specific warnings may be shown", () => {
 EdgeCaseTestingPage.verifySystemWarnings();
});

Then("the application may perform inefficiently", () => {
 EdgeCaseTestingPage.verifyPerformanceIssues();
});

Then("the application may not be responsive", () => {
 EdgeCaseTestingPage.verifyResponsivenessIssues();
});