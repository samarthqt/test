package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.NotificationSettingsPage;

public class NotificationSettingsSteps extends NotificationSettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("the user has existing notification settings")
    public void theUserHasExistingNotificationSettings() {
        verifyExistingNotificationSettings();
    }

    @When("the user navigates to the user settings page")
    public void theUserNavigatesToTheUserSettingsPage() {
        navigateToUserSettingsPage();
    }

    @Then("the user settings page is displayed")
    public void theUserSettingsPageIsDisplayed() {
        verifyUserSettingsPageDisplayed();
    }

    @When("the user clicks on 'Notification Settings'")
    public void theUserClicksOnNotificationSettings() {
        clickNotificationSettings();
    }

    @Then("notification settings options are displayed")
    public void notificationSettingsOptionsAreDisplayed() {
        verifyNotificationSettingsOptionsDisplayed();
    }

    @When("the user selects 'Email' preference")
    public void theUserSelectsEmailPreference() {
        selectEmailPreference();
    }

    @Then("the email preference is selected")
    public void theEmailPreferenceIsSelected() {
        verifyEmailPreferenceSelected();
    }

    @When("the user enters the email address 'user@example.com'")
    public void theUserEntersTheEmailAddress() {
        enterEmailAddress("user@example.com");
    }

    @Then("the email address is entered without errors")
    public void theEmailAddressIsEnteredWithoutErrors() {
        verifyEmailAddressEntered();
    }

    @When("the user selects 'SMS' preference")
    public void theUserSelectsSMSPreference() {
        selectSMSPreference();
    }

    @Then("the SMS preference is selected")
    public void theSMSPreferenceIsSelected() {
        verifySMSPreferenceSelected();
    }

    @When("the user enters the SMS number '+1234567890'")
    public void theUserEntersTheSMSNumber() {
        enterSMSNumber("+1234567890");
    }

    @Then("the SMS number is entered without errors")
    public void theSMSNumberIsEnteredWithoutErrors() {
        verifySMSNumberEntered();
    }

    @When("the user chooses notification frequency as 'Weekly'")
    public void theUserChoosesNotificationFrequencyAsWeekly() {
        chooseNotificationFrequency("Weekly");
    }

    @Then("the notification frequency is set to weekly")
    public void theNotificationFrequencyIsSetToWeekly() {
        verifyNotificationFrequencySet("Weekly");
    }

    @When("the user clicks 'Save Changes'")
    public void theUserClicksSaveChanges() {
        clickSaveChanges();
    }

    @Then("the changes are saved successfully")
    public void theChangesAreSavedSuccessfully() {
        verifyChangesSavedSuccessfully();
    }

    @Then("the confirmation message 'Settings updated successfully' is displayed")
    public void theConfirmationMessageIsDisplayed() {
        verifyConfirmationMessageDisplayed("Settings updated successfully");
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the user is logged back into the application")
    public void theUserIsLoggedBackIntoTheApplication() {
        verifyUserLoggedBackIn();
    }

    @When("the user navigates back to 'Notification Settings'")
    public void theUserNavigatesBackToNotificationSettings() {
        navigateBackToNotificationSettings();
    }

    @Then("the notification settings reflect the updated preferences")
    public void theNotificationSettingsReflectTheUpdatedPreferences() {
        verifyUpdatedNotificationSettings();
    }

    @When("the user checks email inbox for notification test email")
    public void theUserChecksEmailInboxForNotificationTestEmail() {
        checkEmailInboxForTestEmail();
    }

    @Then("the test email is received in the inbox")
    public void theTestEmailIsReceivedInTheInbox() {
        verifyTestEmailReceived();
    }

    @When("the user checks SMS inbox for notification test SMS")
    public void theUserChecksSMSInboxForNotificationTestSMS() {
        checkSMSInboxForTestSMS();
    }

    @Then("the test SMS is received on the phone")
    public void theTestSMSIsReceivedOnThePhone() {
        verifyTestSMSReceived();
    }

    @When("the user attempts to change preferences again without saving")
    public void theUserAttemptsToChangePreferencesAgainWithoutSaving() {
        attemptToChangePreferencesWithoutSaving();
    }

    @Then("no changes occur without saving")
    public void noChangesOccurWithoutSaving() {
        verifyNoChangesWithoutSaving();
    }

    @Then("unauthorized users cannot edit notification settings")
    public void unauthorizedUsersCannotEditNotificationSettings() {
        verifyUnauthorizedUsersCannotEditSettings();
    }
}