import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AuthPage from "../pages/authPage";

Given("the user is on the sign-up page", () => {
 AuthPage.visitSignUp();
});

When("the user enters a valid email and password", () => {
 AuthPage.enterEmailAndPassword();
});

When("the user submits the sign-up form", () => {
 AuthPage.submitSignUpForm();
});

Then("the system sends a confirmation email", () => {
 AuthPage.verifyConfirmationEmailSent();
});

Then("the user receives a successful sign-up message", () => {
 AuthPage.verifySuccessfulSignUpMessage();
});

When("the user chooses to sign up with Google", () => {
 AuthPage.signUpWithGoogle();
});

When("the user provides valid Google credentials", () => {
 AuthPage.enterGoogleCredentials();
});

When("the user chooses to sign up with Facebook", () => {
 AuthPage.signUpWithFacebook();
});

When("the user provides valid Facebook credentials", () => {
 AuthPage.enterFacebookCredentials();
});

Given("the user is on the sign-in page", () => {
 AuthPage.visitSignIn();
});

When("the user enters valid email and password", () => {
 AuthPage.enterEmailAndPassword();
});

When("the user submits the sign-in form", () => {
 AuthPage.submitSignInForm();
});

Then("the user is successfully signed in", () => {
 AuthPage.verifySuccessfulSignIn();
});

When("the user chooses to sign in with Google", () => {
 AuthPage.signInWithGoogle();
});

When("the user chooses to sign in with Facebook", () => {
 AuthPage.signInWithFacebook();
});

When("the user enters invalid email or password", () => {
 AuthPage.enterInvalidEmailOrPassword();
});

Then("an error message is displayed", () => {
 AuthPage.verifyErrorMessageDisplayed();
});

Given("the user is on the password recovery page", () => {
 AuthPage.visitPasswordRecovery();
});

When("the user enters a valid email", () => {
 AuthPage.enterRecoveryEmail();
});

When("the user submits the password recovery form", () => {
 AuthPage.submitRecoveryForm();
});

Then("the system sends a password recovery email", () => {
 AuthPage.verifyRecoveryEmailSent();
});

Then("the user can reset the password securely", () => {
 AuthPage.verifySecurePasswordReset();
});

Given("the user is logged in", () => {
 AuthPage.ensureLoggedIn();
});

When("the user navigates to the change password page", () => {
 AuthPage.navigateToChangePassword();
});

When("the user enters the current password and new password", () => {
 AuthPage.enterCurrentAndNewPassword();
});

When("the user submits the change password form", () => {
 AuthPage.submitChangePasswordForm();
});

Then("the password is changed successfully", () => {
 AuthPage.verifyPasswordChangeSuccess();
});

When("the user navigates to the two-factor authentication setup page", () => {
 AuthPage.navigateToTwoFactorSetup();
});

When("the user completes the setup process", () => {
 AuthPage.completeTwoFactorSetup();
});

Then("two-factor authentication is enabled for the user", () => {
 AuthPage.verifyTwoFactorEnabled();
});

Given("the user attempts to sign in", () => {
 AuthPage.attemptSignIn();
});

Then("the system logs the authentication attempt", () => {
 AuthPage.verifyAuthAttemptLogged();
});

Given("the user is on the authentication page", () => {
 AuthPage.visitAuthenticationPage();
});

Then("the authentication process complies with industry security standards", () => {
 AuthPage.verifySecurityCompliance();
});

Then("the user interface guides the user through the authentication process intuitively", () => {
 AuthPage.verifyIntuitiveInterface();
});