package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProfileSettingsPage;

public class ProfileSettingsSteps extends ProfileSettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User is logged into their account")
    public void userIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("User navigates to the profile settings page")
    public void userNavigatesToProfileSettingsPage() {
        navigateToProfileSettings();
    }

    @Then("Profile settings page is displayed")
    public void profileSettingsPageIsDisplayed() {
        verifyProfileSettingsPageDisplayed();
    }

    @When("User enters new name {string} in the name field")
    public void userEntersNewNameInTheNameField(String name) {
        enterName(name);
    }

    @Then("New name is entered in the name field")
    public void newNameIsEnteredInTheNameField() {
        verifyNameEntered();
    }

    @When("User enters new email {string} in the email field")
    public void userEntersNewEmailInTheEmailField(String email) {
        enterEmail(email);
    }

    @Then("New email is entered in the email field")
    public void newEmailIsEnteredInTheEmailField() {
        verifyEmailEntered();
    }

    @When("User enters new phone number {string} in the phone number field")
    public void userEntersNewPhoneNumberInThePhoneNumberField(String phoneNumber) {
        enterPhoneNumber(phoneNumber);
    }

    @Then("New phone number is entered in the phone number field")
    public void newPhoneNumberIsEnteredInThePhoneNumberField() {
        verifyPhoneNumberEntered();
    }

    @When("User saves the changes")
    public void userSavesTheChanges() {
        saveChanges();
    }

    @Then("Changes are saved successfully")
    public void changesAreSavedSuccessfully() {
        verifyChangesSaved();
    }

    @Then("Profile page displays the updated name, email, and phone number")
    public void profilePageDisplaysTheUpdatedNameEmailAndPhoneNumber() {
        verifyUpdatedProfileDetails();
    }

    @When("User logs out and logs back in")
    public void userLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("User is successfully logged in again")
    public void userIsSuccessfullyLoggedInAgain() {
        verifySuccessfulLogin();
    }

    @Then("Profile page still displays the updated name, email, and phone number")
    public void profilePageStillDisplaysTheUpdatedNameEmailAndPhoneNumber() {
        verifyUpdatedProfileDetails();
    }

    @When("User checks the email inbox for confirmation email")
    public void userChecksTheEmailInboxForConfirmationEmail() {
        checkEmailInboxForConfirmation();
    }

    @Then("User receives a confirmation email about the email change")
    public void userReceivesAConfirmationEmailAboutTheEmailChange() {
        verifyConfirmationEmailReceived();
    }

    @When("User checks the phone for confirmation SMS")
    public void userChecksThePhoneForConfirmationSMS() {
        checkPhoneForConfirmationSMS();
    }

    @Then("User receives a confirmation SMS about the phone number change")
    public void userReceivesAConfirmationSMSAboutThePhoneNumberChange() {
        verifyConfirmationSMSReceived();
    }

    @Then("Account settings display the updated name, email, and phone number")
    public void accountSettingsDisplayTheUpdatedNameEmailAndPhoneNumber() {
        verifyUpdatedAccountSettings();
    }

    @When("User logs in using the updated email address")
    public void userLogsInUsingTheUpdatedEmailAddress() {
        loginWithUpdatedEmail();
    }

    @Then("User can log in using the updated email address")
    public void userCanLogInUsingTheUpdatedEmailAddress() {
        verifyLoginWithUpdatedEmail();
    }

    @When("User verifies that the updated phone number can receive SMS notifications")
    public void userVerifiesThatTheUpdatedPhoneNumberCanReceiveSMSNotifications() {
        verifySMSNotificationsOnUpdatedPhoneNumber();
    }

    @Then("User can receive SMS notifications on the updated phone number")
    public void userCanReceiveSMSNotificationsOnTheUpdatedPhoneNumber() {
        verifySMSNotificationsReceived();
    }
}