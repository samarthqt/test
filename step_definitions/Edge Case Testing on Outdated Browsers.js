import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import EdgeCasePage from "../pages/edgeCasePage";

Given("the application is deployed on the stage environment", () => {
 EdgeCasePage.visitStageEnvironment();
});

When("I open the application in Internet Explorer 11 with network throttling", () => {
 EdgeCasePage.openInIE11WithThrottling();
});

Then("the application should load with potential UI distortions", () => {
 EdgeCasePage.verifyUIDistortions();
});

Given("I am using Firefox 45", () => {
 EdgeCasePage.useFirefox45();
});

When("I navigate through the homepage with low resolution settings", () => {
 EdgeCasePage.navigateHomepageLowResolution();
});

Then("homepage elements may overlap or misalign", () => {
 EdgeCasePage.verifyOverlapMisalign();
});

Given("I am using Chrome 49", () => {
 EdgeCasePage.useChrome49();
});

When("I test the functionality with JavaScript disabled", () => {
 EdgeCasePage.testFunctionalityJSDisabled();
});

Then("some functionalities may not work as expected", () => {
 EdgeCasePage.verifyFunctionalityIssues();
});

Given("I am using {string}", (browser) => {
 EdgeCasePage.useBrowser(browser);
});

When("I perform steps 1-3", () => {
 EdgeCasePage.performSteps1To3();
});

Then("the application may exhibit unexpected behavior", () => {
 EdgeCasePage.verifyUnexpectedBehavior();
});

Given("the application is running with network throttling", () => {
 EdgeCasePage.runWithNetworkThrottling();
});

When("I check the console", () => {
 EdgeCasePage.checkConsoleForErrors();
});

Then("console may show errors related to loading resources", () => {
 EdgeCasePage.verifyConsoleErrors();
});

Given("I am using low resolution settings", () => {
 EdgeCasePage.useLowResolutionSettings();
});

When("I verify CSS styles", () => {
 EdgeCasePage.verifyCSSStyles();
});

Then("CSS styles may not be applied correctly", () => {
 EdgeCasePage.verifyCSSApplicationIssues();
});

Given("I have JavaScript disabled", () => {
 EdgeCasePage.disableJavaScript();
});

When("I test form submissions", () => {
 EdgeCasePage.testFormSubmissions();
});

Then("forms may not submit successfully", () => {
 EdgeCasePage.verifyFormSubmissionIssues();
});

When("I check responsive design elements", () => {
 EdgeCasePage.checkResponsiveDesign();
});

Then("responsive elements may not adjust correctly", () => {
 EdgeCasePage.verifyResponsiveAdjustment();
});

When("I test media content loading", () => {
 EdgeCasePage.testMediaContentLoading();
});

Then("media content may not load correctly", () => {
 EdgeCasePage.verifyMediaLoadingIssues();
});

When("I verify interactive elements", () => {
 EdgeCasePage.verifyInteractiveElements();
});

Then("interactive elements may not function correctly", () => {
 EdgeCasePage.verifyInteractiveFunctionality();
});

When("I check for deprecated HTML/CSS features", () => {
 EdgeCasePage.checkDeprecatedFeatures();
});

Then("the application may rely on deprecated features", () => {
 EdgeCasePage.verifyDeprecatedUsage();
});

When("I test accessibility features", () => {
 EdgeCasePage.testAccessibilityFeatures();
});

Then("accessibility features may not be functional", () => {
 EdgeCasePage.verifyAccessibilityIssues();
});

When("I verify compatibility with JavaScript functions", () => {
 EdgeCasePage.verifyJSFunctionCompatibility();
});

Then("JavaScript functions may not execute correctly", () => {
 EdgeCasePage.verifyJSExecutionIssues();
});

When("I check for browser-specific warnings", () => {
 EdgeCasePage.checkBrowserWarnings();
});

Then("browser-specific warnings may be shown", () => {
 EdgeCasePage.verifyBrowserWarnings();
});