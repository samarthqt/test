package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PhoneNumberUpdateSteps extends UserProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("User is logged into their account")
    public void userIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @Given("User has access to the new phone number")
    public void userHasAccessToTheNewPhoneNumber() {
        verifyNewPhoneNumberAccess();
    }

    @When("User navigates to the user profile settings page")
    public void userNavigatesToTheUserProfileSettingsPage() {
        navigateToProfileSettings();
    }

    @Then("User profile settings page is displayed")
    public void userProfileSettingsPageIsDisplayed() {
        verifyProfileSettingsPageDisplayed();
    }

    @Then("Current phone number is 123-456-7890")
    public void currentPhoneNumberIsDisplayed() {
        verifyCurrentPhoneNumber("123-456-7890");
    }

    @When("User locates the phone number section")
    public void userLocatesThePhoneNumberSection() {
        locatePhoneNumberSection();
    }

    @Then("Phone number section is visible")
    public void phoneNumberSectionIsVisible() {
        verifyPhoneNumberSectionVisible();
    }

    @When("User clicks on the 'Edit' button next to the phone number")
    public void userClicksOnEditButton() {
        clickEditButton();
    }

    @Then("Phone number field becomes editable")
    public void phoneNumberFieldBecomesEditable() {
        verifyPhoneNumberFieldEditable();
    }

    @When("User enters the new phone number: 098-765-4321")
    public void userEntersNewPhoneNumber() {
        enterNewPhoneNumber("098-765-4321");
    }

    @Then("New phone number is entered in the field")
    public void newPhoneNumberIsEntered() {
        verifyNewPhoneNumberEntered("098-765-4321");
    }

    @When("User clicks the 'Save' button")
    public void userClicksSaveButton() {
        clickSaveButton();
    }

    @Then("System prompts for confirmation of the new phone number")
    public void systemPromptsForConfirmation() {
        verifyConfirmationPrompt();
    }

    @When("User confirms the update of the phone number")
    public void userConfirmsPhoneNumberUpdate() {
        confirmPhoneNumberUpdate();
    }

    @Then("A confirmation message is displayed indicating the phone number update is successful")
    public void confirmationMessageIsDisplayed() {
        verifyConfirmationMessage();
    }

    @When("User waits for the verification code to be sent to the new phone number")
    public void userWaitsForVerificationCode() {
        waitForVerificationCode();
    }

    @Then("Verification code is received on the new phone number")
    public void verificationCodeIsReceived() {
        verifyVerificationCodeReceived();
    }

    @When("User enters the received verification code: 123456")
    public void userEntersVerificationCode() {
        enterVerificationCode("123456");
    }

    @Then("Verification code is entered correctly")
    public void verificationCodeIsEnteredCorrectly() {
        verifyVerificationCodeEntered("123456");
    }

    @When("User clicks on 'Verify' button")
    public void userClicksVerifyButton() {
        clickVerifyButton();
    }

    @Then("System verifies the code and confirms the phone number update")
    public void systemVerifiesCodeAndConfirmsUpdate() {
        verifyCodeAndConfirmUpdate();
    }

    @When("User checks the updated phone number on the user profile")
    public void userChecksUpdatedPhoneNumber() {
        checkUpdatedPhoneNumber();
    }

    @Then("New phone number is displayed on the user profile")
    public void newPhoneNumberIsDisplayed() {
        verifyNewPhoneNumberDisplayed();
    }

    @When("User logs out and logs back into the account")
    public void userLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("User logs in successfully with the updated phone number")
    public void userLogsInSuccessfully() {
        verifyLoginWithUpdatedPhoneNumber();
    }

    @When("User attempts to perform an action that requires phone verification")
    public void userAttemptsActionRequiringVerification() {
        performActionRequiringVerification();
    }

    @Then("Action is performed successfully using the updated phone number")
    public void actionIsPerformedSuccessfully() {
        verifyActionPerformedSuccessfully();
    }

    @When("User checks for any errors or alerts on the profile page")
    public void userChecksForErrorsOrAlerts() {
        checkForErrorsOrAlerts();
    }

    @Then("No errors or alerts are displayed")
    public void noErrorsOrAlertsAreDisplayed() {
        verifyNoErrorsOrAlerts();
    }

    @When("User ensures the verification code is not sent to the old phone number")
    public void userEnsuresCodeNotSentToOldNumber() {
        ensureCodeNotSentToOldNumber();
    }

    @Then("Verification code is only sent to the new phone number")
    public void verificationCodeSentToNewNumber() {
        verifyCodeSentToNewNumber();
    }

    @When("User reviews the account activity log for the phone number update entry")
    public void userReviewsAccountActivityLog() {
        reviewAccountActivityLog();
    }

    @Then("Account activity log shows entry for the phone number update")
    public void accountActivityLogShowsEntry() {
        verifyActivityLogEntry();
    }
}