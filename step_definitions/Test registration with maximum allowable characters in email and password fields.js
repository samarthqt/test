import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RegistrationPage from "../pages/registrationPage";

Given("the user registration page is accessible", () => {
 RegistrationPage.visit();
});

When("the user navigates to the registration page of the application", () => {
 RegistrationPage.navigateToRegistrationPage();
});

Then("the registration page is displayed", () => {
 RegistrationPage.verifyRegistrationPageDisplayed();
});

Given("the maximum character limits for email and password fields are understood", () => {
 // Assume this is a precondition and no action is needed
});

When("the user enters the maximum allowable characters in the email field", () => {
 RegistrationPage.enterMaxEmail();
});

Then("the email is entered successfully", () => {
 RegistrationPage.verifyEmailEntered();
});

When("the user enters the maximum allowable characters in the password field", () => {
 RegistrationPage.enterMaxPassword();
});

Then("the password is entered successfully", () => {
 RegistrationPage.verifyPasswordEntered();
});

Given("all required registration fields are filled with valid data", () => {
 RegistrationPage.fillValidData();
});

When("the user clicks on the 'Register' button", () => {
 RegistrationPage.clickRegisterButton();
});

Then("the registration process is initiated", () => {
 RegistrationPage.verifyRegistrationInitiated();
});

When("the registration confirmation message is displayed", () => {
 RegistrationPage.verifyConfirmationMessageDisplayed();
});

Then("the registration confirmation message is displayed", () => {
 RegistrationPage.verifyConfirmationMessageDisplayed();
});

When("the user verifies the email received for registration confirmation", () => {
 RegistrationPage.verifyEmailReceived();
});

Then("the email confirmation is received successfully", () => {
 RegistrationPage.verifyEmailConfirmationReceived();
});

When("the user attempts to log in using the registered email and password", () => {
 RegistrationPage.loginWithRegisteredCredentials();
});

Then("the user is able to log in successfully", () => {
 RegistrationPage.verifyLoginSuccessful();
});

When("the user checks the user profile for registration details", () => {
 RegistrationPage.checkUserProfileDetails();
});

Then("the user profile displays correct registration details", () => {
 RegistrationPage.verifyUserProfileDetails();
});

When("the system stores the email and password", () => {
 RegistrationPage.storeEmailAndPassword();
});

Then("the email and password are stored completely", () => {
 RegistrationPage.verifyEmailAndPasswordStored();
});

When("the user logs out from the application", () => {
 RegistrationPage.logout();
});

Then("the user is logged out successfully", () => {
 RegistrationPage.verifyLogoutSuccessful();
});

When("the user attempts to reset the password using the registered email", () => {
 RegistrationPage.resetPasswordWithRegisteredEmail();
});

Then("the password reset link is sent to the email", () => {
 RegistrationPage.verifyPasswordResetLinkSent();
});

When("the user resets the password using the maximum allowable characters", () => {
 RegistrationPage.resetPasswordWithMaxCharacters();
});

Then("the password reset is successful", () => {
 RegistrationPage.verifyPasswordResetSuccessful();
});

When("the system logs are checked for errors during registration", () => {
 RegistrationPage.checkSystemLogsForErrors();
});

Then("no errors are logged in the system", () => {
 RegistrationPage.verifyNoErrorsInSystemLogs();
});

When("the registration data is stored in the database", () => {
 RegistrationPage.storeRegistrationDataInDatabase();
});

Then("the registration data is encrypted", () => {
 RegistrationPage.verifyRegistrationDataEncrypted();
});