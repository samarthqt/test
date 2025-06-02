import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import EdgeCasePage from "../pages/edgeCasePage";

Given("I have an iPhone 6 with iOS 10", () => {
 EdgeCasePage.setDevice("iPhone 6", "iOS 10");
});

Given("network throttling is enabled", () => {
 EdgeCasePage.enableNetworkThrottling();
});

Given("I have a Samsung Galaxy S5 with Android 5.0", () => {
 EdgeCasePage.setDevice("Samsung Galaxy S5", "Android 5.0");
});

Given("the device battery is low", () => {
 EdgeCasePage.setLowBattery();
});

Given("I am installing the application", () => {
 EdgeCasePage.startInstallation();
});

When("I attempt to download the application from the App Store", () => {
 EdgeCasePage.downloadFromAppStore();
});

When("I try to install and open the application", () => {
 EdgeCasePage.installAndOpenApplication();
});

When("I attempt to download and install the application", () => {
 EdgeCasePage.downloadAndInstallApplication();
});

When("the application is running", () => {
 EdgeCasePage.runApplication();
});

When("I try to load media content", () => {
 EdgeCasePage.loadMediaContent();
});

When("I interact with application elements", () => {
 EdgeCasePage.interactWithElements();
});

When("I try to use accessibility features", () => {
 EdgeCasePage.useAccessibilityFeatures();
});

When("I use system-specific functions", () => {
 EdgeCasePage.useSystemFunctions();
});

When("I use the application", () => {
 EdgeCasePage.useApplication();
});

When("I navigate through the application", () => {
 EdgeCasePage.navigateApplication();
});

When("I view different screens in the application", () => {
 EdgeCasePage.viewScreens();
});

When("the installation process fails", () => {
 EdgeCasePage.failInstallation();
});

Then("the application download fails with potential errors", () => {
 EdgeCasePage.verifyDownloadFailure();
});

Then("the application installation fails with errors", () => {
 EdgeCasePage.verifyInstallationFailure();
});

Then("the application download and installation fail with errors", () => {
 EdgeCasePage.verifyDownloadAndInstallationFailure();
});

Then("unexpected system notifications may be shown", () => {
 EdgeCasePage.verifySystemNotifications();
});

Then("media content may not load correctly", () => {
 EdgeCasePage.verifyMediaContentLoading();
});

Then("interactive elements may not function correctly", () => {
 EdgeCasePage.verifyInteractiveElements();
});

Then("accessibility features may not be functional", () => {
 EdgeCasePage.verifyAccessibilityFeatures();
});

Then("system-specific functions may not execute correctly", () => {
 EdgeCasePage.verifySystemFunctions();
});

Then("the application may rely on deprecated features", () => {
 EdgeCasePage.verifyDeprecatedFeatures();
});

Then("navigation may not be smooth or intuitive", () => {
 EdgeCasePage.verifyNavigation();
});

Then("the layout may be inconsistent across screens", () => {
 EdgeCasePage.verifyLayoutConsistency();
});

Then("system-specific warnings may be shown", () => {
 EdgeCasePage.verifySystemWarnings();
});

Then("the application may perform inefficiently", () => {
 EdgeCasePage.verifyPerformance();
});

Then("the application may not be responsive", () => {
 EdgeCasePage.verifyResponsiveness();
});

Then("error messages indicate unsupported OS version", () => {
 EdgeCasePage.verifyErrorMessages();
});