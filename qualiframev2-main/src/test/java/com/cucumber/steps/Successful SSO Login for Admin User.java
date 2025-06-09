package com.cucumber.steps;

import com.pageobjects.SSOLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SSOLoginSteps extends SSOLoginPage {

    @Given("an Admin user account exists in the system")
    public void anAdminUserAccountExistsInTheSystem() {
        // Implementation to verify admin user account existence
    }

    @Given("SSO integration is configured and active")
    public void ssoIntegrationIsConfiguredAndActive() {
        // Implementation to verify SSO configuration
    }

    @When("the user navigates to the COCO login screen")
    public void theUserNavigatesToTheCOCOLoginScreen() {
        navigateToLoginScreen();
    }

    @Then("the login screen is displayed with all expected fields and buttons")
    public void theLoginScreenIsDisplayedWithAllExpectedFieldsAndButtons() {
        verifyLoginScreenElements();
    }

    @Then("the 'Login with SSO' button is visible on the login screen")
    public void theLoginWithSSOButtonIsVisibleOnTheLoginScreen() {
        verifySSOButtonVisibility();
    }

    @When("the user clicks on the 'Login with SSO' button")
    public void theUserClicksOnTheLoginWithSSOButton() {
        clickSSOButton();
    }

    @Then("the system redirects to the SSO authentication page")
    public void theSystemRedirectsToTheSSOAuthenticationPage() {
        verifySSORedirection();
    }

    @When("the user enters valid SSO credentials {string}, {string} and submits")
    public void theUserEntersValidSSOCredentialsAndSubmits(String username, String credentials) {
        enterSSOCredentials(username, credentials);
        submitSSOCredentials();
    }

    @Then("the credentials are accepted")
    public void theCredentialsAreAccepted() {
        verifyCredentialsAcceptance();
    }

    @Then("the user is redirected back to the application")
    public void theUserIsRedirectedBackToTheApplication() {
        verifyRedirectionToApplication();
    }

    @Then("the admin user is successfully logged into the system")
    public void theAdminUserIsSuccessfullyLoggedIntoTheSystem() {
        verifySuccessfulLogin();
    }

    @Then("the home screen is displayed, indicating successful login")
    public void theHomeScreenIsDisplayedIndicatingSuccessfulLogin() {
        verifyHomeScreenDisplay();
    }
}