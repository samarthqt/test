import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProfilePage from "../pages/profilePage";

Given("User is logged into their account", () => {
 ProfilePage.verifyUserLoggedIn();
});

When("User navigates to the profile settings page", () => {
 ProfilePage.navigateToProfileSettings();
});

Then("Profile settings page is displayed", () => {
 ProfilePage.verifyProfileSettingsDisplayed();
});

When("User enters new name {string} in the name field", (name) => {
 ProfilePage.enterName(name);
});

Then("New name is entered in the name field", () => {
 ProfilePage.verifyNameFieldUpdated();
});

When("User enters new email {string} in the email field", (email) => {
 ProfilePage.enterEmail(email);
});

Then("New email is entered in the email field", () => {
 ProfilePage.verifyEmailFieldUpdated();
});

When("User enters new phone number {string} in the phone number field", (phone) => {
 ProfilePage.enterPhoneNumber(phone);
});

Then("New phone number is entered in the phone number field", () => {
 ProfilePage.verifyPhoneNumberFieldUpdated();
});

When("User saves the changes", () => {
 ProfilePage.saveChanges();
});

Then("Changes are saved successfully", () => {
 ProfilePage.verifyChangesSaved();
});

Then("Profile page displays the updated name, email, and phone number", () => {
 ProfilePage.verifyUpdatedProfileInfo();
});

When("User logs out and logs back in", () => {
 ProfilePage.logoutAndLogin();
});

Then("User is successfully logged in again", () => {
 ProfilePage.verifyUserLoggedIn();
});

Then("Profile page still displays the updated name, email, and phone number", () => {
 ProfilePage.verifyUpdatedProfileInfo();
});

When("User checks the email inbox for confirmation email", () => {
 ProfilePage.checkEmailInbox();
});

Then("User receives a confirmation email about the email change", () => {
 ProfilePage.verifyEmailConfirmationReceived();
});

When("User checks the phone for confirmation SMS", () => {
 ProfilePage.checkPhoneForSMS();
});

Then("User receives a confirmation SMS about the phone number change", () => {
 ProfilePage.verifySMSConfirmationReceived();
});

Then("Account settings display the updated name, email, and phone number", () => {
 ProfilePage.verifyUpdatedAccountSettings();
});

When("User logs in using the updated email address", () => {
 ProfilePage.loginWithUpdatedEmail();
});

Then("User can log in using the updated email address", () => {
 ProfilePage.verifyLoginWithUpdatedEmail();
});

When("User verifies that the updated phone number can receive SMS notifications", () => {
 ProfilePage.verifySMSNotifications();
});

Then("User can receive SMS notifications on the updated phone number", () => {
 ProfilePage.verifySMSNotifications();
});