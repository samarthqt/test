package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageobjects.SSOLoginPage;

public class SSOLoginSteps extends SSOLoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("an Admin user account exists in the system")
    public void anAdminUserAccountExistsInTheSystem() {
        // Assume the admin user account is pre-configured
    }

    @Given("SSO integration is configured and active")
    public void ssoIntegrationIsConfiguredAndActive() {
        // Assume SSO integration is pre-configured
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
        verifyCredentialsAccepted();
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