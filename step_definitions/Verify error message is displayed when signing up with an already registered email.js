import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SignUpPage from "../pages/signUpPage";

Given("the user navigates to the application URL {string}", (url) => {
 SignUpPage.visit(url);
});

When("the user clicks on the {string} button", (buttonText) => {
 SignUpPage.clickButton(buttonText);
});

Then("sign-up options are displayed", () => {
 SignUpPage.verifySignUpOptionsDisplayed();
});

When("the user enters the registered email {string} in the email field", (email) => {
 SignUpPage.enterEmail(email);
});

When("the user enters a new password {string} in the password field", (password) => {
 SignUpPage.enterPassword(password);
});

When("the user clicks on {string} to proceed", (buttonText) => {
 SignUpPage.clickProceedButton(buttonText);
});

Then("the system processes the sign-up request", () => {
 SignUpPage.verifyProcessingRequest();
});

Then("an error message indicating the email is already registered is displayed", () => {
 SignUpPage.verifyErrorMessageDisplayed();
});

Then("the error message includes guidance for recovering password or contacting support", () => {
 SignUpPage.verifyErrorMessageGuidance();
});

Then("the sign-up is successful with a different email", () => {
 SignUpPage.verifySuccessfulSignUp();
});

Then("email confirmation is received for the new account", () => {
 SignUpPage.verifyEmailConfirmationReceived();
});

Then("no duplicate account is created", () => {
 SignUpPage.verifyNoDuplicateAccount();
});

Then("the system logs the error event", () => {
 SignUpPage.verifyErrorLogged();
});

Then("privacy policies are adhered to", () => {
 SignUpPage.verifyPrivacyPolicies();
});

Then("terms and conditions are displayed during sign-up attempt", () => {
 SignUpPage.verifyTermsAndConditionsDisplayed();
});

Then("support contact information is available", () => {
 SignUpPage.verifySupportContactInformation();
});