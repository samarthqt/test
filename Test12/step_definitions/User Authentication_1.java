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
        enterEmailAndPassword();
    }

    @When("the user submits the sign-up form")
    public void theUserSubmitsTheSignUpForm() {
        submitSignUpForm();
    }

    @Then("the system sends a confirmation email")
    public void theSystemSendsAConfirmationEmail() {
        verifyConfirmationEmailSent();
    }

    @Then("the user receives a successful sign-up message")
    public void theUserReceivesASuccessfulSignUpMessage() {
        verifySuccessfulSignUpMessage();
    }

    @When("the user chooses to sign up with Google")
    public void theUserChoosesToSignUpWithGoogle() {
        chooseGoogleSignUp();
    }

    @When("the user provides valid Google credentials")
    public void theUserProvidesValidGoogleCredentials() {
        enterGoogleCredentials();
    }

    @When("the user chooses to sign up with Facebook")
    public void theUserChoosesToSignUpWithFacebook() {
        chooseFacebookSignUp();
    }

    @When("the user provides valid Facebook credentials")
    public void theUserProvidesValidFacebookCredentials() {
        enterFacebookCredentials();
    }

    @Given("the user is on the sign-in page")
    public void theUserIsOnTheSignInPage() {
        navigateToSignInPage();
    }

    @When("the user enters valid email and password")
    public void theUserEntersValidEmailAndPassword() {
        enterEmailAndPassword();
    }

    @When("the user submits the sign-in form")
    public void theUserSubmitsTheSignInForm() {
        submitSignInForm();
    }

    @Then("the user is successfully signed in")
    public void theUserIsSuccessfullySignedIn() {
        verifySuccessfulSignIn();
    }

    @When("the user chooses to sign in with Google")
    public void theUserChoosesToSignInWithGoogle() {
        chooseGoogleSignIn();
    }

    @When("the user provides valid Google credentials")
    public void theUserProvidesValidGoogleCredentials() {
        enterGoogleCredentials();
    }

    @When("the user chooses to sign in with Facebook")
    public void theUserChoosesToSignInWithFacebook() {
        chooseFacebookSignIn();
    }

    @When("the user provides valid Facebook credentials")
    public void theUserProvidesValidFacebookCredentials() {
        enterFacebookCredentials();
    }

    @When("the user enters invalid email or password")
    public void theUserEntersInvalidEmailOrPassword() {
        enterInvalidEmailOrPassword();
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Given("the user is on the password recovery page")
    public void theUserIsOnThePasswordRecoveryPage() {
        navigateToPasswordRecoveryPage();
    }

    @When("the user enters a valid email")
    public void theUserEntersAValidEmail() {
        enterRecoveryEmail();
    }

    @When("the user submits the password recovery form")
    public void theUserSubmitsThePasswordRecoveryForm() {
        submitPasswordRecoveryForm();
    }

    @Then("the system sends a password recovery email")
    public void theSystemSendsAPasswordRecoveryEmail() {
        verifyPasswordRecoveryEmailSent();
    }

    @Then("the user can reset the password securely")
    public void theUserCanResetThePasswordSecurely() {
        verifyPasswordResetSecurely();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the change password page")
    public void theUserNavigatesToTheChangePasswordPage() {
        navigateToChangePasswordPage();
    }

    @When("the user enters the current password and new password")
    public void theUserEntersTheCurrentPasswordAndNewPassword() {
        enterCurrentAndNewPassword();
    }

    @When("the user submits the change password form")
    public void theUserSubmitsTheChangePasswordForm() {
        submitChangePasswordForm();
    }

    @Then("the password is changed successfully")
    public void thePasswordIsChangedSuccessfully() {
        verifyPasswordChangedSuccessfully();
    }

    @When("the user navigates to the two-factor authentication setup page")
    public void theUserNavigatesToTheTwoFactorAuthenticationSetupPage() {
        navigateToTwoFactorSetupPage();
    }

    @When("the user completes the setup process")
    public void theUserCompletesTheSetupProcess() {
        completeTwoFactorSetup();
    }

    @Then("two-factor authentication is enabled for the user")
    public void twoFactorAuthenticationIsEnabledForTheUser() {
        verifyTwoFactorEnabled();
    }

    @Given("the user attempts to sign in")
    public void theUserAttemptsToSignIn() {
        attemptSignIn();
    }

    @Then("the system logs the authentication attempt")
    public void theSystemLogsTheAuthenticationAttempt() {
        verifyAuthenticationLogged();
    }

    @Given("the user is on the authentication page")
    public void theUserIsOnTheAuthenticationPage() {
        navigateToAuthenticationPage();
    }

    @Then("the authentication process complies with industry security standards")
    public void theAuthenticationProcessCompliesWithIndustrySecurityStandards() {
        verifySecurityStandardsCompliance();
    }

    @Then("the user interface guides the user through the authentication process intuitively")
    public void theUserInterfaceGuidesTheUserThroughTheAuthenticationProcessIntuitively() {
        verifyIntuitiveUserInterface();
    }
}