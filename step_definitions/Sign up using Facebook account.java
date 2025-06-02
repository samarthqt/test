package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SignUpPage;

public class SignUpSteps extends SignUpPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the application URL")
    public void theUserNavigatesToTheApplicationURL() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the application homepage is displayed")
    public void theApplicationHomepageIsDisplayed() {
        verifyHomePageDisplayed();
    }

    @When("the user clicks on the 'Sign Up' button")
    public void theUserClicksOnTheSignUpButton() {
        clickSignUpButton();
    }

    @Then("sign-up options are displayed")
    public void signUpOptionsAreDisplayed() {
        verifySignUpOptionsDisplayed();
    }

    @When("the user selects 'Sign up with Facebook'")
    public void theUserSelectsSignUpWithFacebook() {
        selectSignUpWithFacebook();
    }

    @Then("the Facebook login page is displayed")
    public void theFacebookLoginPageIsDisplayed() {
        verifyFacebookLoginPageDisplayed();
    }

    @When("the user enters Facebook account email {string} and password {string}")
    public void theUserEntersFacebookAccountEmailAndPassword(String email, String password) {
        enterFacebookCredentials(email, password);
    }

    @Then("credentials are accepted")
    public void credentialsAreAccepted() {
        verifyCredentialsAccepted();
    }

    @When("the user clicks on 'Login' to proceed")
    public void theUserClicksOnLoginToProceed() {
        clickFacebookLogin();
    }

    @Then("the Facebook account permissions page is displayed")
    public void theFacebookAccountPermissionsPageIsDisplayed() {
        verifyFacebookPermissionsPageDisplayed();
    }

    @When("the user grants necessary permissions to the application")
    public void theUserGrantsNecessaryPermissionsToTheApplication() {
        grantFacebookPermissions();
    }

    @Then("permissions are granted")
    public void permissionsAreGranted() {
        verifyPermissionsGranted();
    }

    @When("the user confirms the sign-up process")
    public void theUserConfirmsTheSignUpProcess() {
        confirmSignUpProcess();
    }

    @Then("a sign-up confirmation message is displayed")
    public void aSignUpConfirmationMessageIsDisplayed() {
        verifySignUpConfirmationMessage();
    }

    @When("the user is redirected to the application dashboard")
    public void theUserIsRedirectedToTheApplicationDashboard() {
        verifyRedirectionToDashboard();
    }

    @Then("the user dashboard is displayed")
    public void theUserDashboardIsDisplayed() {
        verifyUserDashboardDisplayed();
    }

    @When("the user verifies profile information retrieved from Facebook")
    public void theUserVerifiesProfileInformationRetrievedFromFacebook() {
        verifyProfileInformation();
    }

    @Then("profile information matches Facebook account details")
    public void profileInformationMatchesFacebookAccountDetails() {
        verifyProfileInformationMatches();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @When("the user attempts to log in again using the same Facebook account")
    public void theUserAttemptsToLogInAgainUsingTheSameFacebookAccount() {
        loginWithFacebookAgain();
    }

    @Then("the user is logged in successfully using Facebook")
    public void theUserIsLoggedInSuccessfullyUsingFacebook() {
        verifyFacebookLoginSuccess();
    }

    @When("the user checks for any error messages or alerts during the sign-up process")
    public void theUserChecksForAnyErrorMessagesOrAlertsDuringTheSignUpProcess() {
        checkForErrorsOrAlerts();
    }

    @Then("no errors or alerts are displayed")
    public void noErrorsOrAlertsAreDisplayed() {
        verifyNoErrorsOrAlerts();
    }

    @When("the user verifies email confirmation received from the application")
    public void theUserVerifiesEmailConfirmationReceivedFromTheApplication() {
        verifyEmailConfirmation();
    }

    @Then("email confirmation is received")
    public void emailConfirmationIsReceived() {
        verifyEmailConfirmationReceived();
    }

    @When("the user confirms that the sign-up process adheres to privacy policies")
    public void theUserConfirmsThatTheSignUpProcessAdheresToPrivacyPolicies() {
        confirmPrivacyPoliciesAdherence();
    }

    @Then("privacy policies are adhered to")
    public void privacyPoliciesAreAdheredTo() {
        verifyPrivacyPoliciesAdherence();
    }

    @When("the user ensures that application terms and conditions are accepted during sign-up")
    public void theUserEnsuresThatApplicationTermsAndConditionsAreAcceptedDuringSignUp() {
        ensureTermsAndConditionsAccepted();
    }

    @Then("terms and conditions are accepted")
    public void termsAndConditionsAreAccepted() {
        verifyTermsAndConditionsAccepted();
    }
}