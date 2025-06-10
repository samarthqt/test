import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SearchPage from "../pages/searchPage";

Given("the user is on the homepage", () => {
 SearchPage.visitHomepage();
});

When("the user accesses the search functionality", () => {
 SearchPage.accessSearch();
});

Then("the search input field should be visible", () => {
 SearchPage.verifySearchInputVisible();
});

Given("the search functionality is accessible", () => {
 SearchPage.ensureSearchAccessible();
});

When("the user enters a keyword in the search input field", () => {
 SearchPage.enterKeyword("example");
});

Then("the user should be able to submit the search query", () => {
 SearchPage.submitSearch();
});

Given("the user has entered a keyword in the search input field", () => {
 SearchPage.enterKeyword("example");
});

When("the user submits the search query", () => {
 SearchPage.submitSearch();
});

Then("relevant products should be displayed based on the keyword", () => {
 SearchPage.verifyRelevantProductsDisplayed();
});

Given("the user is entering a keyword in the search input field", () => {
 SearchPage.startEnteringKeyword("exam");
});

When("the user pauses typing", () => {
 SearchPage.pauseTyping();
});

Then("the system should display suggestions for common search terms", () => {
 SearchPage.verifySuggestionsDisplayed();
});

Given("the user enters an invalid search input", () => {
 SearchPage.enterInvalidSearchInput("!@#$");
});

When("the user submits the search query", () => {
 SearchPage.submitSearch();
});

Then("an error message should be displayed", () => {
 SearchPage.verifyErrorMessageDisplayed();
});

Given("the user is using a desktop platform", () => {
 SearchPage.setDesktopPlatform();
});

When("the user accesses the search functionality", () => {
 SearchPage.accessSearch();
});

Then("the search functionality should be available", () => {
 SearchPage.verifySearchAvailable();
});

Given("the user is using a mobile platform", () => {
 SearchPage.setMobilePlatform();
});

When("the user accesses the search functionality", () => {
 SearchPage.accessSearch();
});

Then("the search functionality should be available", () => {
 SearchPage.verifySearchAvailable();
});

Given("the user enters a search query", () => {
 SearchPage.enterSearchQuery("SELECT * FROM products");
});

When("the query is processed by the system", () => {
 SearchPage.processQuery();
});

Then("security measures should prevent SQL injection attacks", () => {
 SearchPage.verifySQLInjectionPrevention();
});

Given("the user submits a search query", () => {
 SearchPage.submitSearch();
});

When("the query is processed by the system", () => {
 SearchPage.processQuery();
});

Then("the search query should be logged for analytics purposes", () => {
 SearchPage.verifyQueryLogged();
});

Given("the user submits a search query", () => {
 SearchPage.submitSearch();
});

When("the query is processed by the system", () => {
 SearchPage.processQuery();
});

Then("integration with the product database should ensure accurate search results", () => {
 SearchPage.verifyDatabaseIntegration();
});

Given("the user submits a search query", () => {
 SearchPage.submitSearch();
});

When("the query is processed by the system", () => {
 SearchPage.processQuery();
});

Then("search results should appear within 3 seconds", () => {
 SearchPage.verifySearchPerformance();
});