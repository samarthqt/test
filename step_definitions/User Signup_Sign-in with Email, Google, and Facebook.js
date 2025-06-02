import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SignupSigninPage from "../pages/signupSigninPage";

Given("the user navigates to the signup/sign-in page", () => {
 SignupSigninPage.visit();
});

Then("the signup/sign-in page is displayed with options for email, Google, and Facebook", () => {
 SignupSigninPage.verifyOptions();
});

Given("the user is on the signup/sign-in page", () => {
 SignupSigninPage.visit();
});

When("the user attempts to sign up using email {string}", (email) => {
 SignupSigninPage.signupWithEmail(email);
});

Then("the user is successfully signed up using email", () => {
 SignupSigninPage.verifySignupSuccess();
});

Given("the user is logged out", () => {
 SignupSigninPage.logout();
});

When("the user attempts to sign in using email {string}", (email) => {
 SignupSigninPage.signinWithEmail(email);
});

Then("the user is successfully signed in using email", () => {
 SignupSigninPage.verifySigninSuccess();
});

When("the user attempts to sign up using Google account linked to {string}", (email) => {
 SignupSigninPage.signupWithGoogle(email);
});

Then("the user is successfully signed up using Google account", () => {
 SignupSigninPage.verifySignupSuccess();
});

When("the user attempts to sign in using Google account linked to {string}", (email) => {
 SignupSigninPage.signinWithGoogle(email);
});

Then("the user is successfully signed in using Google account", () => {
 SignupSigninPage.verifySigninSuccess();
});

When("the user attempts to sign up using Facebook account linked to {string}", (email) => {
 SignupSigninPage.signupWithFacebook(email);
});

Then("the user is successfully signed up using Facebook account", () => {
 SignupSigninPage.verifySignupSuccess();
});

When("the user attempts to sign in using Facebook account linked to {string}", (email) => {
 SignupSigninPage.signinWithFacebook(email);
});

Then("the user is successfully signed in using Facebook account", () => {
 SignupSigninPage.verifySigninSuccess();
});

Given("the user is signed in", () => {
 SignupSigninPage.verifySigninSuccess();
});

When("the user navigates to the user profile", () => {
 SignupSigninPage.navigateToProfile();
});

Then("the user profile correctly displays account information", () => {
 SignupSigninPage.verifyProfileDetails();
});

Given("the user has signed up", () => {
 SignupSigninPage.verifySignupSuccess();
});

When("the user checks their email or messages", () => {
 SignupSigninPage.checkForWelcomeEmail();
});

Then("a welcome email or message is received upon signup", () => {
 SignupSigninPage.verifyWelcomeEmail();
});

When("the user attempts to sign in using incorrect credentials", () => {
 SignupSigninPage.signinWithIncorrectCredentials();
});

Then("sign-in fails and an error message is displayed", () => {
 SignupSigninPage.verifySigninError();
});

When("the user examines the security measures", () => {
 SignupSigninPage.verifySecurityMeasures();
});

Then("security measures such as CAPTCHA are in place", () => {
 SignupSigninPage.verifyCAPTCHA();
});

Given("the user is signing up or signing in", () => {
 SignupSigninPage.verifySigningProcess();
});

When("the user checks the browser console", () => {
 SignupSigninPage.checkBrowserConsole();
});

Then("no errors are logged in the console", () => {
 SignupSigninPage.verifyNoConsoleErrors();
});

When("the user attempts to sign up with an already registered email {string}", (email) => {
 SignupSigninPage.signupWithRegisteredEmail(email);
});

Then("an error message indicates the email is already registered", () => {
 SignupSigninPage.verifyEmailAlreadyRegisteredError();
});

When("the user checks for options to reset password if forgotten", () => {
 SignupSigninPage.checkPasswordResetOptions();
});

Then("a password reset option is available", () => {
 SignupSigninPage.verifyPasswordResetOption();
});

When("the user attempts to log out", () => {
 SignupSigninPage.logout();
});

Then("the user is successfully logged out", () => {
 SignupSigninPage.verifyLogoutSuccess();
});