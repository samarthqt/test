package com.cucumber.steps;

import com.page_objects.AccountSettingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSettingsSteps extends AccountSettingsPage {

    @Given("a user account exists")
    public void aUserAccountExists() {
        verifyUserAccountExists();
    }

    @When("the user navigates to the account settings page")
    public void theUserNavigatesToTheAccountSettingsPage() {
        navigateToAccountSettingsPage();
    }

    @Then("the user is directed to the account settings page")
    public void theUserIsDirectedToTheAccountSettingsPage() {
        verifyAccountSettingsPage();
    }

    @Given("the user is on the account settings page")
    public void theUserIsOnTheAccountSettingsPage() {
        verifyAccountSettingsPage();
    }

    @When("the user locates the 2FA settings section")
    public void theUserLocatesThe2FASettingsSection() {
        locate2FASettingsSection();
    }

    @Then("the 2FA settings section is visible")
    public void the2FASettingsSectionIsVisible() {
        verify2FASettingsSectionVisible();
    }

    @Given("the 2FA settings section is visible")
    public void the2FASettingsSectionIsVisibleAgain() {
        verify2FASettingsSectionVisible();
    }

    @When("the user enters an invalid phone number format {string} in the phone number field")
    public void theUserEntersAnInvalidPhoneNumberFormatInThePhoneNumberField(String phoneNumber) {
        enterInvalidPhoneNumber(phoneNumber);
    }

    @Then("the phone number field accepts the input")
    public void thePhoneNumberFieldAcceptsTheInput() {
        verifyPhoneNumberFieldAcceptsInput();
    }

    @Given("the user has entered an invalid phone number format")
    public void theUserHasEnteredAnInvalidPhoneNumberFormat() {
        verifyInvalidPhoneNumberEntered();
    }

    @When("the user attempts to enable 2FA using the invalid phone number")
    public void theUserAttemptsToEnable2FAUsingTheInvalidPhoneNumber() {
        attemptEnable2FAWithInvalidPhoneNumber();
    }

    @Then("an error message is displayed indicating invalid phone number format")
    public void anErrorMessageIsDisplayedIndicatingInvalidPhoneNumberFormat() {
        verifyErrorMessageDisplayed();
    }

    @Given("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Then("the error message suggests the correct phone number format")
    public void theErrorMessageSuggestsTheCorrectPhoneNumberFormat() {
        verifyErrorMessageSuggestsCorrectFormat();
    }

    @Given("the user has tried different invalid phone number formats")
    public void theUserHasTriedDifferentInvalidPhoneNumberFormats() {
        tryDifferentInvalidPhoneNumberFormats();
    }

    @When("the user observes the error handling")
    public void theUserObservesTheErrorHandling() {
        observeErrorHandling();
    }

    @Then("consistent error handling is observed for all invalid formats")
    public void consistentErrorHandlingIsObservedForAllInvalidFormats() {
        verifyConsistentErrorHandling();
    }

    @Given("an error event occurs")
    public void anErrorEventOccurs() {
        triggerErrorEvent();
    }

    @Then("the error event is logged in the system")
    public void theErrorEventIsLoggedInTheSystem() {
        verifyErrorEventLogged();
    }

    @Given("an invalid phone number format is entered")
    public void anInvalidPhoneNumberFormatIsEntered() {
        verifyInvalidPhoneNumberEntered();
    }

    @When("the user checks the 2FA settings")
    public void theUserChecksThe2FASettings() {
        check2FASettings();
    }

    @Then("the 2FA settings remain unchanged")
    public void the2FASettingsRemainUnchanged() {
        verify2FASettingsUnchanged();
    }

    @When("the user attempts to save the invalid phone number")
    public void theUserAttemptsToSaveTheInvalidPhoneNumber() {
        attemptSaveInvalidPhoneNumber();
    }

    @Then("the system prevents saving and displays an error")
    public void theSystemPreventsSavingAndDisplaysAnError() {
        verifySavePreventedAndErrorDisplayed();
    }

    @When("the user looks for guidance")
    public void theUserLooksForGuidance() {
        lookForGuidance();
    }

    @Then("a help link is available for valid phone number formats")
    public void aHelpLinkIsAvailableForValidPhoneNumberFormats() {
        verifyHelpLinkAvailable();
    }

    @When("the user attempts to navigate away from the settings page without correcting the phone number")
    public void theUserAttemptsToNavigateAwayFromTheSettingsPageWithoutCorrectingThePhoneNumber() {
        attemptNavigateAwayWithoutCorrection();
    }

    @Then("the system prompts to correct the phone number before leaving")
    public void theSystemPromptsToCorrectThePhoneNumberBeforeLeaving() {
        verifyPromptToCorrectBeforeLeaving();
    }

    @Given("previous errors occurred with invalid phone numbers")
    public void previousErrorsOccurredWithInvalidPhoneNumbers() {
        verifyPreviousErrorsOccurred();
    }

    @When("the user enters a valid phone number")
    public void theUserEntersAValidPhoneNumber() {
        enterValidPhoneNumber();
    }

    @Then("2FA is enabled successfully")
    public void twoFAIsEnabledSuccessfully() {
        verify2FAEnabledSuccessfully();
    }

    @Given("an error message needs to be displayed")
    public void anErrorMessageNeedsToBeDisplayed() {
        prepareForErrorMessageDisplay();
    }

    @When("an invalid phone number format is entered")
    public void anInvalidPhoneNumberFormatIsEnteredAgain() {
        enterInvalidPhoneNumberAgain();
    }

    @Then("error messages are displayed promptly")
    public void errorMessagesAreDisplayedPromptly() {
        verifyErrorMessagesDisplayedPromptly();
    }

    @When("the user views the phone number field")
    public void theUserViewsThePhoneNumberField() {
        viewPhoneNumberField();
    }

    @Then("the invalid phone number field is highlighted")
    public void theInvalidPhoneNumberFieldIsHighlighted() {
        verifyPhoneNumberFieldHighlighted();
    }

    @Given("a valid phone number format is entered with additional invalid characters")
    public void aValidPhoneNumberFormatIsEnteredWithAdditionalInvalidCharacters() {
        enterValidPhoneNumberWithInvalidCharacters();
    }

    @When("the user attempts to enable 2FA")
    public void theUserAttemptsToEnable2FA() {
        attemptEnable2FA();
    }

    @Then("an error message is displayed for invalid characters")
    public void anErrorMessageIsDisplayedForInvalidCharacters() {
        verifyErrorMessageForInvalidCharacters();
    }
}