package com.cucumber.steps;

import com.page_objects.SignupSigninPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupSigninSteps extends SignupSigninPage {

    @Given("the user navigates to the signup/sign-in page")
    public void theUserNavigatesToTheSignupSigninPage() {
        navigateToSignupSigninPage();
    }

    @Then("the signup/sign-in page is displayed with options for email, Google, and Facebook")
    public void theSignupSigninPageIsDisplayedWithOptions() {
        verifySignupSigninPageOptions();
    }

    @Given("the user is on the signup/sign-in page")
    public void theUserIsOnTheSignupSigninPage() {
        navigateToSignupSigninPage();
    }

    @When("the user attempts to sign up using email {string}")
    public void theUserAttemptsToSignUpUsingEmail(String email) {
        signUpUsingEmail(email);
    }

    @Then("the user is successfully signed up using email")
    public void theUserIsSuccessfullySignedUpUsingEmail() {
        verifySuccessfulSignup();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        logOutUser();
    }

    @When("the user attempts to sign in using email {string}")
    public void theUserAttemptsToSignInUsingEmail(String email) {
        signInUsingEmail(email);
    }

    @Then("the user is successfully signed in using email")
    public void theUserIsSuccessfullySignedInUsingEmail() {
        verifySuccessfulSignin();
    }

    @When("the user attempts to sign up using Google account linked to {string}")
    public void theUserAttemptsToSignUpUsingGoogleAccount(String email) {
        signUpUsingGoogle(email);
    }

    @Then("the user is successfully signed up using Google account")
    public void theUserIsSuccessfullySignedUpUsingGoogleAccount() {
        verifySuccessfulSignup();
    }

    @When("the user attempts to sign in using Google account linked to {string}")
    public void theUserAttemptsToSignInUsingGoogleAccount(String email) {
        signInUsingGoogle(email);
    }

    @Then("the user is successfully signed in using Google account")
    public void theUserIsSuccessfullySignedInUsingGoogleAccount() {
        verifySuccessfulSignin();
    }

    @When("the user attempts to sign up using Facebook account linked to {string}")
    public void theUserAttemptsToSignUpUsingFacebookAccount(String email) {
        signUpUsingFacebook(email);
    }

    @Then("the user is successfully signed up using Facebook account")
    public void theUserIsSuccessfullySignedUpUsingFacebookAccount() {
        verifySuccessfulSignup();
    }

    @When("the user attempts to sign in using Facebook account linked to {string}")
    public void theUserAttemptsToSignInUsingFacebookAccount(String email) {
        signInUsingFacebook(email);
    }

    @Then("the user is successfully signed in using Facebook account")
    public void theUserIsSuccessfullySignedInUsingFacebookAccount() {
        verifySuccessfulSignin();
    }

    @Given("the user is signed in")
    public void theUserIsSignedIn() {
        verifyUserIsSignedIn();
    }

    @When("the user navigates to the user profile")
    public void theUserNavigatesToTheUserProfile() {
        navigateToUserProfile();
    }

    @Then("the user profile correctly displays account information")
    public void theUserProfileCorrectlyDisplaysAccountInformation() {
        verifyUserProfileInformation();
    }

    @Given("the user has signed up")
    public void theUserHasSignedUp() {
        verifyUserHasSignedUp();
    }

    @When("the user checks their email or messages")
    public void theUserChecksTheirEmailOrMessages() {
        checkUserEmailOrMessages();
    }

    @Then("a welcome email or message is received upon signup")
    public void aWelcomeEmailOrMessageIsReceivedUponSignup() {
        verifyWelcomeEmailOrMessage();
    }

    @When("the user attempts to sign in using incorrect credentials")
    public void theUserAttemptsToSignInUsingIncorrectCredentials() {
        signInUsingIncorrectCredentials();
    }

    @Then("sign-in fails and an error message is displayed")
    public void signInFailsAndAnErrorMessageIsDisplayed() {
        verifySignInErrorMessage();
    }

    @When("the user examines the security measures")
    public void theUserExaminesTheSecurityMeasures() {
        examineSecurityMeasures();
    }

    @Then("security measures such as CAPTCHA are in place")
    public void securityMeasuresSuchAsCAPTCHAareInPlace() {
        verifySecurityMeasures();
    }

    @Given("the user is signing up or signing in")
    public void theUserIsSigningUpOrSigningIn() {
        verifyUserIsSigningUpOrSigningIn();
    }

    @When("the user checks the browser console")
    public void theUserChecksTheBrowserConsole() {
        checkBrowserConsole();
    }

    @Then("no errors are logged in the console")
    public void noErrorsAreLoggedInTheConsole() {
        verifyNoConsoleErrors();
    }

    @When("the user attempts to sign up with an already registered email {string}")
    public void theUserAttemptsToSignUpWithAnAlreadyRegisteredEmail(String email) {
        signUpWithRegisteredEmail(email);
    }

    @Then("an error message indicates the email is already registered")
    public void anErrorMessageIndicatesTheEmailIsAlreadyRegistered() {
        verifyEmailAlreadyRegisteredError();
    }

    @When("the user checks for options to reset password if forgotten")
    public void theUserChecksForOptionsToResetPasswordIfForgotten() {
        checkPasswordResetOptions();
    }

    @Then("a password reset option is available")
    public void aPasswordResetOptionIsAvailable() {
        verifyPasswordResetOption();
    }

    @When("the user attempts to log out")
    public void theUserAttemptsToLogOut() {
        logOutUser();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyUserIsLoggedOut();
    }
}