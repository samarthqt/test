import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import BrowserPage from "../pages/browserPage";

Given("the application is deployed on the stage environment", () => {
 BrowserPage.visitStage();
});

When("I open the application in Internet Explorer 11", () => {
 BrowserPage.openInIE11();
});

Then("the application loads without UI distortions", () => {
 BrowserPage.checkNoUIDistortions();
});

Given("the application is open in Firefox 45", () => {
 BrowserPage.openInFirefox45();
});

When("I navigate through the homepage", () => {
 BrowserPage.navigateHomepage();
});

Then("homepage elements are displayed correctly without overlapping", () => {
 BrowserPage.checkNoOverlapping();
});

Given("the application is open in Chrome 49", () => {
 BrowserPage.openInChrome49();
});

When("I click on various links and buttons", () => {
 BrowserPage.clickLinksAndButtons();
});

Then("all links and buttons function as expected", () => {
 BrowserPage.checkLinksButtonsFunctionality();
});

Given("the steps 1-3 are repeated using Firefox 45", () => {
 BrowserPage.repeatStepsInFirefox45();
});

Then("the application functions correctly without UI distortions", () => {
 BrowserPage.checkFunctionalityNoUIDistortions();
});

Given("the steps 1-3 are repeated using Chrome 49", () => {
 BrowserPage.repeatStepsInChrome49();
});

Then("the application functions correctly without UI distortions", () => {
 BrowserPage.checkFunctionalityNoUIDistortions();
});

Given("the application is open in an outdated browser", () => {
 BrowserPage.openInOutdatedBrowser();
});

When("I navigate through the application", () => {
 BrowserPage.navigateApplication();
});

Then("no critical console errors are present", () => {
 BrowserPage.checkNoConsoleErrors();
});

When("I observe the CSS styles", () => {
 BrowserPage.observeCSSStyles();
});

Then("CSS styles are consistent across outdated browsers", () => {
 BrowserPage.checkCSSConsistency();
});

When("I submit forms", () => {
 BrowserPage.submitForms();
});

Then("forms submit successfully without errors", () => {
 BrowserPage.checkFormSubmission();
});

When("I observe responsive design elements", () => {
 BrowserPage.observeResponsiveElements();
});

Then("responsive design elements adjust correctly", () => {
 BrowserPage.checkResponsiveAdjustment();
});

When("I load media content such as images and videos", () => {
 BrowserPage.loadMediaContent();
});

Then("media content loads without distortion or error", () => {
 BrowserPage.checkMediaContentLoading();
});

When("I interact with elements such as sliders and dropdowns", () => {
 BrowserPage.interactWithInteractiveElements();
});

Then("interactive elements function correctly", () => {
 BrowserPage.checkInteractiveFunctionality();
});

When("I check for HTML/CSS features", () => {
 BrowserPage.checkHTMLCSSFeatures();
});

Then("the application does not rely on deprecated features", () => {
 BrowserPage.checkNoDeprecatedFeatures();
});

When("I test accessibility features", () => {
 BrowserPage.testAccessibilityFeatures();
});

Then("accessibility features are functional", () => {
 BrowserPage.checkAccessibilityFunctionality();
});

When("I execute JavaScript functions", () => {
 BrowserPage.executeJavaScriptFunctions();
});

Then("JavaScript functions execute correctly", () => {
 BrowserPage.checkJavaScriptExecution();
});

When("I observe for warnings or suggestions", () => {
 BrowserPage.observeWarningsSuggestions();
});

Then("no browser-specific warnings are shown", () => {
 BrowserPage.checkNoBrowserSpecificWarnings();
});