import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import NotificationPage from "../pages/notificationPage";

Given("the user has an active account with email {string} and phone number {string}", (email, phoneNumber) => {
 NotificationPage.verifyActiveAccount(email, phoneNumber);
});

Given("the user has logged in with valid credentials", () => {
 NotificationPage.login();
});

Given("the user has placed an order with ID {int}", (orderId) => {
 NotificationPage.placeOrder(orderId);
});

When("the user navigates to the 'Order History' section", () => {
 NotificationPage.navigateToOrderHistory();
});

When("selects the order with ID {int} to view its details", (orderId) => {
 NotificationPage.selectOrder(orderId);
});

When("simulates a change in the delivery status to {string}", (status) => {
 NotificationPage.changeDeliveryStatus(status);
});

Then("the system updates the delivery status to {string}", (status) => {
 NotificationPage.verifyDeliveryStatus(status);
});

Then("an email notification is received indicating the status change to {string}", (status) => {
 NotificationPage.verifyEmailNotification(status);
});

Then("an SMS notification is received indicating the status change to {string}", (status) => {
 NotificationPage.verifySMSNotification(status);
});

Given("the delivery status of order ID {int} is {string}", (orderId, status) => {
 NotificationPage.verifyOrderStatus(orderId, status);
});

When("the delivery status is changed to {string}", (status) => {
 NotificationPage.changeDeliveryStatus(status);
});

Given("the notifications for order ID {int} have been sent", (orderId) => {
 NotificationPage.verifyNotificationsSent(orderId);
});

When("the user checks the notification logs in the system", () => {
 NotificationPage.checkNotificationLogs();
});

Then("log entries confirm the delivery of email and SMS notifications for each status change", () => {
 NotificationPage.verifyLogEntries();
});

Then("notifications include order ID, new status, and timestamp of the update", () => {
 NotificationPage.verifyNotificationContent();
});

Given("the system is simulating a failed delivery status update", () => {
 NotificationPage.simulateFailedStatusUpdate();
});

When("the failure occurs", () => {
 NotificationPage.triggerFailure();
});

Then("the system handles the failure gracefully and retries sending the notification", () => {
 NotificationPage.handleFailureGracefully();
});

Given("multiple status changes have occurred for order ID {int}", (orderId) => {
 NotificationPage.simulateMultipleStatusChanges(orderId);
});

When("checking the notifications sent", () => {
 NotificationPage.checkNotificationsSent();
});

Then("each status change results in a single email and SMS notification", () => {
 NotificationPage.verifyNoDuplicateNotifications();
});

Given("the user updates their email to {string} and phone number to {string}", (newEmail, newPhoneNumber) => {
 NotificationPage.updateContactInformation(newEmail, newPhoneNumber);
});

When("the notification process is repeated", () => {
 NotificationPage.repeatNotificationProcess();
});

Then("notifications are sent to the updated email and phone number", () => {
 NotificationPage.verifyUpdatedContactNotifications();
});

Given("the user's account is deactivated", () => {
 NotificationPage.deactivateAccount();
});

When("a delivery status change occurs", () => {
 NotificationPage.changeDeliveryStatus();
});

Then("no notifications are sent to the deactivated account", () => {
 NotificationPage.verifyNoNotificationsForDeactivatedAccount();
});