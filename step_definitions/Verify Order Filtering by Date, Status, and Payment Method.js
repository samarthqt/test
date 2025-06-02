import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user is on the login page", () => {
 LoginPage.visit();
});

When("the user enters valid credentials", () => {
 LoginPage.enterCredentials();
});

Then("the user is successfully logged in", () => {
 LoginPage.verifyLoginSuccess();
});

Then("the user is redirected to the dashboard", () => {
 LoginPage.verifyDashboardRedirection();
});

Given("the user is logged in", () => {
 LoginPage.verifyUserLoggedIn();
});

When("the user navigates to the 'Order History' section", () => {
 OrderHistoryPage.navigate();
});

Then("the Order History page is displayed", () => {
 OrderHistoryPage.verifyPageDisplayed();
});

Given("the user is on the Order History page", () => {
 OrderHistoryPage.verifyPageDisplayed();
});

When("the user views the filter options", () => {
 OrderHistoryPage.viewFilterOptions();
});

Then("filter options for date, status, and payment method are visible", () => {
 OrderHistoryPage.verifyFilterOptionsVisible();
});

When("the user applies a filter for a specific date range", () => {
 OrderHistoryPage.applyDateFilter();
});

Then("the order history updates to show only orders within the specified date range", () => {
 OrderHistoryPage.verifyDateFilterApplied();
});

Given("the user has applied a date filter", () => {
 OrderHistoryPage.verifyDateFilterApplied();
});

When("the user clears the date filter", () => {
 OrderHistoryPage.clearDateFilter();
});

Then("the order history reverts to showing all orders", () => {
 OrderHistoryPage.verifyAllOrdersDisplayed();
});

When("the user applies a filter for a specific status", () => {
 OrderHistoryPage.applyStatusFilter();
});

Then("the order history updates to show only orders with the selected status", () => {
 OrderHistoryPage.verifyStatusFilterApplied();
});

Given("the user has applied a status filter", () => {
 OrderHistoryPage.verifyStatusFilterApplied();
});

When("the user clears the status filter", () => {
 OrderHistoryPage.clearStatusFilter();
});

When("the user applies a filter for a specific payment method", () => {
 OrderHistoryPage.applyPaymentMethodFilter();
});

Then("the order history updates to show only orders with the selected payment method", () => {
 OrderHistoryPage.verifyPaymentMethodFilterApplied();
});

Given("the user has applied a payment method filter", () => {
 OrderHistoryPage.verifyPaymentMethodFilterApplied();
});

When("the user clears the payment method filter", () => {
 OrderHistoryPage.clearPaymentMethodFilter();
});

When("the user applies multiple filters simultaneously", () => {
 OrderHistoryPage.applyMultipleFilters();
});

Then("the order history updates to show orders matching all selected filter criteria", () => {
 OrderHistoryPage.verifyMultipleFiltersApplied();
});

Given("the user has applied multiple filters", () => {
 OrderHistoryPage.verifyMultipleFiltersApplied();
});

When("the user clears all filters", () => {
 OrderHistoryPage.clearAllFilters();
});

When("the user applies a filter with an invalid date range", () => {
 OrderHistoryPage.applyInvalidDateFilter();
});

Then("the system displays an error message indicating an invalid date range", () => {
 OrderHistoryPage.verifyInvalidDateRangeError();
});

Given("the user has applied filters on the Order History page", () => {
 OrderHistoryPage.verifyFiltersApplied();
});

When("the user navigates away and then returns to the Order History page", () => {
 OrderHistoryPage.navigateAwayAndReturn();
});

Then("the filters remain applied", () => {
 OrderHistoryPage.verifyFiltersRemainApplied();
});

Given("the user is accessing the Order History page on different devices", () => {
 OrderHistoryPage.accessOnDifferentDevices();
});

Then("the filter options are accessible and functional across devices", () => {
 OrderHistoryPage.verifyFilterOptionsResponsive();
});

Given("the user is logged out", () => {
 LoginPage.verifyUserLoggedOut();
});

When("the user attempts to apply filters on the Order History page", () => {
 OrderHistoryPage.attemptToApplyFiltersLoggedOut();
});

Then("the user is prompted to log in before applying filters", () => {
 OrderHistoryPage.verifyLoginPrompt();
});