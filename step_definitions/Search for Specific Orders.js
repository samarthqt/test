import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderPage from "../pages/orderPage";

Given("the user navigates to the login page", () => {
 OrderPage.visitLoginPage();
});

When("the user enters valid credentials", () => {
 OrderPage.enterCredentials();
});

Then("the user is successfully logged in and redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user is logged in", () => {
 OrderPage.verifyUserLoggedIn();
});

When("the user navigates to the 'Order History' section", () => {
 OrderPage.navigateToOrderHistory();
});

Then("the order history page is displayed with a list of past orders", () => {
 OrderPage.verifyOrderHistoryPage();
});

Given("the user is on the order history page", () => {
 OrderPage.verifyOrderHistoryPage();
});

When("the user enters an order ID in the search bar", () => {
 OrderPage.searchByOrderID();
});

Then("the system filters and displays the order matching the entered ID", () => {
 OrderPage.verifyOrderByID();
});

When("the user searches for orders by date range", () => {
 OrderPage.searchByDateRange();
});

Then("orders within the specified date range are displayed", () => {
 OrderPage.verifyOrdersByDateRange();
});

When("the user searches for orders using product name", () => {
 OrderPage.searchByProductName();
});

Then("orders containing the specified product are displayed", () => {
 OrderPage.verifyOrdersByProductName();
});

When("the user combines multiple search criteria", () => {
 OrderPage.combineSearchCriteria();
});

Then("the system accurately filters orders based on combined criteria", () => {
 OrderPage.verifyCombinedCriteria();
});

When("the user attempts a search with invalid or non-existent criteria", () => {
 OrderPage.searchWithInvalidCriteria();
});

Then("the system displays a message indicating no matching orders found", () => {
 OrderPage.verifyNoMatchingOrdersMessage();
});

When("the user clears the search criteria", () => {
 OrderPage.clearSearchCriteria();
});

Then("all orders are displayed, indicating the search criteria were cleared successfully", () => {
 OrderPage.verifyAllOrdersDisplayed();
});

When("the user performs search operations on different browsers", () => {
 OrderPage.performSearchOnBrowsers();
});

Then("search functionality works consistently across different web browsers", () => {
 OrderPage.verifyCrossBrowserFunctionality();
});

When("the user performs search operations", () => {
 OrderPage.performSearchOperations();
});

Then("search operations complete quickly and efficiently without delays", () => {
 OrderPage.verifyPerformance();
});

When("the user searches through a large number of orders", () => {
 OrderPage.searchLargeNumberOfOrders();
});

Then("the system handles large datasets effectively without performance degradation", () => {
 OrderPage.verifyLargeDatasetHandling();
});

When("the user searches for orders using partial criteria", () => {
 OrderPage.searchUsingPartialCriteria();
});

Then("the system suggests possible matches based on partial criteria", () => {
 OrderPage.verifyPartialCriteriaSuggestions();
});

When("the user performs a search", () => {
 OrderPage.performSearch();
});

Then("search results accurately reflect the entered criteria", () => {
 OrderPage.verifySearchAccuracy();
});

Given("the user is logged out", () => {
 OrderPage.verifyUserLoggedOut();
});

When("the user attempts to search for orders", () => {
 OrderPage.attemptSearchWhileLoggedOut();
});

Then("the system prevents search operations when the user is not logged in", () => {
 OrderPage.verifySearchPrevention();
});

When("the user performs search operations", () => {
 OrderPage.performSearchOperations();
});

Then("no error messages are displayed, indicating a smooth search process", () => {
 OrderPage.verifyNoErrorMessages();
});