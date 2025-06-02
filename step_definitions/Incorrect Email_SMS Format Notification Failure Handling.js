import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import NotificationPage from "../pages/notificationPage";

Given("the user accesses the notification system", () => {
 NotificationPage.visit();
});

When("the user navigates to the notification system dashboard", () => {
 NotificationPage.navigateToDashboard();
});

Then("the user should be successfully navigated to the dashboard", () => {
 NotificationPage.verifyDashboardNavigation();
});

Given("the user is on the notification system dashboard", () => {
 NotificationPage.verifyDashboard();
});

When("the user selects \"Create New Notification\"", () => {
 NotificationPage.selectCreateNewNotification();
});

Then("the notification creation form should be displayed", () => {
 NotificationPage.verifyCreationFormDisplayed();
});

When("the user enters incorrect email format {string} in the email field", (email) => {
 NotificationPage.enterEmail(email);
});

Then("the system should validate the email format and display an error message", () => {
 NotificationPage.verifyEmailErrorMessage();
});

Given("the notification creation form is displayed", () => {
 NotificationPage.verifyCreationFormDisplayed();
});

When("the user enters incorrect SMS format {string} in the SMS field", (sms) => {
 NotificationPage.enterSMS(sms);
});

Then("the system should validate the SMS format and display an error message", () => {
 NotificationPage.verifySMSErrorMessage();
});

Given("the user has entered incorrect email and SMS formats", () => {
 NotificationPage.verifyIncorrectFormatsEntered();
});

When("the user attempts to send the notification", () => {
 NotificationPage.attemptToSendNotification();
});

Then("the notification sending should be blocked due to incorrect formats", () => {
 NotificationPage.verifyNotificationBlocked();
});

Given("the notification sending is blocked", () => {
 NotificationPage.verifyNotificationBlocked();
});

When("the user checks the error logs", () => {
 NotificationPage.checkErrorLogs();
});

Then("the error logs should contain messages about the incorrect formats", () => {
 NotificationPage.verifyErrorLogsContainMessages();
});

Given("the user is on the notification creation form", () => {
 NotificationPage.verifyCreationFormDisplayed();
});

When("the user enters incorrect email format \"<email>\" in the email field", (email) => {
 NotificationPage.enterEmail(email);
});

And("the user enters incorrect SMS format \"<sms>\" in the SMS field", (sms) => {
 NotificationPage.enterSMS(sms);
});

And("the user attempts to send the notification", () => {
 NotificationPage.attemptToSendNotification();
});

Then("similar error messages should be displayed for the incorrect formats", () => {
 NotificationPage.verifySimilarErrorMessagesDisplayed();
});

Given("the user enters multiple incorrect formats simultaneously", () => {
 NotificationPage.enterMultipleIncorrectFormats();
});

When("the user attempts to send the notification", () => {
 NotificationPage.attemptToSendNotification();
});

Then("the system should handle multiple errors gracefully and display appropriate messages", () => {
 NotificationPage.verifyMultipleErrorsHandledGracefully();
});

Given("the user enters correct email and SMS formats", () => {
 NotificationPage.enterCorrectFormats();
});

When("the user attempts to send the notification", () => {
 NotificationPage.attemptToSendNotification();
});

Then("the notifications should be sent successfully without errors", () => {
 NotificationPage.verifyNotificationSentSuccessfully();
});

Given("the notifications are sent successfully", () => {
 NotificationPage.verifyNotificationSentSuccessfully();
});

When("the user checks the system logs", () => {
 NotificationPage.checkSystemLogs();
});

Then("no unhandled exceptions should be present", () => {
 NotificationPage.verifyNoUnhandledExceptions();
});

Given("the system has handled errors", () => {
 NotificationPage.verifyErrorsHandled();
});

When("the user interacts with the system", () => {
 NotificationPage.interactWithSystem();
});

Then("the system should return to a stable and responsive state", () => {
 NotificationPage.verifySystemStability();
});

Given("the user has entered incorrect email or SMS formats", () => {
 NotificationPage.verifyIncorrectFormatsEntered();
});

When("the system displays error messages", () => {
 NotificationPage.verifyErrorMessagesDisplayed();
});

Then("the user should receive clear and informative feedback about the error", () => {
 NotificationPage.verifyUserFeedback();
});