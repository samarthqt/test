import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import MobileAppPage from "../pages/mobileAppPage";

Given("the user has an iOS device with version 12 or higher", () => {
 MobileAppPage.verifyIOSDeviceVersion(12);
});

Given("the user has an Android device with version 8.0 or higher", () => {
 MobileAppPage.verifyAndroidDeviceVersion(8.0);
});

Given("the user has installed the mobile application on a supported version", () => {
 MobileAppPage.verifyAppInstalledOnSupportedVersion();
});

Given("the mobile application is installed on a supported version", () => {
 MobileAppPage.verifyAppInstalledOnSupportedVersion();
});

When("the user installs the mobile application", () => {
 MobileAppPage.installApplication();
});

When("the user uses the application", () => {
 MobileAppPage.useApplication();
});

When("a new update is available", () => {
 MobileAppPage.checkForUpdate();
});

When("the user navigates through the application", () => {
 MobileAppPage.navigateThroughApplication();
});

Then("the application should install successfully", () => {
 MobileAppPage.verifySuccessfulInstallation();
});

Then("the application should run without issues", () => {
 MobileAppPage.verifyAppRunsWithoutIssues();
});

Then("there should be no functionality issues", () => {
 MobileAppPage.verifyNoFunctionalityIssues();
});

Then("the application should prompt the user to update", () => {
 MobileAppPage.verifyUpdatePrompt();
});

Then("the update should install successfully", () => {
 MobileAppPage.verifySuccessfulUpdateInstallation();
});

Then("the application should maintain compatibility", () => {
 MobileAppPage.verifyCompatibility();
});

Then("the user experience should be seamless and consistent across all supported versions", () => {
 MobileAppPage.verifySeamlessUserExperience();
});