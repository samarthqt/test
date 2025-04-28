package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OTPVerificationSteps extends OTPVerificationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account configured without a phone number in IDP and Auth0")
    public void userAccountWithoutPhoneNumber() {
        verifyUserAccountConfiguration();
    }

    @When("the user attempts to initiate an OTP verification process")
    public void userAttemptsOTPVerification() {
        initiateOTPVerification();
    }

    @Then("the system checks for the presence of a phone number in IDP and Auth0")
    public void systemChecksPhoneNumberPresence() {
        checkPhoneNumberPresence();
    }

    @Then("the system prompts the user to provide a phone number")
    public void systemPromptsForPhoneNumber() {
        promptUserForPhoneNumber();
    }

    @Then("the OTP verification process is not initiated due to the absence of a phone number")
    public void otpVerificationNotInitiated() {
        verifyOTPNotInitiated();
    }

    @Then("the system logs an error or warning indicating the missing phone number")
    public void systemLogsErrorWarning() {
        logErrorOrWarning();
    }

    @Then("the user is provided with an option to update their phone number")
    public void userProvidedOptionToUpdatePhoneNumber() {
        providePhoneNumberUpdateOption();
    }

    @Given("the user updates their phone number")
    public void userUpdatesPhoneNumber() {
        updatePhoneNumber();
    }

    @Then("the system successfully initiates the OTP verification process with the updated phone number")
    public void otpVerificationInitiatedWithUpdatedPhoneNumber() {
        verifyOTPInitiatedWithUpdatedPhoneNumber();
    }

    @Then("the user receives a clear message explaining why a phone number is required")
    public void userReceivesClearMessage() {
        provideClearMessage();
    }

    @Then("the system prevents further attempts until a phone number is provided")
    public void systemPreventsFurtherAttempts() {
        preventFurtherAttempts();
    }

    @Then("the system may offer alternative verification methods \(e.g., email verification\)")
    public void systemOffersAlternativeVerificationMethods() {
        offerAlternativeVerificationMethods();
    }

    @Then("the system logs the attempt to initiate OTP verification without a phone number")
    public void systemLogsAttempt() {
        logOTPVerificationAttempt();
    }

    @When("the user attempts to initiate an OTP verification process on various platforms and devices")
    public void userAttemptsOnVariousPlatforms() {
        initiateOTPOnVariousPlatforms();
    }

    @Then("the system behavior is consistent across these platforms and devices")
    public void systemBehaviorConsistent() {
        verifyConsistentBehavior();
    }

    @Then("the user receives guidance on adding a phone number to their account")
    public void userReceivesGuidance() {
        provideGuidanceOnAddingPhoneNumber();
    }

    @Then("the system complies with security and privacy standards for phone number handling")
    public void systemCompliesWithStandards() {
        verifyComplianceWithStandards();
    }

    @When("the user accesses their account")
    public void userAccessesAccount() {
        accessUserAccount();
    }

    @Then("the user interface visually indicates the missing phone number")
    public void uiIndicatesMissingPhoneNumber() {
        indicateMissingPhoneNumber();
    }

    @Given("a different user account configured with a phone number in IDP and Auth0")
    public void differentUserAccountWithPhoneNumber() {
        verifyDifferentUserAccountConfiguration();
    }

    @Then("the system successfully initiates OTP verification for a user with a phone number")
    public void otpVerificationInitiatedForUserWithPhoneNumber() {
        verifyOTPInitiatedForUserWithPhoneNumber();
    }
}