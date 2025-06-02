import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ApplicationPage from "../pages/applicationPage";

Given("the application is deployed on the stage environment", () => {
 ApplicationPage.visitStageEnvironment();
});

When("the application is opened on a browser with a window size of 1920x1080", () => {
 ApplicationPage.setWindowSize(1920, 1080);
});

Then("the application should adjust correctly to fit the window size", () => {
 ApplicationPage.verifyResponsiveLayout();
});

When("navigating through the homepage", () => {
 ApplicationPage.navigateHomepage();
});

Then("homepage elements should not overlap or be misaligned", () => {
 ApplicationPage.verifyHomepageLayout();
});

When("resizing the window to 2560x1440", () => {
 ApplicationPage.setWindowSize(2560, 1440);
});

Then("the application should adjust smoothly to the new window size", () => {
 ApplicationPage.verifyResponsiveLayout();
});

When("testing form submissions", () => {
 ApplicationPage.testFormSubmissions();
});

Then("form fields should be aligned within the window size", () => {
 ApplicationPage.verifyFormAlignment();
});

When("verifying media content loading", () => {
 ApplicationPage.verifyMediaContent();
});

Then("media content should load without distortion or error", () => {
 ApplicationPage.verifyMediaContentLoading();
});

When("checking interactive elements", () => {
 ApplicationPage.checkInteractiveElements();
});

Then("interactive elements should function correctly within the window size", () => {
 ApplicationPage.verifyInteractiveElements();
});

When("testing accessibility features", () => {
 ApplicationPage.testAccessibilityFeatures();
});

Then("accessibility features should be functional", () => {
 ApplicationPage.verifyAccessibilityFeatures();
});

When("verifying CSS styles and responsive design elements", () => {
 ApplicationPage.verifyCSSAndResponsiveDesign();
});

Then("CSS styles and responsive elements should adjust correctly", () => {
 ApplicationPage.verifyResponsiveElements();
});

When("checking for console errors during navigation", () => {
 ApplicationPage.checkConsoleErrors();
});

Then("no critical console errors should be present", () => {
 ApplicationPage.verifyNoCriticalConsoleErrors();
});

When("testing application performance at maximum window size", () => {
 ApplicationPage.testPerformance();
});

Then("the application should perform efficiently without lag", () => {
 ApplicationPage.verifyPerformanceEfficiency();
});

When("verifying compatibility with JavaScript functions", () => {
 ApplicationPage.verifyJSFunctions();
});

Then("JavaScript functions should execute correctly", () => {
 ApplicationPage.verifyJSExecution();
});

When("checking for browser-specific warnings or suggestions", () => {
 ApplicationPage.checkBrowserWarnings();
});

Then("no browser-specific warnings should be shown", () => {
 ApplicationPage.verifyNoBrowserWarnings();
});

When("testing application navigation at maximum window size", () => {
 ApplicationPage.testNavigation();
});

Then("navigation should be smooth and intuitive", () => {
 ApplicationPage.verifyNavigation();
});

When("verifying application layout across different pages", () => {
 ApplicationPage.verifyLayoutConsistency();
});

Then("layout should be consistent across pages", () => {
 ApplicationPage.verifyConsistentLayout();
});

When("checking for deprecated HTML/CSS features", () => {
 ApplicationPage.checkDeprecatedFeatures();
});

Then("the application should not rely on deprecated features", () => {
 ApplicationPage.verifyNoDeprecatedFeatures();
});