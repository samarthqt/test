import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user has a User ID {string}", (userId) => {
 cy.wrap(userId).as('userId');
});

When("the user logs into the account", () => {
 OrderHistoryPage.login(cy.get('@userId'));
});

Then("the user is successfully logged in and navigated to the account dashboard", () => {
 OrderHistoryPage.verifyDashboard();
});

Given("the user is on the account dashboard", () => {
 OrderHistoryPage.verifyDashboard();
});

When("the user navigates to the 'Order History' section", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("the order history page is displayed with a list of past orders", () => {
 OrderHistoryPage.verifyOrderHistoryPage();
});

Given("the user is on the order history page", () => {
 OrderHistoryPage.verifyOrderHistoryPage();
});

When("the user enters the date range from {string} to {string} in the search filter", (startDate, endDate) => {
 OrderHistoryPage.enterDateRange(startDate, endDate);
});

Then("the date range filter is applied successfully", () => {
 OrderHistoryPage.verifyDateRangeFilterApplied();
});

Given("the date range filter is applied", () => {
 OrderHistoryPage.verifyDateRangeFilterApplied();
});

When("the user clicks the 'Search' button", () => {
 OrderHistoryPage.clickSearchButton();
});

Then("orders within the specified date range are displayed", () => {
 OrderHistoryPage.verifyOrdersDisplayedWithinDateRange();
});

Given("orders are displayed based on the date range", () => {
 OrderHistoryPage.verifyOrdersDisplayedWithinDateRange();
});

Then("all displayed orders fall within the date range from {string} to {string}", (startDate, endDate) => {
 OrderHistoryPage.verifyOrdersMatchDateRange(startDate, endDate);
});

Then("order details are accurate and complete for each order displayed", () => {
 OrderHistoryPage.verifyOrderDetailsAccuracy();
});

Given("orders are filtered based on the date range", () => {
 OrderHistoryPage.verifyDateRangeFilterApplied();
});

When("the user attempts to export the filtered order list", () => {
 OrderHistoryPage.exportFilteredOrderList();
});

Then("the filtered order list is exported successfully", () => {
 OrderHistoryPage.verifyExportSuccess();
});

Given("the filtered order list is exported", () => {
 OrderHistoryPage.verifyExportSuccess();
});

Then("the exported list contains the same orders as displayed on the screen", () => {
 OrderHistoryPage.verifyExportedListMatchesDisplayedOrders();
});

When("the user changes the date range to a different set of dates and repeats the search", () => {
 OrderHistoryPage.changeDateRangeAndSearch();
});

Then("orders within the new date range are displayed", () => {
 OrderHistoryPage.verifyOrdersDisplayedWithinNewDateRange();
});

Given("the user performs a search with a date range", () => {
 OrderHistoryPage.performSearchWithDateRange();
});

When("the user changes the date range and performs another search", () => {
 OrderHistoryPage.changeDateRangeAndSearchAgain();
});

Then("the system supports consecutive searches with different date ranges without errors", () => {
 OrderHistoryPage.verifyConsecutiveSearchesSupport();
});

Given("the user enters a date range with no orders", () => {
 OrderHistoryPage.enterDateRangeWithNoOrders();
});

Then("the system displays a message indicating no orders found for the specified date range", () => {
 OrderHistoryPage.verifyNoOrdersFoundMessage();
});

Given("the user performs a search and filter operation", () => {
 OrderHistoryPage.performSearchAndFilterOperation();
});

Then("the system responds promptly to the search and filter operation", () => {
 OrderHistoryPage.verifyPromptSystemResponse();
});

Then("system logs indicate the search and filter operation and any results returned", () => {
 OrderHistoryPage.verifySystemLogs();
});

Given("the user performs search and filter operations", () => {
 OrderHistoryPage.performSearchAndFilterOperations();
});

Then("user account details remain unchanged and secure", () => {
 OrderHistoryPage.verifyAccountSecurity();
});

Given("the user enters invalid date formats in the search filter", () => {
 OrderHistoryPage.enterInvalidDateFormats();
});

Then("the system displays an error message indicating invalid date formats", () => {
 OrderHistoryPage.verifyInvalidDateFormatError();
});