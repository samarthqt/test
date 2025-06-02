import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user has a valid account with multiple past orders", () => {
  // Assume user is already registered and has past orders
});

When("the user logs into their account", () => {
  OrderHistoryPage.login();
});

Then("the user is successfully logged in and redirected to the dashboard", () => {
  cy.url().should("include", "/dashboard");
});

Given("the user is logged into their account", () => {
  OrderHistoryPage.ensureLoggedIn();
});

When("the user navigates to the 'Order History' section", () => {
  OrderHistoryPage.navigateToOrderHistory();
});

Then("the Order History page is displayed", () => {
  OrderHistoryPage.verifyOrderHistoryPage();
});

Given("the user is on the Order History page", () => {
  OrderHistoryPage.visitOrderHistory();
});

When("the user views the list of past orders", () => {
  OrderHistoryPage.viewPastOrders();
});

Then("all past orders are listed with basic details", () => {
  OrderHistoryPage.verifyPastOrdersList();
});

Given("the user is viewing the list of past orders", () => {
  OrderHistoryPage.viewPastOrders();
});

When("the user checks the order status for each order", () => {
  OrderHistoryPage.checkOrderStatus();
});

Then("each order displays the correct order status", () => {
  OrderHistoryPage.verifyOrderStatus();
});

When("the user checks the payment details for each order", () => {
  OrderHistoryPage.checkPaymentDetails();
});

Then("each order displays the correct payment method and status", () => {
  OrderHistoryPage.verifyPaymentDetails();
});

When("the user selects an order to view detailed information", () => {
  OrderHistoryPage.selectOrderForDetails();
});

Then("detailed information for the selected order is displayed", () => {
  OrderHistoryPage.verifyOrderDetails();
});

Given("the user is viewing detailed information for a selected order", () => {
  OrderHistoryPage.viewOrderDetails();
});

When("the user verifies the order status", () => {
  OrderHistoryPage.verifyDetailedOrderStatus();
});

Then("the order status matches the status shown in the list view", () => {
  OrderHistoryPage.compareOrderStatus();
});

When("the user verifies the payment details", () => {
  OrderHistoryPage.verifyDetailedPaymentDetails();
});

Then("the payment details match those shown in the list view", () => {
  OrderHistoryPage.comparePaymentDetails();
});

When("the user looks for a filter or search option", () => {
  OrderHistoryPage.checkFilterSearchOption();
});

Then("a filter or search option is available for refining order history", () => {
  OrderHistoryPage.verifyFilterSearchOption();
});

When("the user applies a filter to view orders by a specific status", () => {
  OrderHistoryPage.applyStatusFilter();
});

Then("the order history updates to show only orders with the selected status", () => {
  OrderHistoryPage.verifyFilteredOrders();
});

Given("the user has applied a filter on the Order History page", () => {
  OrderHistoryPage.applyStatusFilter();
});

When("the user removes the filter", () => {
  OrderHistoryPage.removeFilter();
});

Then("the order history reverts to showing all orders", () => {
  OrderHistoryPage.verifyAllOrdersShown();
});

Given("the user is not logged into their account", () => {
  OrderHistoryPage.logout();
});

When("the user attempts to access the order history", () => {
  OrderHistoryPage.attemptAccessOrderHistory();
});

Then("the user is prompted to log in before accessing order history", () => {
  OrderHistoryPage.verifyLoginPrompt();
});

When("the user checks the display of orders with different payment methods", () => {
  OrderHistoryPage.checkPaymentMethodDisplay();
});

Then("orders display correct payment method icons or labels", () => {
  OrderHistoryPage.verifyPaymentMethodIcons();
});

When("the number of orders is large", () => {
  OrderHistoryPage.checkLargeOrderCount();
});

Then("pagination controls are available and functional", () => {
  OrderHistoryPage.verifyPaginationControls();
});

When("the user logs out and attempts to view order history", () => {
  OrderHistoryPage.logoutAndAttemptViewOrderHistory();
});

Then("the user is redirected to the login page", () => {
  cy.url().should("include", "/login");
});