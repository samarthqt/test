package com.cucumber.steps;

import com.page_objects.AuthenticationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationSteps extends AuthenticationPage {

    @Given("the user is on the sign-up page")
    public void theUserIsOnTheSignUpPage() {
        navigateToSignUpPage();
    }

    @When("the user enters a valid email and password")
    public void theUserEntersAValidEmailAndPassword() {
        enterEmail(testHarness.getData("SignUpData", "Email"));
        enterPassword(testHarness.getData("SignUpData", "Password"));
    }

    @When("clicks the sign-up button")
    public void clicksTheSignUpButton() {
        clickSignUpButton();
    }

    @Then("the user should be signed up successfully")
    public void theUserShouldBeSignedUpSuccessfully() {
        verifySignUpSuccess();
    }

    @Then("receive a notification for successful sign-up")
    public void receiveANotificationForSuccessfulSignUp() {
        verifySignUpNotification();
    }

    @When("the user chooses to sign up using Google")
    public void theUserChoosesToSignUpUsingGoogle() {
        clickGoogleSignUp();
    }

    @When("completes the Google authentication process")
    public void completesTheGoogleAuthenticationProcess() {
        completeGoogleAuthentication();
    }

    @When("the user chooses to sign up using Facebook")
    public void theUserChoosesToSignUpUsingFacebook() {
        clickFacebookSignUp();
    }

    @When("completes the Facebook authentication process")
    public void completesTheFacebookAuthenticationProcess() {
        completeFacebookAuthentication();
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        navigateToLoginPage();
    }

    @When("the user enters a valid email and password")
    public void theUserEntersAValidEmailAndPasswordForLogin() {
        enterEmail(testHarness.getData("LoginData", "Email"));
        enterPassword(testHarness.getData("LoginData", "Password"));
    }

    @When("clicks the login button")
    public void clicksTheLoginButton() {
        clickLoginButton();
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        verifyLoginSuccess();
    }

    @Then("receive a notification for successful login")
    public void receiveANotificationForSuccessfulLogin() {
        verifyLoginNotification();
    }

    @When("the user chooses to log in using Google")
    public void theUserChoosesToLogInUsingGoogle() {
        clickGoogleLogin();
    }

    @When("completes the Google authentication process")
    public void completesTheGoogleAuthenticationProcessForLogin() {
        completeGoogleAuthentication();
    }

    @When("the user chooses to log in using Facebook")
    public void theUserChoosesToLogInUsingFacebook() {
        clickFacebookLogin();
    }

    @When("completes the Facebook authentication process")
    public void completesTheFacebookAuthenticationProcessForLogin() {
        completeFacebookAuthentication();
    }

    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        enterEmail(testHarness.getData("InvalidLoginData", "Email"));
        enterPassword(testHarness.getData("InvalidLoginData", "Password"));
    }

    @Then("the user should see an authentication error message")
    public void theUserShouldSeeAnAuthenticationErrorMessage() {
        verifyAuthenticationError();
    }

    @When("the user enters their credentials")
    public void theUserEntersTheirCredentials() {
        enterEmail(testHarness.getData("LoginData", "Email"));
        enterPassword(testHarness.getData("LoginData", "Password"));
    }

    @Then("the application should ensure secure handling of the credentials")
    public void theApplicationShouldEnsureSecureHandlingOfTheCredentials() {
        verifySecureHandling();
    }

    @Given("the user attempts to log in")
    public void theUserAttemptsToLogIn() {
        navigateToLoginPage();
    }

    @Then("the system should log the authentication attempt")
    public void theSystemShouldLogTheAuthenticationAttempt() {
        verifyAuthenticationLogging();
    }

    @Given("the user has signed up")
    public void theUserHasSignedUp() {
        navigateToSignUpPage();
        enterEmail(testHarness.getData("SignUpData", "Email"));
        enterPassword(testHarness.getData("SignUpData", "Password"));
        clickSignUpButton();
        verifySignUpSuccess();
    }

    @Then("the application should comply with GDPR for user data privacy")
    public void theApplicationShouldComplyWithGDPRForUserDataPrivacy() {
        verifyGDPRCompliance();
    }

    @When("the user clicks on \"Forgot Password\"")
    public void theUserClicksOnForgotPassword() {
        clickForgotPassword();
    }

    @Then("the user should be able to initiate password recovery")
    public void theUserShouldBeAbleToInitiatePasswordRecovery() {
        verifyPasswordRecoveryInitiation();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        navigateToLoginPage();
        enterEmail(testHarness.getData("LoginData", "Email"));
        enterPassword(testHarness.getData("LoginData", "Password"));
        clickLoginButton();
        verifyLoginSuccess();
    }

    @When("the user opts to enable 2FA")
    public void theUserOptsToEnable2FA() {
        enableTwoFactorAuthentication();
    }

    @Then("the application should offer two-factor authentication for enhanced security")
    public void theApplicationShouldOfferTwoFactorAuthenticationForEnhancedSecurity() {
        verifyTwoFactorAuthentication();
    }
}