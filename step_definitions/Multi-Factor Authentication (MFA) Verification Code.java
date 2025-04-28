package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MFAVerificationSteps extends MFAPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user has a registered phone number in the system")
    public void aUserHasARegisteredPhoneNumberInTheSystem() {
        verifyRegisteredPhoneNumber();
    }

    @When("the user initiates the MFA process by logging into the system with a registered account")
    public void theUserInitiatesTheMFAProcess() {
        initiateMFAProcess();
    }

    @Then("the system prompts for MFA verification")
    public void theSystemPromptsForMFAVerification() {
        verifyMFAPrompt();
    }

    @Given("the system prompts for MFA verification")
    public void theSystemPromptsForMFAVerificationAgain() {
        verifyMFAPrompt();
    }

    @When("the user selects the phone number as the verification method")
    public void theUserSelectsPhoneNumberAsVerificationMethod() {
        selectPhoneNumberVerificationMethod();
    }

    @Then("the system displays the registered phone number for verification")
    public void theSystemDisplaysRegisteredPhoneNumber() {
        displayRegisteredPhoneNumber();
    }

    @Given("the user has selected the phone number for verification")
    public void theUserHasSelectedPhoneNumberForVerification() {
        verifyPhoneNumberSelection();
    }

    @When("the user confirms the phone number selection")
    public void theUserConfirmsPhoneNumberSelection() {
        confirmPhoneNumberSelection();
    }

    @Then("the system sends a 6-digit verification code to the registered phone number")
    public void theSystemSendsVerificationCode() {
        sendVerificationCode();
    }

    @Given("a verification code is sent to the registered phone number")
    public void aVerificationCodeIsSent() {
        verifyCodeSent();
    }

    @When("the user checks the phone for the received verification code")
    public void theUserChecksPhoneForVerificationCode() {
        checkPhoneForCode();
    }

    @Then("verification code '123456' is received via SMS")
    public void verificationCodeIsReceived() {
        verifyReceivedCode("123456");
    }

    @Given("the verification code is received via SMS")
    public void theVerificationCodeIsReceivedViaSMS() {
        verifyCodeReceivedViaSMS();
    }

    @When("the user enters the received verification code into the system")
    public void theUserEntersReceivedCodeIntoSystem() {
        enterVerificationCode();
    }

    @Then("the system verifies the code and grants access to the account")
    public void theSystemVerifiesCodeAndGrantsAccess() {
        verifyCodeAndGrantAccess();
    }

    @Given("a verification code is received")
    public void aVerificationCodeIsReceivedAgain() {
        verifyCodeReceived();
    }

    @When("the user checks the code format")
    public void theUserChecksCodeFormat() {
        checkCodeFormat();
    }

    @Then("the code is exactly 6 digits long")
    public void theCodeIsExactly6DigitsLong() {
        verifyCodeLength(6);
    }

    @Given("a different registered phone number is available")
    public void aDifferentRegisteredPhoneNumberIsAvailable() {
        verifyDifferentRegisteredPhoneNumber();
    }

    @When("the user repeats the MFA process with the different phone number")
    public void theUserRepeatsMFAProcessWithDifferentNumber() {
        repeatMFAProcessWithDifferentNumber();
    }

    @Then("the verification code is sent successfully to the new number")
    public void theVerificationCodeIsSentToNewNumber() {
        verifyCodeSentToNewNumber();
    }

    @Given("the user initiates the MFA process")
    public void theUserInitiatesMFAProcessAgain() {
        initiateMFAProcess();
    }

    @When("the user does not select a phone number")
    public void theUserDoesNotSelectPhoneNumber() {
        doNotSelectPhoneNumber();
    }

    @Then("the system prompts to select a phone number for verification")
    public void theSystemPromptsToSelectPhoneNumber() {
        promptToSelectPhoneNumber();
    }

    @Given("a verification code is sent")
    public void aVerificationCodeIsSentAgain() {
        verifyCodeSent();
    }

    @When("the user checks the delivery time")
    public void theUserChecksDeliveryTime() {
        checkDeliveryTime();
    }

    @Then("the code is received within a reasonable time frame \(e.g., 30 seconds\)")
    public void theCodeIsReceivedWithinTimeFrame() {
        verifyCodeReceivedWithinTimeFrame(30);
    }

    @Given("a verification code is received via SMS")
    public void aVerificationCodeIsReceivedViaSMSAgain() {
        verifyCodeReceivedViaSMS();
    }

    @When("the user checks the SMS content")
    public void theUserChecksSMSContent() {
        checkSMSContent();
    }

    @Then("the SMS contains only the verification code and no sensitive information")
    public void theSMSContainsOnlyVerificationCode() {
        verifySMSContent();
    }

    @Given("multiple login attempts are made")
    public void multipleLoginAttemptsAreMade() {
        verifyMultipleLoginAttempts();
    }

    @When("the user checks the verification codes for each attempt")
    public void theUserChecksVerificationCodesForEachAttempt() {
        checkVerificationCodesForAttempts();
    }

    @Then("a different code is sent for each login attempt")
    public void aDifferentCodeIsSentForEachAttempt() {
        verifyDifferentCodesForAttempts();
    }

    @Given("a login attempt is made")
    public void aLoginAttemptIsMade() {
        verifyLoginAttempt();
    }

    @When("the user checks the number of verification codes sent")
    public void theUserChecksNumberOfCodesSent() {
        checkNumberOfCodesSent();
    }

    @Then("no duplicate codes are sent for the same attempt")
    public void noDuplicateCodesAreSent() {
        verifyNoDuplicateCodes();
    }

    @Given("a phone number is registered in the system")
    public void aPhoneNumberIsRegisteredInSystem() {
        verifyPhoneNumberRegistered();
    }

    @When("the user checks the phone number format in the system settings")
    public void theUserChecksPhoneNumberFormatInSettings() {
        checkPhoneNumberFormatInSettings();
    }

    @Then("the phone number is correctly formatted and matches the registered number")
    public void thePhoneNumberIsCorrectlyFormatted() {
        verifyPhoneNumberFormat();
    }

    @Given("a verification code is sent to a registered phone number")
    public void aVerificationCodeIsSentToRegisteredNumber() {
        verifyCodeSentToRegisteredNumber();
    }

    @When("the user checks the system logs")
    public void theUserChecksSystemLogs() {
        checkSystemLogs();
    }

    @Then("the system logs show the verification code sent to the registered number")
    public void theSystemLogsShowCodeSent() {
        verifySystemLogsForCodeSent();
    }

    @Given("an unregistered phone number is used for MFA")
    public void anUnregisteredPhoneNumberIsUsedForMFA() {
        verifyUnregisteredPhoneNumber();
    }

    @When("the user attempts MFA")
    public void theUserAttemptsMFA() {
        attemptMFAWithUnregisteredNumber();
    }

    @Then("the system does not send a verification code and prompts to register the number")
    public void theSystemDoesNotSendCodeAndPromptsToRegister() {
        verifyNoCodeSentAndPromptToRegister();
    }
}