import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import MobileAppPage from "../pages/mobileAppPage";

Given("an unlocked iPhone X device with iOS 12", () => {
 MobileAppPage.setupIOSDevice();
});

Given("an Android 8.0+ device", () => {
 MobileAppPage.setupAndroidDevice();
});

Given("normal network conditions with 100Mbps speed", () => {
 MobileAppPage.setupNetworkConditions();
});

Given("slightly reduced network conditions", () => {
 MobileAppPage.setupReducedNetworkConditions();
});

Given("peak hour conditions", () => {
 MobileAppPage.setupPeakHourConditions();
});

Given("various mobile browsers are used", () => {
 MobileAppPage.setupVariousBrowsers();
});

Given("the application is loaded on a mobile device", () => {
 MobileAppPage.ensureAppIsLoaded();
});

Given("the application has been updated", () => {
 MobileAppPage.updateApplication();
});

Given("the application is accessed repeatedly", () => {
 MobileAppPage.accessRepeatedly();
});

When("the user navigates to the application home page on the mobile browser", () => {
 MobileAppPage.navigateToHomePage();
});

When("starts a timer as the page begins loading", () => {
 MobileAppPage.startLoadingTimer();
});

Then("the application loads within 3 seconds", () => {
 MobileAppPage.verifyLoadingTime(3);
});

Then("the application still loads within 3 seconds", () => {
 MobileAppPage.verifyLoadingTime(3);
});

Then("repeated access does not affect loading time", () => {
 MobileAppPage.verifyRepeatedAccessLoadingTime();
});

Then("no performance degradation is observed", () => {
 MobileAppPage.verifyNoPerformanceDegradation();
});

Then("all application features are functional", () => {
 MobileAppPage.verifyAllFeaturesFunctional();
});

Then("no errors are present in the mobile browser console", () => {
 MobileAppPage.verifyNoConsoleErrors();
});

Then("the application layout and design appear correctly", () => {
 MobileAppPage.verifyLayoutAndDesign();
});

Then("loading times are logged accurately for all devices", () => {
 MobileAppPage.verifyLoadingTimesLogged();
});

Then("loading times remain consistent", () => {
 MobileAppPage.verifyConsistentLoadingTimes();
});

Then("the application loads within 3 seconds on all tested mobile browsers", () => {
 MobileAppPage.verifyMultiBrowserLoadingTime(3);
});

Then("the application is optimized and loads efficiently on mobile devices", () => {
 MobileAppPage.verifyOptimizationAndEfficiency();
});