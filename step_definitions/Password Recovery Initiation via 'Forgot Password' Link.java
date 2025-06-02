package com.cucumber.steps;

import com.page_objects.ForgotPasswordPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordRecoverySteps extends ForgotPasswordPage {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        navigateToLoginPage();
    }

    @When("the user clicks on the 'Forgot Password' link")
    public void theUserClicksOnTheForgotPasswordLink() {
        clickForgotPasswordLink();
    }

    @Then("the 'Forgot Password' page is displayed")
    public void theForgotPasswordPageIsDisplayed() {
        verifyForgotPasswordPageDisplayed();
    }

    @Given("the user is on the 'Forgot Password' page")
    public void theUserIsOnTheForgotPasswordPage() {
        verifyForgotPasswordPageDisplayed();
    }

    @When("the user enters the registered email address \"user@example.com\"")
    public void theUserEntersTheRegisteredEmailAddress() {
        enterRegisteredEmailAddress("user@example.com");
    }

    @Then("the email address is accepted")
    public void theEmailAddressIsAccepted() {
        verifyEmailAddressAccepted();
    }

    @Given("the user has entered a registered email address")
    public void theUserHasEnteredARegisteredEmailAddress() {
        verifyEmailAddressAccepted();
    }

    @When("the user submits the password recovery request")
    public void theUserSubmitsThePasswordRecoveryRequest() {
        submitPasswordRecoveryRequest();
    }

    @Then("a confirmation message for password recovery is displayed")
    public void aConfirmationMessageForPasswordRecoveryIsDisplayed() {
        verifyPasswordRecoveryConfirmationMessage();
    }

    @Given("the user has submitted a password recovery request")
    public void theUserHasSubmittedAPasswordRecoveryRequest() {
        verifyPasswordRecoveryConfirmationMessage();
    }

    @When("the user checks the registered email inbox")
    public void theUserChecksTheRegisteredEmailInbox() {
        checkEmailInboxForRecoveryEmail();
    }

    @Then("the password recovery email is received")
    public void thePasswordRecoveryEmailIsReceived() {
        verifyRecoveryEmailReceived();
    }

    @Given("the password recovery email is received")
    public void thePasswordRecoveryEmailIsReceivedAgain() {
        verifyRecoveryEmailReceived();
    }

    @When("the user opens the email")
    public void theUserOpensTheEmail() {
        openRecoveryEmail();
    }

    @Then("the email contains a secure recovery link")
    public void theEmailContainsASecureRecoveryLink() {
        verifySecureRecoveryLinkInEmail();
    }

    @Given("the user has a secure recovery link from the email")
    public void theUserHasASecureRecoveryLinkFromTheEmail() {
        verifySecureRecoveryLinkInEmail();
    }

    @When("the user attempts to use the recovery link")
    public void theUserAttemptsToUseTheRecoveryLink() {
        useRecoveryLink();
    }

    @Then("the recovery link leads to the password reset page")
    public void theRecoveryLinkLeadsToThePasswordResetPage() {
        verifyPasswordResetPage();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user logs out of any active sessions")
    public void theUserLogsOutOfAnyActiveSessions() {
        logoutActiveSessions();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }
}