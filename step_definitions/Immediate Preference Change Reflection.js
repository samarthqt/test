import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserSettingsPage from "../pages/userSettingsPage";

Given("the user is logged into the application", () => {
 cy.login();
});

When("the user navigates to the user settings page", () => {
 UserSettingsPage.visit();
});

Then("the user settings page is displayed", () => {
 UserSettingsPage.verifyPageDisplayed();
});

And("the user has existing preferences", () => {
 UserSettingsPage.verifyExistingPreferences();
});

When("the user clicks on 'Notification Settings'", () => {
 UserSettingsPage.clickNotificationSettings();
});

Then("notification settings options are displayed", () => {
 UserSettingsPage.verifyNotificationOptionsDisplayed();
});

When("the user selects 'Email' preference", () => {
 UserSettingsPage.selectEmailPreference();
});

Then("the email preference is selected", () => {
 UserSettingsPage.verifyEmailPreferenceSelected();
});

When("the user enters the email address {string}", (email) => {
 UserSettingsPage.enterEmailAddress(email);
});

Then("the email address is entered without errors", () => {
 UserSettingsPage.verifyEmailEnteredWithoutErrors();
});

When("the user selects 'SMS' preference", () => {
 UserSettingsPage.selectSMSPreference();
});

Then("the SMS preference is selected", () => {
 UserSettingsPage.verifySMSPreferenceSelected();
});

When("the user enters the SMS number {string}", (smsNumber) => {
 UserSettingsPage.enterSMSNumber(smsNumber);
});

Then("the SMS number is entered without errors", () => {
 UserSettingsPage.verifySMSNumberEnteredWithoutErrors();
});

When("the user chooses notification frequency as {string}", (frequency) => {
 UserSettingsPage.chooseNotificationFrequency(frequency);
});

Then("the notification frequency is set to weekly", () => {
 UserSettingsPage.verifyNotificationFrequencySetToWeekly();
});

When("the user clicks 'Save Changes'", () => {
 UserSettingsPage.clickSaveChanges();
});

Then("changes are saved successfully", () => {
 UserSettingsPage.verifyChangesSavedSuccessfully();
});

And("a confirmation message {string} is displayed", (message) => {
 UserSettingsPage.verifyConfirmationMessageDisplayed(message);
});

When("the user immediately checks the notification settings page", () => {
 UserSettingsPage.checkNotificationSettingsPage();
});

Then("the updated preferences are reflected immediately", () => {
 UserSettingsPage.verifyPreferencesReflectedImmediately();
});

When("the user logs out and logs back in", () => {
 cy.logout();
 cy.login();
});

Then("the user is logged back into the application", () => {
 cy.verifyLogin();
});

When("the user navigates back to 'Notification Settings'", () => {
 UserSettingsPage.navigateBackToNotificationSettings();
});

Then("the notification settings reflect the updated preferences", () => {
 UserSettingsPage.verifyUpdatedPreferencesReflected();
});

When("the user checks the email inbox for notification test email", () => {
 UserSettingsPage.checkEmailInboxForTestEmail();
});

Then("the test email is received in the inbox", () => {
 UserSettingsPage.verifyTestEmailReceived();
});

When("the user checks the SMS inbox for notification test SMS", () => {
 UserSettingsPage.checkSMSInboxForTestSMS();
});

Then("the test SMS is received on the phone", () => {
 UserSettingsPage.verifyTestSMSReceived();
});

And("ensure immediate reflection of changes across all user devices", () => {
 UserSettingsPage.ensureImmediateReflectionAcrossDevices();
});

Then("changes are synchronized across all devices", () => {
 UserSettingsPage.verifyChangesSynchronizedAcrossDevices();
});