import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SignUpPage from "../pages/signUpPage";

Given("the user accesses the application", () => {
 cy.visit("/");
});

When("the user navigates to the sign-up page", () => {
 SignUpPage.navigateToSignUp();
});

Then("the sign-up page is displayed", () => {
 SignUpPage.verifySignUpPageDisplayed();
});

Given("the user is on the sign-up page", () => {
 SignUpPage.verifySignUpPageDisplayed();
});

When("the user enters a valid email {string} and password {string}", (email, password) => {
 SignUpPage.enterEmail(email);
 SignUpPage.enterPassword(password);
});

And("submits the sign-up form", () => {
 SignUpPage.submitSignUpForm();
});

Then("the sign-up form is submitted successfully", () => {
 SignUpPage.verifySignUpSubmissionSuccess();
});

And("email confirmation is sent", () => {
 SignUpPage.verifyEmailConfirmationSent();
});

When("the user attempts to sign up using a Google account {string}", (googleEmail) => {
 SignUpPage.signUpWithGoogle(googleEmail);
});

And("authorizes Google account access", () => {
 SignUpPage.authorizeGoogleAccess();
});

Then("the Google sign-up process is completed successfully", () => {
 SignUpPage.verifyGoogleSignUpSuccess();
});

When("the user attempts to sign up using a Facebook account {string}", (facebookEmail) => {
 SignUpPage.signUpWithFacebook(facebookEmail);
});

And("authorizes Facebook account access", () => {
 SignUpPage.authorizeFacebookAccess();
});

Then("the Facebook sign-up process is completed successfully", () => {
 SignUpPage.verifyFacebookSignUpSuccess();
});

Given("the user has signed up successfully", () => {
 SignUpPage.verifySignUpSubmissionSuccess();
});

When("the user attempts to log in", () => {
 SignUpPage.loginAfterSignUp();
});

Then("the user is able to log in successfully", () => {
 SignUpPage.verifyLoginSuccess();
});

Given("the user has an existing account", () => {
 SignUpPage.verifyExistingAccount();
});

When("the user attempts to sign up with the same email", () => {
 SignUpPage.attemptDuplicateSignUp();
});

Then("the system prevents the creation of duplicate accounts", () => {
 SignUpPage.verifyDuplicateAccountPrevention();
});

When("the user enters an invalid email format", () => {
 SignUpPage.enterInvalidEmail();
});

Then("the system alerts the user to the invalid email format", () => {
 SignUpPage.verifyInvalidEmailAlert();
});

When("the user completes the sign-up process", () => {
 SignUpPage.completeSignUpProcess();
});

Then("the system logs sign-up actions accurately", () => {
 SignUpPage.verifySignUpActionsLogged();
});

When("the user checks the account status", () => {
 SignUpPage.checkAccountStatus();
});

Then("the account status is active and accessible", () => {
 SignUpPage.verifyAccountStatusActive();
});