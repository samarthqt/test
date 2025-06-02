package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProfileSettingsPage;

public class ProfileSettingsSteps extends ProfileSettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with update permissions")
    public void aUserAccountWithUpdatePermissions() {
        // Assume user has permissions
    }

    @When("the user logs in using valid credentials")
    public void theUserLogsInUsingValidCredentials() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @Then("the user should be successfully logged in and directed to the dashboard")
    public void theUserShouldBeSuccessfullyLoggedInAndDirectedToTheDashboard() {
        verifyDashboardDisplayed();
    }

    @Given("the user is on the dashboard")
    public void theUserIsOnTheDashboard() {
        verifyDashboardDisplayed();
    }

    @When("the user navigates to the profile settings page")
    public void theUserNavigatesToTheProfileSettingsPage() {
        navigateToProfileSettings();
    }

    @Then("the profile settings page should be displayed")
    public void theProfileSettingsPageShouldBeDisplayed() {
        verifyProfileSettingsPageDisplayed();
    }

    @Given("the user is on the profile settings page")
    public void theUserIsOnTheProfileSettingsPage() {
        verifyProfileSettingsPageDisplayed();
    }

    @When("the user updates the email address field with a new valid email")
    public void theUserUpdatesTheEmailAddressFieldWithANewValidEmail() {
        String newEmail = testHarness.getData("ProfileData", "NewEmail");
        updateEmailAddress(newEmail);
    }

    @Then("the email field should accept the new email address")
    public void theEmailFieldShouldAcceptTheNewEmailAddress() {
        String expectedEmail = testHarness.getData("ProfileData", "NewEmail");
        verifyEmailAddress(expectedEmail);
    }

    @Given("the user has updated the email address")
    public void theUserHasUpdatedTheEmailAddress() {
        String newEmail = testHarness.getData("ProfileData", "NewEmail");
        updateEmailAddress(newEmail);
    }

    @When("the user clicks on the 'Save Changes' button")
    public void theUserClicksOnTheSaveChangesButton() {
        saveChanges();
    }

    @Then("changes should be saved successfully")
    public void changesShouldBeSavedSuccessfully() {
        verifyChangesSaved();
    }

    @Then("a confirmation message should be displayed indicating successful update")
    public void aConfirmationMessageShouldBeDisplayedIndicatingSuccessfulUpdate() {
        verifyConfirmationMessageDisplayed();
    }

    @Given("the user has saved the changes")
    public void theUserHasSavedTheChanges() {
        saveChanges();
    }

    @When("the user checks the updated email in the profile settings")
    public void theUserChecksTheUpdatedEmailInTheProfileSettings() {
        verifyEmailAddress(testHarness.getData("ProfileData", "NewEmail"));
    }

    @Then("the new email should be displayed in the email field")
    public void theNewEmailShouldBeDisplayedInTheEmailField() {
        verifyEmailAddress(testHarness.getData("ProfileData", "NewEmail"));
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyDashboardDisplayed();
    }

    @When("the user logs out of the account")
    public void theUserLogsOutOfTheAccount() {
        logout();
    }

    @Then("the user should be successfully logged out")
    public void theUserShouldBeSuccessfullyLoggedOut() {
        verifyLoggedOut();
    }

    @When("the user logs back in using the new email address")
    public void theUserLogsBackInUsingTheNewEmailAddress() {
        String newEmail = testHarness.getData("ProfileData", "NewEmail");
        String password = testHarness.getData("LoginData", "Password");
        login(newEmail, password);
    }

    @Then("the user should be able to log in using the updated email")
    public void theUserShouldBeAbleToLogInUsingTheUpdatedEmail() {
        verifyDashboardDisplayed();
    }

    @Given("the user has updated the email address")
    public void theUserHasUpdatedTheEmailAddressAgain() {
        updateEmailAddress(testHarness.getData("ProfileData", "NewEmail"));
    }

    @When("the user checks the inbox for a confirmation email")
    public void theUserChecksTheInboxForAConfirmationEmail() {
        verifyConfirmationEmailReceived();
    }

    @Then("a confirmation email should be received with details of the update")
    public void aConfirmationEmailShouldBeReceivedWithDetailsOfTheUpdate() {
        verifyConfirmationEmailReceived();
    }

    @Given("the user is updating profile information")
    public void theUserIsUpdatingProfileInformation() {
        navigateToProfileSettings();
    }

    @When("the user performs the update")
    public void theUserPerformsTheUpdate() {
        updateEmailAddress(testHarness.getData("ProfileData", "NewEmail"));
    }

    @Then("no error messages should appear during the update process")
    public void noErrorMessagesShouldAppearDuringTheUpdateProcess() {
        verifyNoErrorMessages();
    }

    @Given("the user is on the profile settings page")
    public void theUserIsOnTheProfileSettingsPageAgain() {
        verifyProfileSettingsPageDisplayed();
    }

    @When("the user attempts to update another field")
    public void theUserAttemptsToUpdateAnotherField() {
        updateAnotherField();
    }

    @Then("a confirmation message should appear for each successful update")
    public void aConfirmationMessageShouldAppearForEachSuccessfulUpdate() {
        verifyConfirmationMessageDisplayed();
    }

    @Given("the user has updated profile information")
    public void theUserHasUpdatedProfileInformation() {
        updateEmailAddress(testHarness.getData("ProfileData", "NewEmail"));
    }

    @When("the user checks notifications")
    public void theUserChecksNotifications() {
        verifyNotificationForUpdate();
    }

    @Then("notification should confirm the successful update")
    public void notificationShouldConfirmTheSuccessfulUpdate() {
        verifyNotificationForUpdate();
    }

    @Given("the user has performed an update")
    public void theUserHasPerformedAnUpdate() {
        updateEmailAddress(testHarness.getData("ProfileData", "NewEmail"));
    }

    @When("the system logs are checked")
    public void theSystemLogsAreChecked() {
        verifySystemLogsForUpdate();
    }

    @Then("system logs should record the update action with a timestamp")
    public void systemLogsShouldRecordTheUpdateActionWithATimestamp() {
        verifySystemLogsForUpdate();
    }

    @Given("the user is on the profile settings page")
    public void theUserIsOnTheProfileSettingsPageYetAgain() {
        verifyProfileSettingsPageDisplayed();
    }

    @When("the user attempts to update with invalid data")
    public void theUserAttemptsToUpdateWithInvalidData() {
        attemptUpdateWithInvalidData();
    }

    @Then("no confirmation message should appear")
    public void noConfirmationMessageShouldAppear() {
        verifyNoConfirmationMessage();
    }

    @Then("error handling should activate")
    public void errorHandlingShouldActivate() {
        verifyErrorHandlingActivated();
    }

    @Given("the user receives a confirmation message")
    public void theUserReceivesAConfirmationMessage() {
        verifyConfirmationMessageDisplayed();
    }

    @Then("the confirmation message should clearly state the update was successful")
    public void theConfirmationMessageShouldClearlyStateTheUpdateWasSuccessful() {
        verifyConfirmationMessageClarity();
    }
}