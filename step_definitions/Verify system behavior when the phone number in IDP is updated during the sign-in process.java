package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PhoneNumberUpdateSteps extends IDPPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account is linked to an IDP with a valid phone number")
    public void userAccountLinkedToIDP() {
        verifyUserAccountLinkedToIDP();
    }

    @Given("the user has access to the IDP management interface")
    public void userHasAccessToIDPManagement() {
        verifyAccessToIDPManagement();
    }

    @When("the user initiates sign-in using email {string} and password {string}")
    public void userInitiatesSignIn(String email, String password) {
        initiateSignIn(email, password);
    }

    @Then("the user should receive an OTP prompt for the current phone number")
    public void userReceivesOTPPrompt() {
        verifyOTPPromptReceived();
    }

    @When("the user updates the phone number in the IDP to a new number {string}")
    public void userUpdatesPhoneNumber(String newPhoneNumber) {
        updatePhoneNumberInIDP(newPhoneNumber);
    }

    @Then("the IDP should reflect the new phone number")
    public void idpReflectsNewPhoneNumber() {
        verifyIDPReflectsNewPhoneNumber();
    }

    @When("the user attempts to enter the OTP sent to the old phone number {string}")
    public void userAttemptsToEnterOldOTP(String oldPhoneNumber) {
        enterOTPForOldPhoneNumber(oldPhoneNumber);
    }

    @Then("the user should receive an error message indicating the OTP is invalid")
    public void userReceivesInvalidOTPError() {
        verifyInvalidOTPErrorMessage();
    }

    @When("the user requests a new OTP after phone number update")
    public void userRequestsNewOTP() {
        requestNewOTPAfterUpdate();
    }

    @Then("the user should receive the OTP on the new phone number {string}")
    public void userReceivesOTPOnNewPhoneNumber(String newPhoneNumber) {
        verifyOTPReceivedOnNewPhoneNumber(newPhoneNumber);
    }

    @When("the user enters the new OTP {string} received on the updated phone number")
    public void userEntersNewOTP(String newOTP) {
        enterNewOTP(newOTP);
    }

    @Then("the user should successfully sign in with the new OTP")
    public void userSuccessfullySignsIn() {
        verifySuccessfulSignIn();
    }

    @Then("the system logs should show timestamped phone number update and OTP requests")
    public void verifySystemLogs() {
        verifySystemLogsForUpdates();
    }

    @Then("the user should receive a notification of phone number update")
    public void userReceivesNotification() {
        verifyNotificationReceived();
    }

    @When("the user attempts to sign in with the old phone number")
    public void userAttemptsSignInWithOldPhoneNumber() {
        attemptSignInWithOldPhoneNumber();
    }

    @Then("the user should receive an error message indicating phone number mismatch")
    public void userReceivesPhoneNumberMismatchError() {
        verifyPhoneNumberMismatchError();
    }

    @Then("the user's account settings should display the updated phone number")
    public void verifyUpdatedPhoneNumberInAccountSettings() {
        verifyAccountSettingsDisplayUpdatedPhoneNumber();
    }

    @When("a network failure is simulated during the OTP request after phone number update")
    public void simulateNetworkFailureDuringOTPRequest() {
        simulateNetworkFailure();
    }

    @Then("the system should retry OTP sending or prompt the user to retry")
    public void systemRetriesOTPSending() {
        verifySystemRetriesOrPrompts();
    }

    @When("the user attempts to update the phone number back to the old number during sign-in")
    public void userAttemptsToRevertPhoneNumber() {
        attemptPhoneNumberReversion();
    }

    @Then("the IDP should allow or reject the update based on policy")
    public void idpHandlesReversionBasedOnPolicy() {
        verifyIDPPolicyOnReversion();
    }

    @When("the phone number update is successful")
    public void phoneNumberUpdateSuccessful() {
        verifyPhoneNumberUpdateSuccess();
    }

    @Then("the OTP should be sent to the reverted phone number if allowed")
    public void otpSentToRevertedPhoneNumber() {
        verifyOTPSentToRevertedPhoneNumber();
    }

    @Then("the system should log any alerts or flags for security review")
    public void verifySecurityAlertsLogged() {
        verifySecurityAlerts();
    }

    @Then("the user may be prompted for additional verification based on policy")
    public void userPromptedForAdditionalVerification() {
        verifyAdditionalVerificationPrompt();
    }

    @Then("the user should remain securely signed in without session invalidation")
    public void verifySecureSignInSession() {
        verifySecureSession();
    }
}