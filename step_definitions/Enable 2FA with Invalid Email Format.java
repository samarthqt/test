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
        navigateToAccountSettings();
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

    @Given("the user is in the 2FA settings section")
    public void theUserIsInThe2FASettingsSection() {
        verify2FASettingsSectionVisible();
    }

    @When("the user enters an invalid email format {string} in the email field")
    public void theUserEntersAnInvalidEmailFormatInTheEmailField(String email) {
        enterEmail(email);
    }

    @Then("the email field accepts the input")
    public void theEmailFieldAcceptsTheInput() {
        verifyEmailFieldInput();
    }

    @Given("the user has entered an invalid email format")
    public void theUserHasEnteredAnInvalidEmailFormat() {
        verifyInvalidEmailEntered();
    }

    @When("the user attempts to enable 2FA")
    public void theUserAttemptsToEnable2FA() {
        attemptEnable2FA();
    }

    @Then("an error message is displayed indicating invalid email format")
    public void anErrorMessageIsDisplayedIndicatingInvalidEmailFormat() {
        verifyInvalidEmailErrorMessage();
    }

    @Given("the error message is displayed")
    public void theErrorMessageIsDisplayed() {
        verifyInvalidEmailErrorMessage();
    }

    @When("the user reviews the error message")
    public void theUserReviewsTheErrorMessage() {
        reviewErrorMessage();
    }

    @Then("the error message suggests the correct email format")
    public void theErrorMessageSuggestsTheCorrectEmailFormat() {
        verifyErrorMessageSuggestion();
    }

    @When("the user tries different invalid email formats")
    public void theUserTriesDifferentInvalidEmailFormats() {
        tryDifferentInvalidEmailFormats();
    }

    @Then("consistent error handling is observed for all invalid formats")
    public void consistentErrorHandlingIsObservedForAllInvalidFormats() {
        verifyConsistentErrorHandling();
    }

    @When("the user checks the system logs")
    public void theUserChecksTheSystemLogs() {
        checkSystemLogs();
    }

    @Then("the error event is logged in the system")
    public void theErrorEventIsLoggedInTheSystem() {
        verifyErrorEventLogged();
    }

    @When("the user checks the 2FA settings")
    public void theUserChecksThe2FASettings() {
        check2FASettings();
    }

    @Then("the 2FA settings remain unchanged")
    public void the2FASettingsRemainUnchanged() {
        verify2FASettingsUnchanged();
    }

    @Given("an invalid email format is entered")
    public void anInvalidEmailFormatIsEntered() {
        verifyInvalidEmailEntered();
    }

    @When("the user attempts to save the email")
    public void theUserAttemptsToSaveTheEmail() {
        attemptSaveEmail();
    }

    @Then("the system prevents saving and displays an error")
    public void theSystemPreventsSavingAndDisplaysAnError() {
        verifySavePreventionAndError();
    }

    @When("the user looks for guidance")
    public void theUserLooksForGuidance() {
        lookForGuidance();
    }

    @Then("a help link is available for valid email formats")
    public void aHelpLinkIsAvailableForValidEmailFormats() {
        verifyHelpLinkAvailable();
    }

    @When("the user attempts to navigate away from the settings page")
    public void theUserAttemptsToNavigateAwayFromTheSettingsPage() {
        attemptNavigateAway();
    }

    @Then("the system prompts to correct the email before leaving")
    public void theSystemPromptsToCorrectTheEmailBeforeLeaving() {
        verifyPromptToCorrectEmail();
    }

    @Given("previous errors with invalid email formats")
    public void previousErrorsWithInvalidEmailFormats() {
        verifyPreviousErrors();
    }

    @When("the user enters a valid email format")
    public void theUserEntersAValidEmailFormat() {
        enterValidEmail();
    }

    @Then("2FA is enabled successfully")
    public void twoFAIsEnabledSuccessfully() {
        verify2FAEnabled();
    }

    @When("the user attempts to enable 2FA")
    public void theUserAttemptsToEnable2FAAgain() {
        attemptEnable2FA();
    }

    @Then("error messages are displayed promptly")
    public void errorMessagesAreDisplayedPromptly() {
        verifyPromptErrorMessages();
    }

    @When("the user reviews the email field")
    public void theUserReviewsTheEmailField() {
        reviewEmailField();
    }

    @Then("the invalid email field is highlighted")
    public void theInvalidEmailFieldIsHighlighted() {
        verifyEmailFieldHighlighted();
    }

    @Given("a valid email format with additional invalid characters is entered")
    public void aValidEmailFormatWithAdditionalInvalidCharactersIsEntered() {
        enterEmailWithInvalidCharacters();
    }

    @When("the user attempts to enable 2FA")
    public void theUserAttemptsToEnable2FAWithInvalidCharacters() {
        attemptEnable2FA();
    }

    @Then("an error message is displayed for invalid characters")
    public void anErrorMessageIsDisplayedForInvalidCharacters() {
        verifyInvalidCharactersErrorMessage();
    }
}