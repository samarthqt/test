package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ForgotPasswordPage;

public class ForgotPasswordSteps extends ForgotPasswordPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a registered user has forgotten their password")
    public void aRegisteredUserHasForgottenTheirPassword() {
        navigateToForgotPasswordPage();
    }

    @When("the user chooses to recover their password via email")
    public void theUserChoosesToRecoverTheirPasswordViaEmail() {
        selectRecoveryOption("email");
    }

    @Then("the system should send a password recovery email to the user's registered email address")
    public void theSystemShouldSendAPasswordRecoveryEmail() {
        verifyRecoveryEmailSent();
    }

    @When("the user chooses to recover their password via SMS")
    public void theUserChoosesToRecoverTheirPasswordViaSMS() {
        selectRecoveryOption("sms");
    }

    @Then("the system should send a password recovery SMS to the user's registered phone number")
    public void theSystemShouldSendAPasswordRecoverySMS() {
        verifyRecoverySMSSent();
    }

    @Given("the user has initiated a password recovery request")
    public void theUserHasInitiatedAPasswordRecoveryRequest() {
        initiatePasswordRecovery();
    }

    @When("the system sends a secure token to the user")
    public void theSystemSendsASecureTokenToTheUser() {
        sendSecureToken();
    }

    @Then("the system should validate the user's identity using the secure token")
    public void theSystemShouldValidateTheUsersIdentityUsingTheSecureToken() {
        validateSecureToken();
    }

    @Given("the system has sent a secure token to the user")
    public void theSystemHasSentASecureTokenToTheUser() {
        sendSecureToken();
    }

    @When("the user attempts to use the token after its expiration time")
    public void theUserAttemptsToUseTheTokenAfterItsExpirationTime() {
        attemptToUseExpiredToken();
    }

    @Then("the system should display an error message for the expired token")
    public void theSystemShouldDisplayAnErrorMessageForTheExpiredToken() {
        verifyExpiredTokenErrorMessage();
    }

    @Given("the user has successfully reset their password")
    public void theUserHasSuccessfullyResetTheirPassword() {
        resetPasswordSuccessfully();
    }

    @When("the password reset process is completed")
    public void thePasswordResetProcessIsCompleted() {
        completePasswordResetProcess();
    }

    @Then("the user should receive a confirmation of successful password reset")
    public void theUserShouldReceiveAConfirmationOfSuccessfulPasswordReset() {
        verifyPasswordResetConfirmation();
    }

    @Given("the user has an invalid token")
    public void theUserHasAnInvalidToken() {
        provideInvalidToken();
    }

    @When("the user attempts to reset their password with the invalid token")
    public void theUserAttemptsToResetTheirPasswordWithTheInvalidToken() {
        attemptPasswordResetWithInvalidToken();
    }

    @Then("the system should display an error message for the invalid token")
    public void theSystemShouldDisplayAnErrorMessageForTheInvalidToken() {
        verifyInvalidTokenErrorMessage();
    }

    @Given("a user has initiated a password reset request")
    public void aUserHasInitiatedAPasswordResetRequest() {
        initiatePasswordResetRequest();
    }

    @When("the request is processed")
    public void theRequestIsProcessed() {
        processPasswordResetRequest();
    }

    @Then("the system should log the password reset request for security auditing")
    public void theSystemShouldLogThePasswordResetRequestForSecurityAuditing() {
        verifyPasswordResetRequestLogged();
    }

    @Given("the system handles user data for password recovery")
    public void theSystemHandlesUserDataForPasswordRecovery() {
        handleUserDataForRecovery();
    }

    @When("processing password reset requests")
    public void processingPasswordResetRequests() {
        processPasswordResetRequests();
    }

    @Then("the system must comply with GDPR and other data protection regulations")
    public void theSystemMustComplyWithGDPRAndOtherDataProtectionRegulations() {
        verifyGDPRCompliance();
    }
}