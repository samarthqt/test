package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AdminPanelPage;

public class AdminCustomizationSteps extends AdminPanelPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the admin has access to the system")
    public void theAdminHasAccessToTheSystem() {
        // Assume admin has access
    }

    @When("the admin logs in to the admin panel using valid admin credentials")
    public void theAdminLogsInToTheAdminPanelUsingValidAdminCredentials() {
        String adminUsername = testHarness.getData("AdminData", "AdminUsername");
        String adminPassword = testHarness.getData("AdminData", "AdminPassword");
        loginToAdminPanel(adminUsername, adminPassword);
    }

    @Then("the admin is successfully logged into the system")
    public void theAdminIsSuccessfullyLoggedIntoTheSystem() {
        verifyAdminLoginSuccess();
    }

    @When("the admin navigates to the settings section of the admin panel")
    public void theAdminNavigatesToTheSettingsSectionOfTheAdminPanel() {
        navigateToSettingsSection();
    }

    @Then("the settings section is displayed")
    public void theSettingsSectionIsDisplayed() {
        verifySettingsSectionDisplayed();
    }

    @When("the admin locates the confirmation message customization options")
    public void theAdminLocatesTheConfirmationMessageCustomizationOptions() {
        locateConfirmationMessageCustomizationOptions();
    }

    @Then("the customization options for confirmation messages are visible")
    public void theCustomizationOptionsForConfirmationMessagesAreVisible() {
        verifyCustomizationOptionsVisible();
    }

    @When("the admin selects a confirmation message template to customize")
    public void theAdminSelectsAConfirmationMessageTemplateToCustomize() {
        selectConfirmationMessageTemplate();
    }

    @Then("the selected template is ready for customization")
    public void theSelectedTemplateIsReadyForCustomization() {
        verifyTemplateReadyForCustomization();
    }

    @When("the admin modifies the text of the confirmation message")
    public void theAdminModifiesTheTextOfTheConfirmationMessage() {
        modifyConfirmationMessageText();
    }

    @Then("the text of the confirmation message is updated")
    public void theTextOfTheConfirmationMessageIsUpdated() {
        verifyTextUpdated();
    }

    @When("the admin changes the font style of the confirmation message")
    public void theAdminChangesTheFontStyleOfTheConfirmationMessage() {
        changeFontStyle();
    }

    @Then("the font style is successfully changed")
    public void theFontStyleIsSuccessfullyChanged() {
        verifyFontStyleChanged();
    }

    @When("the admin updates the color scheme of the confirmation message")
    public void theAdminUpdatesTheColorSchemeOfTheConfirmationMessage() {
        updateColorScheme();
    }

    @Then("the color scheme is updated as per the selection")
    public void theColorSchemeIsUpdatedAsPerTheSelection() {
        verifyColorSchemeUpdated();
    }

    @When("the admin saves the changes made to the confirmation message")
    public void theAdminSavesTheChangesMadeToTheConfirmationMessage() {
        saveConfirmationMessageChanges();
    }

    @Then("the changes are saved successfully")
    public void theChangesAreSavedSuccessfully() {
        verifyChangesSaved();
    }

    @When("the admin previews the customized confirmation message")
    public void theAdminPreviewsTheCustomizedConfirmationMessage() {
        previewCustomizedConfirmationMessage();
    }

    @Then("the preview shows the updated confirmation message with all applied customizations")
    public void thePreviewShowsTheUpdatedConfirmationMessageWithAllAppliedCustomizations() {
        verifyPreviewShowsCustomizations();
    }

    @When("the admin reverts the changes to the default confirmation message settings")
    public void theAdminRevertsTheChangesToTheDefaultConfirmationMessageSettings() {
        revertToDefaultSettings();
    }

    @Then("the confirmation message is reverted to default settings")
    public void theConfirmationMessageIsRevertedToDefaultSettings() {
        verifyRevertedToDefault();
    }

    @When("the admin logs out from the admin panel")
    public void theAdminLogsOutFromTheAdminPanel() {
        logoutFromAdminPanel();
    }

    @Then("the admin is logged out successfully")
    public void theAdminIsLoggedOutSuccessfully() {
        verifyAdminLogoutSuccess();
    }

    @Given("the admin has customized the confirmation message")
    public void theAdminHasCustomizedTheConfirmationMessage() {
        // Assume customization is done
    }

    @When("a regular user logs in and performs an action that triggers a confirmation message")
    public void aRegularUserLogsInAndPerformsAnActionThatTriggersAConfirmationMessage() {
        triggerConfirmationMessage();
    }

    @Then("the customized confirmation message is displayed to the user")
    public void theCustomizedConfirmationMessageIsDisplayedToTheUser() {
        verifyCustomizedMessageDisplayed();
    }

    @When("the user verifies the content, font, and color of the confirmation message")
    public void theUserVerifiesTheContentFontAndColorOfTheConfirmationMessage() {
        verifyMessageContentFontAndColor();
    }

    @Then("the confirmation message matches the customizations made by the admin")
    public void theConfirmationMessageMatchesTheCustomizationsMadeByTheAdmin() {
        verifyMessageMatchesCustomizations();
    }

    @When("the user checks if the confirmation message is clear and understandable")
    public void theUserChecksIfTheConfirmationMessageIsClearAndUnderstandable() {
        checkMessageClarity();
    }

    @Then("the confirmation message is clear and provides necessary information")
    public void theConfirmationMessageIsClearAndProvidesNecessaryInformation() {
        verifyMessageClarity();
    }

    @When("the user ensures that the confirmation message is appropriately aligned and formatted")
    public void theUserEnsuresThatTheConfirmationMessageIsAppropriatelyAlignedAndFormatted() {
        ensureMessageAlignmentAndFormatting();
    }

    @Then("the confirmation message is well-aligned and formatted correctly")
    public void theConfirmationMessageIsWellAlignedAndFormattedCorrectly() {
        verifyMessageAlignmentAndFormatting();
    }
}