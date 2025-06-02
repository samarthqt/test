import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OutdatedBrowserPage from "../pages/outdatedBrowserPage";

Given("the application is deployed on the stage environment", () => {
 OutdatedBrowserPage.visitStage();
});

Given("the application is opened in Internet Explorer 11", () => {
 OutdatedBrowserPage.openInIE11();
});

Given("the application is opened in Firefox 45", () => {
 OutdatedBrowserPage.openInFirefox45();
});

Given("the application is opened in Chrome 49", () => {
 OutdatedBrowserPage.openInChrome49();
});

Given("the application is opened in an outdated browser", () => {
 OutdatedBrowserPage.openInOutdatedBrowser();
});

When("the application is opened in Internet Explorer 11", () => {
 OutdatedBrowserPage.checkFunctionalityIssues();
});

When("navigating through the homepage", () => {
 OutdatedBrowserPage.navigateHomepage();
});

When("clicking on various links and buttons", () => {
 OutdatedBrowserPage.clickLinksAndButtons();
});

When("repeating steps 1-3", () => {
 OutdatedBrowserPage.repeatSteps();
});

When("navigating through the application", () => {
 OutdatedBrowserPage.navigateApplication();
});

When("verifying CSS styles", () => {
 OutdatedBrowserPage.verifyCSSStyles();
});

When("testing form submissions", () => {
 OutdatedBrowserPage.testFormSubmissions();
});

When("checking for responsive design elements", () => {
 OutdatedBrowserPage.checkResponsiveDesign();
});

When("testing media content loading", () => {
 OutdatedBrowserPage.testMediaContent();
});

When("verifying interactive elements", () => {
 OutdatedBrowserPage.verifyInteractiveElements();
});

When("checking for deprecated HTML/CSS features", () => {
 OutdatedBrowserPage.checkDeprecatedFeatures();
});

When("testing accessibility features", () => {
 OutdatedBrowserPage.testAccessibilityFeatures();
});

When("verifying JavaScript functions", () => {
 OutdatedBrowserPage.verifyJavaScriptFunctions();
});

When("checking for browser-specific warnings or suggestions", () => {
 OutdatedBrowserPage.checkBrowserWarnings();
});

Then("the application loads with functionality issues", () => {
 OutdatedBrowserPage.verifyFunctionalityIssues();
});

Then("homepage elements are not displayed correctly", () => {
 OutdatedBrowserPage.verifyHomepageElements();
});

Then("some links and buttons do not function as expected", () => {
 OutdatedBrowserPage.verifyLinksAndButtons();
});

Then("the application functions incorrectly with UI distortions", () => {
 OutdatedBrowserPage.verifyUIDistortions();
});

Then("critical console errors are present", () => {
 OutdatedBrowserPage.verifyConsoleErrors();
});

Then("CSS styles are inconsistent across outdated browsers", () => {
 OutdatedBrowserPage.verifyCSSInconsistencies();
});

Then("forms do not submit successfully", () => {
 OutdatedBrowserPage.verifyFormSubmissions();
});

Then("responsive design elements do not adjust correctly", () => {
 OutdatedBrowserPage.verifyResponsiveDesign();
});

Then("media content does not load correctly", () => {
 OutdatedBrowserPage.verifyMediaContentLoading();
});

Then("interactive elements do not function correctly", () => {
 OutdatedBrowserPage.verifyInteractiveElementsFunctionality();
});

Then("the application relies on deprecated features", () => {
 OutdatedBrowserPage.verifyDeprecatedFeatures();
});

Then("accessibility features are not functional", () => {
 OutdatedBrowserPage.verifyAccessibilityFeatures();
});

Then("JavaScript functions do not execute correctly", () => {
 OutdatedBrowserPage.verifyJavaScriptExecution();
});

Then("browser-specific warnings are shown", () => {
 OutdatedBrowserPage.verifyBrowserWarnings();
});