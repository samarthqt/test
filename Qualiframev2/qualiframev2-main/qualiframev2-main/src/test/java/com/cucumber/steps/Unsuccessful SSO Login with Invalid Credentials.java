package com.cucumber.steps;

import com.pageobjects.SSOLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SSOLoginSteps extends SSOLoginPage {

    @Given("the admin user account exists in the system")
    public void theAdminUserAccountExistsInTheSystem() {
        verifyAdminUserExists();
    }

    @Given("I navigate to the COCO login screen")
    public void iNavigateToTheCOCOLoginScreen() {
        navigateToLoginScreen();
    }

    @Then("the login screen is displayed with all expected fields and buttons")
    public void theLoginScreenIsDisplayedWithAllExpectedFieldsAndButtons() {
        verifyLoginScreenElements();
    }

    @Given("the admin username is {string}")
    public void theAdminUsernameIs(String username) {
        setAdminUsername(username);
    }

    @Given("SSO integration is configured and active")
    public void ssoIntegrationIsConfiguredAndActive() {
        verifySSOIntegrationActive();
    }

    @When("I verify the presence of the 'Login with SSO' button on the login screen")
    public void iVerifyThePresenceOfTheLoginWithSSOButtonOnTheLoginScreen() {
        verifySSOButtonPresence();
    }

    @Then("the 'Login with SSO' button is visible on the login screen")
    public void theLoginWithSSOButtonIsVisibleOnTheLoginScreen() {
        assertSSOButtonVisible();
    }

    @Given("the admin SSO credentials are {string}")
    public void theAdminSSOCredentialsAre(String credentials) {
        setSSOCredentials(credentials);
    }

    @When("I click on the 'Login with SSO' button")
    public void iClickOnTheLoginWithSSOButton() {
        clickSSOButton();
    }

    @Then("the system redirects to the SSO authentication page")
    public void theSystemRedirectsToTheSSOAuthenticationPage() {
        verifySSORedirection();
    }

    @When("I enter invalid SSO credentials {string} and {string} and submit")
    public void iEnterInvalidSSOCredentialsAndSubmit(String username, String credentials) {
        enterInvalidSSOCredentials(username, credentials);
    }

    @Then("the system displays an error message indicating the credentials are invalid")
    public void theSystemDisplaysAnErrorMessageIndicatingTheCredentialsAreInvalid() {
        verifyInvalidCredentialsErrorMessage();
    }

    @Then("I verify that the admin user is not logged into the system")
    public void iVerifyThatTheAdminUserIsNotLoggedIntoTheSystem() {
        assertUserNotLoggedIn();
    }

    @Then("the login screen remains visible, and the user is not redirected to the home screen")
    public void theLoginScreenRemainsVisibleAndTheUserIsNotRedirectedToTheHomeScreen() {
        verifyLoginScreenRemainsVisible();
    }
}