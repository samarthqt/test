import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import EcommercePage from "../pages/ecommercePage";

Given("I am on the login page", () => {
 EcommercePage.visitLoginPage();
});

When("I enter valid user ID {string} and password {string}", (userID, password) => {
 EcommercePage.enterCredentials(userID, password);
});

Then("I should be successfully logged in and redirected to the homepage", () => {
 EcommercePage.verifyHomepage();
});

Given("I am logged in to the e-commerce website", () => {
 EcommercePage.verifyLoggedIn();
});

When("I navigate to the 'My Orders' section", () => {
 EcommercePage.navigateToMyOrders();
});

Then("'My Orders' page should display a list of past and current orders", () => {
 EcommercePage.verifyOrdersList();
});

Given("I am on the 'My Orders' page", () => {
 EcommercePage.verifyMyOrdersPage();
});

When("I select the order with Order ID {string}", (orderID) => {
 EcommercePage.selectOrder(orderID);
});

Then("the order details page should be displayed with tracking options", () => {
 EcommercePage.verifyOrderDetailsPage();
});

Given("I am on the order details page", () => {
 EcommercePage.verifyOrderDetailsPage();
});

When("I click on the 'Track Order' button", () => {
 EcommercePage.clickTrackOrderButton();
});

Then("I should be redirected to the tracking page with current delivery status", () => {
 EcommercePage.verifyTrackingPage();
});

Given("I am on the tracking page", () => {
 EcommercePage.verifyTrackingPage();
});

When("peak traffic conditions are simulated", () => {
 EcommercePage.simulatePeakTraffic();
});

Then("the system should continue to function efficiently under high load", () => {
 EcommercePage.verifySystemEfficiency();
});

Given("peak traffic conditions are simulated", () => {
 EcommercePage.simulatePeakTraffic();
});

When("I check the tracking information", () => {
 EcommercePage.checkTrackingInformation();
});

Then("tracking details should remain accurate and up-to-date", () => {
 EcommercePage.verifyTrackingDetailsAccuracy();
});

When("I monitor the system performance", () => {
 EcommercePage.monitorSystemPerformance();
});

Then("the system should maintain performance standards without significant delays", () => {
 EcommercePage.verifyPerformanceStandards();
});

When("I log out", () => {
 EcommercePage.logout();
});

Then("I should be logged out successfully", () => {
 EcommercePage.verifyLogout();
});

Given("I am logged out from the e-commerce website", () => {
 EcommercePage.verifyLoggedOut();
});

When("I log back in using valid credentials", () => {
 EcommercePage.loginWithValidCredentials();
});

Then("the tracking status should be consistent and accurate even during peak traffic", () => {
 EcommercePage.verifyTrackingStatusConsistency();
});

When("I attempt to track another order", () => {
 EcommercePage.trackAnotherOrder();
});

Then("tracking information should be displayed correctly for the new order", () => {
 EcommercePage.verifyNewOrderTrackingInfo();
});

Given("I am tracking an order", () => {
 EcommercePage.verifyTrackingOrder();
});

When("there are delivery status changes", () => {
 EcommercePage.checkDeliveryStatusChanges();
});

Then("I should receive email updates about delivery status changes", () => {
 EcommercePage.verifyEmailNotifications();
});

When("I check the integration with the shipping carrier's tracking system", () => {
 EcommercePage.checkCarrierIntegration();
});

Then("tracking information should be synced accurately with the carrier's system", () => {
 EcommercePage.verifyCarrierSync();
});

When("tracking fails", () => {
 EcommercePage.simulateTrackingFailure();
});

Then("relevant error messages should be displayed", () => {
 EcommercePage.verifyErrorMessages();
});

When("I check the security of tracking information", () => {
 EcommercePage.checkTrackingSecurity();
});

Then("tracking details should be accessible only to authorized users", () => {
 EcommercePage.verifySecurityAccess();
});

Given("I am using a mobile device", () => {
 EcommercePage.verifyMobileDeviceUsage();
});

When("I access the tracking functionality", () => {
 EcommercePage.accessTrackingFunctionality();
});

Then("tracking functionality should be consistent and efficient on mobile platforms", () => {
 EcommercePage.verifyMobileTrackingEfficiency();
});