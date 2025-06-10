package com.cucumber.steps;

import com.page_objects.AccountPreferencesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountPreferencesSteps extends AccountPreferencesPage {

    @Given("the user is on the account preferences page")
    public void theUserIsOnTheAccountPreferencesPage() {
        navigateToAccountPreferencesPage();
    }

    @When("the user updates the notification settings")
    public void theUserUpdatesTheNotificationSettings() {
        updateNotificationSettings();
    }

    @Then("the system provides a confirmation message for successful update")
    public void theSystemProvidesAConfirmationMessageForSuccessfulUpdate() {
        verifyConfirmationMessage();
    }

    @Then("the changes are stored and reflected immediately in the user profile")
    public void theChangesAreStoredAndReflectedImmediatelyInTheUserProfile() {
        verifyChangesReflectedInUserProfile();
    }

    @When("the user changes the privacy settings")
    public void theUserChangesThePrivacySettings() {
        changePrivacySettings();
    }

    @When("the user updates personal information such as name, email, and phone number")
    public void theUserUpdatesPersonalInformationSuchAsNameEmailAndPhoneNumber() {
        updatePersonalInformation();
    }

    @When("the user enters invalid inputs")
    public void theUserEntersInvalidInputs() {
        enterInvalidInputs();
    }

    @Then("error messages are displayed")
    public void errorMessagesAreDisplayed() {
        verifyErrorMessagesDisplayed();
    }

    @Given("the user has updated account preferences")
    public void theUserHasUpdatedAccountPreferences() {
        updateAccountPreferences();
    }

    @When("the changes are saved")
    public void theChangesAreSaved() {
        saveChanges();
    }

    @Then("user preferences are saved securely and comply with privacy regulations")
    public void userPreferencesAreSavedSecurelyAndComplyWithPrivacyRegulations() {
        verifyPreferencesSavedSecurely();
    }

    @When("the user resets preferences to default settings")
    public void theUserResetsPreferencesToDefaultSettings() {
        resetPreferencesToDefault();
    }

    @Then("the system provides a confirmation message for successful reset")
    public void theSystemProvidesAConfirmationMessageForSuccessfulReset() {
        verifyResetConfirmationMessage();
    }

    @When("the user interacts with the interface")
    public void theUserInteractsWithTheInterface() {
        interactWithInterface();
    }

    @Then("the interface is intuitive and user-friendly")
    public void theInterfaceIsIntuitiveAndUserFriendly() {
        verifyInterfaceIntuitiveAndUserFriendly();
    }

    @Then("logs are generated for changes made to account preferences")
    public void logsAreGeneratedForChangesMadeToAccountPreferences() {
        verifyLogsGeneratedForChanges();
    }
}