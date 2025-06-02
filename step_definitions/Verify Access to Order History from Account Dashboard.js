import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountDashboardPage from "../pages/accountDashboardPage";

Given("a user account with previous orders", () => {
 // Assume user data with previous orders is set up in the backend
});

When("the user logs in to their account", () => {
 AccountDashboardPage.login();
});

Then("the user is successfully logged in", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to the account dashboard", () => {
 AccountDashboardPage.navigateToDashboard();
});

Then("the account dashboard is displayed", () => {
 AccountDashboardPage.verifyDashboardDisplayed();
});

Given("the account dashboard is displayed", () => {
 AccountDashboardPage.verifyDashboardDisplayed();
});

When("the user locates the order history section on the dashboard", () => {
 AccountDashboardPage.locateOrderHistorySection();
});

Then("the order history section is visible on the dashboard", () => {
 AccountDashboardPage.verifyOrderHistorySectionVisible();
});

Given("the order history section is visible", () => {
 AccountDashboardPage.verifyOrderHistorySectionVisible();
});

When("the user clicks on the order history section", () => {
 AccountDashboardPage.clickOrderHistorySection();
});

Then("the order history details are displayed", () => {
 AccountDashboardPage.verifyOrderHistoryDetailsDisplayed();
});

Given("the order history details are displayed", () => {
 AccountDashboardPage.verifyOrderHistoryDetailsDisplayed();
});

Then("all past orders are listed with relevant details", () => {
 AccountDashboardPage.verifyPastOrdersListed();
});

Given("the list of past orders is displayed", () => {
 AccountDashboardPage.verifyPastOrdersListed();
});

When("the user checks the details of a specific order from the list", () => {
 AccountDashboardPage.checkSpecificOrderDetails();
});

Then("the order details including items, quantities, prices, and status are displayed", () => {
 AccountDashboardPage.verifyOrderDetailsDisplayed();
});

Then("orders are sorted from most recent to oldest", () => {
 AccountDashboardPage.verifyOrdersSortedByDate();
});

When("the user filters orders by selecting a specific date range", () => {
 AccountDashboardPage.filterOrdersByDateRange();
});

Then("the user can filter orders by date range", () => {
 AccountDashboardPage.verifyOrdersFilteredByDateRange();
});

When("the user searches for specific orders using keywords or order numbers", () => {
 AccountDashboardPage.searchOrders();
});

Then("the user can search for specific orders", () => {
 AccountDashboardPage.verifySearchFunctionality();
});

Then("each order displays its payment and delivery status clearly", () => {
 AccountDashboardPage.verifyPaymentAndDeliveryStatus();
});

When("the user downloads invoices for past orders", () => {
 AccountDashboardPage.downloadOrderInvoices();
});

Then("the user can download order invoices", () => {
 AccountDashboardPage.verifyInvoiceDownload();
});

When("the user logs out from their account", () => {
 AccountDashboardPage.logout();
});

Then("the user is logged out successfully", () => {
 cy.url().should("include", "/login");
});

Given("the user is logged out", () => {
 cy.url().should("include", "/login");
});

When("the user logs back in", () => {
 AccountDashboardPage.login();
});

Then("the order history remains accessible and unchanged", () => {
 AccountDashboardPage.verifyOrderHistoryUnchanged();
});

When("the user accesses the order history section on different devices", () => {
 AccountDashboardPage.accessOrderHistoryOnDifferentDevices();
});

Then("the order history is accessible and displays correctly on various devices", () => {
 AccountDashboardPage.verifyResponsiveness();
});

Then("the order history data is secure and accessible only to the authorized user", () => {
 AccountDashboardPage.verifyDataSecurity();
});