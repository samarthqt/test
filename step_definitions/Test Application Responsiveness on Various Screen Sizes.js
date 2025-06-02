import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ResponsivePage from "../pages/responsivePage";

Given("I have a device with screen size {int}x{int} pixels", (width, height) => {
 cy.viewport(width, height);
});

Given("I have opened the application on a device with screen size {int}x{int} pixels", (width, height) => {
 cy.viewport(width, height);
 ResponsivePage.openApplication();
});

Given("I have devices with various screen sizes", () => {
 // This step is a placeholder for iterating through multiple screen sizes
});

Given("I have devices with portrait and landscape orientations", () => {
 // This step is a placeholder for testing both orientations
});

When("I open the application", () => {
 ResponsivePage.openApplication();
});

When("I navigate through the application", () => {
 ResponsivePage.navigateThroughApplication();
});

When("I check the layout and alignment of UI elements", () => {
 ResponsivePage.checkLayoutAndAlignment();
});

When("I check images and multimedia content", () => {
 ResponsivePage.checkImagesAndMultimedia();
});

When("I test interactive elements such as buttons and links", () => {
 ResponsivePage.testInteractiveElements();
});

When("I scroll through the application", () => {
 ResponsivePage.scrollThroughApplication();
});

When("I check font sizes and readability", () => {
 ResponsivePage.checkFontSizesAndReadability();
});

When("I identify any responsiveness issues", () => {
 ResponsivePage.identifyResponsivenessIssues();
});

When("I switch between orientations", () => {
 ResponsivePage.switchOrientations();
});

Then("the application should load correctly", () => {
 ResponsivePage.verifyApplicationLoad();
});

Then("navigation should be smooth and all UI elements should be accessible", () => {
 ResponsivePage.verifyNavigationSmoothness();
});

Then("UI elements should be correctly aligned and not overlap", () => {
 ResponsivePage.verifyUIAlignment();
});

Then("they should resize appropriately to fit the screen", () => {
 ResponsivePage.verifyImageResizing();
});

Then("interactive elements should be easily clickable and responsive", () => {
 ResponsivePage.verifyInteractiveElements();
});

Then("scrolling should be smooth without any abrupt stops or jumps", () => {
 ResponsivePage.verifyScrollingSmoothness();
});

Then("font sizes should be consistent and text should be easily readable", () => {
 ResponsivePage.verifyFontConsistency();
});

Then("I should document and report them to the development team", () => {
 ResponsivePage.documentAndReportIssues();
});

Then("the application should display correctly without layout issues", () => {
 ResponsivePage.verifyOrientationAdaptability();
});