import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RegistrationPage from "../pages/registrationPage";

Given("the user registration page is accessible", () => {
 RegistrationPage.visit();
});

When("I navigate to the registration page of the application", () => {
 RegistrationPage.visit();
});

Then("the registration page is displayed", () => {
 RegistrationPage.verifyPageDisplayed();
});

When("I enter {string} in the email field", (email) => {
 RegistrationPage.enterEmail(email);
});

Then("the email with special characters is entered successfully", () => {
 RegistrationPage.verifyEmailEntered();
});

When("I enter {string} in the password field", (password) => {
 RegistrationPage.enterPassword(password);
});

Then("the password with special characters is entered successfully", () => {
 RegistrationPage.verifyPasswordEntered();
});

When("I fill in other required registration fields with valid data", () => {
 RegistrationPage.fillOtherFields();
});

Then("all fields are populated correctly", () => {
 RegistrationPage.verifyFieldsPopulated();
});

When("I click on the 'Register' button", () => {
 RegistrationPage.clickRegisterButton();
});

Then("the registration process is initiated", () => {
 RegistrationPage.verifyRegistrationInitiated();
});

When("I check if the registration confirmation message is displayed", () => {
 RegistrationPage.checkConfirmationMessage();
});

Then("the registration confirmation message is displayed", () => {
 RegistrationPage.verifyConfirmationMessageDisplayed();
});

When("I verify the email received for registration confirmation", () => {
 RegistrationPage.verifyEmailConfirmationReceived();
});

Then("email confirmation is received successfully", () => {
 RegistrationPage.verifyEmailConfirmation();
});

When("I attempt to log in using the registered email and password", () => {
 RegistrationPage.loginWithRegisteredCredentials();
});

Then("the user is able to log in successfully", () => {
 RegistrationPage.verifyLoginSuccessful();
});

When("I check the user profile for registration details", () => {
 RegistrationPage.checkUserProfileDetails();
});

Then("the user profile displays correct registration details", () => {
 RegistrationPage.verifyUserProfileDetails();
});

When("I verify that the system does not truncate special characters in email or password", () => {
 RegistrationPage.verifyNoTruncation();
});

Then("email and password are stored completely with special characters", () => {
 RegistrationPage.verifyStorageOfSpecialCharacters();
});

When("I log out from the application", () => {
 RegistrationPage.logout();
});

Then("the user is logged out successfully", () => {
 RegistrationPage.verifyLogoutSuccessful();
});

When("I attempt to reset the password using the registered email", () => {
 RegistrationPage.resetPassword();
});

Then("the password reset link is sent to the email", () => {
 RegistrationPage.verifyResetLinkSent();
});

When("I verify the password reset functionality with special characters", () => {
 RegistrationPage.verifyPasswordResetWithSpecialCharacters();
});

Then("password reset is successful using special characters", () => {
 RegistrationPage.verifyPasswordResetSuccessful();
});

When("I check the system logs for any errors during registration", () => {
 RegistrationPage.checkSystemLogsForErrors();
});

Then("no errors are logged in the system", () => {
 RegistrationPage.verifyNoErrorsLogged();
});

When("I ensure the registration data is encrypted in the database", () => {
 RegistrationPage.ensureDataEncrypted();
});

Then("registration data is encrypted", () => {
 RegistrationPage.verifyDataEncrypted();
});