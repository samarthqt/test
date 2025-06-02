import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HomePage from "../pages/homePage";

Given("the user is logged into the application", () => {
 // Assume user is already logged in
});

Given("the user is on the homepage with a visible search bar", () => {
 HomePage.visit();
 HomePage.verifySearchBarVisible();
});

When("the user navigates to the homepage", () => {
 HomePage.visit();
});

When("the user clicks on the search bar", () => {
 HomePage.clickSearchBar();
});

When("the user types {string} into the search bar", (query) => {
 HomePage.enterSearchQuery(query);
});

When("the user enters a query with special characters", () => {
 HomePage.enterSearchQuery("@#$%^&*");
});

When("the user enters an empty search query", () => {
 HomePage.enterSearchQuery("");
});

When("the user enters a query with only spaces", () => {
 HomePage.enterSearchQuery("   ");
});

When("the user enters a query with mixed valid and invalid characters", () => {
 HomePage.enterSearchQuery("valid123!@#");
});

When("the user enters a query exceeding maximum length", () => {
 HomePage.enterSearchQuery("a".repeat(300));
});

When("the user enters a query with repetitive characters", () => {
 HomePage.enterSearchQuery("aaaaaaa");
});

When("the user enters a query with non-ASCII characters", () => {
 HomePage.enterSearchQuery("你好");
});

When("the user enters a query with HTML tags", () => {
 HomePage.enterSearchQuery("<div>Test</div>");
});

Then("the homepage is displayed with a visible search bar", () => {
 HomePage.verifySearchBarVisible();
});

Then("the system provides a message indicating no results or invalid query", () => {
 HomePage.verifyInvalidQueryMessage();
});

Then("the system handles the long input gracefully and provides appropriate feedback", () => {
 HomePage.verifyLongInputFeedback();
});

Then("the system prevents script execution and provides a message indicating invalid query", () => {
 HomePage.verifyInvalidQueryMessage();
});

Then("the system prevents SQL injection and provides a message indicating invalid query", () => {
 HomePage.verifyInvalidQueryMessage();
});

Then("the system provides feedback indicating invalid query", () => {
 HomePage.verifyInvalidQueryMessage();
});

Then("the system prompts the user to enter a valid search query", () => {
 HomePage.verifyPromptForValidQuery();
});

Then("the system truncates input and provides feedback indicating invalid query", () => {
 HomePage.verifyTruncatedInputMessage();
});