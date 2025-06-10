package com.cucumber.steps;

import com.page_objects.SignUpSignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSignInSteps extends SignUpSignInPage {

    @Given("the user is on the sign-up page")
    public void theUserIsOnTheSignUpPage() {
        navigateToSignUpPage();
    }

    @Given("the user is on the sign-in page")
    public void theUserIsOnTheSignInPage() {
        navigateToSignInPage();
    }

    @Given("the user has an existing account")
    public void theUserHasAnExistingAccount() {
        verifyExistingAccount();
    }

    @When("the user enters a valid email address and password")
    public void theUserEntersAValidEmailAddressAndPassword() {
        enterEmail(testHarness.getData("SignUpData", "Email"));
        enterPassword(testHarness.getData("SignUpData", "Password"));
    }

    @When("the user enters a valid email and password")
    public void theUserEntersAValidEmailAndPassword() {
        enterEmail(testHarness.getData("SignInData", "Email"));
        enterPassword(testHarness.getData("SignInData", "Password"));
    }

    @When("the user submits the form")
    public void theUserSubmitsTheForm() {
        submitForm();
    }

    @When("the user chooses to sign up with Google")
    public void theUserChoosesToSignUpWithGoogle() {
        signUpWithGoogle();
    }

    @When("the user chooses to sign up with Facebook")
    public void theUserChoosesToSignUpWithFacebook() {
        signUpWithFacebook();
    }

    @When("the user chooses to sign in with Google")
    public void theUserChoosesToSignInWithGoogle() {
        signInWithGoogle();
    }

    @When("the user chooses to sign in with Facebook")
    public void theUserChoosesToSignInWithFacebook() {
        signInWithFacebook();
    }

    @When("the user enters an invalid email or password")
    public void theUserEntersAnInvalidEmailOrPassword() {
        enterEmail(testHarness.getData("InvalidSignInData", "Email"));
        enterPassword(testHarness.getData("InvalidSignInData", "Password"));
    }

    @When("the user clicks on \"Forgot Password\"")
    public void theUserClicksOnForgotPassword() {
        clickForgotPassword();
    }

    @When("the user enters a valid email address")
    public void theUserEntersAValidEmailAddress() {
        enterEmail(testHarness.getData("RecoveryData", "Email"));
    }

    @Then("the system should create a new account")
    public void theSystemShouldCreateANewAccount() {
        verifyAccountCreation();
    }

    @Then("the system should validate the email address")
    public void theSystemShouldValidateTheEmailAddress() {
        verifyEmailValidation();
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
        verifyUserLoggedIn();
    }

    @Then("the system should authenticate using Google credentials")
    public void theSystemShouldAuthenticateUsingGoogleCredentials() {
        verifyGoogleAuthentication();
    }

    @Then("the system should authenticate using Facebook credentials")
    public void theSystemShouldAuthenticateUsingFacebookCredentials() {
        verifyFacebookAuthentication();
    }

    @Then("the system should display an error message")
    public void theSystemShouldDisplayAnErrorMessage() {
        verifyErrorMessage();
    }

    @Then("the system should send a password recovery email")
    public void theSystemShouldSendAPasswordRecoveryEmail() {
        verifyPasswordRecoveryEmail();
    }

    @Then("the system should log the authentication activity for security purposes")
    public void theSystemShouldLogTheAuthenticationActivityForSecurityPurposes() {
        verifyAuthenticationLogging();
    }

    @Then("the system should ensure compliance with GDPR for data protection")
    public void theSystemShouldEnsureComplianceWithGDPRForDataProtection() {
        verifyGDPRCompliance();
    }
}