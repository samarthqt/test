import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import DashboardPage from "../pages/dashboardPage";
import OrderTrackingPage from "../pages/orderTrackingPage";

Given("the user has valid credentials", () => {
 LoginPage.visit();
});

When("the user logs in to the account", () => {
 LoginPage.enterCredentials();
 LoginPage.submit();
});

Then("the user is successfully logged in and redirected to the dashboard", () => {
 DashboardPage.verifyDashboard();
});

Given("the user is on the dashboard", () => {
 DashboardPage.verifyDashboard();
});

When("the user navigates to the 'Order Tracking' section", () => {
 DashboardPage.navigateToOrderTracking();
});

Then("the 'Order Tracking' section is displayed with a list of orders eligible for tracking", () => {
 OrderTrackingPage.verifyOrderTrackingSection();
});

Given("the user is in the 'Order Tracking' section", () => {
 OrderTrackingPage.verifyOrderTrackingSection();
});

When("the user enters an invalid order ID {string}", (orderId) => {
 OrderTrackingPage.enterOrderId(orderId);
});

Then("the system displays an error message indicating the order ID is invalid", () => {
 OrderTrackingPage.verifyInvalidOrderIdError();
});

Given("the user has entered an invalid order ID {string}", (orderId) => {
 OrderTrackingPage.enterOrderId(orderId);
});

When("the user attempts to track the order", () => {
 OrderTrackingPage.trackOrder();
});

Then("the system prevents tracking and displays an error message", () => {
 OrderTrackingPage.verifyTrackingPrevention();
});

Given("the system displays an error message for invalid order ID", () => {
 OrderTrackingPage.verifyInvalidOrderIdError();
});

Then("the error message suggests checking the order ID and trying again", () => {
 OrderTrackingPage.verifyErrorMessageGuidance();
});

Given("the user has entered an invalid order ID previously", () => {
 OrderTrackingPage.verifyPreviousInvalidOrderId();
});

When("the user enters a valid order ID", () => {
 OrderTrackingPage.enterValidOrderId();
});

Then("the user can successfully track the order", () => {
 OrderTrackingPage.verifySuccessfulTracking();
});

Given("the user has attempted to track an order with an invalid ID", () => {
 OrderTrackingPage.verifyPreviousInvalidOrderId();
});

Then("the invalid tracking attempt is logged in the system for review", () => {
 OrderTrackingPage.verifyLoggingOfInvalidAttempt();
});

Given("the user attempts to track orders with multiple invalid IDs", () => {
 OrderTrackingPage.attemptMultipleInvalidIds();
});

Then("the system consistently displays error messages for repeated invalid attempts", () => {
 OrderTrackingPage.verifyConsistentErrorMessages();
});

Given("the user has attempted to track an order with an invalid ID", () => {
 OrderTrackingPage.verifyPreviousInvalidOrderId();
});

Then("the user receives a notification regarding the invalid tracking attempt", () => {
 OrderTrackingPage.verifyNotificationForInvalidAttempt();
});

Given("the user is facing issues with order tracking", () => {
 OrderTrackingPage.verifyTrackingIssues();
});

When("the user seeks help or support", () => {
 OrderTrackingPage.seekHelpOrSupport();
});

Then("help or support options are available for tracking issues", () => {
 OrderTrackingPage.verifyHelpOrSupportOptions();
});

Given("the user is in the 'Order Tracking' section", () => {
 OrderTrackingPage.verifyOrderTrackingSection();
});

When("the user chooses to navigate back to the dashboard", () => {
 OrderTrackingPage.navigateToDashboard();
});

Then("the user is redirected to the dashboard without any issues", () => {
 DashboardPage.verifyDashboard();
});

Given("the user is logged in", () => {
 DashboardPage.verifyDashboard();
});

When("the user logs out from the account", () => {
 DashboardPage.logout();
});

Then("the user is successfully logged out and redirected to the login page", () => {
 LoginPage.verifyLogout();
});