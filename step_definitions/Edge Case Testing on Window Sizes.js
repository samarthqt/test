import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import EdgeCasePage from "../pages/edgeCasePage";

Given("I have a browser with a window size of {int}x{int}", (width, height) => {
 EdgeCasePage.setWindowSize(width, height);
});

Given("network throttling is enabled", () => {
 EdgeCasePage.enableNetworkThrottling();
});

Given("JavaScript is disabled in the browser", () => {
 EdgeCasePage.disableJavaScript();
});

Given("I have a browser with extreme window sizes", () => {
 EdgeCasePage.setExtremeWindowSizes();
});

When("I open the application", () => {
 EdgeCasePage.openApplication();
});

When("I navigate through the homepage", () => {
 EdgeCasePage.navigateHomepage();
});

When("I test the application functionality", () => {
 EdgeCasePage.testFunctionality();
});

When("I open the application under network throttling", () => {
 EdgeCasePage.openApplicationWithThrottling();
});

When("I check the browser console", () => {
 EdgeCasePage.checkConsoleErrors();
});

When("I verify the CSS styles", () => {
 EdgeCasePage.verifyCSSStyles();
});

When("I attempt to submit a form", () => {
 EdgeCasePage.submitForm();
});

When("I check responsive design elements", () => {
 EdgeCasePage.checkResponsiveDesign();
});

When("I test media content loading", () => {
 EdgeCasePage.testMediaContent();
});

When("I verify interactive elements", () => {
 EdgeCasePage.verifyInteractiveElements();
});

When("I check for deprecated HTML/CSS features", () => {
 EdgeCasePage.checkDeprecatedFeatures();
});

When("I test accessibility features", () => {
 EdgeCasePage.testAccessibilityFeatures();
});

When("I verify compatibility with JavaScript functions", () => {
 EdgeCasePage.verifyJavaScriptCompatibility();
});

When("I check for browser-specific warnings", () => {
 EdgeCasePage.checkBrowserWarnings();
});

When("I test application navigation", () => {
 EdgeCasePage.testNavigation();
});

Then("the application should load with potential UI distortions", () => {
 cy.get('body').should('exist');
});

Then("homepage elements may overlap or misalign", () => {
 cy.get('header').should('exist');
});

Then("some functionalities may not work as expected", () => {
 cy.get('button').should('exist');
});

Then("the application may exhibit unexpected behavior", () => {
 cy.get('main').should('exist');
});

Then("console may show errors related to loading resources", () => {
 cy.get('console').should('exist');
});

Then("CSS styles may not be applied correctly", () => {
 cy.get('style').should('exist');
});

Then("the form may not submit successfully", () => {
 cy.get('form').should('exist');
});

Then("responsive elements may not adjust correctly", () => {
 cy.get('responsive').should('exist');
});

Then("media content may not load correctly", () => {
 cy.get('media').should('exist');
});

Then("interactive elements may not function correctly", () => {
 cy.get('interactive').should('exist');
});

Then("the application may rely on deprecated features", () => {
 cy.get('deprecated').should('exist');
});

Then("accessibility features may not be functional", () => {
 cy.get('accessibility').should('exist');
});

Then("JavaScript functions may not execute correctly", () => {
 cy.get('script').should('exist');
});

Then("browser-specific warnings may be shown", () => {
 cy.get('warnings').should('exist');
});

Then("navigation may not be smooth or intuitive", () => {
 cy.get('navigation').should('exist');
});