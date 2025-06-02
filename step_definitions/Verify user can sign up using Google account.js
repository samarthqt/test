import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SignUpPage from "../pages/signUpPage";

Given("the user has access to the internet", () => {
 cy.log("User has internet access");
});

Given("the application URL {string} is accessible", (url) => {
 cy.visit(url);
});

Given("Google sign-up integration is enabled", () => {
 cy.log("Google sign-up integration is enabled");
});

When("the user navigates to the application URL", () => {
 SignUpPage.visit();
});

Then("the application homepage is displayed", () => {
 cy.url().should("include", "/home");
});

When("the user clicks on the 'Sign Up' button", () => {
 SignUpPage.clickSignUpButton();
});

Then("sign-up options are displayed", () => {
 SignUpPage.verifySignUpOptions();
});

When("the user selects 'Sign up with Google'", () => {
 SignUpPage.selectGoogleSignUp();
});

Then("the Google login page is displayed", () => {
 cy.url().should("include", "accounts.google.com");
});

When("the user enters Google account email {string} and password {string}", (email, password) => {
 SignUpPage.enterGoogleCredentials(email, password);
});

Then("the credentials are accepted", () => {
 SignUpPage.verifyCredentialsAccepted();
});

When("the user clicks on 'Next' to proceed", () => {
 SignUpPage.clickNext();
});

Then("the Google account permissions page is displayed", () => {
 cy.url().should("include", "permissions");
});

When("the user grants necessary permissions to the application", () => {
 SignUpPage.grantPermissions();
});

Then("permissions are granted", () => {
 SignUpPage.verifyPermissionsGranted();
});

When("the user confirms the sign-up process", () => {
 SignUpPage.confirmSignUp();
});

Then("a sign-up confirmation message is displayed", () => {
 SignUpPage.verifySignUpConfirmation();
});

When("the user is redirected to the application dashboard", () => {
 cy.url().should("include", "/dashboard");
});

Then("the user dashboard is displayed", () => {
 SignUpPage.verifyDashboardDisplayed();
});

When("the user verifies their profile information", () => {
 SignUpPage.verifyProfileInformation();
});

Then("the profile information matches Google account details", () => {
 SignUpPage.verifyProfileMatchesGoogle();
});

When("the user logs out from the application", () => {
 SignUpPage.logout();
});

Then("the user is logged out successfully", () => {
 SignUpPage.verifyLogoutSuccessful();
});

When("the user attempts to log in again using the same Google account", () => {
 SignUpPage.loginWithGoogle();
});

Then("the user is logged in successfully using Google", () => {
 SignUpPage.verifyLoginSuccessful();
});

When("the user checks for any error messages or alerts during the sign-up process", () => {
 SignUpPage.checkForErrors();
});

Then("no errors or alerts are displayed", () => {
 SignUpPage.verifyNoErrors();
});

When("the user verifies email confirmation received from the application", () => {
 SignUpPage.verifyEmailConfirmation();
});

Then("email confirmation is received", () => {
 SignUpPage.verifyEmailReceived();
});

When("the user confirms that the sign-up process adheres to privacy policies", () => {
 SignUpPage.verifyPrivacyPolicies();
});

Then("privacy policies are adhered to", () => {
 SignUpPage.verifyPrivacyAdhered();
});

When("the user ensures that application terms and conditions are accepted during sign-up", () => {
 SignUpPage.verifyTermsAccepted();
});

Then("terms and conditions are accepted", () => {
 SignUpPage.verifyTermsConditionsAccepted();
});