import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoadTimePage from "../pages/loadTimePage";

Given("the application is deployed on the web platform", () => {
 LoadTimePage.deployWebPlatform();
});

Given("the application is deployed on the mobile platform", () => {
 LoadTimePage.deployMobilePlatform();
});

Given("the application is deployed on both web and mobile platforms", () => {
 LoadTimePage.deployBothPlatforms();
});

Given("the application load time is being monitored", () => {
 LoadTimePage.monitorLoadTime();
});

Given("the application is accessed under different network conditions", () => {
 LoadTimePage.accessUnderDifferentNetworkConditions();
});

When("a user accesses the application using a web browser", () => {
 LoadTimePage.accessUsingWebBrowser();
});

When("a user accesses the application using a mobile device", () => {
 LoadTimePage.accessUsingMobileDevice();
});

When("a user accesses the application using {string} on {string}", (device, browser) => {
 LoadTimePage.accessUsingDeviceAndBrowser(device, browser);
});

When("the load time exceeds 3 seconds", () => {
 LoadTimePage.checkLoadTimeExceeds();
});

When("a user accesses the application", () => {
 LoadTimePage.accessApplication();
});

Then("the application should load within 3 seconds", () => {
 LoadTimePage.verifyLoadTimeWithinLimit();
});

Then("a performance optimization process should be triggered", () => {
 LoadTimePage.triggerPerformanceOptimization();
});

Then("the load time should remain consistent within 3 seconds", () => {
 LoadTimePage.verifyConsistentLoadTime();
});

Then("user experience should not be compromised", () => {
 LoadTimePage.verifyUserExperienceNotCompromised();
});