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

    @Given("the user navigates to the user settings page")
    public void theUserNavigatesToTheUserSettingsPage() {
        navigateToUserSettingsPage();
    }

    @Given("the user has existing preferences")
    public void theUserHasExistingPreferences() {
        verifyExistingPreferences();
    }

    @When("the user clicks on 'Notification Settings'")
    public void theUserClicksOnNotificationSettings() {
        clickNotificationSettings();
    }

    @When("the user enters invalid email format 'invalid-email'")
    public void theUserEntersInvalidEmailFormat() {
        enterEmail("invalid-email");
    }

    @Then("the system displays an error message for invalid email format")
    public void theSystemDisplaysAnErrorMessageForInvalidEmailFormat() {
        verifyEmailFormatErrorMessage();
    }

    @Given("the user is on the notification settings page")
    public void theUserIsOnTheNotificationSettingsPage() {
        navigateToNotificationSettingsPage();
    }

    @When("the user enters invalid SMS number '12345'")
    public void theUserEntersInvalidSMSNumber() {
        enterSMSNumber("12345");
    }

    @Then("the system displays an error message for invalid SMS number")
    public void theSystemDisplaysAnErrorMessageForInvalidSMSNumber() {
        verifySMSNumberErrorMessage();
    }

    @When("the user sets notification frequency to 'Daily'")
    public void theUserSetsNotificationFrequencyToDaily() {
        setNotificationFrequency("Daily");
    }

    @Then("the notification frequency is set to daily")
    public void theNotificationFrequencyIsSetToDaily() {
        verifyNotificationFrequencySetToDaily();
    }

    @Given("the user has entered invalid email and SMS number")
    public void theUserHasEnteredInvalidEmailAndSMSNumber() {
        enterEmail("invalid-email");
        enterSMSNumber("12345");
    }

    @When("the user clicks 'Save Changes'")
    public void theUserClicksSaveChanges() {
        clickSaveChanges();
    }

    @Then("the system prevents saving due to invalid data formats")
    public void theSystemPreventsSavingDueToInvalidDataFormats() {
        verifySavePreventedDueToInvalidData();
    }

    @Then("error messages are displayed for invalid email and SMS number")
    public void errorMessagesAreDisplayedForInvalidEmailAndSMSNumber() {
        verifyEmailFormatErrorMessage();
        verifySMSNumberErrorMessage();
    }

    @When("the user attempts to save changes again")
    public void theUserAttemptsToSaveChangesAgain() {
        clickSaveChanges();
    }

    @Then("the system continues to prevent saving due to invalid data formats")
    public void theSystemContinuesToPreventSavingDueToInvalidDataFormats() {
        verifySavePreventedDueToInvalidData();
    }

    @Given("the user enters valid email and SMS data")
    public void theUserEntersValidEmailAndSMSData() {
        enterEmail("valid@example.com");
        enterSMSNumber("1234567890");
    }

    @When("the user clicks 'Save Changes' with valid data")
    public void theUserClicksSaveChangesWithValidData() {
        clickSaveChanges();
    }

    @Then("changes are saved successfully")
    public void changesAreSavedSuccessfully() {
        verifyChangesSavedSuccessfully();
    }

    @Then("a confirmation message 'Settings updated successfully' is displayed")
    public void aConfirmationMessageIsDisplayed() {
        verifyConfirmationMessage();
    }

    @When("the user tests system behavior with unsupported notification frequency")
    public void theUserTestsSystemBehaviorWithUnsupportedNotificationFrequency() {
        setNotificationFrequency("Unsupported");
    }

    @Then("the system displays an error message for unsupported frequency")
    public void theSystemDisplaysAnErrorMessageForUnsupportedFrequency() {
        verifyUnsupportedFrequencyErrorMessage();
    }

    @When("the user attempts to enter non-numeric SMS number")
    public void theUserAttemptsToEnterNonNumericSMSNumber() {
        enterSMSNumber("non-numeric");
    }

    @Then("the system displays an error message for non-numeric SMS number")
    public void theSystemDisplaysAnErrorMessageForNonNumericSMSNumber() {
        verifyNonNumericSMSNumberErrorMessage();
    }

    @Given("the user has attempted to save changes with invalid data formats")
    public void theUserHasAttemptedToSaveChangesWithInvalidDataFormats() {
        enterEmail("invalid-email");
        enterSMSNumber("12345");
        clickSaveChanges();
    }

    @When("the user checks system logs for failed update attempts")
    public void theUserChecksSystemLogsForFailedUpdateAttempts() {
        checkSystemLogsForFailedAttempts();
    }

    @Then("logs reflect failed attempts accurately")
    public void logsReflectFailedAttemptsAccurately() {
        verifyLogsForFailedAttempts();
    }

    @Given("the user encounters error messages for invalid inputs")
    public void theUserEncountersErrorMessagesForInvalidInputs() {
        enterEmail("invalid-email");
        enterSMSNumber("12345");
        clickSaveChanges();
    }

    @Then("the error messages provide clear guidance on corrections")
    public void theErrorMessagesProvideClearGuidanceOnCorrections() {
        verifyUserFriendlyErrorMessages();
    }
}