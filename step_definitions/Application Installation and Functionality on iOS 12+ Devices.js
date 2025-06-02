import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AppPage from "../pages/appPage";

Given("the application is available for download in the App Store", () => {
 AppPage.checkAppAvailability();
});

When("the user downloads the application on iPhone 8 with iOS 12", () => {
 AppPage.downloadApp("iPhone 8", "iOS 12");
});

Then("the application downloads successfully", () => {
 AppPage.verifyDownloadSuccess();
});

Given("the application is downloaded on iPhone 11 with iOS 14", () => {
 AppPage.downloadApp("iPhone 11", "iOS 14");
});

When("the user installs and opens the application", () => {
 AppPage.installAndOpenApp();
});

Then("the application installs and opens without errors", () => {
 AppPage.verifyInstallAndOpenSuccess();
});

Given("the application is installed and opened", () => {
 AppPage.verifyInstallAndOpenSuccess();
});

When("the user navigates through the application", () => {
 AppPage.navigateApp();
});

Then("basic functionalities work as expected", () => {
 AppPage.verifyBasicFunctionalities();
});

When("the user downloads, installs, and navigates through the application on iPhone 11 with iOS 14", () => {
 AppPage.downloadApp("iPhone 11", "iOS 14");
 AppPage.installAndOpenApp();
 AppPage.navigateApp();
});

Then("the application installs and functions correctly", () => {
 AppPage.verifyInstallAndFunction();
});

Given("the application is installed", () => {
 AppPage.verifyInstallSuccess();
});

When("the user tests the application performance", () => {
 AppPage.testPerformance();
});

Then("the application performs efficiently without lag", () => {
 AppPage.verifyPerformance();
});

When("the user tests the application responsiveness across iOS 12+ versions", () => {
 AppPage.testResponsiveness();
});

Then("the application is responsive across iOS 12+ versions", () => {
 AppPage.verifyResponsiveness();
});

Given("the application is being installed", () => {
 AppPage.startInstallation();
});

When("the installation process is monitored", () => {
 AppPage.monitorInstallation();
});

Then("no unexpected notifications are shown", () => {
 AppPage.verifyNoNotifications();
});

When("the user loads media content such as images and videos", () => {
 AppPage.loadMediaContent();
});

Then("media content loads without distortion or error", () => {
 AppPage.verifyMediaContent();
});

When("the user interacts with elements like sliders and dropdowns", () => {
 AppPage.interactWithElements();
});

Then("interactive elements function correctly", () => {
 AppPage.verifyInteractiveElements();
});

When("the user tests accessibility features", () => {
 AppPage.testAccessibilityFeatures();
});

Then("accessibility features are functional", () => {
 AppPage.verifyAccessibilityFeatures();
});

When("the user tests iOS-specific functions", () => {
 AppPage.testIOSFunctions();
});

Then("iOS-specific functions execute correctly", () => {
 AppPage.verifyIOSFunctions();
});

When("the user checks for deprecated iOS features", () => {
 AppPage.checkDeprecatedFeatures();
});

Then("the application does not rely on deprecated features", () => {
 AppPage.verifyNoDeprecatedFeatures();
});

When("the user navigates through the application", () => {
 AppPage.navigateApp();
});

Then("navigation is smooth and intuitive", () => {
 AppPage.verifyNavigation();
});

When("the user views the application layout on different screens", () => {
 AppPage.viewLayout();
});

Then("layout is consistent across all screens", () => {
 AppPage.verifyLayoutConsistency();
});

When("the user checks for system-specific warnings or suggestions", () => {
 AppPage.checkSystemWarnings();
});

Then("no system-specific warnings are shown", () => {
 AppPage.verifyNoSystemWarnings();
});