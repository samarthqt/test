package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PhoneNumberSteps extends UserProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user navigates to the user profile settings page")
    public void theUserNavigatesToTheUserProfileSettingsPage() {
        navigateToUserProfileSettings();
    }

    @Then("the user profile settings page is displayed")
    public void theUserProfileSettingsPageIsDisplayed() {
        verifyUserProfileSettingsPageDisplayed();
    }

    @When("the user locates the phone number section")
    public void theUserLocatesThePhoneNumberSection() {
        locatePhoneNumberSection();
    }

    @Then("the phone number section is visible")
    public void thePhoneNumberSectionIsVisible() {
        verifyPhoneNumberSectionVisible();
    }

    @When("the user clicks on the 'Edit' button next to the phone number")
    public void theUserClicksOnTheEditButtonNextToThePhoneNumber() {
        clickEditButton();
    }

    @Then("the phone number field becomes editable")
    public void thePhoneNumberFieldBecomesEditable() {
        verifyPhoneNumberFieldEditable();
    }

    @When("the user enters an invalid phone number format {string}")
    public void theUserEntersAnInvalidPhoneNumberFormat(String phoneNumber) {
        enterPhoneNumber(phoneNumber);
    }

    @When("clicks the 'Save' button")
    public void clicksTheSaveButton() {
        clickSaveButton();
    }

    @Then("the system validates the phone number format")
    public void theSystemValidatesThePhoneNumberFormat() {
        validatePhoneNumberFormat();
    }

    @Then("an error message {string} is displayed")
    public void anErrorMessageIsDisplayed(String errorMessage) {
        verifyErrorMessageDisplayed(errorMessage);
    }

    @Then("the phone number is not updated in the system")
    public void thePhoneNumberIsNotUpdatedInTheSystem() {
        verifyPhoneNumberNotUpdated();
    }

    @Then("the phone number remains unchanged")
    public void thePhoneNumberRemainsUnchanged() {
        verifyPhoneNumberUnchanged();
    }

    @When("the user attempts to perform an action that requires phone verification")
    public void theUserAttemptsToPerformAnActionThatRequiresPhoneVerification() {
        attemptActionRequiringPhoneVerification();
    }

    @Then("the action cannot be performed due to invalid phone number")
    public void theActionCannotBePerformedDueToInvalidPhoneNumber() {
        verifyActionCannotBePerformed();
    }

    @When("the user reviews the account activity log for any entries related to the invalid phone number update attempt")
    public void theUserReviewsTheAccountActivityLog() {
        reviewAccountActivityLog();
    }

    @Then("the activity log does not show a successful update entry")
    public void theActivityLogDoesNotShowASuccessfulUpdateEntry() {
        verifyNoSuccessfulUpdateEntry();
    }

    @When("the user tries entering another invalid format {string}")
    public void theUserTriesEnteringAnotherInvalidFormat(String phoneNumber) {
        enterPhoneNumber(phoneNumber);
    }

    @When("the user enters a valid phone number format and saves")
    public void theUserEntersAValidPhoneNumberFormatAndSaves() {
        enterValidPhoneNumberAndSave();
    }

    @Then("the system accepts the valid phone number and updates successfully")
    public void theSystemAcceptsTheValidPhoneNumberAndUpdatesSuccessfully() {
        verifyPhoneNumberUpdatedSuccessfully();
    }

    @Then("verifies that the error message no longer appears with a valid format")
    public void verifiesThatTheErrorMessageNoLongerAppears() {
        verifyNoErrorMessageForValidFormat();
    }

    @Then("no error message is displayed for the valid phone number")
    public void noErrorMessageIsDisplayedForTheValidPhoneNumber() {
        verifyNoErrorMessageDisplayed();
    }

    @When("the user checks the system logs for any errors during the invalid phone number entry")
    public void theUserChecksTheSystemLogs() {
        checkSystemLogsForErrors();
    }

    @Then("the system logs show validation error entries")
    public void theSystemLogsShowValidationErrorEntries() {
        verifySystemLogsForValidationErrors();
    }

    @When("the user attempts to enter a valid phone number with extra spaces or special characters")
    public void theUserAttemptsToEnterAValidPhoneNumberWithExtraSpaces() {
        enterPhoneNumberWithSpacesOrSpecialCharacters();
    }

    @Then("the system trims spaces and removes special characters, accepting the valid number")
    public void theSystemTrimsSpacesAndRemovesSpecialCharacters() {
        verifyPhoneNumberAcceptedAfterTrimming();
    }

    @Then("ensures that the input field has proper input validation to prevent invalid entries")
    public void ensuresThatTheInputFieldHasProperInputValidation() {
        verifyInputFieldValidation();
    }

    @Then("the field has input validation preventing invalid formats from being submitted")
    public void theFieldHasInputValidationPreventingInvalidFormats() {
        verifyFieldInputValidation();
    }
}