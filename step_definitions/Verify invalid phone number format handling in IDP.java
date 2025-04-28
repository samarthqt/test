package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IDPPhoneNumberSteps extends IDPLoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has access to IDP")
    public void theUserHasAccessToIDP() {
        // Code to verify user access
    }

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        // Code to verify user login
    }

    @When("the user navigates to the IDP login page")
    public void theUserNavigatesToTheIDPLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the IDP login page is displayed")
    public void theIDPLoginPageIsDisplayed() {
        verifyPageTitle("IDP Login");
    }

    @Given("the user is on the IDP login page")
    public void theUserIsOnTheIDPLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user enters a valid email address in the email field")
    public void theUserEntersAValidEmailAddressInTheEmailField() {
        String email = testHarness.getData("IDPData", "ValidEmail");
        enterEmail(email);
    }

    @Then("the email address is accepted")
    public void theEmailAddressIsAccepted() {
        verifyEmailAcceptance();
    }

    @When("the user enters {string} in the phone number field")
    public void theUserEntersInvalidPhoneNumberInThePhoneNumberField(String invalidPhoneNumber) {
        enterPhoneNumber(invalidPhoneNumber);
    }

    @Then("the system displays an error message indicating invalid phone number format")
    public void theSystemDisplaysAnErrorMessageIndicatingInvalidPhoneNumberFormat() {
        verifyPhoneNumberErrorMessage();
    }

    @When("the user attempts to submit the form with the invalid phone number")
    public void theUserAttemptsToSubmitTheFormWithTheInvalidPhoneNumber() {
        submitForm();
    }

    @Then("the form submission is blocked, and an error message is displayed")
    public void theFormSubmissionIsBlockedAndAnErrorMessageIsDisplayed() {
        verifyFormSubmissionBlocked();
    }

    @When("the user corrects the phone number format to a valid one")
    public void theUserCorrectsThePhoneNumberFormatToAValidOne() {
        String validPhoneNumber = testHarness.getData("IDPData", "ValidPhoneNumber");
        enterPhoneNumber(validPhoneNumber);
    }

    @Then("the system accepts the corrected phone number format")
    public void theSystemAcceptsTheCorrectedPhoneNumberFormat() {
        verifyPhoneNumberAcceptance();
    }

    @When("the user submits the form with the corrected phone number")
    public void theUserSubmitsTheFormWithTheCorrectedPhoneNumber() {
        submitForm();
    }

    @Then("the form is successfully submitted")
    public void theFormIsSuccessfullySubmitted() {
        verifyFormSubmissionSuccess();
    }

    @When("the user enters invalid phone number formats from test data")
    public void theUserEntersInvalidPhoneNumberFormatsFromTestData() {
        String[] invalidPhoneNumbers = testHarness.getDataArray("IDPData", "InvalidPhoneNumbers");
        for (String phoneNumber : invalidPhoneNumbers) {
            enterPhoneNumber(phoneNumber);
            verifyPhoneNumberErrorMessage();
        }
    }

    @Then("the system consistently displays error messages for invalid formats")
    public void theSystemConsistentlyDisplaysErrorMessagesForInvalidFormats() {
        verifyConsistentErrorMessages();
    }

    @Then("the system logs contain entries for each invalid phone number attempt")
    public void theSystemLogsContainEntriesForEachInvalidPhoneNumberAttempt() {
        verifySystemLogsForInvalidAttempts();
    }

    @Then("the system does not send OTP for invalid phone number formats")
    public void theSystemDoesNotSendOTPForInvalidPhoneNumberFormats() {
        verifyNoOTPForInvalidNumbers();
    }

    @When("the user attempts to use an invalid phone number for account recovery")
    public void theUserAttemptsToUseAnInvalidPhoneNumberForAccountRecovery() {
        attemptAccountRecoveryWithInvalidNumber();
    }

    @Then("the account recovery process fails due to invalid phone number format")
    public void theAccountRecoveryProcessFailsDueToInvalidPhoneNumberFormat() {
        verifyAccountRecoveryFailure();
    }

    @When("the user enters an invalid phone number format")
    public void theUserEntersAnInvalidPhoneNumberFormat() {
        String invalidPhoneNumber = testHarness.getData("IDPData", "InvalidPhoneNumber");
        enterPhoneNumber(invalidPhoneNumber);
    }

    @Then("the system displays error messages promptly after invalid input")
    public void theSystemDisplaysErrorMessagesPromptlyAfterInvalidInput() {
        verifyPromptErrorMessages();
    }

    @Then("the error messages provide clear guidance on valid phone number formats")
    public void theErrorMessagesProvideClearGuidanceOnValidPhoneNumberFormats() {
        verifyErrorMessageGuidance();
    }

    @When("the user enters international invalid phone number formats")
    public void theUserEntersInternationalInvalidPhoneNumberFormats() {
        String[] internationalInvalidNumbers = testHarness.getDataArray("IDPData", "InternationalInvalidNumbers");
        for (String phoneNumber : internationalInvalidNumbers) {
            enterPhoneNumber(phoneNumber);
            verifyPhoneNumberErrorMessage();
        }
    }

    @Then("the system behaves consistently with international invalid formats")
    public void theSystemBehavesConsistentlyWithInternationalInvalidFormats() {
        verifyConsistentBehaviorForInternationalFormats();
    }

    @When("the user attempts to bypass validation using special characters")
    public void theUserAttemptsToBypassValidationUsingSpecialCharacters() {
        attemptValidationBypass();
    }

    @Then("the system detects and blocks attempts to bypass validation")
    public void theSystemDetectsAndBlocksAttemptsToBypassValidation() {
        verifyValidationBypassBlocked();
    }

    @Then("the system maintains security, with no exposure of phone number details")
    public void theSystemMaintainsSecurityWithNoExposureOfPhoneNumberDetails() {
        verifySecurityMaintained();
    }
}