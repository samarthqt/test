import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import NotificationSettingsPage from "../pages/notificationSettingsPage";

Given("the user is logged into the application", () => {
 // Assume user is logged in
});

Given("the user navigates to the user settings page", () => {
 NotificationSettingsPage.visitUserSettings();
});

Given("the user has existing preferences", () => {
 // Assume user has existing preferences
});

When("the user clicks on 'Notification Settings'", () => {
 NotificationSettingsPage.clickNotificationSettings();
});

When("the user enters invalid email format {string}", (email) => {
 NotificationSettingsPage.enterEmail(email);
});

Then("the system displays an error message for invalid email format", () => {
 NotificationSettingsPage.verifyEmailErrorMessage();
});

Given("the user is on the notification settings page", () => {
 NotificationSettingsPage.visitNotificationSettings();
});

When("the user enters invalid SMS number {string}", (smsNumber) => {
 NotificationSettingsPage.enterSMSNumber(smsNumber);
});

Then("the system displays an error message for invalid SMS number", () => {
 NotificationSettingsPage.verifySMSErrorMessage();
});

When("the user sets notification frequency to {string}", (frequency) => {
 NotificationSettingsPage.setNotificationFrequency(frequency);
});

Then("the notification frequency is set to daily", () => {
 NotificationSettingsPage.verifyFrequencySetToDaily();
});

Given("the user has entered invalid email and SMS number", () => {
 NotificationSettingsPage.enterInvalidEmailAndSMS();
});

When("the user clicks 'Save Changes'", () => {
 NotificationSettingsPage.clickSaveChanges();
});

Then("the system prevents saving due to invalid data formats", () => {
 NotificationSettingsPage.verifySavePrevention();
});

Then("error messages are displayed for invalid email and SMS number", () => {
 NotificationSettingsPage.verifyErrorsForInvalidData();
});

When("the user attempts to save changes again", () => {
 NotificationSettingsPage.attemptSaveChangesAgain();
});

Then("the system continues to prevent saving due to invalid data formats", () => {
 NotificationSettingsPage.verifyContinuedSavePrevention();
});

Given("the user enters valid email and SMS data", () => {
 NotificationSettingsPage.enterValidEmailAndSMS();
});

When("the user clicks 'Save Changes' with valid data", () => {
 NotificationSettingsPage.clickSaveChangesWithValidData();
});

Then("changes are saved successfully", () => {
 NotificationSettingsPage.verifySuccessfulSave();
});

Then("a confirmation message {string} is displayed", (message) => {
 NotificationSettingsPage.verifyConfirmationMessage(message);
});

When("the user tests system behavior with unsupported notification frequency", () => {
 NotificationSettingsPage.testUnsupportedFrequency();
});

Then("the system displays an error message for unsupported frequency", () => {
 NotificationSettingsPage.verifyUnsupportedFrequencyError();
});

When("the user attempts to enter non-numeric SMS number", () => {
 NotificationSettingsPage.enterNonNumericSMSNumber();
});

Then("the system displays an error message for non-numeric SMS number", () => {
 NotificationSettingsPage.verifyNonNumericSMSError();
});

Given("the user has attempted to save changes with invalid data formats", () => {
 // Assume user has attempted to save changes
});

When("the user checks system logs for failed update attempts", () => {
 NotificationSettingsPage.checkSystemLogs();
});

Then("logs reflect failed attempts accurately", () => {
 NotificationSettingsPage.verifyFailedAttemptsInLogs();
});

Given("the user encounters error messages for invalid inputs", () => {
 // Assume user encounters error messages
});

Then("the error messages provide clear guidance on corrections", () => {
 NotificationSettingsPage.verifyUserFriendlyErrorMessages();
});