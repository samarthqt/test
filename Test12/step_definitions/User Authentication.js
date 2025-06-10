import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AuthPage from "../pages/authPage";

Given("the user is on the sign-up page", () => {
 AuthPage.visitSignUpPage();
});

When("the user enters a valid email and password", () => {
 AuthPage.enterEmailAndPassword('valid@example.com', 'Password123');
});

When("the user chooses to sign up using Google", () => {
 AuthPage.signUpWithGoogle();
});

When("the user chooses to sign up using Facebook", () => {
 AuthPage.signUpWithFacebook();
});

When("the user clicks the sign-up button", () => {
 AuthPage.clickSignUpButton();
});

Then("the user should be signed up successfully", () => {
 AuthPage.verifySignUpSuccess();
});

Then("receive a notification for successful sign-up", () => {
 AuthPage.verifySignUpNotification();
});

Given("the user is on the login page", () => {
 AuthPage.visitLoginPage();
});

When("the user enters a valid email and password", () => {
 AuthPage.enterEmailAndPassword('valid@example.com', 'Password123');
});

When("the user chooses to log in using Google", () => {
 AuthPage.logInWithGoogle();
});

When("the user chooses to log in using Facebook", () => {
 AuthPage.logInWithFacebook();
});

When("the user clicks the login button", () => {
 AuthPage.clickLoginButton();
});

Then("the user should be logged in successfully", () => {
 AuthPage.verifyLoginSuccess();
});

Then("receive a notification for successful login", () => {
 AuthPage.verifyLoginNotification();
});

When("the user enters invalid credentials", () => {
 AuthPage.enterEmailAndPassword('invalid@example.com', 'wrongpassword');
});

Then("the user should see an authentication error message", () => {
 AuthPage.verifyAuthErrorMessage();
});

When("the user enters their credentials", () => {
 AuthPage.enterEmailAndPassword('user@example.com', 'UserPassword');
});

Then("the application should ensure secure handling of the credentials", () => {
 AuthPage.verifySecureCredentialHandling();
});

Given("the user attempts to log in", () => {
 AuthPage.attemptLogin();
});

Then("the system should log the authentication attempt", () => {
 AuthPage.verifyAuthAttemptLogged();
});

Given("the user has signed up", () => {
 AuthPage.userSignedUp();
});

Then("the application should comply with GDPR for user data privacy", () => {
 AuthPage.verifyGDPRCompliance();
});

When("the user clicks on \"Forgot Password\"", () => {
 AuthPage.clickForgotPassword();
});

Then("the user should be able to initiate password recovery", () => {
 AuthPage.verifyPasswordRecoveryInitiation();
});

Given("the user is logged in", () => {
 AuthPage.userLoggedIn();
});

When("the user opts to enable 2FA", () => {
 AuthPage.enableTwoFactorAuthentication();
});

Then("the application should offer two-factor authentication for enhanced security", () => {
 AuthPage.verifyTwoFactorAuthEnabled();
});