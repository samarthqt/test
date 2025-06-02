import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import DashboardPage from "../pages/dashboardPage";
import OrderHistoryPage from "../pages/orderHistoryPage";
import OrderDetailsPage from "../pages/orderDetailsPage";

Given("the user has valid credentials", () => {
 // Assume credentials are stored in environment variables
});

When("the user logs in with User ID {string}", (userId) => {
 cy.login(userId, Cypress.env('password'));
});

Then("the user is redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user is on the dashboard", () => {
 DashboardPage.visit();
});

When("the user navigates to the {string} section", (section) => {
 DashboardPage.goToSection(section);
});

Then("the {string} section is displayed with a list of past orders", (section) => {
 OrderHistoryPage.verifySectionDisplayed(section);
});

Given("the user is on the {string} section", (section) => {
 OrderHistoryPage.visit();
});

When("the user selects an order with Order ID {string}", (orderId) => {
 OrderHistoryPage.selectOrder(orderId);
});

Then("the order details are displayed including product names, quantities, prices, and total cost", () => {
 OrderDetailsPage.verifyOrderDetails();
});

Given("the order details are displayed", () => {
 OrderDetailsPage.verifyOrderDetailsDisplayed();
});

Then("the order date {string} and status match the expected values", (date) => {
 OrderDetailsPage.verifyOrderDateAndStatus(date);
});

Then("the product details such as name {string}, quantity {string}, and price are accurate", (productName, quantity) => {
 OrderDetailsPage.verifyProductDetails(productName, quantity);
});

Then("the total amount {string} matches the sum of product prices and quantities", (totalAmount) => {
 OrderDetailsPage.verifyTotalAmount(totalAmount);
});

Then("any applicable discounts or promotions are accurately applied to the total amount", () => {
 OrderDetailsPage.verifyDiscountsAndPromotions();
});

Then("the shipping address and billing address are correct and match the user's information", () => {
 OrderDetailsPage.verifyAddresses();
});

Then("the payment method matches the method used during checkout", () => {
 OrderDetailsPage.verifyPaymentMethod();
});

When("the user attempts to download the order invoice or receipt", () => {
 OrderDetailsPage.downloadInvoice();
});

Then("the invoice or receipt is successfully downloaded and contains accurate order information", () => {
 OrderDetailsPage.verifyInvoiceDownloaded();
});

When("the user filters orders by a specified date range", () => {
 OrderHistoryPage.filterOrdersByDateRange();
});

Then("orders are filtered and displayed according to the specified date range", () => {
 OrderHistoryPage.verifyFilteredOrders();
});

When("the user sorts orders by status", () => {
 OrderHistoryPage.sortOrdersByStatus();
});

Then("orders are sorted correctly based on status", () => {
 OrderHistoryPage.verifySortedOrders();
});

When("there are large numbers of orders", () => {
 OrderHistoryPage.checkLargeNumberOfOrders();
});

Then("pagination is implemented and works correctly for navigating through orders", () => {
 OrderHistoryPage.verifyPagination();
});

Given("the user is on the order details page", () => {
 OrderDetailsPage.visit();
});

When("the user navigates back to the dashboard", () => {
 OrderDetailsPage.navigateBackToDashboard();
});

Then("the user is redirected to the dashboard without any issues", () => {
 cy.url().should("include", "/dashboard");
});

When("the user logs out from the account", () => {
 DashboardPage.logout();
});

Then("the user is successfully logged out and redirected to the login page", () => {
 cy.url().should("include", "/login");
});