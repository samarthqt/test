package com.cucumber.steps;

import com.page_objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends LoginPage {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        launchLoginPage();
    }

    @When("the user enters valid email {string} and password {string}")
    public void theUserEntersValidEmailAndPassword(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    @When("clicks on the 'Login' button")
    public void clicksOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("the user is successfully logged in and redirected to the homepage")
    public void theUserIsSuccessfullyLoggedInAndRedirectedToTheHomepage() {
        verifyHomePageRedirection();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        clickLogoutButton();
    }

    @Then("the user is logged out and redirected to the login page")
    public void theUserIsLoggedOutAndRedirectedToTheLoginPage() {
        verifyLoginPageRedirection();
    }

    @When("the user clicks on the 'Login with Facebook' button")
    public void theUserClicksOnTheLoginWithFacebookButton() {
        clickLoginWithFacebookButton();
    }

    @When("enters valid Facebook credentials")
    public void entersValidFacebookCredentials() {
        enterFacebookCredentials();
    }

    @When("authorizes the application")
    public void authorizesTheApplication() {
        authorizeFacebookApplication();
    }

    @Then("the user is logged in via Facebook and redirected to the homepage")
    public void theUserIsLoggedInViaFacebookAndRedirectedToTheHomepage() {
        verifyHomePageRedirection();
    }

    @Given("the user is logged in via Facebook")
    public void theUserIsLoggedInViaFacebook() {
        verifyUserLoggedInViaFacebook();
    }

    @Then("the user profile information matches the data from the linked social media account")
    public void theUserProfileInformationMatchesTheDataFromTheLinkedSocialMediaAccount() {
        verifyFacebookProfileInformation();
    }

    @When("the user attempts to log in using Google account")
    public void theUserAttemptsToLogInUsingGoogleAccount() {
        clickLoginWithGoogleButton();
    }

    @Then("the user is redirected to Google login page and can log in successfully")
    public void theUserIsRedirectedToGoogleLoginPageAndCanLogInSuccessfully() {
        verifyGoogleLoginRedirection();
    }

    @When("the user enters incorrect email or password")
    public void theUserEntersIncorrectEmailOrPassword() {
        enterIncorrectEmailOrPassword();
    }

    @Then("an appropriate error message is displayed for incorrect login credentials")
    public void anAppropriateErrorMessageIsDisplayedForIncorrectLoginCredentials() {
        verifyErrorMessageForIncorrectCredentials();
    }

    @When("the user attempts to log in without entering any credentials")
    public void theUserAttemptsToLogInWithoutEnteringAnyCredentials() {
        attemptLoginWithoutCredentials();
    }

    @Then("the system prompts the user to enter credentials")
    public void theSystemPromptsTheUserToEnterCredentials() {
        verifyPromptForCredentials();
    }

    @Given("the user is accessing the login page on a mobile device")
    public void theUserIsAccessingTheLoginPageOnAMobileDevice() {
        accessLoginPageOnMobileDevice();
    }

    @Then("the login page is responsive and functions correctly on mobile devices")
    public void theLoginPageIsResponsiveAndFunctionsCorrectlyOnMobileDevices() {
        verifyMobileResponsiveness();
    }

    @Given("multiple users attempt to log in concurrently")
    public void multipleUsersAttemptToLogInConcurrently() {
        simulateConcurrentLoginAttempts();
    }

    @Then("the system handles multiple login attempts efficiently without downtime")
    public void theSystemHandlesMultipleLoginAttemptsEfficientlyWithoutDowntime() {
        verifyConcurrentLoginHandling();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        verifyUserLoggedOut();
    }

    @When("the user attempts to log in with Twitter account")
    public void theUserAttemptsToLogInWithTwitterAccount() {
        clickLoginWithTwitterButton();
    }

    @Then("the user can log in successfully using Twitter credentials")
    public void theUserCanLogInSuccessfullyUsingTwitterCredentials() {
        verifyTwitterLoginSuccess();
    }

    @When("the user remains inactive for a defined period")
    public void theUserRemainsInactiveForADefinedPeriod() {
        simulateUserInactivity();
    }

    @Then("the user session expires")
    public void theUserSessionExpires() {
        verifySessionTimeout();
    }

    @Then("the login page meets accessibility standards")
    public void theLoginPageMeetsAccessibilityStandards() {
        verifyAccessibilityCompliance();
    }
}