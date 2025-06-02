import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RetailPage from "../pages/retailPage";

Given("the user is logged into the retail application", () => {
 RetailPage.login();
});

When("the user navigates to the search bar in the product catalog section", () => {
 RetailPage.navigateToSearchBar();
});

When("the user enters a search query that has no matching products", () => {
 RetailPage.enterSearchQuery("nonexistent product");
});

Then("the system displays a message indicating no products were found matching the search criteria", () => {
 RetailPage.verifyNoResultsMessage();
});

Then("UI elements remain intact after search", () => {
 RetailPage.verifyUIElementsIntact();
});

Then("alternative suggestions are provided if applicable", () => {
 RetailPage.verifyAlternativeSuggestions();
});

When("the user enters a search query with special characters", () => {
 RetailPage.enterSearchQuery("@#$%^&*");
});

Then("the system handles special characters gracefully and displays an appropriate message", () => {
 RetailPage.verifySpecialCharactersHandling();
});

When("the user enters an excessively long search query", () => {
 RetailPage.enterSearchQuery("a".repeat(1000));
});

Then("the system processes the query and handles it without errors", () => {
 RetailPage.verifyLongQueryHandling();
});

When("the user performs rapid successive search operations", () => {
 RetailPage.performRapidSearches();
});

Then("the system maintains performance and responsiveness", () => {
 RetailPage.verifyPerformance();
});

When("the user logs out from the application", () => {
 RetailPage.logout();
});

Then("the user is successfully logged out and redirected to the login page", () => {
 RetailPage.verifyLogout();
});

Given("the user is logged into the retail application using {string}", (userAccount) => {
 RetailPage.loginAsUser(userAccount);
});

Then("the search functionality works consistently across different user accounts", () => {
 RetailPage.verifySearchConsistency();
});

When("the user navigates to the search bar in the product catalog section using {string}", (browser) => {
 RetailPage.navigateToSearchBarOnBrowser(browser);
});

Then("the search works consistently on all supported browsers", () => {
 RetailPage.verifyBrowserConsistency();
});

When("the user navigates to the search bar in the product catalog section using {string}", (device) => {
 RetailPage.navigateToSearchBarOnDevice(device);
});

Then("search operations can be performed on mobile devices without any issues", () => {
 RetailPage.verifyMobileDeviceSearch();
});

When("the user enters a search query with invalid data format", () => {
 RetailPage.enterSearchQuery("invalid\ndata");
});

Then("the system handles invalid data gracefully and displays an error message", () => {
 RetailPage.verifyInvalidDataHandling();
});

When("the user performs a search operation", () => {
 RetailPage.performSearchOperation();
});

Then("system logs do not show any critical errors related to search operations", () => {
 RetailPage.verifySystemLogs();
});