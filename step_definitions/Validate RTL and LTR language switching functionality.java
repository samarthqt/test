package com.cucumber.steps;

import com.page_objects.LanguageSettingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LanguageSwitchSteps extends LanguageSettingsPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the language settings")
    public void theUserNavigatesToTheLanguageSettings() {
        navigateToLanguageSettings();
    }

    @Then("the language settings screen is displayed")
    public void theLanguageSettingsScreenIsDisplayed() {
        verifyLanguageSettingsScreenDisplayed();
    }

    @Given("the user is on the language settings screen")
    public void theUserIsOnTheLanguageSettingsScreen() {
        verifyLanguageSettingsScreenDisplayed();
    }

    @When("the user selects English \(LTR\) as the current language")
    public void theUserSelectsEnglishLTRAsTheCurrentLanguage() {
        selectLanguage("English");
    }

    @Then("the application interface updates to display in English")
    public void theApplicationInterfaceUpdatesToDisplayInEnglish() {
        verifyInterfaceLanguage("English");
    }

    @Given("the application interface is in English \(LTR\)")
    public void theApplicationInterfaceIsInEnglishLTR() {
        verifyInterfaceLanguage("English");
    }

    @Then("all text is aligned to the left")
    public void allTextIsAlignedToTheLeft() {
        verifyTextAlignment("left");
    }

    @Then("navigation is from left to right")
    public void navigationIsFromLeftToRight() {
        verifyNavigationDirection("LTR");
    }

    @When("the user switches the language setting to Arabic \(RTL\)")
    public void theUserSwitchesTheLanguageSettingToArabicRTL() {
        selectLanguage("Arabic");
    }

    @Then("the application interface updates to display in Arabic")
    public void theApplicationInterfaceUpdatesToDisplayInArabic() {
        verifyInterfaceLanguage("Arabic");
    }

    @Given("the application interface is in Arabic \(RTL\)")
    public void theApplicationInterfaceIsInArabicRTL() {
        verifyInterfaceLanguage("Arabic");
    }

    @Then("all text is aligned to the right")
    public void allTextIsAlignedToTheRight() {
        verifyTextAlignment("right");
    }

    @Then("navigation is from right to left")
    public void navigationIsFromRightToLeft() {
        verifyNavigationDirection("RTL");
    }

    @When("the user navigates through different application modules")
    public void theUserNavigatesThroughDifferentApplicationModules() {
        navigateThroughModules();
    }

    @Then("all modules are accessible and display correctly in RTL format")
    public void allModulesAreAccessibleAndDisplayCorrectlyInRTLFormat() {
        verifyModulesDisplayCorrectly("RTL");
    }

    @When("the user switches back to English \(LTR\)")
    public void theUserSwitchesBackToEnglishLTR() {
        selectLanguage("English");
    }

    @Then("the application returns to LTR format with no loss of functionality")
    public void theApplicationReturnsToLTRFormatWithNoLossOfFunctionality() {
        verifyInterfaceLanguage("English");
        verifyFunctionalityIntact();
    }

    @Given("the application interface is switched between languages")
    public void theApplicationInterfaceIsSwitchedBetweenLanguages() {
        switchLanguages();
    }

    @Then("all user data remains consistent and accessible")
    public void allUserDataRemainsConsistentAndAccessible() {
        verifyUserDataConsistency();
    }

    @Given("the application supports both RTL and LTR modes")
    public void theApplicationSupportsBothRTLandLTRModes() {
        verifyLanguageSupport();
    }

    @Then("navigation and functionality remain intact in both modes")
    public void navigationAndFunctionalityRemainIntactInBothModes() {
        verifyNavigationAndFunctionality();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the selected language persists after logout and login")
    public void theSelectedLanguagePersistsAfterLogoutAndLogin() {
        verifyLanguagePersistence();
    }

    @Then("input fields reflect the correct text direction based on language setting")
    public void inputFieldsReflectTheCorrectTextDirectionBasedOnLanguageSetting() {
        verifyInputFieldsTextDirection();
    }

    @Then("error messages and alerts are displayed correctly in the selected language")
    public void errorMessagesAndAlertsAreDisplayedCorrectlyInTheSelectedLanguage() {
        verifyErrorMessagesAndAlerts();
    }

    @Then("application layout remains responsive and intact during and after language switch")
    public void applicationLayoutRemainsResponsiveAndIntactDuringAndAfterLanguageSwitch() {
        verifyLayoutResponsiveness();
    }

    @Then("language switch functions correctly across various devices and screen sizes")
    public void languageSwitchFunctionsCorrectlyAcrossVariousDevicesAndScreenSizes() {
        verifyLanguageSwitchOnDevices();
    }

    @Then("session and security settings remain unaffected by language switch")
    public void sessionAndSecuritySettingsRemainUnaffectedByLanguageSwitch() {
        verifySessionAndSecuritySettings();
    }
}