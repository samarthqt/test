import { Given, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingPage from "../pages/trackingPage";

Given("I access the tracking feature on {string} using {string}", (device, browser) => {
 TrackingPage.visit(device, browser);
});

Given("I enter tracking number {string} on {string} using {string}", (trackingNumber, device, browser) => {
 TrackingPage.enterTrackingNumber(trackingNumber, device, browser);
});

Given("I simulate slow network conditions on {string} using {string}", (device, browser) => {
 TrackingPage.simulateSlowNetwork(device, browser);
});

Given("I access the tracking feature using an older version of {string} on {string}", (browser, device) => {
 TrackingPage.visitWithOlderBrowserVersion(browser, device);
});

Given("I access the tracking feature on any device", () => {
 TrackingPage.visitOnAnyDevice();
});

Given("the {string} platform experiences high load", (platform) => {
 TrackingPage.simulateHighLoad(platform);
});

Then("the tracking feature should be accessible and display correctly", () => {
 TrackingPage.verifyAccessibilityAndDisplay();
});

Then("the tracking feature should adapt to various screen sizes", () => {
 TrackingPage.verifyResponsiveDesign();
});

Then("accessibility features should be functional and meet standards", () => {
 TrackingPage.verifyAccessibilityFeatures();
});

Then("tracking information should be displayed correctly", () => {
 TrackingPage.verifyTrackingInformationDisplay();
});

Then("tracking feature should load gracefully under slow network conditions", () => {
 TrackingPage.verifyGracefulLoadingUnderSlowNetwork();
});

Then("the tracking feature should be compatible with older browser versions", () => {
 TrackingPage.verifyCompatibilityWithOlderBrowserVersions();
});

Then("accessibility feedback should be provided to users", () => {
 TrackingPage.verifyAccessibilityFeedback();
});

Then("the system should remain responsive and accessible", () => {
 TrackingPage.verifySystemPerformanceUnderHighLoad();
});