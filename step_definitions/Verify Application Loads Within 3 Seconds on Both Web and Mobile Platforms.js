import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ApplicationPage from "../pages/applicationPage";

Given("I open a web browser", () => {
 ApplicationPage.openWebBrowser();
});

When("I navigate to the application URL", () => {
 ApplicationPage.navigateToURL();
});

Then("the application URL is accessed successfully", () => {
 ApplicationPage.verifyURLAccess();
});

Then("the application loads within 3 seconds", () => {
 ApplicationPage.verifyLoadTime(3000);
});

Given("I open the application on a mobile device", () => {
 ApplicationPage.openMobileApp();
});

When("I access the application URL", () => {
 ApplicationPage.accessURLOnMobile();
});

Then("the application is accessed successfully on mobile", () => {
 ApplicationPage.verifyMobileURLAccess();
});

Then("the application loads within 3 seconds on mobile", () => {
 ApplicationPage.verifyMobileLoadTime(3000);
});

Given("the application is loaded", () => {
 ApplicationPage.verifyApplicationLoaded();
});

Then("the application functions correctly after loading", () => {
 ApplicationPage.verifyFunctionality();
});

Then("all UI elements are displayed correctly", () => {
 ApplicationPage.verifyUIElements();
});

When("I navigate through different sections of the application", () => {
 ApplicationPage.navigateSections();
});

Then("navigation is smooth and responsive", () => {
 ApplicationPage.verifyNavigation();
});

When("I perform a sample transaction or task", () => {
 ApplicationPage.performTransaction();
});

Then("the transaction or task is completed successfully", () => {
 ApplicationPage.verifyTransactionCompletion();
});

When("I log out from the application", () => {
 ApplicationPage.logout();
});

Then("the user is logged out successfully", () => {
 ApplicationPage.verifyLogout();
});

When("I log back into the application", () => {
 ApplicationPage.login();
});

Then("the user is logged in successfully", () => {
 ApplicationPage.verifyLogin();
});

Then("the application performs optimally under normal conditions", () => {
 ApplicationPage.verifyPerformance();
});

Then("no loading errors or delays are encountered", () => {
 ApplicationPage.verifyNoLoadingErrors();
});

Then("the application responds promptly to user actions", () => {
 ApplicationPage.verifyResponsiveness();
});

Then("the application is compatible with various browsers and devices", () => {
 ApplicationPage.verifyCompatibility();
});

Then("application updates are visible immediately", () => {
 ApplicationPage.verifyUpdates();
});