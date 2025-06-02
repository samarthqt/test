import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderTrackingPage from "../pages/orderTrackingPage";

Given("a valid user account with login credentials", () => {
 // Assume user credentials are set in environment variables
});

When("the user logs in to the e-commerce website", () => {
 OrderTrackingPage.login();
});

Then("the user should be successfully logged in and redirected to the homepage", () => {
 cy.url().should("include", "/homepage");
});

Given("the user is logged in", () => {
 OrderTrackingPage.verifyUserLoggedIn();
});

When("the user navigates to the 'My Orders' section", () => {
 OrderTrackingPage.navigateToMyOrders();
});

Then("'My Orders' page should display a list of past and current orders", () => {
 OrderTrackingPage.verifyOrdersList();
});

Given("the user is on the 'My Orders' page", () => {
 OrderTrackingPage.verifyOnMyOrdersPage();
});

When("the user selects the order to be tracked", () => {
 OrderTrackingPage.selectOrder();
});

Then("the order details page should be displayed with tracking options", () => {
 OrderTrackingPage.verifyOrderDetailsPage();
});

Given("the user is on the order details page", () => {
 OrderTrackingPage.verifyOnOrderDetailsPage();
});

When("the user clicks on the 'Track Order' button", () => {
 OrderTrackingPage.trackOrder();
});

Then("the user should be redirected to the tracking page with current delivery status", () => {
 cy.url().should("include", "/tracking");
 OrderTrackingPage.verifyTrackingStatus();
});

Given("the user is on the tracking page", () => {
 OrderTrackingPage.verifyOnTrackingPage();
});

When("the tracking information is displayed", () => {
 OrderTrackingPage.displayTrackingInfo();
});

Then("the tracking details should include current status, estimated delivery time, and location", () => {
 OrderTrackingPage.verifyTrackingDetails();
});

When("there are changes in delivery status", () => {
 OrderTrackingPage.checkForDeliveryUpdates();
});

Then("notifications should be displayed", () => {
 OrderTrackingPage.verifyNotifications();
});

When("the page loads", () => {
 OrderTrackingPage.checkPageLoad();
});

Then("the tracking page should load efficiently without delays", () => {
 OrderTrackingPage.verifyPageLoadEfficiency();
});

When("the user logs out from the website", () => {
 OrderTrackingPage.logout();
});

Then("the user should be logged out successfully", () => {
 OrderTrackingPage.verifyLogout();
});

Given("the user has logged out", () => {
 OrderTrackingPage.verifyUserLoggedOut();
});

When("the user logs back in", () => {
 OrderTrackingPage.login();
});

Then("the tracking status should be consistent and accurate", () => {
 OrderTrackingPage.verifyTrackingStatus();
});

When("the user attempts to track another order", () => {
 OrderTrackingPage.trackAnotherOrder();
});

Then("tracking information should be displayed correctly for the new order", () => {
 OrderTrackingPage.verifyNewOrderTrackingInfo();
});

Given("the user is tracking an order", () => {
 OrderTrackingPage.verifyTrackingOrder();
});

Then("the user should receive email updates about delivery status changes", () => {
 OrderTrackingPage.verifyEmailNotifications();
});

When("tracking information is updated", () => {
 OrderTrackingPage.updateTrackingInfo();
});

Then("tracking information should be synced accurately with the carrier's system", () => {
 OrderTrackingPage.verifyCarrierSync();
});

When("tracking fails", () => {
 OrderTrackingPage.simulateTrackingFailure();
});

Then("relevant error messages should be displayed", () => {
 OrderTrackingPage.verifyErrorMessages();
});

When("accessing tracking details", () => {
 OrderTrackingPage.accessTrackingDetails();
});

Then("tracking details should be accessible only to authorized users", () => {
 OrderTrackingPage.verifySecurity();
});

Given("the user is accessing the website on a mobile device", () => {
 OrderTrackingPage.verifyMobileAccess();
});

When("the user tracks an order", () => {
 OrderTrackingPage.trackOrderOnMobile();
});

Then("tracking functionality should be consistent and efficient on mobile platforms", () => {
 OrderTrackingPage.verifyMobileTrackingFunctionality();
});