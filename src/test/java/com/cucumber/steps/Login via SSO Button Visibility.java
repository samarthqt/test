package com.cucumber.steps;

import com.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginViaSSOSteps extends LoginPage {

    @Given("the CoCo URL is accessible")
    public void theCoCoURLIsAccessible() {
        verifyURLAccessibility();
    }

    @When("I launch the CoCo URL in a web browser")
    public void iLaunchTheCoCoURLInAWebBrowser() {
        launchCoCoURL();
    }

    @Then("the CoCo login page is displayed")
    public void theCoCoLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
    }

    @Then("the standard login option is visible")
    public void theStandardLoginOptionIsVisible() {
        verifyStandardLoginOptionVisible();
    }

    @When("I observe the login options available on the screen")
    public void iObserveTheLoginOptionsAvailableOnTheScreen() {
        observeLoginOptions();
    }

    @Then("the 'Login with SSO' button is displayed")
    public void theLoginWithSSOButtonIsDisplayed() {
        verifySSOButtonDisplayed();
    }

    @Given("the 'Login with SSO' button is displayed on the CoCo login screen")
    public void theLoginWithSSOButtonIsDisplayedOnTheCoCoLoginScreen() {
        verifySSOButtonDisplayed();
    }

    @When("I click on the 'Login with SSO' button")
    public void iClickOnTheLoginWithSSOButton() {
        clickSSOButton();
    }

    @Then("the SSO login process is initiated")
    public void theSSOLoginProcessIsInitiated() {
        verifySSOLoginInitiated();
    }

    @When("I enter valid SSO credentials")
    public void iEnterValidSSOCredentials() {
        enterSSOCredentials();
    }

    @When("I submit the SSO credentials")
    public void iSubmitTheSSOCredentials() {
        submitSSOCredentials();
    }

    @Then("the SSO credentials are accepted")
    public void theSSOCredentialsAreAccepted() {
        verifySSOCredentialsAccepted();
    }

    @Then("the user is successfully logged into CoCo")
    public void theUserIsSuccessfullyLoggedIntoCoCo() {
        verifyUserLoggedIn();
    }

    @Then("the user is redirected to the homepage after SSO login")
    public void theUserIsRedirectedToTheHomepageAfterSSOLogin() {
        verifyRedirectionToHomepage();
    }

    @Then("the user is on the CoCo homepage")
    public void theUserIsOnTheCoCoHomepage() {
        verifyUserOnHomepage();
    }
}