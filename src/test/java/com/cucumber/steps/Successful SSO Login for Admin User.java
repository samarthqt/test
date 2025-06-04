package com.cucumber.steps;

import com.page_objects.SSOLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SSOLoginSteps extends SSOLoginPage {

    @Given("an Admin user account exists in the system")
    public void adminUserAccountExists() {
        verifyAdminUserExists();
    }

    @Given("SSO integration is configured and active")
    public void ssoIntegrationConfigured() {
        verifySSOIntegrationActive();
    }

    @When("the user navigates to the COCO login screen")
    public void navigateToCOCOLoginScreen() {
        openCOCOLoginScreen();
    }

    @Then("the login screen is displayed with all expected fields and buttons")
    public void verifyLoginScreenDisplayed() {
        checkLoginScreenElements();
    }

    @Then("the 'Login with SSO' button is visible on the login screen")
    public void verifySSOButtonVisible() {
        checkSSOButtonVisibility();
    }

    @When("the user clicks on the 'Login with SSO' button")
    public void clickSSOButton() {
        clickLoginWithSSOButton();
    }

    @Then("the system redirects to the SSO authentication page")
    public void verifySSORedirection() {
        checkSSORedirection();
    }

    @When("the user enters valid SSO credentials {string}, {string} and submits")
    public void enterSSOCredentials(String username, String credentials) {
        inputSSOCredentials(username, credentials);
        submitSSOCredentials();
    }

    @Then("the credentials are accepted")
    public void verifyCredentialsAccepted() {
        checkCredentialsAcceptance();
    }

    @Then("the user is redirected back to the application")
    public void verifyRedirectionBackToApplication() {
        checkRedirectionBackToApp();
    }

    @Then("the admin user is successfully logged into the system")
    public void verifyAdminUserLoggedIn() {
        checkAdminUserLoginSuccess();
    }

    @Then("the home screen is displayed, indicating successful login")
    public void verifyHomeScreenDisplayed() {
        checkHomeScreenDisplay();
    }
}