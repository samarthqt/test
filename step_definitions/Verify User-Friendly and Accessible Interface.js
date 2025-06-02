import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserInterfacePage from "../pages/userInterfacePage";

Given("the user has valid credentials", () => {
 UserInterfacePage.setValidCredentials();
});

When("the user logs in to the application", () => {
 UserInterfacePage.login();
});

Then("the user should be successfully logged in and directed to the main interface", () => {
 UserInterfacePage.verifyLoginSuccess();
});

Given("the user is logged in to the application", () => {
 UserInterfacePage.ensureUserIsLoggedIn();
});

When("the user navigates through different sections of the interface", () => {
 UserInterfacePage.navigateSections();
});

Then("navigation should be smooth and intuitive", () => {
 UserInterfacePage.verifyNavigation();
});

Given("the user is on the main interface", () => {
 UserInterfacePage.goToMainInterface();
});

When("the user checks for accessibility features", () => {
 UserInterfacePage.checkAccessibilityFeatures();
});

Then("accessibility features such as text-to-speech and high contrast mode should be available", () => {
 UserInterfacePage.verifyAccessibilityFeatures();
});

Given("the user is accessing the interface on different devices", () => {
 UserInterfacePage.accessOnDifferentDevices();
});

When("the interface is displayed", () => {
 UserInterfacePage.displayInterface();
});

Then("the interface should adapt to various screen sizes and resolutions", () => {
 UserInterfacePage.verifyResponsiveness();
});

When("the user views text and labels", () => {
 UserInterfacePage.viewTextAndLabels();
});

Then("text and labels should be clear and readable", () => {
 UserInterfacePage.verifyTextReadability();
});

When("the user interacts with buttons, links, and other interactive elements", () => {
 UserInterfacePage.interactWithElements();
});

Then("these elements should function correctly", () => {
 UserInterfacePage.verifyElementFunctionality();
});

Given("the user is on multiple sections of the interface", () => {
 UserInterfacePage.goToMultipleSections();
});

When("the user views design elements", () => {
 UserInterfacePage.viewDesignElements();
});

Then("design elements should be consistent throughout the application", () => {
 UserInterfacePage.verifyDesignConsistency();
});

Given("the user performs an invalid action", () => {
 UserInterfacePage.performInvalidAction();
});

When("an error message is displayed", () => {
 UserInterfacePage.displayErrorMessage();
});

Then("error messages should guide users in resolving issues", () => {
 UserInterfacePage.verifyErrorMessage();
});

Given("the user is navigating to different pages", () => {
 UserInterfacePage.navigatePages();
});

When("a page is requested", () => {
 UserInterfacePage.requestPage();
});

Then("pages should load quickly without delays", () => {
 UserInterfacePage.verifyPageLoadSpeed();
});

When("the user checks for links and images", () => {
 UserInterfacePage.checkLinksAndImages();
});

Then("no broken links or missing images should be present", () => {
 UserInterfacePage.verifyLinksAndImages();
});

Given("the user wants to change the language", () => {
 UserInterfacePage.initiateLanguageChange();
});

When("the user selects a different language", () => {
 UserInterfacePage.selectLanguage();
});

Then("the interface should support language selection and display text accordingly", () => {
 UserInterfacePage.verifyLanguageSupport();
});

Given("the application is under high user traffic", () => {
 UserInterfacePage.simulateHighTraffic();
});

When("multiple users access the interface simultaneously", () => {
 UserInterfacePage.accessSimultaneously();
});

Then("the interface should perform efficiently under high traffic conditions", () => {
 UserInterfacePage.verifyPerformanceUnderHighTraffic();
});

When("the user accesses navigation menus", () => {
 UserInterfacePage.accessNavigationMenus();
});

Then("navigation menus should be easily accessible and user-friendly", () => {
 UserInterfacePage.verifyNavigationMenus();
});

When("the interface is evaluated against accessibility standards", () => {
 UserInterfacePage.evaluateAccessibilityStandards();
});

Then("the interface should comply with established accessibility standards", () => {
 UserInterfacePage.verifyAccessibilityCompliance();
});

When("the user wants to provide feedback", () => {
 UserInterfacePage.provideFeedback();
});

Then("users should be able to provide feedback on interface usability", () => {
 UserInterfacePage.verifyFeedbackMechanism();
});