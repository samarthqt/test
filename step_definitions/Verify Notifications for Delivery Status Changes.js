import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import NotificationsPage from "../pages/notificationsPage";

Given("the user has a valid order ID {string}", (orderId) => {
 NotificationsPage.verifyOrderId(orderId);
});

When("the user logs into the account", () => {
 NotificationsPage.login();
});

Then("the user should be successfully logged in", () => {
 NotificationsPage.verifyLoginSuccess();
});

When("the user navigates to the 'Order History' section", () => {
 NotificationsPage.navigateOrderHistory();
});

Then("the order history page should display all past and current orders", () => {
 NotificationsPage.verifyOrderHistoryDisplayed();
});

Given("the tracking number is {string}", (trackingNumber) => {
 NotificationsPage.verifyTrackingNumber(trackingNumber);
});

When("the user selects the order with tracking number XYZ789", () => {
 NotificationsPage.selectOrderByTrackingNumber("XYZ789");
});

Then("the order details should be displayed, including tracking information", () => {
 NotificationsPage.verifyOrderDetailsDisplayed();
});

Given("the notification email is {string}", (email) => {
 NotificationsPage.verifyNotificationEmail(email);
});

And("the notification phone is {string}", (phone) => {
 NotificationsPage.verifyNotificationPhone(phone);
});

When("the user checks notification settings for the order", () => {
 NotificationsPage.checkNotificationSettings();
});

Then("notification settings should be enabled", () => {
 NotificationsPage.verifyNotificationSettingsEnabled();
});

When("a change in package status is simulated to 'Out for Delivery'", () => {
 NotificationsPage.simulateStatusChange("Out for Delivery");
});

Then("a notification should be sent to the user regarding the status change", () => {
 NotificationsPage.verifyNotificationSent();
});

When("the user checks the email notifications", () => {
 NotificationsPage.checkEmailNotifications();
});

Then("an email notification should be received with the updated status", () => {
 NotificationsPage.verifyEmailNotificationReceived();
});

When("the user checks the SMS notifications", () => {
 NotificationsPage.checkSMSNotifications();
});

Then("an SMS notification should be received with the updated status", () => {
 NotificationsPage.verifySMSNotificationReceived();
});

When("delivery completion is simulated", () => {
 NotificationsPage.simulateDeliveryCompletion();
});

Then("a notification should be sent to the user regarding delivery completion", () => {
 NotificationsPage.verifyDeliveryNotificationSent();
});

Then("an email notification should be received confirming delivery", () => {
 NotificationsPage.verifyEmailDeliveryNotificationReceived();
});

Then("an SMS notification should be received confirming delivery", () => {
 NotificationsPage.verifySMSDeliveryNotificationReceived();
});

When("the user logs out of the account", () => {
 NotificationsPage.logout();
});

Then("the user should be successfully logged out", () => {
 NotificationsPage.verifyLogoutSuccess();
});

When("the user logs back into the account", () => {
 NotificationsPage.login();
});

Then("the user should be successfully logged in again", () => {
 NotificationsPage.verifyLoginSuccess();
});

When("the user navigates to the 'Order History' section again", () => {
 NotificationsPage.navigateOrderHistory();
});

Then("the order history page should display all past and current orders", () => {
 NotificationsPage.verifyOrderHistoryDisplayed();
});

When("the user selects the order with tracking number XYZ789 again", () => {
 NotificationsPage.selectOrderByTrackingNumber("XYZ789");
});

Then("the order details should be displayed, including updated tracking information", () => {
 NotificationsPage.verifyOrderDetailsDisplayed();
});

When("the user checks the notification history", () => {
 NotificationsPage.checkNotificationHistory();
});

Then("the notification history should display all sent notifications for the order", () => {
 NotificationsPage.verifyNotificationHistoryDisplayed();
});