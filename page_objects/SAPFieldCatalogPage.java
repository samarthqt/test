package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SAPFieldCatalogPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By homePageHeader = By.id("homePageHeader");
    protected By configurationScreenHeader = By.id("configurationScreenHeader");
    protected By fieldCatalogSettingsLink = By.id("fieldCatalogSettingsLink");
    protected By searchField = By.id("searchField");
    protected By attributeErrorMessage = By.id("attributeErrorMessage");
    protected By btnSaveChanges = By.id("saveChangesButton");
    protected By saveErrorMessage = By.id("saveErrorMessage");
    protected By btnLogout = By.id("logoutButton");

    public void navigateToLoginPage() {
        launchUrl("https://sap-system-login-page.com");
        maximizeWindow();
    }

    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifySuccessfulLogin() {
        waitUntilElementVisible(homePageHeader, 3);
        Assert.assertTrue(isElementDisplayed(homePageHeader), "Login failed.");
    }

    public void navigateToHomePage() {
        waitUntilElementVisible(homePageHeader, 3);
        clickElement(homePageHeader);
    }

    public void navigateToConfigurationScreen() {
        waitUntilElementVisible(configurationScreenHeader, 3);
        clickElement(configurationScreenHeader);
    }

    public void verifyConfigurationScreenDisplayed() {
        waitUntilElementVisible(configurationScreenHeader, 3);
        Assert.assertTrue(isElementDisplayed(configurationScreenHeader), "Configuration screen not displayed.");
    }

    public void navigateToFieldCatalogSettings() {
        waitUntilElementVisible(fieldCatalogSettingsLink, 3);
        clickElement(fieldCatalogSettingsLink);
    }

    public void verifyFieldCatalogSettingsAccessible() {
        waitUntilElementVisible(fieldCatalogSettingsLink, 3);
        Assert.assertTrue(isElementDisplayed(fieldCatalogSettingsLink), "Field catalog settings not accessible.");
    }

    public void searchForAttribute(String attributeName) {
        waitUntilElementVisible(searchField, 3);
        enterText(searchField, attributeName);
    }

    public void verifyAttributeNotVisible(String attributeName) {
        waitUntilElementVisible(attributeErrorMessage, 3);
        String errorMessage = getTextFromElement(attributeErrorMessage);
        Assert.assertTrue(errorMessage.contains(attributeName), "Attribute is visible in the field catalog list.");
    }

    public void attemptToConfigureRuleUsingAttribute(String attributeName) {
        searchForAttribute(attributeName);
        clickElement(attributeErrorMessage);
    }

    public void verifyErrorForAttributeAbsence(String attributeName) {
        waitUntilElementVisible(attributeErrorMessage, 3);
        String errorMessage = getTextFromElement(attributeErrorMessage);
        Assert.assertTrue(errorMessage.contains(attributeName), "No error displayed for missing attribute.");
    }

    public void makeConfigurationChanges() {
        // Logic to make configuration changes
    }

    public void attemptToSaveChanges() {
        waitUntilElementVisible(btnSaveChanges, 3);
        clickElement(btnSaveChanges);
    }

    public void verifyErrorOnSaveAttempt() {
        waitUntilElementVisible(saveErrorMessage, 3);
        String errorMessage = getTextFromElement(saveErrorMessage);
        Assert.assertTrue(errorMessage.contains("Error"), "No error displayed on save attempt.");
    }

    public void clickLogoutButton() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifySuccessfulLogout() {
        waitUntilElementVisible(txtUsername, 3);
        Assert.assertTrue(isElementDisplayed(txtUsername), "Logout failed.");
    }
}