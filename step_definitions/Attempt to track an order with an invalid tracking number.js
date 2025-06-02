import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import EcommercePage from "../pages/ecommercePage";

Given("a valid user account with User ID {string} and password {string}", (userId, password) => {
 EcommercePage.enterCredentials(userId, password);
});

When("the user logs in to the e-commerce website", () => {
 EcommercePage.login();
});

Then("the user should be successfully logged in and redirected to the homepage", () => {
 EcommercePage.verifyHomepage();
});

Given("the user is logged in", () => {
 EcommercePage.verifyLoggedIn();
});

When("the user navigates to the 'My Orders' section", () => {
 EcommercePage.navigateToMyOrders();
});

Then("'My Orders' page should display a list of past and current orders", () => {
 EcommercePage.verifyOrdersList();
});

Given("the user is on 'My Orders' page", () => {
 EcommercePage.verifyMyOrdersPage();
});

When("the user selects the order with Order ID {string}", (orderId) => {
 EcommercePage.selectOrder(orderId);
});

Then("the order details page should be displayed with tracking options", () => {
 EcommercePage.verifyOrderDetailsPage();
});

Given("the user is on the order details page", () => {
 EcommercePage.verifyOrderDetailsPage();
});

When("the user clicks on the 'Track Order' button with invalid tracking number {string}", (trackingNumber) => {
 EcommercePage.trackOrder(trackingNumber);
});

Then("the system should attempt to retrieve tracking information", () => {
 EcommercePage.attemptRetrieveTrackingInfo();
});

And("an error message should be displayed indicating the tracking number is invalid", () => {
 EcommercePage.verifyInvalidTrackingError();
});

Given("an error message is displayed for an invalid tracking number", () => {
 EcommercePage.verifyInvalidTrackingError();
});

When("the user views the error message", () => {
 EcommercePage.viewErrorMessage();
});

Then("the system should offer suggestions or links to customer support for assistance", () => {
 EcommercePage.offerSupportLinks();
});

When("the user views the error message on different browsers", () => {
 EcommercePage.verifyErrorMessageOnBrowsers();
});

Then("the error message should be consistent and clear on all supported browsers", () => {
 EcommercePage.verifyErrorMessageConsistency();
});

When("the user logs out from the website", () => {
 EcommercePage.logout();
});

Then("the user should be logged out successfully", () => {
 EcommercePage.verifyLogout();
});

Given("the user is logged out", () => {
 EcommercePage.verifyLoggedOut();
});

When("the user logs back in and attempts to track the order with invalid tracking number {string}", (trackingNumber) => {
 EcommercePage.loginAndTrackOrder(trackingNumber);
});

Then("the system should consistently display the error message for the invalid tracking number", () => {
 EcommercePage.verifyConsistentErrorMessage();
});

When("the user attempts to track the order with a different invalid tracking number", () => {
 EcommercePage.trackOrderWithDifferentInvalidNumber();
});

Then("an error message should be displayed for any invalid tracking number", () => {
 EcommercePage.verifyAnyInvalidTrackingError();
});

When("the system logs the error event", () => {
 EcommercePage.logErrorEvent();
});

Then("the error should be logged for further analysis", () => {
 EcommercePage.verifyErrorLogging();
});

Given("the user attempts to track an order", () => {
 EcommercePage.attemptTrackOrder();
});

When("the system processes the tracking request", () => {
 EcommercePage.processTrackingRequest();
});

Then("the system should ensure tracking details are secure and inaccessible to unauthorized users", () => {
 EcommercePage.verifyTrackingSecurity();
});

Given("the user attempts to track an order on a mobile device", () => {
 EcommercePage.attemptTrackOrderOnMobile();
});

When("the system handles the tracking request", () => {
 EcommercePage.handleTrackingRequest();
});

Then("error handling should be consistent and efficient on mobile platforms", () => {
 EcommercePage.verifyMobileErrorHandling();
});

When("the user attempts to track an order with a valid tracking number", () => {
 EcommercePage.trackOrderWithValidNumber();
});

Then("the system should display correct tracking information for valid numbers", () => {
 EcommercePage.verifyValidTrackingInfo();
});

When("the system sends notifications", () => {
 EcommercePage.sendTrackingNotifications();
});

Then("the user should receive email notifications if tracking fails due to invalid numbers", () => {
 EcommercePage.verifyEmailNotifications();
});