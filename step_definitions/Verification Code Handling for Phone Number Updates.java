package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PhoneNumberVerificationSteps extends UserProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user navigates to the user profile settings page")
    public void theUserNavigatesToTheUserProfileSettingsPage() {
        navigateToProfileSettings();
    }

    @Then("the user profile settings page is displayed")
    public void theUserProfileSettingsPageIsDisplayed() {
        verifyProfileSettingsPageDisplayed();
    }

    @When("the user accesses the phone number update page")
    public void theUserAccessesThePhoneNumberUpdatePage() {
        accessPhoneNumberUpdatePage();
    }

    @Then("the phone number section is visible")
    public void thePhoneNumberSectionIsVisible() {
        verifyPhoneNumberSectionVisible();
    }

    @Then("no verification code is received")
    public void noVerificationCodeIsReceived() {
        verifyNoVerificationCodeReceived();
    }

    @When("the user clicks on the 'Edit' button next to the phone number")
    public void theUserClicksOnTheEditButtonNextToThePhoneNumber() {
        clickEditPhoneNumber();
    }

    @Then("the phone number field becomes editable")
    public void thePhoneNumberFieldBecomesEditable() {
        verifyPhoneNumberFieldEditable();
    }

    @When("the user enters an incorrect phone number {string}")
    public void theUserEntersAnIncorrectPhoneNumber(String phoneNumber) {
        enterPhoneNumber(phoneNumber);
    }

    @Then("the incorrect phone number is entered in the field")
    public void theIncorrectPhoneNumberIsEnteredInTheField() {
        verifyIncorrectPhoneNumberEntered();
    }

    @When("the user clicks the 'Save' button")
    public void theUserClicksTheSaveButton() {
        clickSaveButton();
    }

    @Then("the system attempts to send a verification code to the entered phone number")
    public void theSystemAttemptsToSendAVerificationCodeToTheEnteredPhoneNumber() {
        attemptToSendVerificationCode();
    }

    @When("the user waits for the verification code to be sent")
    public void theUserWaitsForTheVerificationCodeToBeSent() {
        waitForVerificationCode();
    }

    @Then("no verification code is received on the incorrect phone number")
    public void noVerificationCodeIsReceivedOnTheIncorrectPhoneNumber() {
        verifyNoCodeReceivedOnIncorrectNumber();
    }

    @When("the user checks for any error messages or alerts on the profile page")
    public void theUserChecksForAnyErrorMessagesOrAlertsOnTheProfilePage() {
        checkForErrorMessages();
    }

    @Then("the system alerts the user to the incorrect phone number")
    public void theSystemAlertsTheUserToTheIncorrectPhoneNumber() {
        verifySystemAlertForIncorrectNumber();
    }

    @When("the user attempts to perform an action that requires phone verification")
    public void theUserAttemptsToPerformAnActionThatRequiresPhoneVerification() {
        attemptActionRequiringVerification();
    }

    @Then("the action cannot be performed without verification")
    public void theActionCannotBePerformedWithoutVerification() {
        verifyActionCannotBePerformedWithoutVerification();
    }

    @When("the user reviews the account activity log for any entries related to the incorrect phone number update attempt")
    public void theUserReviewsTheAccountActivityLogForAnyEntriesRelatedToTheIncorrectPhoneNumberUpdateAttempt() {
        reviewAccountActivityLog();
    }

    @Then("the activity log shows a failed verification attempt")
    public void theActivityLogShowsAFailedVerificationAttempt() {
        verifyFailedVerificationAttemptInLog();
    }

    @When("the user enters a valid phone number and saves")
    public void theUserEntersAValidPhoneNumberAndSaves() {
        enterValidPhoneNumberAndSave();
    }

    @Then("the system sends a verification code to the valid phone number")
    public void theSystemSendsAVerificationCodeToTheValidPhoneNumber() {
        verifyCodeSentToValidNumber();
    }

    @When("the user verifies that the verification code is received on the valid phone number")
    public void theUserVerifiesThatTheVerificationCodeIsReceivedOnTheValidPhoneNumber() {
        verifyCodeReceivedOnValidNumber();
    }

    @Then("the verification code is received successfully")
    public void theVerificationCodeIsReceivedSuccessfully() {
        verifySuccessfulCodeReception();
    }

    @When("the user checks the system logs for any errors during the incorrect phone number entry")
    public void theUserChecksTheSystemLogsForAnyErrorsDuringTheIncorrectPhoneNumberEntry() {
        checkSystemLogsForErrors();
    }

    @Then("the system logs show entries for failed verification attempts")
    public void theSystemLogsShowEntriesForFailedVerificationAttempts() {
        verifyFailedAttemptsInSystemLogs();
    }

    @When("the user ensures that the system prevents further actions until a valid phone number is verified")
    public void theUserEnsuresThatTheSystemPreventsFurtherActionsUntilAValidPhoneNumberIsVerified() {
        ensureSystemPreventsActionsUntilVerification();
    }

    @Then("the system restricts actions until the phone number is verified")
    public void theSystemRestrictsActionsUntilThePhoneNumberIsVerified() {
        verifySystemRestrictionUntilVerification();
    }

    @When("the user attempts to enter an incorrect phone number format")
    public void theUserAttemptsToEnterAnIncorrectPhoneNumberFormat() {
        attemptIncorrectPhoneNumberFormat();
    }

    @Then("the system displays an error message for incorrect format")
    public void theSystemDisplaysAnErrorMessageForIncorrectFormat() {
        verifyErrorMessageForIncorrectFormat();
    }

    @When("the user ensures that the input field has proper input validation to prevent incorrect entries")
    public void theUserEnsuresThatTheInputFieldHasProperInputValidationToPreventIncorrectEntries() {
        ensureInputFieldValidation();
    }

    @Then("the field has input validation preventing incorrect numbers from being submitted")
    public void theFieldHasInputValidationPreventingIncorrectNumbersFromBeingSubmitted() {
        verifyInputValidationPreventsIncorrectEntries();
    }
}