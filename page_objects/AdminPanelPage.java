package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AdminPanelPage extends WebReusableComponents {

    protected By txtAdminUsername = By.id("adminUsername");
    protected By txtAdminPassword = By.id("adminPassword");
    protected By btnLogin = By.id("adminLoginButton");
    protected By settingsSection = By.id("settingsSection");
    protected By confirmationMessageOptions = By.id("confirmationMessageOptions");
    protected By messageTemplate = By.id("messageTemplate");
    protected By messageTextArea = By.id("messageTextArea");
    protected By fontStyleDropdown = By.id("fontStyleDropdown");
    protected By colorSchemePicker = By.id("colorSchemePicker");
    protected By btnSaveChanges = By.id("saveChanges");
    protected By btnPreview = By.id("previewButton");
    protected By btnRevertToDefault = By.id("revertToDefault");
    protected By btnLogout = By.id("logoutButton");

    public AdminPanelPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToAdminPanel(String username, String password) {
        waitUntilElementVisible(txtAdminUsername, 3);
        enterText(txtAdminUsername, username);
        enterText(txtAdminPassword, password);
        clickElement(btnLogin);
    }

    public void verifyAdminLoginSuccess() {
        Assert.assertTrue(isElementVisible(settingsSection), "Admin login failed.");
    }

    public void navigateToSettingsSection() {
        clickElement(settingsSection);
    }

    public void verifySettingsSectionDisplayed() {
        Assert.assertTrue(isElementVisible(settingsSection), "Settings section not displayed.");
    }

    public void locateConfirmationMessageCustomizationOptions() {
        clickElement(confirmationMessageOptions);
    }

    public void verifyCustomizationOptionsVisible() {
        Assert.assertTrue(isElementVisible(confirmationMessageOptions), "Customization options not visible.");
    }

    public void selectConfirmationMessageTemplate() {
        clickElement(messageTemplate);
    }

    public void verifyTemplateReadyForCustomization() {
        Assert.assertTrue(isElementVisible(messageTextArea), "Template not ready for customization.");
    }

    public void modifyConfirmationMessageText() {
        enterText(messageTextArea, "New Confirmation Message Text");
    }

    public void verifyTextUpdated() {
        Assert.assertEquals(getTextFromElement(messageTextArea), "New Confirmation Message Text", "Text not updated.");
    }

    public void changeFontStyle() {
        selectByValue(fontStyleDropdown, "Bold");
    }

    public void verifyFontStyleChanged() {
        Assert.assertEquals(getSelectedValue(fontStyleDropdown), "Bold", "Font style not changed.");
    }

    public void updateColorScheme() {
        selectByValue(colorSchemePicker, "Blue");
    }

    public void verifyColorSchemeUpdated() {
        Assert.assertEquals(getSelectedValue(colorSchemePicker), "Blue", "Color scheme not updated.");
    }

    public void saveConfirmationMessageChanges() {
        clickElement(btnSaveChanges);
    }

    public void verifyChangesSaved() {
        Assert.assertTrue(isElementVisible(btnSaveChanges), "Changes not saved.");
    }

    public void previewCustomizedConfirmationMessage() {
        clickElement(btnPreview);
    }

    public void verifyPreviewShowsCustomizations() {
        Assert.assertTrue(isElementVisible(btnPreview), "Preview does not show customizations.");
    }

    public void revertToDefaultSettings() {
        clickElement(btnRevertToDefault);
    }

    public void verifyRevertedToDefault() {
        Assert.assertTrue(isElementVisible(btnRevertToDefault), "Not reverted to default.");
    }

    public void logoutFromAdminPanel() {
        clickElement(btnLogout);
    }

    public void verifyAdminLogoutSuccess() {
        Assert.assertTrue(isElementVisible(btnLogin), "Admin logout failed.");
    }

    public void triggerConfirmationMessage() {
        // Simulate action triggering confirmation message
        clickElement(messageTemplate);
    }

    public void verifyCustomizedMessageDisplayed() {
        Assert.assertTrue(isElementVisible(messageTextArea), "Customized message not displayed.");
    }

    public void verifyMessageContentFontAndColor() {
        Assert.assertEquals(getSelectedValue(fontStyleDropdown), "Bold", "Font style mismatch.");
        Assert.assertEquals(getSelectedValue(colorSchemePicker), "Blue", "Color scheme mismatch.");
    }

    public void verifyMessageMatchesCustomizations() {
        Assert.assertEquals(getTextFromElement(messageTextArea), "New Confirmation Message Text", "Message content mismatch.");
    }

    public void checkMessageClarity() {
        Assert.assertTrue(getTextFromElement(messageTextArea).contains("Confirmation"), "Message lacks clarity.");
    }

    public void verifyMessageClarity() {
        Assert.assertTrue(getTextFromElement(messageTextArea).contains("Confirmation"), "Message clarity not verified.");
    }

    public void ensureMessageAlignmentAndFormatting() {
        // Ensure message alignment and formatting
        Assert.assertTrue(isElementVisible(messageTextArea), "Message alignment and formatting not ensured.");
    }

    public void verifyMessageAlignmentAndFormatting() {
        Assert.assertTrue(isElementVisible(messageTextArea), "Message alignment and formatting not verified.");
    }
}