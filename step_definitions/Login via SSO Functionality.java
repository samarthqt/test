package com.cucumber.steps;

import com.page_objects.LoginSSOPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSSOSteps extends LoginSSOPage {

    @Given("I have access to the COCO application login screen")
    public void iHaveAccessToTheCOCOApplicationLoginScreen() {
        verifyAccessToLoginScreen();
    }

    @When("I navigate to the COCO login screen")
    public void iNavigateToTheCOCOLoginScreen() {
        navigateToLoginScreen();
    }

    @Then("the login screen should be displayed")
    public void theLoginScreenShouldBeDisplayed() {
        verifyLoginScreenDisplayed();
    }

    @Then("SSO integration should be configured")
    public void ssoIntegrationShouldBeConfigured() {
        verifySSOIntegrationConfigured();
    }

    @When("I click on the 'Login with SSO' button")
    public void iClickOnTheLoginWithSSOButton() {
        clickLoginWithSSOButton();
    }

    @Then("I should be redirected to the SSO login page")
    public void iShouldBeRedirectedToTheSSOLoginPage() {
        verifyRedirectionToSSOLoginPage();
    }

    @When("I enter valid SSO credentials")
    public void iEnterValidSSOCredentials() {
        enterSSOCredentials();
    }

    @Then("the credentials should be accepted")
    public void theCredentialsShouldBeAccepted() {
        verifyCredentialsAccepted();
    }

    @When("I submit the SSO login form")
    public void iSubmitTheSSOLoginForm() {
        submitSSOLoginForm();
    }

    @Then("I should be logged into the COCO application successfully")
    public void iShouldBeLoggedIntoTheCOCOApplicationSuccessfully() {
        verifySuccessfulLogin();
    }
}