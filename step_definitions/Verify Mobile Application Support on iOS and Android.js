import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import MobileAppPage from "../pages/mobileAppPage";

Given("I have access to the mobile application source code", () => {
 MobileAppPage.checkSourceCodeAccess();
});

When("I open the development environment for the mobile application", () => {
 MobileAppPage.openDevelopmentEnvironment();
});

Then("the development environment should load successfully without errors", () => {
 MobileAppPage.verifyEnvironmentLoaded();
});

Given("I have an iOS device with version 14.0", () => {
 MobileAppPage.connectIOSDevice("14.0");
});

When("I connect the iOS device to the development environment", () => {
 MobileAppPage.connectDeviceToEnvironment("iOS");
});

Then("the iOS device should be recognized by the development environment", () => {
 MobileAppPage.verifyDeviceRecognition("iOS");
});

Given("the iOS device is recognized by the development environment", () => {
 MobileAppPage.deviceIsRecognized("iOS");
});

When("I build and deploy the application to the iOS device", () => {
 MobileAppPage.buildAndDeployApp("iOS");
});

Then("the application should deploy successfully and be available on the iOS device", () => {
 MobileAppPage.verifyAppDeployment("iOS");
});

Given("the application is available on the iOS device", () => {
 MobileAppPage.appIsAvailable("iOS");
});

When("I launch the application on the iOS device", () => {
 MobileAppPage.launchApp("iOS");
});

Then("the application should launch without errors and display the home screen", () => {
 MobileAppPage.verifyAppLaunch();
});

Given("the application is launched on the iOS device", () => {
 MobileAppPage.appIsLaunched("iOS");
});

When("I perform basic navigation within the application", () => {
 MobileAppPage.performBasicNavigation();
});

Then("navigation should be smooth and responsive, with all screens displaying correctly", () => {
 MobileAppPage.verifyNavigation();
});

Given("I have an Android device with version 11.0", () => {
 MobileAppPage.connectAndroidDevice("11.0");
});

When("I connect the Android device to the development environment", () => {
 MobileAppPage.connectDeviceToEnvironment("Android");
});

Then("the Android device should be recognized by the development environment", () => {
 MobileAppPage.verifyDeviceRecognition("Android");
});

Given("the Android device is recognized by the development environment", () => {
 MobileAppPage.deviceIsRecognized("Android");
});

When("I build and deploy the application to the Android device", () => {
 MobileAppPage.buildAndDeployApp("Android");
});

Then("the application should deploy successfully and be available on the Android device", () => {
 MobileAppPage.verifyAppDeployment("Android");
});

Given("the application is available on the Android device", () => {
 MobileAppPage.appIsAvailable("Android");
});

When("I launch the application on the Android device", () => {
 MobileAppPage.launchApp("Android");
});

Then("the application should launch without errors and display the home screen", () => {
 MobileAppPage.verifyAppLaunch();
});

Given("the application is launched on the Android device", () => {
 MobileAppPage.appIsLaunched("Android");
});

When("I perform basic navigation within the application", () => {
 MobileAppPage.performBasicNavigation();
});

Then("navigation should be smooth and responsive, with all screens displaying correctly", () => {
 MobileAppPage.verifyNavigation();
});

Given("the application is launched on both iOS and Android devices", () => {
 MobileAppPage.appIsLaunchedOnBothDevices();
});

When("I test specific features such as login and data synchronization", () => {
 MobileAppPage.testSpecificFeatures();
});

Then("features should function identically on both iOS and Android devices", () => {
 MobileAppPage.verifyFeatureFunctionality();
});

When("I verify UI elements", () => {
 MobileAppPage.verifyUIElements();
});

Then("UI elements should be consistent in style and layout on both devices", () => {
 MobileAppPage.verifyUIConsistency();
});

When("I check for platform-specific errors or warnings during usage", () => {
 MobileAppPage.checkPlatformSpecificErrors();
});

Then("there should be no platform-specific errors or warnings", () => {
 MobileAppPage.verifyNoPlatformSpecificErrors();
});

When("I test device-specific functionalities such as camera access", () => {
 MobileAppPage.testDeviceSpecificFunctionalities();
});

Then("device-specific functionalities should work seamlessly on both platforms", () => {
 MobileAppPage.verifyDeviceFunctionalities();
});

When("I test application performance metrics", () => {
 MobileAppPage.testPerformanceMetrics();
});

Then("performance metrics should be within acceptable limits on both iOS and Android devices", () => {
 MobileAppPage.verifyPerformanceMetrics();
});

Given("I have tested the application on both iOS and Android devices", () => {
 MobileAppPage.applicationTestedOnBothDevices();
});

When("I document any issues found", () => {
 MobileAppPage.documentIssues();
});

Then("all issues should be documented clearly for further analysis and reported back to the development team", () => {
 MobileAppPage.verifyIssueDocumentation();
});