import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountCreationPage from "../pages/accountCreationPage";

Given("I navigate to the account creation page", () => {
 AccountCreationPage.visit();
});

Given("I am logged out and on the account creation page", () => {
 AccountCreationPage.ensureLoggedOut();
 AccountCreationPage.visit();
});

When("I select the {string} option", (option) => {
 AccountCreationPage.selectSignUpOption(option);
});

When("I enter the email address {string} and fill in the required details", (email) => {
 AccountCreationPage.enterEmailDetails(email);
});

When("I submit the email sign-up form", () => {
 AccountCreationPage.submitEmailSignUpForm();
});

When("I authenticate using Google account {string}", (googleEmail) => {
 AccountCreationPage.authenticateWithGoogle(googleEmail);
});

When("I authenticate using Facebook account {string}", (facebookEmail) => {
 AccountCreationPage.authenticateWithFacebook(facebookEmail);
});

When("I attempt to log in using each account", () => {
 AccountCreationPage.attemptLoginWithAllAccounts();
});

When("I check for any confirmation email or notification received after account creation", () => {
 AccountCreationPage.checkConfirmationEmails();
});

When("I verify the user account details", () => {
 AccountCreationPage.verifyAccountDetails();
});

When("I attempt to create another account using the same email", () => {
 AccountCreationPage.attemptDuplicateEmailSignUp();
});

When("I initiate an account creation request", () => {
 AccountCreationPage.initiateAccountCreationRequest();
});

Then("an account is created successfully using the email address", () => {
 AccountCreationPage.verifyEmailAccountCreationSuccess();
});

Then("Google authentication is successful and account is created", () => {
 AccountCreationPage.verifyGoogleAccountCreationSuccess();
});

Then("Facebook authentication is successful and account is created", () => {
 AccountCreationPage.verifyFacebookAccountCreationSuccess();
});

Then("I am able to log in using email, Google, and Facebook accounts", () => {
 AccountCreationPage.verifyLoginWithAllAccounts();
});

Then("confirmation email or notification is received for each account creation method", () => {
 AccountCreationPage.verifyConfirmationEmailsReceived();
});

Then("user account details are accurate and match the information provided during sign-up", () => {
 AccountCreationPage.verifyAccountDetailsAccuracy();
});

Then("the system displays an error message indicating the email is already registered", () => {
 AccountCreationPage.verifyDuplicateEmailError();
});

Then("the system responds promptly to account creation requests", () => {
 AccountCreationPage.verifyResponseTime();
});