import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import NotificationPage from "../pages/notificationPage";

Given("I have access to the system during peak traffic times", () => {
 NotificationPage.accessSystemDuringPeak();
});

When("I simulate peak traffic conditions using appropriate tools", () => {
 NotificationPage.simulatePeakTraffic();
});

Then("Peak traffic conditions are successfully simulated", () => {
 NotificationPage.verifyPeakTrafficSimulation();
});

Given("I am on the system homepage", () => {
 NotificationPage.visitHomepage();
});

When("I navigate to the notification system dashboard", () => {
 NotificationPage.navigateToDashboard();
});

Then("User is successfully navigated to the dashboard", () => {
 NotificationPage.verifyDashboardNavigation();
});

Given("I am on the notification system dashboard", () => {
 NotificationPage.onDashboard();
});

When("I select \"Create New Notification\"", () => {
 NotificationPage.selectCreateNewNotification();
});

Then("Notification creation form is displayed", () => {
 NotificationPage.verifyNotificationFormDisplayed();
});

Given("I am on the notification creation form", () => {
 NotificationPage.onNotificationForm();
});

When("I enter valid email format {string} in the email field", (email) => {
 NotificationPage.enterEmail(email);
});

Then("Email format is accepted without errors", () => {
 NotificationPage.verifyEmailFormat();
});

When("I enter valid SMS format {string} in the SMS field", (sms) => {
 NotificationPage.enterSMS(sms);
});

Then("SMS format is accepted without errors", () => {
 NotificationPage.verifySMSFormat();
});

Given("I have entered valid email and SMS formats", () => {
 NotificationPage.enterValidFormats();
});

When("I attempt to send the notification during peak traffic", () => {
 NotificationPage.sendNotificationDuringPeak();
});

Then("Notification should be sent successfully, albeit with potential delays", () => {
 NotificationPage.verifyNotificationSent();
});

Given("Notification is being sent during peak traffic", () => {
 NotificationPage.notificationInProgress();
});

When("I monitor system performance metrics", () => {
 NotificationPage.monitorPerformanceMetrics();
});

Then("System performance metrics should indicate load but no critical failures", () => {
 NotificationPage.verifyPerformanceMetrics();
});

Given("Notification has been sent during peak traffic", () => {
 NotificationPage.notificationSent();
});

When("I check system logs for any errors or exceptions", () => {
 NotificationPage.checkSystemLogs();
});

Then("Logs should not contain critical errors", () => {
 NotificationPage.verifySystemLogs();
});

When("I verify notification delivery to the intended recipients", () => {
 NotificationPage.verifyNotificationDelivery();
});

Then("Recipients should receive the notification successfully", () => {
 NotificationPage.verifyRecipientsReceived();
});

Given("Peak traffic has subsided", () => {
 NotificationPage.peakTrafficSubsided();
});

When("I assess system recovery time", () => {
 NotificationPage.assessRecoveryTime();
});

Then("System should recover to normal performance levels quickly", () => {
 NotificationPage.verifyRecovery();
});

Given("I am sending notifications during non-peak times", () => {
 NotificationPage.sendingDuringNonPeak();
});

When("I send the notification", () => {
 NotificationPage.sendNotification();
});

Then("Notifications should be sent more quickly during non-peak times", () => {
 NotificationPage.verifyQuickSend();
});

Given("The system is under peak load", () => {
 NotificationPage.systemUnderPeakLoad();
});

When("I verify system scalability", () => {
 NotificationPage.verifyScalability();
});

Then("System should scale resources appropriately to handle peak load", () => {
 NotificationPage.verifyResourceScaling();
});

Given("The system is under peak traffic conditions", () => {
 NotificationPage.systemUnderPeakTraffic();
});

When("I ensure system stability", () => {
 NotificationPage.ensureStability();
});

Then("System should remain stable and responsive", () => {
 NotificationPage.verifyStability();
});

Given("Notification sending might be delayed", () => {
 NotificationPage.possibleDelay();
});

When("I verify user feedback", () => {
 NotificationPage.verifyUserFeedback();
});

Then("User should receive feedback about potential delays", () => {
 NotificationPage.verifyFeedbackReceived();
});

When("I check for any unhandled exceptions", () => {
 NotificationPage.checkUnhandledExceptions();
});

Then("No unhandled exceptions should be present", () => {
 NotificationPage.verifyNoUnhandledExceptions();
});