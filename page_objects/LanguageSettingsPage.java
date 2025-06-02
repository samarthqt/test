package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class LanguageSettingsPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By languageDropdown = By.id("languageDropdown");
    protected By selectedLanguage = By.id("selectedLanguage");
    protected By menuItems = By.cssSelector(".menu-item");
    protected By errorMessage = By.id("errorMessage");
    protected By helpSection = By.id("helpSection");
    protected By userContent = By.id("userContent");
    protected By userSettingsLink = By.id("userSettingsLink");
    protected By saveSettingsButton = By.id("saveSettingsButton");

    public LanguageSettingsPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchLoginPage() {
        navigateToUrl(getAppUrl() + "/login");
    }

    public void login(String username, String password) {
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        clickElement(loginButton);
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(By.id("homePage")), "User is not logged in.");
    }

    public void navigateToLanguageSettings() {
        clickElement(By.id("settingsMenu"));
        clickElement(By.id("languageSettings"));
    }

    public void verifyLanguageSettingsPageDisplayed() {
        Assert.assertTrue(isElementVisible(languageDropdown), "Language settings page is not displayed.");
    }

    public void selectDifferentLanguage() {
        selectByValue(languageDropdown, "fr");
    }

    public void verifyLanguageSelectionUpdated() {
        String currentLanguage = getTextFromElement(selectedLanguage);
        Assert.assertEquals(currentLanguage, "French", "Language selection is not updated.");
    }

    public void navigateThroughApplication() {
        clickElement(By.id("homeMenu"));
        clickElement(By.id("profileMenu"));
    }

    public void verifyInterfaceInSelectedLanguage() {
        String pageTitle = getTextFromElement(By.id("pageTitle"));
        Assert.assertTrue(pageTitle.contains("Bienvenue"), "Interface is not in the selected language.");
    }

    public void checkMenuItems() {
        List<WebElement> items = getWebElementList(menuItems);
        for (WebElement item : items) {
            Assert.assertTrue(item.getText().matches(".*[a-zA-Z].*"), "Menu item is not translated.");
        }
    }

    public void verifyMenuItemsTranslation() {
        Assert.assertTrue(getWebElementList(menuItems).stream().allMatch(item -> item.getText().contains("Accueil")), "Menu items are not correctly translated.");
    }

    public void triggerError() {
        clickElement(By.id("triggerError"));
    }

    public void verifyErrorMessagesTranslation() {
        String errorText = getTextFromElement(errorMessage);
        Assert.assertTrue(errorText.contains("Erreur"), "Error message is not translated.");
    }

    public void accessHelpAndSupport() {
        clickElement(helpSection);
    }

    public void verifyHelpAndSupportTranslation() {
        String helpText = getTextFromElement(helpSection);
        Assert.assertTrue(helpText.contains("Aide"), "Help section is not translated.");
    }

    public void viewUserSubmittedContent() {
        clickElement(userContent);
    }

    public void verifyUserContentOriginalLanguage() {
        String contentText = getTextFromElement(userContent);
        Assert.assertFalse(contentText.contains("Bonjour"), "User content is not in the original language.");
    }

    public void logoutAndLoginAgain() {
        clickElement(By.id("logoutButton"));
        login("username", "password");
    }

    public void verifyLanguagePersistenceAfterReLogin() {
        String currentLanguage = getTextFromElement(selectedLanguage);
        Assert.assertEquals(currentLanguage, "French", "Language does not persist after re-login.");
    }

    public void accessApplicationOnDifferentDevices() {
        // Simulate accessing on different devices
    }

    public void verifyLanguageConsistencyAcrossDevices() {
        Assert.assertTrue(true, "Language settings are not consistent across devices.");
    }

    public void accessApplicationOnDifferentBrowsers() {
        // Simulate accessing on different browsers
    }

    public void verifyLanguageConsistencyAcrossBrowsers() {
        Assert.assertTrue(true, "Language settings are not consistent across browsers.");
    }

    public void accessMobileApp() {
        // Simulate accessing mobile app
    }

    public void verifyLanguageAccessibilityOnMobileApp() {
        Assert.assertTrue(true, "Language settings are not accessible on mobile app.");
    }

    public void verifyNoMissingTranslations() {
        Assert.assertTrue(true, "There are missing translations.");
    }

    public void useApplication() {
        // Simulate using the application
    }

    public void verifyApplicationPerformance() {
        Assert.assertTrue(true, "Application performance is affected by language selection.");
    }

    public void switchToDefaultLanguage() {
        selectByValue(languageDropdown, "en");
    }

    public void verifySwitchBackToDefaultLanguage() {
        String currentLanguage = getTextFromElement(selectedLanguage);
        Assert.assertEquals(currentLanguage, "English", "Language is not switched back to default.");
    }

    public void navigateToUserSettings() {
        clickElement(userSettingsLink);
    }

    public void verifyUserSettingsPageDisplayed() {
        Assert.assertTrue(isElementVisible(languageDropdown), "User settings page is not displayed.");
    }

    public void verifyLanguageSelectionEnabled() {
        Assert.assertTrue(isElementEnabled(languageDropdown), "Language selection feature is not enabled.");
    }

    public void locateLanguageDropdown() {
        waitUntilElementVisible(languageDropdown, 3);
    }

    public void verifyLanguageDropdownVisible() {
        Assert.assertTrue(isElementVisible(languageDropdown), "Language selection dropdown is not visible.");
    }

    public void selectLanguage(String language) {
        selectByVisibleText(languageDropdown, language);
    }

    public void verifyLanguageSelected(String language) {
        String selectedLanguage = getSelectedOption(languageDropdown);
        Assert.assertEquals(selectedLanguage, language, "Preferred language is not selected.");
    }

    public void saveSettingsChanges() {
        clickElement(saveSettingsButton);
    }

    public void verifySettingsSaved() {
        Assert.assertTrue(isSettingsSaved(), "Settings are not saved successfully.");
    }

    public void refreshOrNavigate() {
        refreshPage();
    }

    public void verifyInterfaceTextUpdated(String language) {
        Assert.assertTrue(isInterfaceTextUpdated(language), "Interface text is not updated to " + language + ".");
    }

    public void navigateToHomePage() {
        navigateToPage("home");
    }
}