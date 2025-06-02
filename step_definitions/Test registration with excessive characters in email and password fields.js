import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RegistrationPage from "../pages/registrationPage";

Given("the user registration page is accessible", () => {
 RegistrationPage.visit();
});

When("I navigate to the registration page of the application", () => {
 RegistrationPage.checkPageDisplayed();
});

Then("the registration page is displayed", () => {
 RegistrationPage.verifyPageDisplayed();
});

Given("I understand maximum character limits for email and password fields", () => {
 // Code to understand limits
});

When("I enter excessive characters in the email field", () => {
 RegistrationPage.enterExcessiveEmail();
});

Then("the system displays an error message for exceeding character limit", () => {
 RegistrationPage.verifyEmailError();
});

When("I enter excessive characters in the password field", () => {
 RegistrationPage.enterExcessivePassword();
});

Then("the system displays an error message for exceeding character limit", () => {
 RegistrationPage.verifyPasswordError();
});

Given("I have entered excessive characters in the email and password fields", () => {
 // Code for precondition
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

Then("the registration process is not initiated due to errors", () => {
 RegistrationPage.verifyRegistrationNotInitiated();
});

Given("I have attempted to register with excessive characters", () => {
 // Code for precondition
});

When("I check if the registration error message is displayed", () => {
 RegistrationPage.checkErrorMessageDisplayed();
});

Then("the registration error message is displayed for email and password", () => {
 RegistrationPage.verifyErrorMessageDisplayed();
});

When("I attempt to log in using the email and password with excessive characters", () => {
 RegistrationPage.attemptLoginWithExcessiveCharacters();
});

Then("the user is unable to log in due to invalid credentials", () => {
 RegistrationPage.verifyLoginFailure();
});

When("I verify that no registration email is received", () => {
 RegistrationPage.verifyNoEmailReceived();
});

Then("no registration confirmation email is received", () => {
 RegistrationPage.verifyConfirmationEmailNotReceived();
});

When("I check the user profile for any registration details", () => {
 RegistrationPage.checkUserProfile();
});

Then("the user profile is not created", () => {
 RegistrationPage.verifyUserProfileNotCreated();
});

When("I verify that the system does not store excessive characters in email or password", () => {
 RegistrationPage.verifyNoExcessiveDataStored();
});

Then("the system does not store excessive characters", () => {
 RegistrationPage.verifyDataIntegrity();
});

Given("I am logged in", () => {
 // Code for precondition
});

When("I log out from the application", () => {
 RegistrationPage.logout();
});

Then("the user is logged out successfully", () => {
 RegistrationPage.verifyLogoutSuccessful();
});

Given("I have entered excessive characters in the email field", () => {
 // Code for precondition
});

When("I attempt to reset the password using the email with excessive characters", () => {
 RegistrationPage.attemptPasswordReset();
});

Then("the system displays an error message for invalid email", () => {
 RegistrationPage.verifyPasswordResetError();
});

When("I verify the password reset functionality with excessive characters", () => {
 RegistrationPage.verifyPasswordResetFunctionality();
});

Then("the password reset is unsuccessful due to invalid email", () => {
 RegistrationPage.verifyPasswordResetFailure();
});

When("I check the system logs for errors during registration attempts", () => {
 RegistrationPage.checkSystemLogs();
});

Then("errors are logged for exceeding character limits", () => {
 RegistrationPage.verifyErrorsLogged();
});

When("I ensure the system does not store invalid registration data", () => {
 RegistrationPage.verifyNoInvalidDataStored();
});

Then("invalid registration data is not stored", () => {
 RegistrationPage.verifyDataIntegrity();
});