import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import DashboardPage from "../pages/dashboardPage";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user is on the login page", () => {
 LoginPage.visit();
});

When("the user logs in with valid credentials {string}", (userId) => {
 LoginPage.enterUserId(userId);
 LoginPage.submit();
});

Then("the user is successfully logged in and redirected to the dashboard", () => {
 DashboardPage.verifyDashboardPage();
});

Given("the user is on the dashboard", () => {
 DashboardPage.verifyDashboardPage();
});

When("the user navigates to the 'Order History' section", () => {
 DashboardPage.goToOrderHistory();
});

Then("the 'Order History' section is displayed with a list of past orders", () => {
 OrderHistoryPage.verifyOrderHistorySection();
});

Given("the user is in the 'Order History' section", () => {
 OrderHistoryPage.verifyOrderHistorySection();
});

When("the user selects an order with Order ID: {string}", (orderId) => {
 OrderHistoryPage.selectOrder(orderId);
});

Then("order details are displayed with options for cancellation or return", () => {
 OrderHistoryPage.verifyOrderDetails();
});

Given("the user has selected an order eligible for cancellation", () => {
 OrderHistoryPage.verifyOrderDetails();
});

When("the user attempts to cancel the order by selecting the cancellation option", () => {
 OrderHistoryPage.cancelOrder();
});

Then("the cancellation request is processed, and the user receives confirmation", () => {
 OrderHistoryPage.verifyCancellationConfirmation();
});

Given("the user has cancelled an order", () => {
 OrderHistoryPage.verifyCancellationConfirmation();
});

When("the user selects a cancellation reason as {string}", (reason) => {
 OrderHistoryPage.selectCancellationReason(reason);
});

Then("the cancellation reason matches the user's selection", () => {
 OrderHistoryPage.verifyCancellationReason();
});

Then("the order status changes to 'Cancelled' in the order history", () => {
 OrderHistoryPage.verifyOrderStatus('Cancelled');
});

Given("the user has selected an order eligible for return", () => {
 OrderHistoryPage.verifyOrderDetails();
});

When("the user selects the return option", () => {
 OrderHistoryPage.returnOrder();
});

Then("the return request is processed, and the user receives confirmation", () => {
 OrderHistoryPage.verifyReturnConfirmation();
});

Given("the user has returned an order", () => {
 OrderHistoryPage.verifyReturnConfirmation();
});

When("the user selects a return reason as {string}", (reason) => {
 OrderHistoryPage.selectReturnReason(reason);
});

Then("the return reason matches the user's selection", () => {
 OrderHistoryPage.verifyReturnReason();
});

Then("the order status changes to 'Returned' in the order history", () => {
 OrderHistoryPage.verifyOrderStatus('Returned');
});

Given("the user has cancelled or returned an order", () => {
 OrderHistoryPage.verifyOrderStatusChange();
});

Then("the user receives notifications for any changes in order status", () => {
 OrderHistoryPage.verifyStatusChangeNotification();
});

Then("the refund is processed and credited to the user's account or original payment method", () => {
 OrderHistoryPage.verifyRefundProcessing();
});

Given("the user has received a refund for a cancelled or returned order", () => {
 OrderHistoryPage.verifyRefundProcessing();
});

Then("refund details are accurately displayed in the order history", () => {
 OrderHistoryPage.verifyRefundDetails();
});

Given("the user attempts an invalid cancellation or return request", () => {
 OrderHistoryPage.attemptInvalidRequest();
});

Then("the system displays appropriate error messages for invalid requests", () => {
 OrderHistoryPage.verifyInvalidRequestError();
});

Given("the user is on the cancellation/return page", () => {
 OrderHistoryPage.verifyCancellationReturnPage();
});

When("the user navigates back to the dashboard", () => {
 OrderHistoryPage.goBackToDashboard();
});

Then("the user is redirected to the dashboard without any issues", () => {
 DashboardPage.verifyDashboardPage();
});

When("the user logs out", () => {
 DashboardPage.logout();
});

Then("the user is successfully logged out and redirected to the login page", () => {
 LoginPage.verifyLoginPage();
});