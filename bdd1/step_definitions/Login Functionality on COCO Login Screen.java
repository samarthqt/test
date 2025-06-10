package com.cucumber.steps;

import com.pageobjects.CocoLoginPage;
import com.pageobjects.SsoLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunctionalitySteps extends CocoLoginPage {

    @Given("I am on the COCO login screen")
    public void iAmOnTheCOCOLoginScreen() {
        navigateToCocoLoginScreen();
    }

    @Then("I should see a button labeled \"Login with SSO\"")
    public void iShouldSeeButtonLabeledLoginWithSSO() {
        verifyLoginWithSSOButtonVisible();
    }

    @When("I click on the \"Login with SSO\" button")
    public void iClickOnTheLoginWithSSOButton() {
        clickLoginWithSSOButton();
    }

    @Then("I should be redirected to the SSO login page")
    public void iShouldBeRedirectedToTheSSOLoginPage() {
        verifyRedirectionToSSOLoginPage();
    }

    @Given("I am on the SSO login page")
    public void iAmOnTheSSOLoginPage() {
        navigateToSSOLoginPage();
    }

    @When("I enter valid SSO credentials")
    public void iEnterValidSSOCredentials() {
        enterSSOCredentials("validUsername", "validPassword");
    }

    @When("I submit the SSO login form")
    public void iSubmitTheSSOLoginForm() {
        submitSSOLoginForm();
    }

    @Then("I should be logged into the COCO application")
    public void iShouldBeLoggedIntoTheCOCOApplication() {
        verifySuccessfulLoginToCocoApplication();
    }

    @When("I enter invalid SSO credentials")
    public void iEnterInvalidSSOCredentials() {
        enterSSOCredentials("invalidUsername", "invalidPassword");
    }

    @Then("I should see an error message indicating invalid credentials")
    public void iShouldSeeAnErrorMessageIndicatingInvalidCredentials() {
        verifyInvalidCredentialsErrorMessage();
    }

    @When("I choose to cancel the login process")
    public void iChooseToCancelTheLoginProcess() {
        cancelSSOLoginProcess();
    }

    @Then("I should be redirected back to the COCO login screen")
    public void iShouldBeRedirectedBackToTheCOCOLoginScreen() {
        verifyRedirectionToCocoLoginScreen();
    }
}