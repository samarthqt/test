import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import NotificationPage from "../pages/notificationPage";

Given("SendGrid and Twilio are integrated with the system", () => {
 NotificationPage.verifyIntegration();
});

When("I configure the system to send notifications via SendGrid and Twilio", () => {
 NotificationPage.configureNotificationSystem();
});

Then("the system should be able to send email and SMS notifications", () => {
 NotificationPage.verifyNotificationSending();
});

Given("an order is confirmed or tracking updates are available", () => {
 NotificationPage.orderOrTrackingUpdatesAvailable();
});

When("the system sends notifications", () => {
 NotificationPage.sendNotifications();
});

Then("the user should receive an order confirmation or tracking update notification", () => {
 NotificationPage.verifyUserReceivesNotification();
});

Given("a notification is sent for order confirmation or tracking updates", () => {
 NotificationPage.notificationSent();
});

When("I check the content of the notification", () => {
 NotificationPage.checkNotificationContent();
});

Then("the notification content should accurately reflect the order status or tracking information", () => {
 NotificationPage.verifyNotificationContentAccuracy();
});

Given("a user with {string} preference", (notification_type) => {
 NotificationPage.userWithPreference(notification_type);
});

When("a notification is sent for order confirmation or tracking updates", () => {
 NotificationPage.sendNotificationForOrderOrTracking();
});

Then("the user should receive the notification via {string}", (notification_type) => {
 NotificationPage.verifyNotificationDelivery(notification_type);
});

Given("a notification fails to be delivered", () => {
 NotificationPage.notificationFails();
});

When("the system detects the failure", () => {
 NotificationPage.detectFailure();
});

Then("the system should implement error handling procedures", () => {
 NotificationPage.implementErrorHandling();
});

Given("a user has set preferences for notification types", () => {
 NotificationPage.userSetPreferences();
});

When("notifications are sent", () => {
 NotificationPage.sendNotifications();
});

Then("the notifications should be sent according to the user's preferences", () => {
 NotificationPage.verifyNotificationsSentAccordingToPreferences();
});

Given("notifications are sent to users", () => {
 NotificationPage.notificationsSentToUsers();
});

When("I check the system logs", () => {
 NotificationPage.checkSystemLogs();
});

Then("all notification activities should be logged for auditing purposes", () => {
 NotificationPage.verifyNotificationActivitiesLogged();
});

Given("the notification system is integrated with user account management", () => {
 NotificationPage.verifyIntegrationWithUserAccountManagement();
});

When("a notification is sent", () => {
 NotificationPage.sendNotification();
});

Then("it should validate the user's account status and preferences before sending", () => {
 NotificationPage.validateUserAccountStatusAndPreferences();
});

Given("the notification system is operational", () => {
 NotificationPage.verifySystemOperational();
});

When("notifications are sent to users", () => {
 NotificationPage.sendNotificationsToUsers();
});

Then("the system should ensure compliance with communication regulations", () => {
 NotificationPage.ensureComplianceWithRegulations();
});