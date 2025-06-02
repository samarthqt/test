import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import NotificationSettingsPage from "../pages/notificationSettingsPage";

Given("the user is logged into the application", () => {
 // Implement login functionality here
});

Given("the user has existing notification settings", () => {
 // Ensure user has existing settings
});

When("the user navigates to the user settings page", () => {
 NotificationSettingsPage.visitSettingsPage();
});

Then("the user settings page is displayed", () => {
 NotificationSettingsPage.verifySettingsPage();
});

When("the user clicks on 'Notification Settings'", () => {
 NotificationSettingsPage.clickNotificationSettings();
});

Then("notification settings options are displayed", () => {
 NotificationSettingsPage.verifyNotificationOptionsDisplayed();
});

When("the user selects 'Email' preference", () => {
 NotificationSettingsPage.selectEmailPreference();
});

Then("the email preference is selected", () => {
 NotificationSettingsPage.verifyEmailPreferenceSelected();
});

When("the user enters the email address 'user@example.com'", () => {
 NotificationSettingsPage.enterEmailAddress('user@example.com');
});

Then("the email address is entered without errors", () => {
 NotificationSettingsPage.verifyEmailEntered();
});

When("the user selects 'SMS' preference", () => {
 NotificationSettingsPage.selectSMSPreference();
});

Then("the SMS preference is selected", () => {
 NotificationSettingsPage.verifySMSPreferenceSelected();
});

When("the user enters the SMS number '+1234567890'", () => {
 NotificationSettingsPage.enterSMSNumber('+1234567890');
});

Then("the SMS number is entered without errors", () => {
 NotificationSettingsPage.verifySMSNumberEntered();
});

When("the user chooses notification frequency as 'Weekly'", () => {
 NotificationSettingsPage.setNotificationFrequency('Weekly');
});

Then("the notification frequency is set to weekly", () => {
 NotificationSettingsPage.verifyNotificationFrequency('Weekly');
});

When("the user clicks 'Save Changes'", () => {
 NotificationSettingsPage.saveChanges();
});

Then("the changes are saved successfully", () => {
 NotificationSettingsPage.verifyChangesSaved();
});

Then("the confirmation message 'Settings updated successfully' is displayed", () => {
 NotificationSettingsPage.verifyConfirmationMessage('Settings updated successfully');
});

When("the user logs out and logs back in", () => {
 // Implement logout and login functionality here
});

Then("the user is logged back into the application", () => {
 // Verify user is logged back in
});

When("the user navigates back to 'Notification Settings'", () => {
 NotificationSettingsPage.navigateBackToNotificationSettings();
});

Then("the notification settings reflect the updated preferences", () => {
 NotificationSettingsPage.verifyUpdatedPreferences();
});

When("the user checks email inbox for notification test email", () => {
 // Implement email inbox check functionality here
});

Then("the test email is received in the inbox", () => {
 // Verify test email is received
});

When("the user checks SMS inbox for notification test SMS", () => {
 // Implement SMS inbox check functionality here
});

Then("the test SMS is received on the phone", () => {
 // Verify test SMS is received
});

When("the user attempts to change preferences again without saving", () => {
 NotificationSettingsPage.attemptChangeWithoutSaving();
});

Then("no changes occur without saving", () => {
 NotificationSettingsPage.verifyNoChangesWithoutSaving();
});

Then("unauthorized users cannot edit notification settings", () => {
 NotificationSettingsPage.verifyUnauthorizedCannotEdit();
});