import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SignUpPage from "../pages/signUpPage";

Given("the user navigates to the application URL", () => {
 SignUpPage.visit();
});

When("the application homepage is displayed", () => {
 SignUpPage.verifyHomepage();
});

When("the user clicks on the 'Sign Up' button", () => {
 SignUpPage.clickSignUpButton();
});

Then("sign-up options are displayed", () => {
 SignUpPage.verifySignUpOptions();
});

When("the user selects 'Sign up with Facebook'", () => {
 SignUpPage.selectSignUpWithFacebook();
});

Then("the Facebook login page is displayed", () => {
 SignUpPage.verifyFacebookLoginPage();
});

When("the user enters Facebook account email {string} and password {string}", (email, password) => {
 SignUpPage.enterFacebookCredentials(email, password);
});

Then("credentials are accepted", () => {
 SignUpPage.verifyCredentialsAccepted();
});

When("the user clicks on 'Login' to proceed", () => {
 SignUpPage.clickLoginToProceed();
});

Then("the Facebook account permissions page is displayed", () => {
 SignUpPage.verifyFacebookPermissionsPage();
});

When("the user grants necessary permissions to the application", () => {
 SignUpPage.grantPermissions();
});

Then("permissions are granted", () => {
 SignUpPage.verifyPermissionsGranted();
});

When("the user confirms the sign-up process", () => {
 SignUpPage.confirmSignUpProcess();
});

Then("a sign-up confirmation message is displayed", () => {
 SignUpPage.verifySignUpConfirmationMessage();
});

When("the user is redirected to the application dashboard", () => {
 SignUpPage.redirectToDashboard();
});

Then("the user dashboard is displayed", () => {
 SignUpPage.verifyUserDashboard();
});

When("the user verifies profile information retrieved from Facebook", () => {
 SignUpPage.verifyProfileInformation();
});

Then("profile information matches Facebook account details", () => {
 SignUpPage.verifyProfileInformationMatches();
});

When("the user logs out from the application", () => {
 SignUpPage.logout();
});

Then("the user is logged out successfully", () => {
 SignUpPage.verifyLogoutSuccess();
});

When("the user attempts to log in again using the same Facebook account", () => {
 SignUpPage.loginAgainWithFacebook();
});

Then("the user is logged in successfully using Facebook", () => {
 SignUpPage.verifyLoginSuccessWithFacebook();
});

When("the user checks for any error messages or alerts during the sign-up process", () => {
 SignUpPage.checkForErrorsOrAlerts();
});

Then("no errors or alerts are displayed", () => {
 SignUpPage.verifyNoErrorsOrAlerts();
});

When("the user verifies email confirmation received from the application", () => {
 SignUpPage.verifyEmailConfirmation();
});

Then("email confirmation is received", () => {
 SignUpPage.verifyEmailConfirmationReceived();
});

When("the user confirms that the sign-up process adheres to privacy policies", () => {
 SignUpPage.confirmPrivacyPoliciesAdherence();
});

Then("privacy policies are adhered to", () => {
 SignUpPage.verifyPrivacyPoliciesAdherence();
});

When("the user ensures that application terms and conditions are accepted during sign-up", () => {
 SignUpPage.ensureTermsAndConditionsAccepted();
});

Then("terms and conditions are accepted", () => {
 SignUpPage.verifyTermsAndConditionsAccepted();
});