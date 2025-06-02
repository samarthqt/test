package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.LanguageSettingsPage;

public class LanguageSupportSteps extends LanguageSettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        launchLoginPage();
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyUserLoggedIn();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        theUserIsOnTheLoginPage();
        theUserLogsInWithValidCredentials();
    }

    @When("the user navigates to the language settings page")
    public void theUserNavigatesToTheLanguageSettingsPage() {
        navigateToLanguageSettings();
    }

    @Then("the language settings page is displayed")
    public void theLanguageSettingsPageIsDisplayed() {
        verifyLanguageSettingsPageDisplayed();
    }

    @Given("the user is on the language settings page")
    public void theUserIsOnTheLanguageSettingsPage() {
        theUserIsLoggedIn();
        theUserNavigatesToTheLanguageSettingsPage();
    }

    @When("the user selects a different language from the default")
    public void theUserSelectsADifferentLanguageFromTheDefault() {
        selectDifferentLanguage();
    }

    @Then("the language selection is updated")
    public void theLanguageSelectionIsUpdated() {
        verifyLanguageSelectionUpdated();
    }

    @Given("the user has selected a different language")
    public void theUserHasSelectedADifferentLanguage() {
        theUserIsOnTheLanguageSettingsPage();
        theUserSelectsADifferentLanguageFromTheDefault();
    }

    @When("the user navigates through the application")
    public void theUserNavigatesThroughTheApplication() {
        navigateThroughApplication();
    }

    @Then("the application interface is displayed in the selected language")
    public void theApplicationInterfaceIsDisplayedInTheSelectedLanguage() {
        verifyInterfaceInSelectedLanguage();
    }

    @Given("the application interface is displayed in the selected language")
    public void theApplicationInterfaceIsDisplayedInTheSelectedLanguage() {
        theUserHasSelectedADifferentLanguage();
        theUserNavigatesThroughTheApplication();
    }

    @When("the user checks the menu items")
    public void theUserChecksTheMenuItems() {
        checkMenuItems();
    }

    @Then("all menu items are correctly translated")
    public void allMenuItemsAreCorrectlyTranslated() {
        verifyMenuItemsTranslation();
    }

    @When("an error occurs")
    public void anErrorOccurs() {
        triggerError();
    }

    @Then("error messages are displayed in the selected language")
    public void errorMessagesAreDisplayedInTheSelectedLanguage() {
        verifyErrorMessagesTranslation();
    }

    @When("the user accesses help and support sections")
    public void theUserAccessesHelpAndSupportSections() {
        accessHelpAndSupport();
    }

    @Then("help and support sections are correctly translated")
    public void helpAndSupportSectionsAreCorrectlyTranslated() {
        verifyHelpAndSupportTranslation();
    }

    @When("the user views user-submitted content")
    public void theUserViewsUserSubmittedContent() {
        viewUserSubmittedContent();
    }

    @Then("user-submitted content remains in the original language")
    public void userSubmittedContentRemainsInTheOriginalLanguage() {
        verifyUserContentOriginalLanguage();
    }

    @Given("the user has selected a language")
    public void theUserHasSelectedALanguage() {
        theUserIsOnTheLanguageSettingsPage();
        theUserSelectsADifferentLanguageFromTheDefault();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLoginAgain();
    }

    @Then("the selected language persists after re-login")
    public void theSelectedLanguagePersistsAfterReLogin() {
        verifyLanguagePersistenceAfterReLogin();
    }

    @When("the user accesses the application on different devices")
    public void theUserAccessesTheApplicationOnDifferentDevices() {
        accessApplicationOnDifferentDevices();
    }

    @Then("language settings are consistent across different devices")
    public void languageSettingsAreConsistentAcrossDifferentDevices() {
        verifyLanguageConsistencyAcrossDevices();
    }

    @When("the user accesses the application on different browsers")
    public void theUserAccessesTheApplicationOnDifferentBrowsers() {
        accessApplicationOnDifferentBrowsers();
    }

    @Then("language settings are consistent across different browsers")
    public void languageSettingsAreConsistentAcrossDifferentBrowsers() {
        verifyLanguageConsistencyAcrossBrowsers();
    }

    @When("the user accesses the mobile app")
    public void theUserAccessesTheMobileApp() {
        accessMobileApp();
    }

    @Then("language settings are accessible on the mobile app")
    public void languageSettingsAreAccessibleOnTheMobileApp() {
        verifyLanguageAccessibilityOnMobileApp();
    }

    @Then("there are no missing translations in the selected language")
    public void thereAreNoMissingTranslationsInTheSelectedLanguage() {
        verifyNoMissingTranslations();
    }

    @When("the user uses the application")
    public void theUserUsesTheApplication() {
        useApplication();
    }

    @Then("application performance remains unaffected by language selection")
    public void applicationPerformanceRemainsUnaffectedByLanguageSelection() {
        verifyApplicationPerformance();
    }

    @When("the user switches back to the default language")
    public void theUserSwitchesBackToTheDefaultLanguage() {
        switchToDefaultLanguage();
    }

    @Then("the language can be switched back to the default successfully")
    public void theLanguageCanBeSwitchedBackToTheDefaultSuccessfully() {
        verifySwitchBackToDefaultLanguage();
    }
}