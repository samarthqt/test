package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MFAVerificationSteps extends MFAPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user has a registered phone number in the system")
    public void userHasRegisteredPhoneNumber() {
        verifyRegisteredPhoneNumber();
    }

    @When("the user initiates the MFA process by logging into the system with a registered account")
    public void userInitiatesMFAProcess() {
        initiateMFAProcess();
    }

    @Then("the system prompts for MFA verification")
    public void systemPromptsForMFAVerification() {
        verifyMFAPrompt();
    }

    @Given("the system prompts for MFA verification")
    public void systemPromptsForVerification() {
        verifyMFAPrompt();
    }

    @When("the user selects the phone number as the verification method")
    public void userSelectsPhoneNumber() {
        selectPhoneNumberForVerification();
    }

    @Then("the system displays the registered phone number for verification")
    public void systemDisplaysRegisteredPhoneNumber() {
        verifyDisplayedPhoneNumber();
    }

    @Given("the user has selected the phone number for verification")
    public void userHasSelectedPhoneNumber() {
        verifyPhoneNumberSelection();
    }

    @When("the user confirms the phone number selection")
    public void userConfirmsPhoneNumberSelection() {
        confirmPhoneNumberSelection();
    }

    @Then("the system sends a 6-digit verification code to the registered phone number")
    public void systemSendsVerificationCode() {
        verifyCodeSentToPhoneNumber();
    }

    @Given("a verification code is sent to the registered phone number")
    public void verificationCodeSentToPhone() {
        verifyCodeSentToPhoneNumber();
    }

    @When("the user checks the phone for the received verification code")
    public void userChecksPhoneForCode() {
        checkPhoneForVerificationCode();
    }

    @Then("verification code '123456' is received via SMS")
    public void verificationCodeReceived() {
        verifyReceivedCode("123456");
    }

    @Given("the verification code is received via SMS")
    public void verificationCodeReceivedViaSMS() {
        verifyReceivedCodeViaSMS();
    }

    @When("the user enters the received verification code into the system")
    public void userEntersVerificationCode() {
        enterVerificationCode();
    }

    @Then("the system verifies the code and grants access to the account")
    public void systemVerifiesCodeAndGrantsAccess() {
        verifyCodeAndGrantAccess();
    }

    @Given("a verification code is received")
    public void verificationCodeIsReceived() {
        verifyReceivedCode();
    }

    @When("the user checks the code format")
    public void userChecksCodeFormat() {
        checkCodeFormat();
    }

    @Then("the code is exactly 6 digits long")
    public void codeIsSixDigitsLong() {
        verifyCodeLength(6);
    }

    @Given("a different registered phone number is available")
    public void differentRegisteredPhoneNumberAvailable() {
        verifyDifferentRegisteredPhoneNumber();
    }

    @When("the user repeats the MFA process with the different phone number")
    public void userRepeatsMFAProcess() {
        repeatMFAProcessWithDifferentNumber();
    }

    @Then("the verification code is sent successfully to the new number")
    public void verificationCodeSentToNewNumber() {
        verifyCodeSentToNewNumber();
    }

    @Given("the user initiates the MFA process")
    public void userInitiatesMFA() {
        initiateMFAProcess();
    }

    @When("the user does not select a phone number")
    public void userDoesNotSelectPhoneNumber() {
        verifyNoPhoneNumberSelection();
    }

    @Then("the system prompts to select a phone number for verification")
    public void systemPromptsToSelectPhoneNumber() {
        verifyPromptToSelectPhoneNumber();
    }

    @Given("a verification code is sent")
    public void verificationCodeIsSent() {
        verifyCodeSent();
    }

    @When("the user checks the delivery time")
    public void userChecksDeliveryTime() {
        checkCodeDeliveryTime();
    }

    @Then("the code is received within a reasonable time frame \(e.g., 30 seconds\)")
    public void codeReceivedWithinTimeFrame() {
        verifyCodeReceivedWithinTimeFrame(30);
    }

    @Given("a verification code is received via SMS")
    public void verificationCodeReceivedViaSMSAgain() {
        verifyReceivedCodeViaSMS();
    }

    @When("the user checks the SMS content")
    public void userChecksSMSContent() {
        checkSMSContent();
    }

    @Then("the SMS contains only the verification code and no sensitive information")
    public void smsContainsOnlyVerificationCode() {
        verifySMSContent();
    }

    @Given("multiple login attempts are made")
    public void multipleLoginAttemptsMade() {
        verifyMultipleLoginAttempts();
    }

    @When("the user checks the verification codes for each attempt")
    public void userChecksVerificationCodes() {
        checkVerificationCodesForAttempts();
    }

    @Then("a different code is sent for each login attempt")
    public void differentCodeSentForEachAttempt() {
        verifyDifferentCodeForEachAttempt();
    }

    @Given("a login attempt is made")
    public void loginAttemptMade() {
        verifyLoginAttempt();
    }

    @When("the user checks the number of verification codes sent")
    public void userChecksNumberOfCodesSent() {
        checkNumberOfCodesSent();
    }

    @Then("no duplicate codes are sent for the same attempt")
    public void noDuplicateCodesSent() {
        verifyNoDuplicateCodesSent();
    }

    @Given("a phone number is registered in the system")
    public void phoneNumberRegisteredInSystem() {
        verifyPhoneNumberRegistered();
    }

    @When("the user checks the phone number format in the system settings")
    public void userChecksPhoneNumberFormat() {
        checkPhoneNumberFormatInSettings();
    }

    @Then("the phone number is correctly formatted and matches the registered number")
    public void phoneNumberCorrectlyFormatted() {
        verifyPhoneNumberFormat();
    }

    @Given("a verification code is sent to a registered phone number")
    public void verificationCodeSentToRegisteredNumber() {
        verifyCodeSentToPhoneNumber();
    }

    @When("the user checks the system logs")
    public void userChecksSystemLogs() {
        checkSystemLogsForCodeSent();
    }

    @Then("the system logs show the verification code sent to the registered number")
    public void systemLogsShowCodeSent() {
        verifySystemLogsForCodeSent();
    }

    @Given("an unregistered phone number is used for MFA")
    public void unregisteredPhoneNumberUsedForMFA() {
        verifyUnregisteredPhoneNumber();
    }

    @When("the user attempts MFA")
    public void userAttemptsMFA() {
        attemptMFAWithUnregisteredNumber();
    }

    @Then("the system does not send a verification code and prompts to register the number")
    public void systemPromptsToRegisterNumber() {
        verifyPromptToRegisterNumber();
    }
}