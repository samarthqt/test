import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountCreationPage from "../pages/accountCreationPage";

Given("I am on the account creation page", () => {
 AccountCreationPage.visit();
});

When("I enter the email {string} and password {string}", (email, password) => {
 AccountCreationPage.enterEmail(email);
 AccountCreationPage.enterPassword(password);
});

When("I enter a non-registered email and a password", () => {
 AccountCreationPage.enterEmail("newuser@example.com");
 AccountCreationPage.enterPassword("ValidPass123");
});

When("I click on the {string} button", (button) => {
 AccountCreationPage.clickCreateAccountButton();
});

When("I repeatedly attempt to create an account with the email {string}", (email) => {
 for(let i = 0; i < 3; i++) {
   AccountCreationPage.enterEmail(email);
   AccountCreationPage.enterPassword("NewPass123");
   AccountCreationPage.clickCreateAccountButton();
 }
});

Then("I should see an error message indicating the email is already registered", () => {
 AccountCreationPage.verifyEmailAlreadyRegisteredError();
});

Then("the error message should clearly state the reason for account creation failure", () => {
 AccountCreationPage.verifyErrorMessageDetails();
});

Then("the account should be created successfully", () => {
 AccountCreationPage.verifyAccountCreationSuccess();
});

Then("the system should consistently display an error message for each attempt", () => {
 AccountCreationPage.verifyRepeatedErrorMessage();
});

Then("the error message should be accessible and clearly visible", () => {
 AccountCreationPage.verifyErrorMessageAccessibility();
});

Then("the error message should be displayed correctly on mobile devices", () => {
 AccountCreationPage.verifyErrorMessageOnMobile();
});

Then("I should see an error message for both registered email and invalid password", () => {
 AccountCreationPage.verifyEmailAndPasswordError();
});

Then("the system logs should contain records of failed account creation attempts", () => {
 AccountCreationPage.verifySystemLogsForFailedAttempts();
});

Then("the system should handle high traffic efficiently and display an error message", () => {
 AccountCreationPage.verifyErrorMessageDuringHighTraffic();
});

Then("the system should prompt for a stronger password and display an email registration error", () => {
 AccountCreationPage.verifyPasswordStrengthPromptAndEmailError();
});

Then("the system should display an error message indicating a network issue", () => {
 AccountCreationPage.verifyNetworkIssueErrorMessage();
});

Then("the system should allow account creation via social media despite the registered email", () => {
 AccountCreationPage.verifySocialMediaAccountCreation();
});

Then("the system should prompt me to re-login and display an error message for the registered email", () => {
 AccountCreationPage.verifySessionExpiryAndEmailError();
});