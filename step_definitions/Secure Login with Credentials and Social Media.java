package com.cucumber.steps;

import com.page_objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SecureLoginSteps extends LoginPage {

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        navigateToLoginPage();
    }

    @When("the user enters valid username {string} and password {string}")
    public void theUserEntersValidUsernameAndPassword(String username, String password) {
        enterUserName(username);
        enterPassword(password);
    }

    @When("clicks on the 'Login' button")
    public void clicksOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("the user is successfully logged in and redirected to the dashboard")
    public void theUserIsSuccessfullyLoggedInAndRedirectedToTheDashboard() {
        verifyDashboardRedirection();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user logs out of the account")
    public void theUserLogsOutOfTheAccount() {
        clickLogoutButton();
    }

    @Then("the user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage() {
        verifyLoginPageRedirection();
    }

    @When("the user selects 'Login with Facebook'")
    public void theUserSelectsLoginWithFacebook() {
        clickLoginWithFacebook();
    }

    @Then("the Facebook login page is displayed")
    public void theFacebookLoginPageIsDisplayed() {
        verifyFacebookLoginPageDisplayed();
    }

    @When("the user enters Facebook credentials and logs in")
    public void theUserEntersFacebookCredentialsAndLogsIn() {
        enterFacebookCredentialsAndLogin();
    }

    @Then("the user is successfully logged in through Facebook and redirected to the dashboard")
    public void theUserIsSuccessfullyLoggedInThroughFacebookAndRedirectedToTheDashboard() {
        verifyDashboardRedirection();
    }

    @Given("the user is logged in through Facebook")
    public void theUserIsLoggedInThroughFacebook() {
        verifyUserLoggedInThroughFacebook();
    }

    @When("the user selects 'Login with Google'")
    public void theUserSelectsLoginWithGoogle() {
        clickLoginWithGoogle();
    }

    @Then("the Google login page is displayed")
    public void theGoogleLoginPageIsDisplayed() {
        verifyGoogleLoginPageDisplayed();
    }

    @When("the user enters Google credentials and logs in")
    public void theUserEntersGoogleCredentialsAndLogsIn() {
        enterGoogleCredentialsAndLogin();
    }

    @Then("the user is successfully logged in through Google and redirected to the dashboard")
    public void theUserIsSuccessfullyLoggedInThroughGoogleAndRedirectedToTheDashboard() {
        verifyDashboardRedirection();
    }

    @When("the user attempts to log in")
    public void theUserAttemptsToLogIn() {
        attemptLogin();
    }

    @Then("CAPTCHA is displayed and required for login")
    public void captchaIsDisplayedAndRequiredForLogin() {
        verifyCaptchaDisplayed();
    }

    @Then("no security warnings or alerts are displayed")
    public void noSecurityWarningsOrAlertsAreDisplayed() {
        verifyNoSecurityWarnings();
    }

    @Given("the user navigates to the login page from a new device")
    public void theUserNavigatesToTheLoginPageFromANewDevice() {
        navigateToLoginPageFromNewDevice();
    }

    @Then("verification via email or phone is required")
    public void verificationViaEmailOrPhoneIsRequired() {
        verifyEmailOrPhoneVerificationRequired();
    }

    @When("the user is inactive for a period")
    public void theUserIsInactiveForAPeriod() {
        simulateUserInactivity();
    }

    @Then("the session times out and requires re-login")
    public void theSessionTimesOutAndRequiresReLogin() {
        verifySessionTimeout();
    }

    @Then("all login pages and redirects are secured with HTTPS")
    public void allLoginPagesAndRedirectsAreSecuredWithHTTPS() {
        verifyHttpsRedirection();
    }

    @Given("the system is under maintenance")
    public void theSystemIsUnderMaintenance() {
        simulateSystemMaintenance();
    }

    @Then("the user receives a maintenance notification and cannot log in")
    public void theUserReceivesAMaintenanceNotificationAndCannotLogIn() {
        verifyMaintenanceNotification();
    }
}