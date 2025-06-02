import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import HomePage from "../pages/homePage";
import NotificationSettingsPage from "../pages/notificationSettingsPage";

Given("User {string} has a valid account with email {string} and phone number {string}", (name, email, phone) => {
 // User setup logic
});

When("User logs into the application using valid credentials", () => {
 LoginPage.login();
});

Then("User is successfully logged in and navigated to the homepage", () => {
 HomePage.verifyHomePage();
});

Given("User is on the homepage", () => {
 HomePage.visit();
});

When("User navigates to notification settings", () => {
 HomePage.goToNotificationSettings();
});

Then("Notification settings page is displayed with options for email and SMS notifications", () => {
 NotificationSettingsPage.verifyNotificationOptions();
});

Given("User is on the notification settings page", () => {
 NotificationSettingsPage.visit();
});

When("User ensures email and phone number are correctly registered", () => {
 NotificationSettingsPage.verifyEmailAndPhone();
});

Then("Email and phone number are verified and saved", () => {
 NotificationSettingsPage.verifySave();
});

When("User places an order", () => {
 HomePage.placeOrder();
});

Then("Order is successfully placed and notifications are triggered", () => {
 HomePage.verifyOrderAndNotifications();
});

Given("Notifications are triggered", () => {
 // Notification trigger logic
});

When("User checks for email notification", () => {
 NotificationSettingsPage.checkEmailNotification();
});

Then("Email notification is received with order details", () => {
 NotificationSettingsPage.verifyEmailNotification();
});

When("User checks for SMS notification", () => {
 NotificationSettingsPage.checkSMSNotification();
});

Then("SMS notification is received with order details", () => {
 NotificationSettingsPage.verifySMSNotification();
});

Given("Email notification is received", () => {
 // Email received logic
});

When("User checks the format and content of the email notification", () => {
 NotificationSettingsPage.checkEmailFormatAndContent();
});

Then("Email notification is correctly formatted and contains accurate order information", () => {
 NotificationSettingsPage.verifyEmailContent();
});

Given("SMS notification is received", () => {
 // SMS received logic
});

When("User checks the format and content of the SMS notification", () => {
 NotificationSettingsPage.checkSMSFormatAndContent();
});

Then("SMS notification is correctly formatted and contains accurate order information", () => {
 NotificationSettingsPage.verifySMSContent();
});

Given("Notifications are sent", () => {
 // Notifications sent logic
});

When("User verifies logging of notification delivery status", () => {
 NotificationSettingsPage.verifyNotificationLogging();
});

Then("Notification delivery status is logged for auditing purposes", () => {
 NotificationSettingsPage.verifyLoggingForAudit();
});

When("User logs out from the application", () => {
 HomePage.logout();
});

Then("User is successfully logged out", () => {
 LoginPage.verifyLogout();
});

Given("User is logged out", () => {
 // User logged out logic
});

When("User re-logs into the application and navigates to notification history", () => {
 LoginPage.login();
 HomePage.goToNotificationHistory();
});

Then("Notification history displays recent notifications with delivery status", () => {
 NotificationSettingsPage.verifyNotificationHistory();
});

Given("Notifications have a delivery status", () => {
 // Notifications status logic
});

When("User attempts to resend notifications if delivery fails", () => {
 NotificationSettingsPage.resendFailedNotifications();
});

Then("System allows resending of notifications and logs the attempt", () => {
 NotificationSettingsPage.verifyResendAndLog();
});

When("User edits notification preferences to disable SMS", () => {
 NotificationSettingsPage.disableSMSNotifications();
});

Then("SMS notifications are disabled and only email notifications are sent", () => {
 NotificationSettingsPage.verifySMSDisabled();
});

Given("SMS notifications are disabled", () => {
 // SMS disabled logic
});

When("User places another order", () => {
 HomePage.placeOrder();
});

Then("Only email notification is sent for the new order", () => {
 NotificationSettingsPage.verifyOnlyEmailSent();
});

Given("Email notification is expected", () => {
 // Email expected logic
});

When("Email sending fails", () => {
 NotificationSettingsPage.failEmailSending();
});

Then("System logs the failure and provides options to retry or contact support", () => {
 NotificationSettingsPage.verifyFailureLoggingAndOptions();
});