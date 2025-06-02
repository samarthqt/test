package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.UserSettingsPage;

public class UserSettingsSteps extends UserSettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the user settings page")
    public void theUserNavigatesToTheUserSettingsPage() {
        navigateToUserSettings();
    }

    @Then("the user settings page is displayed")
    public void theUserSettingsPageIsDisplayed() {
        verifyUserSettingsPageDisplayed();
    }

    @And("the user has existing preferences")
    public void theUserHasExistingPreferences() {
        verifyExistingPreferences();
    }

    @When("the user clicks on 'Notification Settings'")
    public void theUserClicksOnNotificationSettings() {
        clickNotificationSettings();
    }

    @Then("notification settings options are displayed")
    public void notificationSettingsOptionsAreDisplayed() {
        verifyNotificationSettingsDisplayed();
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
        selectNotificationFrequency("Weekly");
    }

    @Then("the notification frequency is set to weekly")
    public void theNotificationFrequencyIsSetToWeekly() {
        verifyNotificationFrequencySet();
    }

    @When("the user clicks 'Save Changes'")
    public void theUserClicksSaveChanges() {
        clickSaveChanges();
    }

    @Then("changes are saved successfully")
    public void changesAreSavedSuccessfully() {
        verifyChangesSaved();
    }

    @And("a confirmation message 'Settings updated successfully' is displayed")
    public void aConfirmationMessageIsDisplayed() {
        verifyConfirmationMessageDisplayed();
    }

    @When("the user immediately checks the notification settings page")
    public void theUserImmediatelyChecksTheNotificationSettingsPage() {
        checkNotificationSettingsPage();
    }

    @Then("the updated preferences are reflected immediately")
    public void theUpdatedPreferencesAreReflectedImmediately() {
        verifyPreferencesReflectedImmediately();
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
        verifyNotificationSettingsUpdated();
    }

    @When("the user checks the email inbox for notification test email")
    public void theUserChecksTheEmailInboxForNotificationTestEmail() {
        checkEmailInboxForTestEmail();
    }

    @Then("the test email is received in the inbox")
    public void theTestEmailIsReceivedInTheInbox() {
        verifyTestEmailReceived();
    }

    @When("the user checks the SMS inbox for notification test SMS")
    public void theUserChecksTheSMSInboxForNotificationTestSMS() {
        checkSMSInboxForTestSMS();
    }

    @Then("the test SMS is received on the phone")
    public void theTestSMSIsReceivedOnThePhone() {
        verifyTestSMSReceived();
    }

    @And("ensure immediate reflection of changes across all user devices")
    public void ensureImmediateReflectionOfChangesAcrossAllUserDevices() {
        verifyImmediateReflectionAcrossDevices();
    }

    @Then("changes are synchronized across all devices")
    public void changesAreSynchronizedAcrossAllDevices() {
        verifyChangesSynchronizedAcrossDevices();
    }
}