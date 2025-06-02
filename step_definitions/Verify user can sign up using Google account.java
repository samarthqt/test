package com.cucumber.steps;

import com.page_objects.GoogleSignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSignUpSteps extends GoogleSignUpPage {

    @Given("the user has access to the internet")
    public void theUserHasAccessToTheInternet() {
        verifyInternetAccess();
    }

    @Given("the application URL {string} is accessible")
    public void theApplicationURLIsAccessible(String url) {
        verifyUrlAccessibility(url);
    }

    @Given("Google sign-up integration is enabled")
    public void googleSignUpIntegrationIsEnabled() {
        verifyGoogleIntegrationEnabled();
    }

    @When("the user navigates to the application URL")
    public void theUserNavigatesToTheApplicationURL() {
        navigateToApplicationUrl();
    }

    @Then("the application homepage is displayed")
    public void theApplicationHomepageIsDisplayed() {
        verifyHomepageDisplayed();
    }

    @When("the user clicks on the 'Sign Up' button")
    public void theUserClicksOnTheSignUpButton() {
        clickSignUpButton();
    }

    @Then("sign-up options are displayed")
    public void signUpOptionsAreDisplayed() {
        verifySignUpOptionsDisplayed();
    }

    @When("the user selects 'Sign up with Google'")
    public void theUserSelectsSignUpWithGoogle() {
        selectGoogleSignUpOption();
    }

    @Then("the Google login page is displayed")
    public void theGoogleLoginPageIsDisplayed() {
        verifyGoogleLoginPageDisplayed();
    }

    @When("the user enters Google account email {string} and password {string}")
    public void theUserEntersGoogleAccountEmailAndPassword(String email, String password) {
        enterGoogleCredentials(email, password);
    }

    @Then("the credentials are accepted")
    public void theCredentialsAreAccepted() {
        verifyCredentialsAccepted();
    }

    @When("the user clicks on 'Next' to proceed")
    public void theUserClicksOnNextToProceed() {
        clickNextButton();
    }

    @Then("the Google account permissions page is displayed")
    public void theGoogleAccountPermissionsPageIsDisplayed() {
        verifyPermissionsPageDisplayed();
    }

    @When("the user grants necessary permissions to the application")
    public void theUserGrantsNecessaryPermissionsToTheApplication() {
        grantPermissions();
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
        verifyDashboardDisplayed();
    }

    @When("the user verifies their profile information")
    public void theUserVerifiesTheirProfileInformation() {
        verifyProfileInformation();
    }

    @Then("the profile information matches Google account details")
    public void theProfileInformationMatchesGoogleAccountDetails() {
        verifyProfileMatchesGoogleDetails();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @When("the user attempts to log in again using the same Google account")
    public void theUserAttemptsToLogInAgainUsingTheSameGoogleAccount() {
        loginUsingGoogleAccount();
    }

    @Then("the user is logged in successfully using Google")
    public void theUserIsLoggedInSuccessfullyUsingGoogle() {
        verifyLoginSuccess();
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
        verifyEmailConfirmationReceived();
    }

    @Then("email confirmation is received")
    public void emailConfirmationIsReceived() {
        verifyEmailConfirmation();
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