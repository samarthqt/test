import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SignUpPage from "../pages/signUpPage";

Given("the user has access to the sign-up page", () => {
 SignUpPage.visit();
});

When("the user navigates to the sign-up page", () => {
 SignUpPage.navigateToSignUp();
});

Then("the sign-up page loads successfully", () => {
 SignUpPage.verifyPageLoad();
});

Given("the user has no existing account with the test email", () => {
 SignUpPage.verifyNoExistingAccount();
});

When("the user enters a valid email address in the email field", () => {
 SignUpPage.enterEmail("test@example.com");
});

Then("the email address is accepted without errors", () => {
 SignUpPage.verifyEmailAcceptance();
});

Given("the user has a valid email address", () => {
 SignUpPage.verifyValidEmail();
});

When("the user enters a strong password in the password field", () => {
 SignUpPage.enterPassword("StrongP@ssw0rd!");
});

Then("the password is accepted and meets strength criteria", () => {
 SignUpPage.verifyPasswordStrength();
});

Given("the user has entered a valid email address and strong password", () => {
 SignUpPage.verifyCredentials();
});

When("the user fills in the required user details", () => {
 SignUpPage.fillUserDetails({ name: "John Doe", dob: "1990-01-01" });
});

Then("the user details are accepted without errors", () => {
 SignUpPage.verifyUserDetails();
});

Given("the user has filled in the required user details", () => {
 SignUpPage.verifyUserDetailsFilled();
});

When("the user agrees to the terms and conditions", () => {
 SignUpPage.agreeToTerms();
});

Then("the terms and conditions are agreed upon", () => {
 SignUpPage.verifyTermsAgreement();
});

Given("the user has agreed to the terms and conditions", () => {
 SignUpPage.verifyTermsAgreed();
});

When("the user clicks the 'Sign Up' button", () => {
 SignUpPage.clickSignUp();
});

Then("user registration is successful and a confirmation message is displayed", () => {
 SignUpPage.verifyRegistrationSuccess();
});

Given("the user has successfully registered", () => {
 SignUpPage.verifySuccessfulRegistration();
});

When("the user checks the email inbox for a confirmation email", () => {
 SignUpPage.checkEmailInbox();
});

Then("the confirmation email is received in the inbox", () => {
 SignUpPage.verifyConfirmationEmail();
});

Given("the user has received a confirmation email", () => {
 SignUpPage.verifyEmailReceived();
});

When("the user clicks the confirmation link in the email", () => {
 SignUpPage.clickConfirmationLink();
});

Then("the email is verified and the user is directed to the welcome page", () => {
 SignUpPage.verifyEmailVerification();
});

Given("the user has verified their email", () => {
 SignUpPage.verifyEmailVerified();
});

When("the user attempts to log in with the registered email and password", () => {
 SignUpPage.loginWithCredentials("test@example.com", "StrongP@ssw0rd!");
});

Then("login is successful and the user is directed to the dashboard", () => {
 SignUpPage.verifyLoginSuccess();
});

Given("the user is on the dashboard", () => {
 SignUpPage.verifyOnDashboard();
});

When("the user verifies the account details", () => {
 SignUpPage.verifyAccountDetails();
});

Then("account details are accurate and reflect the registration information", () => {
 SignUpPage.verifyAccountAccuracy();
});

Given("the user is logged into the dashboard", () => {
 SignUpPage.verifyLoggedIn();
});

When("the user logs out and attempts to log back in", () => {
 SignUpPage.logoutAndLoginAgain();
});

Then("the user can log back in successfully with the registered credentials", () => {
 SignUpPage.verifyReLoginSuccess();
});

Given("the user is attempting to sign up", () => {
 SignUpPage.attemptSignUp();
});

When("the user completes the sign-up process", () => {
 SignUpPage.completeSignUp();
});

Then("no error messages are displayed during the sign-up process", () => {
 SignUpPage.verifyNoErrors();
});

Given("the user has a registered account", () => {
 SignUpPage.verifyRegisteredAccount();
});

When("the user attempts to recover the password", () => {
 SignUpPage.recoverPassword();
});

Then("the password recovery process functions correctly", () => {
 SignUpPage.verifyPasswordRecovery();
});

Given("the user is attempting to sign up on {string} using {string}", (device, browser) => {
 SignUpPage.attemptSignUpOnDevice(device, browser);
});

When("the user completes the sign-up process", () => {
 SignUpPage.completeSignUp();
});

Then("the sign-up process works consistently across devices and browsers", () => {
 SignUpPage.verifySignUpConsistency();
});

Given("the user is attempting to register with an existing email", () => {
 SignUpPage.attemptDuplicateEmailSignUp();
});

When("the user tries to sign up", () => {
 SignUpPage.trySignUp();
});

Then("the system prevents duplicate registrations and provides appropriate feedback", () => {
 SignUpPage.verifyDuplicatePrevention();
});