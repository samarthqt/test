import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ApplicationPage from "../pages/applicationPage";

Given("the application is deployed on the stage environment", () => {
 ApplicationPage.visitStage();
});

When("I open the application on a browser with a window size of {string}", (size) => {
 ApplicationPage.setWindowSize(size);
});

Then("the application adjusts to fit the window size without distortion", () => {
 ApplicationPage.verifyResponsiveAdjustment();
});

Given("the browser window size is {string}", (size) => {
 ApplicationPage.setWindowSize(size);
});

When("I navigate through the homepage", () => {
 ApplicationPage.navigateHomepage();
});

Then("homepage elements are displayed correctly without overlapping", () => {
 ApplicationPage.verifyHomepageLayout();
});

Given("I have opened the application", () => {
 ApplicationPage.open();
});

When("I resize the window to {string}", (size) => {
 ApplicationPage.resizeWindow(size);
});

Then("the application adjusts to the new window size smoothly", () => {
 ApplicationPage.verifyResizeAdjustment();
});

Given("a form is available in the application", () => {
 ApplicationPage.verifyFormPresence();
});

When("I submit the form", () => {
 ApplicationPage.submitForm();
});

Then("form fields are aligned correctly within the window size", () => {
 ApplicationPage.verifyFormAlignment();
});

Given("media content is present in the application", () => {
 ApplicationPage.verifyMediaContent();
});

When("I load the media content", () => {
 ApplicationPage.loadMediaContent();
});

Then("the media content loads without distortion or error", () => {
 ApplicationPage.verifyMediaLoad();
});

Given("interactive elements are present", () => {
 ApplicationPage.verifyInteractiveElements();
});

When("I interact with sliders and dropdowns", () => {
 ApplicationPage.interactWithElements();
});

Then("interactive elements function correctly within the window size", () => {
 ApplicationPage.verifyElementFunctionality();
});

Given("the application supports accessibility features", () => {
 ApplicationPage.verifyAccessibilitySupport();
});

When("I use the application at minimum window size", () => {
 ApplicationPage.setWindowSize("800x600");
});

Then("accessibility features are functional", () => {
 ApplicationPage.verifyAccessibilityFunctionality();
});

Given("CSS styles and responsive design elements are implemented", () => {
 ApplicationPage.verifyCSSImplementation();
});

When("I view the application", () => {
 ApplicationPage.viewApplication();
});

Then("CSS styles and responsive elements adjust correctly", () => {
 ApplicationPage.verifyCSSAdjustment();
});

Given("I am navigating through the application", () => {
 ApplicationPage.navigateApplication();
});

When("I check the console", () => {
 ApplicationPage.checkConsole();
});

Then("no critical console errors are present", () => {
 ApplicationPage.verifyNoConsoleErrors();
});

Given("the application is running", () => {
 ApplicationPage.verifyApplicationRunning();
});

When("I use the application at minimum window size", () => {
 ApplicationPage.setWindowSize("800x600");
});

Then("the application performs efficiently without lag", () => {
 ApplicationPage.verifyPerformance();
});

Given("JavaScript functions are used in the application", () => {
 ApplicationPage.verifyJavaScriptUsage();
});

When("I execute JavaScript functions", () => {
 ApplicationPage.executeJavaScript();
});

Then("JavaScript functions execute correctly", () => {
 ApplicationPage.verifyJavaScriptExecution();
});

Given("I am using a browser to access the application", () => {
 ApplicationPage.accessViaBrowser();
});

When("I check for warnings or suggestions", () => {
 ApplicationPage.checkBrowserWarnings();
});

Then("no browser-specific warnings are shown", () => {
 ApplicationPage.verifyNoBrowserWarnings();
});

Given("the application is open", () => {
 ApplicationPage.open();
});

When("I navigate through the application", () => {
 ApplicationPage.navigateApplication();
});

Then("navigation is smooth and intuitive", () => {
 ApplicationPage.verifyNavigation();
});

Given("the application has multiple pages", () => {
 ApplicationPage.verifyMultiplePages();
});

When("I navigate across different pages", () => {
 ApplicationPage.navigateDifferentPages();
});

Then("layout is consistent across all pages", () => {
 ApplicationPage.verifyLayoutConsistency();
});

Given("the application uses HTML/CSS", () => {
 ApplicationPage.verifyHTMLCSSUsage();
});

When("I inspect the application", () => {
 ApplicationPage.inspectApplication();
});

Then("the application does not rely on deprecated features", () => {
 ApplicationPage.verifyNoDeprecatedFeatures();
});