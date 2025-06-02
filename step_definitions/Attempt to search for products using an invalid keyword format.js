import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HomePage from "../pages/homePage";

Given("the user is logged into the retail application", () => {
 // Assume user is already logged in for this scenario
});

When("the user navigates to the homepage", () => {
 HomePage.visit();
});

When("the user enters {string} in the search bar and presses enter", (keyword) => {
 HomePage.enterSearchKeyword(keyword);
 HomePage.submitSearch();
});

Then("the system displays an error message indicating {string}", (errorMessage) => {
 HomePage.verifyErrorMessage(errorMessage);
});

Given("the user has entered an invalid keyword", () => {
 HomePage.enterSearchKeyword("invalid");
 HomePage.submitSearch();
});

Then("no products are displayed; only error message is shown", () => {
 HomePage.verifyNoProductsDisplayed();
});

Then("the search bar remains operational and can accept new input", () => {
 HomePage.verifySearchBarOperational();
});

Then("the system does not execute any unintended SQL commands", () => {
 HomePage.verifyNoSQLExecution();
});

Then("error messages provide clear guidance on correcting the input", () => {
 HomePage.verifyUserFriendlyErrorMessage();
});

Then("other functionalities remain unaffected and operational", () => {
 HomePage.verifyOtherFunctionalitiesUnaffected();
});

Then("invalid search attempts are logged for auditing purposes", () => {
 HomePage.verifySearchAttemptsLogged();
});

Then("the system suggests alternative keywords or categories", () => {
 HomePage.verifyKeywordSuggestions();
});

When("the user enters a valid keyword", () => {
 HomePage.enterSearchKeyword("valid");
 HomePage.submitSearch();
});

Then("the user can perform a successful search", () => {
 HomePage.verifySuccessfulSearch();
});

Then("the user account remains unlocked and accessible", () => {
 HomePage.verifyAccountAccessible();
});