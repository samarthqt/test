package com.cucumber.steps;

import com.page_objects.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSteps extends SignUpPage {

    @Given("the user accesses the application")
    public void theUserAccessesTheApplication() {
        launchApplication();
    }

    @When("the user navigates to the sign-up page")
    public void theUserNavigatesToTheSignUpPage() {
        navigateToSignUpPage();
    }

    @Then("the sign-up page is displayed")
    public void theSignUpPageIsDisplayed() {
        verifySignUpPageDisplayed();
    }

    @Given("the user is on the sign-up page")
    public void theUserIsOnTheSignUpPage() {
        navigateToSignUpPage();
    }

    @When("the user enters a valid email {string} and password {string}")
    public void theUserEntersAValidEmailAndPassword(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    @When("submits the sign-up form")
    public void submitsTheSignUpForm() {
        submitSignUpForm();
    }

    @Then("the sign-up form is submitted successfully")
    public void theSignUpFormIsSubmittedSuccessfully() {
        verifySignUpSuccess();
    }

    @Then("email confirmation is sent")
    public void emailConfirmationIsSent() {
        verifyEmailConfirmationSent();
    }

    @When("the user attempts to sign up using a Google account {string}")
    public void theUserAttemptsToSignUpUsingAGoogleAccount(String googleEmail) {
        signUpWithGoogle(googleEmail);
    }

    @When("authorizes Google account access")
    public void authorizesGoogleAccountAccess() {
        authorizeGoogleAccess();
    }

    @Then("the Google sign-up process is completed successfully")
    public void theGoogleSignUpProcessIsCompletedSuccessfully() {
        verifyGoogleSignUpSuccess();
    }

    @When("the user attempts to sign up using a Facebook account {string}")
    public void theUserAttemptsToSignUpUsingAFacebookAccount(String facebookEmail) {
        signUpWithFacebook(facebookEmail);
    }

    @When("authorizes Facebook account access")
    public void authorizesFacebookAccountAccess() {
        authorizeFacebookAccess();
    }

    @Then("the Facebook sign-up process is completed successfully")
    public void theFacebookSignUpProcessIsCompletedSuccessfully() {
        verifyFacebookSignUpSuccess();
    }

    @Given("the user has signed up successfully")
    public void theUserHasSignedUpSuccessfully() {
        verifySignUpSuccess();
    }

    @When("the user attempts to log in")
    public void theUserAttemptsToLogIn() {
        attemptLogin();
    }

    @Then("the user is able to log in successfully")
    public void theUserIsAbleToLogInSuccessfully() {
        verifyLoginSuccess();
    }

    @Given("the user has an existing account")
    public void theUserHasAnExistingAccount() {
        verifyExistingAccount();
    }

    @When("the user attempts to sign up with the same email")
    public void theUserAttemptsToSignUpWithTheSameEmail() {
        attemptDuplicateSignUp();
    }

    @Then("the system prevents the creation of duplicate accounts")
    public void theSystemPreventsTheCreationOfDuplicateAccounts() {
        verifyDuplicateAccountPrevention();
    }

    @When("the user enters an invalid email format")
    public void theUserEntersAnInvalidEmailFormat() {
        enterInvalidEmailFormat();
    }

    @Then("the system alerts the user to the invalid email format")
    public void theSystemAlertsTheUserToTheInvalidEmailFormat() {
        verifyInvalidEmailAlert();
    }

    @When("the user completes the sign-up process")
    public void theUserCompletesTheSignUpProcess() {
        completeSignUpProcess();
    }

    @Then("the system logs sign-up actions accurately")
    public void theSystemLogsSignUpActionsAccurately() {
        verifySignUpLogging();
    }

    @When("the user checks the account status")
    public void theUserChecksTheAccountStatus() {
        checkAccountStatus();
    }

    @Then("the account status is active and accessible")
    public void theAccountStatusIsActiveAndAccessible() {
        verifyAccountStatusActive();
    }
}