import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AppPage from "../pages/appPage";

Given("I have access to a Samsung Galaxy S9 with Android 8.0", () => {
 AppPage.accessDevice("Samsung Galaxy S9", "Android 8.0");
});

When("I download the application from the Google Play Store", () => {
 AppPage.downloadApp();
});

Then("the application downloads successfully", () => {
 AppPage.verifyDownloadSuccess();
});

Given("I have access to a Google Pixel 4 with Android 10", () => {
 AppPage.accessDevice("Google Pixel 4", "Android 10");
});

When("I install the application and open it", () => {
 AppPage.installAndOpenApp();
});

Then("the application installs and opens without errors", () => {
 AppPage.verifyInstallationAndOpening();
});

Given("the application is installed and opened", () => {
 AppPage.verifyAppOpened();
});

When("I navigate through the application", () => {
 AppPage.navigateApp();
});

Then("basic functionalities work as expected", () => {
 AppPage.verifyBasicFunctionalities();
});

Given("I repeat steps 1-3 on Google Pixel 4 with Android 10", () => {
 AppPage.repeatSteps("Google Pixel 4", "Android 10");
});

Then("the application installs and functions correctly", () => {
 AppPage.verifyInstallationAndFunctionality();
});

Given("the application is installed on Android 8.0+ devices", () => {
 AppPage.verifyAppInstalledOnDevices("Android 8.0+");
});

When("I test application performance", () => {
 AppPage.testPerformance();
});

Then("the application performs efficiently without lag", () => {
 AppPage.verifyPerformanceEfficiency();
});

Given("the application is installed on different Android 8.0+ versions", () => {
 AppPage.verifyAppInstalledOnDifferentVersions("Android 8.0+");
});

When("I check application responsiveness", () => {
 AppPage.checkResponsiveness();
});

Then("the application is responsive across Android 8.0+ versions", () => {
 AppPage.verifyResponsivenessAcrossVersions();
});

Given("the application is being installed", () => {
 AppPage.verifyInstallationInProgress();
});

When("I check for system notifications", () => {
 AppPage.checkSystemNotifications();
});

Then("no unexpected notifications are shown", () => {
 AppPage.verifyNoUnexpectedNotifications();
});

Given("the application is opened", () => {
 AppPage.verifyAppOpened();
});

When("I test media content loading such as images and videos", () => {
 AppPage.testMediaContentLoading();
});

Then("media content loads without distortion or error", () => {
 AppPage.verifyMediaContentLoading();
});

When("I verify interactive elements such as sliders and dropdowns", () => {
 AppPage.verifyInteractiveElements();
});

Then("interactive elements function correctly", () => {
 AppPage.verifyInteractiveElementsFunctionality();
});

Given("the application is opened on Android 8.0+ devices", () => {
 AppPage.verifyAppOpenedOnDevices("Android 8.0+");
});

When("I test accessibility features", () => {
 AppPage.testAccessibilityFeatures();
});

Then("accessibility features are functional", () => {
 AppPage.verifyAccessibilityFeatures();
});

When("I verify compatibility with Android-specific functions", () => {
 AppPage.verifyAndroidSpecificFunctions();
});

Then("Android-specific functions execute correctly", () => {
 AppPage.verifyAndroidSpecificFunctionExecution();
});

When("I check for deprecated Android features", () => {
 AppPage.checkDeprecatedFeatures();
});

Then("the application does not rely on deprecated features", () => {
 AppPage.verifyNoDeprecatedFeatures();
});

When("I test application navigation", () => {
 AppPage.testNavigation();
});

Then("navigation is smooth and intuitive", () => {
 AppPage.verifyNavigationSmoothness();
});

When("I verify application layout consistency across different screens", () => {
 AppPage.verifyLayoutConsistency();
});

Then("layout is consistent across all screens", () => {
 AppPage.verifyLayoutAcrossScreens();
});

When("I check for system-specific warnings or suggestions", () => {
 AppPage.checkSystemWarnings();
});

Then("no system-specific warnings are shown", () => {
 AppPage.verifyNoSystemWarnings();
});