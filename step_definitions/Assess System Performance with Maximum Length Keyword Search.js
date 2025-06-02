import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HomePage from "../pages/homePage";

Given("the user is logged into the application", () => {
  cy.login();
});

When("the user navigates to the homepage of the application", () => {
  HomePage.visit();
});

Then("the homepage is displayed with a visible search bar", () => {
  HomePage.verifySearchBarVisible();
});

Given("the search bar is visible on the homepage", () => {
  HomePage.verifySearchBarVisible();
});

When("the user clicks on the search bar", () => {
  HomePage.clickSearchBar();
});

Then("the cursor is placed in the search bar, ready for input", () => {
  HomePage.verifyCursorInSearchBar();
});

Given("the cursor is placed in the search bar", () => {
  HomePage.verifyCursorInSearchBar();
});

When("the user types {string} repeated 255 times into the search bar", (char) => {
  HomePage.typeInSearchBar(char.repeat(255));
});

Then("the system processes the input without crashing and provides feedback", () => {
  HomePage.verifySystemFeedback();
});

Given("the user has entered maximum length input into the search bar", () => {
  HomePage.typeInSearchBar('a'.repeat(255));
});

Then("the system handles the input efficiently and provides feedback", () => {
  HomePage.verifySystemPerformance();
});

Then("the system remains responsive and does not freeze", () => {
  HomePage.verifySystemResponsiveness();
});

Then("the system remains stable and does not crash", () => {
  HomePage.verifySystemStability();
});

Then("the system handles input efficiently across devices", () => {
  HomePage.verifySystemAcrossDevices();
});

Then("the system processes full input without truncation", () => {
  HomePage.verifyFullInputProcessing();
});

Then("the system provides appropriate feedback for input", () => {
  HomePage.verifyAppropriateFeedback();
});

Then("the system logs input correctly for auditing", () => {
  HomePage.verifyCorrectLogging();
});

Then("the system prevents security vulnerabilities with input", () => {
  HomePage.verifySecurityHandling();
});