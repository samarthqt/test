import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountPreferencesPage from "../pages/accountPreferencesPage";

Given("the user is on the account preferences page", () => {
 AccountPreferencesPage.visit();
});

When("the user updates the notification settings", () => {
 AccountPreferencesPage.updateNotificationSettings();
});

Then("the system provides a confirmation message for successful update", () => {
 AccountPreferencesPage.verifySuccessMessage();
});

Then("the changes are stored and reflected immediately in the user profile", () => {
 AccountPreferencesPage.verifyChangesReflected();
});

When("the user changes the privacy settings", () => {
 AccountPreferencesPage.changePrivacySettings();
});

When("the user updates personal information such as name, email, and phone number", () => {
 AccountPreferencesPage.updatePersonalInformation();
});

When("the user enters invalid inputs", () => {
 AccountPreferencesPage.enterInvalidInputs();
});

Then("error messages are displayed", () => {
 AccountPreferencesPage.verifyErrorMessages();
});

Given("the user has updated account preferences", () => {
 AccountPreferencesPage.preferencesUpdated();
});

When("the changes are saved", () => {
 AccountPreferencesPage.saveChanges();
});

Then("user preferences are saved securely and comply with privacy regulations", () => {
 AccountPreferencesPage.verifySecureSave();
});

When("the user resets preferences to default settings", () => {
 AccountPreferencesPage.resetToDefault();
});

Then("the system provides a confirmation message for successful reset", () => {
 AccountPreferencesPage.verifyResetMessage();
});

When("the user interacts with the interface", () => {
 AccountPreferencesPage.interactWithInterface();
});

Then("the interface is intuitive and user-friendly", () => {
 AccountPreferencesPage.verifyInterfaceIntuitive();
});

Given("the user has made changes to account preferences", () => {
 AccountPreferencesPage.changesMade();
});

Then("logs are generated for changes made to account preferences", () => {
 AccountPreferencesPage.verifyLogsGenerated();
});