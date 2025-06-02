package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PrivacySettingsPage;

public class PrivacySettingsSteps extends PrivacySettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("the user has existing privacy settings")
    public void theUserHasExistingPrivacySettings() {
        verifyExistingPrivacySettings();
    }

    @When("the user navigates to the user settings page")
    public void theUserNavigatesToTheUserSettingsPage() {
        navigateToUserSettingsPage();
    }

    @Then("the user settings page is displayed")
    public void theUserSettingsPageIsDisplayed() {
        verifyUserSettingsPageDisplayed();
    }

    @Given("the user is on the user settings page")
    public void theUserIsOnTheUserSettingsPage() {
        verifyUserSettingsPageDisplayed();
    }

    @When("the user clicks on 'Privacy Settings'")
    public void theUserClicksOnPrivacySettings() {
        clickOnPrivacySettings();
    }

    @Then("the privacy settings options are displayed")
    public void thePrivacySettingsOptionsAreDisplayed() {
        verifyPrivacySettingsOptionsDisplayed();
    }

    @Given("the privacy settings options are displayed")
    public void thePrivacySettingsOptionsAreDisplayedGiven() {
        verifyPrivacySettingsOptionsDisplayed();
    }

    @When("the user selects 'Data Sharing' option")
    public void theUserSelectsDataSharingOption() {
        selectDataSharingOption();
    }

    @When("the user enables data sharing")
    public void theUserEnablesDataSharing() {
        enableDataSharing();
    }

    @When("the user sets privacy level to 'High'")
    public void theUserSetsPrivacyLevelToHigh() {
        setPrivacyLevelToHigh();
    }

    @When("the user clicks 'Save Changes'")
    public void theUserClicksSaveChanges() {
        clickSaveChanges();
    }

    @Then("the changes are saved successfully")
    public void theChangesAreSavedSuccessfully() {
        verifyChangesSavedSuccessfully();
    }

    @Then("a confirmation message 'Privacy settings updated successfully' is displayed")
    public void aConfirmationMessageIsDisplayed() {
        verifyConfirmationMessageDisplayed();
    }

    @Given("the user has updated privacy settings")
    public void theUserHasUpdatedPrivacySettings() {
        verifyUpdatedPrivacySettings();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @When("the user navigates back to 'Privacy Settings'")
    public void theUserNavigatesBackToPrivacySettings() {
        navigateBackToPrivacySettings();
    }

    @Then("the privacy settings reflect the updated preferences")
    public void thePrivacySettingsReflectTheUpdatedPreferences() {
        verifyPrivacySettingsReflectUpdatedPreferences();
    }

    @Given("the user is on the privacy settings page")
    public void theUserIsOnThePrivacySettingsPage() {
        verifyPrivacySettingsPageDisplayed();
    }

    @When("the user attempts to disable data sharing without saving")
    public void theUserAttemptsToDisableDataSharingWithoutSaving() {
        attemptToDisableDataSharingWithoutSaving();
    }

    @Then("no changes occur without saving")
    public void noChangesOccurWithoutSaving() {
        verifyNoChangesWithoutSaving();
    }

    @Given("an unauthorized user is logged into the application")
    public void anUnauthorizedUserIsLoggedIntoTheApplication() {
        loginAsUnauthorizedUser();
    }

    @When("the unauthorized user attempts to edit privacy settings")
    public void theUnauthorizedUserAttemptsToEditPrivacySettings() {
        attemptToEditPrivacySettingsAsUnauthorizedUser();
    }

    @Then("the unauthorized user cannot edit privacy settings")
    public void theUnauthorizedUserCannotEditPrivacySettings() {
        verifyUnauthorizedUserCannotEditPrivacySettings();
    }

    @Given("the user has enabled data sharing")
    public void theUserHasEnabledDataSharing() {
        verifyDataSharingEnabled();
    }

    @When("the system logs are checked")
    public void theSystemLogsAreChecked() {
        checkSystemLogs();
    }

    @Then("the logs reflect data sharing activity accurately")
    public void theLogsReflectDataSharingActivityAccurately() {
        verifyLogsReflectDataSharingActivity();
    }

    @When("the system is evaluated for data protection compliance")
    public void theSystemIsEvaluatedForDataProtectionCompliance() {
        evaluateSystemForDataProtectionCompliance();
    }

    @Then("the system complies with data protection regulations")
    public void theSystemCompliesWithDataProtectionRegulations() {
        verifySystemComplianceWithDataProtection();
    }

    @Given("a user with a lower privilege account is logged into the application")
    public void aUserWithALowerPrivilegeAccountIsLoggedIntoTheApplication() {
        loginAsLowerPrivilegeUser();
    }

    @When("the user attempts to change privacy settings")
    public void theUserAttemptsToChangePrivacySettings() {
        attemptToChangePrivacySettingsAsLowerPrivilegeUser();
    }

    @Then("changes are not allowed with lower privilege accounts")
    public void changesAreNotAllowedWithLowerPrivilegeAccounts() {
        verifyChangesNotAllowedForLowerPrivilege();
    }

    @Given("conflicting privacy settings are introduced")
    public void conflictingPrivacySettingsAreIntroduced() {
        introduceConflictingPrivacySettings();
    }

    @When("the system processes the settings")
    public void theSystemProcessesTheSettings() {
        processPrivacySettings();
    }

    @Then("the system resolves conflicts appropriately")
    public void theSystemResolvesConflictsAppropriately() {
        verifySystemResolvesConflicts();
    }
}