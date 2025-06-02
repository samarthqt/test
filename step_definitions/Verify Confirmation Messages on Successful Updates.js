import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import DashboardPage from "../pages/dashboardPage";
import ProfileSettingsPage from "../pages/profileSettingsPage";

Given("a user account with update permissions", () => {
 // Assume user account setup
});

When("the user logs in using valid credentials", () => {
 cy.login('validUser', 'validPassword');
});

Then("the user should be successfully logged in and directed to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user is on the dashboard", () => {
 DashboardPage.verifyDashboard();
});

When("the user navigates to the profile settings page", () => {
 DashboardPage.goToProfileSettings();
});

Then("the profile settings page should be displayed", () => {
 ProfileSettingsPage.verifyPage();
});

Given("the user is on the profile settings page", () => {
 ProfileSettingsPage.verifyPage();
});

When("the user updates the email address field with a new valid email", () => {
 ProfileSettingsPage.updateEmail('newemail@example.com');
});

Then("the email field should accept the new email address", () => {
 ProfileSettingsPage.verifyEmailUpdated('newemail@example.com');
});

Given("the user has updated the email address", () => {
 // Assume email is updated
});

When("the user clicks on the 'Save Changes' button", () => {
 ProfileSettingsPage.saveChanges();
});

Then("changes should be saved successfully", () => {
 ProfileSettingsPage.verifyChangesSaved();
});

Then("a confirmation message should be displayed indicating successful update", () => {
 ProfileSettingsPage.verifyConfirmationMessage();
});

Given("the user has saved the changes", () => {
 // Assume changes are saved
});

When("the user checks the updated email in the profile settings", () => {
 ProfileSettingsPage.verifyEmailUpdated('newemail@example.com');
});

Then("the new email should be displayed in the email field", () => {
 ProfileSettingsPage.verifyEmailUpdated('newemail@example.com');
});

Given("the user is logged in", () => {
 DashboardPage.verifyDashboard();
});

When("the user logs out of the account", () => {
 cy.logout();
});

Then("the user should be successfully logged out", () => {
 cy.url().should("include", "/login");
});

When("the user logs back in using the new email address", () => {
 cy.login('newemail@example.com', 'validPassword');
});

Then("the user should be able to log in using the updated email", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user has updated the email address", () => {
 // Assume email is updated
});

When("the user checks the inbox for a confirmation email", () => {
 cy.checkEmailInbox('newemail@example.com');
});

Then("a confirmation email should be received with details of the update", () => {
 cy.verifyConfirmationEmailReceived();
});

Given("the user is updating profile information", () => {
 // Assume profile update process
});

When("the user performs the update", () => {
 ProfileSettingsPage.performUpdate();
});

Then("no error messages should appear during the update process", () => {
 ProfileSettingsPage.verifyNoErrorMessages();
});

Given("the user is on the profile settings page", () => {
 ProfileSettingsPage.verifyPage();
});

When("the user attempts to update another field", () => {
 ProfileSettingsPage.updateAnotherField();
});

Then("a confirmation message should appear for each successful update", () => {
 ProfileSettingsPage.verifyConfirmationMessage();
});

Given("the user has updated profile information", () => {
 // Assume profile information updated
});

When("the user checks notifications", () => {
 cy.checkNotifications();
});

Then("notification should confirm the successful update", () => {
 cy.verifyNotificationConfirmation();
});

Given("the user has performed an update", () => {
 // Assume update performed
});

When("the system logs are checked", () => {
 cy.checkSystemLogs();
});

Then("system logs should record the update action with a timestamp", () => {
 cy.verifySystemLogs();
});

Given("the user is on the profile settings page", () => {
 ProfileSettingsPage.verifyPage();
});

When("the user attempts to update with invalid data", () => {
 ProfileSettingsPage.updateWithInvalidData();
});

Then("no confirmation message should appear", () => {
 ProfileSettingsPage.verifyNoConfirmationMessage();
});

Then("error handling should activate", () => {
 ProfileSettingsPage.verifyErrorHandling();
});

Given("the user receives a confirmation message", () => {
 // Assume confirmation message received
});

Then("the confirmation message should clearly state the update was successful", () => {
 ProfileSettingsPage.verifyConfirmationMessageClarity();
});