package com.cucumber.steps;

import com.page_objects.UserSettingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSettingsSteps extends UserSettingsPage {

    @Given("User is logged into the application")
    public void userIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("User navigates to the user settings page")
    public void userNavigatesToTheUserSettingsPage() {
        navigateToUserSettingsPage();
    }

    @Then("User settings page is displayed")
    public void userSettingsPageIsDisplayed() {
        verifyUserSettingsPageDisplayed();
    }

    @Then("Language selection feature is enabled")
    public void languageSelectionFeatureIsEnabled() {
        verifyLanguageSelectionEnabled();
    }

    @Given("User is on the user settings page")
    public void userIsOnTheUserSettingsPage() {
        verifyUserSettingsPageDisplayed();
    }

    @When("User locates the language selection dropdown")
    public void userLocatesTheLanguageSelectionDropdown() {
        locateLanguageSelectionDropdown();
    }

    @Then("Language selection dropdown is visible")
    public void languageSelectionDropdownIsVisible() {
        verifyLanguageDropdownVisible();
    }

    @Given("User is viewing the language selection dropdown")
    public void userIsViewingTheLanguageSelectionDropdown() {
        verifyLanguageDropdownVisible();
    }

    @When("User attempts to select 'Klingon' from the dropdown")
    public void userAttemptsToSelectKlingonFromTheDropdown() {
        attemptToSelectUnsupportedLanguage("Klingon");
    }

    @Then("System does not allow selection of unsupported language")
    public void systemDoesNotAllowSelectionOfUnsupportedLanguage() {
        verifyUnsupportedLanguageSelectionNotAllowed();
    }

    @Given("User attempted to select an unsupported language")
    public void userAttemptedToSelectAnUnsupportedLanguage() {
        attemptToSelectUnsupportedLanguage("Klingon");
    }

    @When("User checks for error messages")
    public void userChecksForErrorMessages() {
        checkForErrorMessages();
    }

    @Then("Appropriate error message is displayed indicating unsupported language")
    public void appropriateErrorMessageIsDisplayedIndicatingUnsupportedLanguage() {
        verifyErrorMessageDisplayed();
    }

    @Given("User has selected an unsupported language")
    public void userHasSelectedAnUnsupportedLanguage() {
        attemptToSelectUnsupportedLanguage("Klingon");
    }

    @When("User attempts to save changes")
    public void userAttemptsToSaveChanges() {
        attemptToSaveChanges();
    }

    @Then("Changes are not saved")
    public void changesAreNotSaved() {
        verifyChangesNotSaved();
    }

    @Then("User is prompted to select a supported language")
    public void userIsPromptedToSelectASupportedLanguage() {
        verifyPromptToSelectSupportedLanguage();
    }

    @Given("User selects a supported language")
    public void userSelectsASupportedLanguage() {
        selectSupportedLanguage();
    }

    @When("User saves changes")
    public void userSavesChanges() {
        saveChanges();
    }

    @Then("Changes are saved successfully with a supported language")
    public void changesAreSavedSuccessfullyWithASupportedLanguage() {
        verifyChangesSavedSuccessfully();
    }

    @Given("User has saved changes with a supported language")
    public void userHasSavedChangesWithASupportedLanguage() {
        saveChanges();
    }

    @When("User refreshes the page or navigates to another page")
    public void userRefreshesThePageOrNavigatesToAnotherPage() {
        refreshOrNavigateToAnotherPage();
    }

    @Then("Interface text is displayed in the selected supported language")
    public void interfaceTextIsDisplayedInTheSelectedSupportedLanguage() {
        verifyInterfaceTextInSupportedLanguage();
    }

    @Given("User is logged in with a supported language")
    public void userIsLoggedInWithASupportedLanguage() {
        loginToApplicationWithSupportedLanguage();
    }

    @When("User logs out and logs back into the application")
    public void userLogsOutAndLogsBackIntoTheApplication() {
        logoutAndLogin();
    }

    @Then("Login page and subsequent pages are displayed in the selected supported language")
    public void loginPageAndSubsequentPagesAreDisplayedInTheSelectedSupportedLanguage() {
        verifyPagesInSupportedLanguage();
    }

    @Given("User is logged in")
    public void userIsLoggedIn() {
        loginToApplication();
    }

    @When("User attempts to manually change URL parameters to set an unsupported language")
    public void userAttemptsToManuallyChangeURLParametersToSetAnUnsupportedLanguage() {
        attemptURLManipulationForUnsupportedLanguage();
    }

    @Then("System prevents setting of unsupported language via URL manipulation")
    public void systemPreventsSettingOfUnsupportedLanguageViaURLManipulation() {
        verifyURLManipulationPrevention();
    }

    @Given("User attempted to set an unsupported language")
    public void userAttemptedToSetAnUnsupportedLanguage() {
        attemptToSelectUnsupportedLanguage("Klingon");
    }

    @When("User checks the default language setting")
    public void userChecksTheDefaultLanguageSetting() {
        checkDefaultLanguageSetting();
    }

    @Then("System reverts to default language setting")
    public void systemRevertsToDefaultLanguageSetting() {
        verifyDefaultLanguageSetting();
    }

    @Given("User is logged in")
    public void userIsLoggedInAgain() {
        loginToApplication();
    }

    @When("User checks the language settings in the user profile")
    public void userChecksTheLanguageSettingsInTheUserProfile() {
        checkLanguageSettingsInUserProfile();
    }

    @Then("Language settings reflect a supported language")
    public void languageSettingsReflectASupportedLanguage() {
        verifyLanguageSettingsReflectSupportedLanguage();
    }

    @Given("User has selected a supported language")
    public void userHasSelectedASupportedLanguageAgain() {
        selectSupportedLanguage();
    }

    @When("User performs a product search")
    public void userPerformsAProductSearch() {
        performProductSearch();
    }

    @Then("Search results are displayed in the supported language")
    public void searchResultsAreDisplayedInTheSupportedLanguage() {
        verifySearchResultsInSupportedLanguage();
    }

    @Given("User is logged in with a supported language")
    public void userIsLoggedInWithASupportedLanguageAgain() {
        loginToApplicationWithSupportedLanguage();
    }

    @When("User navigates to the help section")
    public void userNavigatesToTheHelpSection() {
        navigateToHelpSection();
    }

    @Then("Help section is displayed in the supported language")
    public void helpSectionIsDisplayedInTheSupportedLanguage() {
        verifyHelpSectionInSupportedLanguage();
    }

    @Given("User is on the language selection page")
    public void userIsOnTheLanguageSelectionPage() {
        navigateToLanguageSelectionPage();
    }

    @When("User attempts to select multiple unsupported languages simultaneously")
    public void userAttemptsToSelectMultipleUnsupportedLanguagesSimultaneously() {
        attemptToSelectMultipleUnsupportedLanguages();
    }

    @Then("System does not allow selection of multiple unsupported languages")
    public void systemDoesNotAllowSelectionOfMultipleUnsupportedLanguages() {
        verifyMultipleUnsupportedLanguagesSelectionNotAllowed();
    }

    @Given("User attempted unsupported language selection")
    public void userAttemptedUnsupportedLanguageSelection() {
        attemptToSelectUnsupportedLanguage("Klingon");
    }

    @When("User verifies system logs")
    public void userVerifiesSystemLogs() {
        verifySystemLogs();
    }

    @Then("System logs indicate handling of unsupported language selection without errors")
    public void systemLogsIndicateHandlingOfUnsupportedLanguageSelectionWithoutErrors() {
        verifySystemLogsForUnsupportedLanguageSelection();
    }
}