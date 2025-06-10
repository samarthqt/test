package com.cucumber.steps;

import com.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.framework.cucumber.TestHarness;

public class LoginSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the CoCo URL is accessible")
    public void theCoCoURLIsAccessible() {
        verifyUrlAccessibility();
    }

    @When("I launch the CoCo URL in a web browser")
    public void iLaunchTheCoCoURLInAWebBrowser() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the CoCo login page is displayed")
    public void theCoCoLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
    }

    @Then("the \"Login with SSO\" button is displayed on the login screen")
    public void theLoginWithSSOButtonIsDisplayedOnTheLoginScreen() {
        verifySSOButtonDisplayed();
    }

    @Given("the \"Login with SSO\" button is displayed on the login screen")
    public void theLoginWithSSOButtonIsDisplayedOnTheLoginScreenGiven() {
        verifySSOButtonDisplayed();
    }

    @When("I click on the \"Login with SSO\" button")
    public void iClickOnTheLoginWithSSOButton() {
        clickSSOButton();
    }

    @Then("I am redirected to the SSO login page")
    public void iAmRedirectedToTheSSOLoginPage() {
        verifySSOLoginPageRedirection();
    }

    @When("I enter valid SSO credentials")
    public void iEnterValidSSOCredentials() {
        String ssoUsername = testHarness.getData("SSOData", "Username");
        String ssoPassword = testHarness.getData("SSOData", "Password");
        enterSSOUsername(ssoUsername);
        enterSSOPassword(ssoPassword);
    }

    @When("I submit the SSO login form")
    public void iSubmitTheSSOLoginForm() {
        submitSSOLoginForm();
    }

    @Then("I am redirected to the homepage")
    public void iAmRedirectedToTheHomepage() {
        verifyHomePageRedirection();
    }

    @Then("the homepage is displayed with user-specific content")
    public void theHomepageIsDisplayedWithUserSpecificContent() {
        verifyUserSpecificContent();
    }

    @When("I enter invalid SSO credentials")
    public void iEnterInvalidSSOCredentials() {
        String invalidSSOUsername = testHarness.getData("SSOData", "InvalidUsername");
        String invalidSSOPassword = testHarness.getData("SSOData", "InvalidPassword");
        enterSSOUsername(invalidSSOUsername);
        enterSSOPassword(invalidSSOPassword);
    }

    @Then("the login attempt fails")
    public void theLoginAttemptFails() {
        verifyLoginFailure();
    }

    @Then("an error message 'Invalid SSO credentials' is displayed")
    public void anErrorMessageInvalidSSOCredentialsIsDisplayed() {
        verifyErrorMessage("Invalid SSO credentials");
    }
}