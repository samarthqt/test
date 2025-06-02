import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import MobileAppPage from "../pages/mobileAppPage";

Given("the application is installed on an {string} device", (deviceType) => {
 MobileAppPage.install(deviceType);
});

When("the application is opened", () => {
 MobileAppPage.open();
});

Then("the application opens successfully on the {string} device", (deviceType) => {
 MobileAppPage.verifyOpenSuccess(deviceType);
});

Given("the application is opened on an {string} device", (deviceType) => {
 MobileAppPage.openOnDevice(deviceType);
});

When("navigating through different sections of the application", () => {
 MobileAppPage.navigateSections();
});

Then("navigation through sections is smooth and responsive", () => {
 MobileAppPage.verifyNavigationResponsiveness();
});

When("checking the application layout on {string} screen size", (screenSize) => {
 MobileAppPage.checkLayout(screenSize);
});

Then("the application layout adjusts correctly on {string} screen size", (screenSize) => {
 MobileAppPage.verifyLayoutAdjustment(screenSize);
});

When("testing responsiveness of interactive elements like buttons and menus", () => {
 MobileAppPage.testInteractiveElements();
});

Then("interactive elements respond correctly on all devices", () => {
 MobileAppPage.verifyInteractiveElements();
});

When("checking the application performance during network fluctuations", () => {
 MobileAppPage.checkPerformanceNetworkFluctuations();
});

Then("application performance remains stable during network fluctuations", () => {
 MobileAppPage.verifyPerformanceStability();
});

When("verifying touch gestures like swipe, pinch, and zoom", () => {
 MobileAppPage.verifyTouchGestures();
});

Then("touch gestures work correctly across all devices", () => {
 MobileAppPage.verifyGesturesFunctionality();
});

When("testing application loading speed on mobile data", () => {
 MobileAppPage.testLoadingSpeed();
});

Then("the application loads within acceptable time on mobile data", () => {
 MobileAppPage.verifyLoadingSpeed();
});

When("checking application behavior on device rotation", () => {
 MobileAppPage.checkBehaviorDeviceRotation();
});

Then("the application adjusts layout correctly on device rotation", () => {
 MobileAppPage.verifyRotationAdjustment();
});