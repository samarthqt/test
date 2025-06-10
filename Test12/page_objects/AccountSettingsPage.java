package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountSettingsPage extends WebReusableComponents {

    protected By txtCurrentPassword = By.id("currentPassword");
    protected By txtNewPassword = By.id("newPassword");
    protected By txtConfirmPassword = By.id("confirmPassword");
    protected By btnChangePassword = By.id("changePasswordButton");
    protected By msgConfirmation = By.id("confirmationMessage");
    protected By msgError = By.id("errorMessage");
    protected By accountSettingsLink = By.id("accountSettingsLink");
    protected By passwordResetLink = By.id("passwordResetLink");
    protected By emailAddressField = By.id("emailAddress");

    public AccountSettingsPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isUserLoggedIn(), "User is not logged in.");
    }

    public void navigateToAccountSettings() {
        clickElement(accountSettingsLink);
    }

    public void enterCurrentPassword(String currentPassword) {
        waitUntilElementVisible(txtCurrentPassword, 3);
        enterText(txtCurrentPassword, currentPassword);
    }

    public void enterNewPassword(String newPassword) {
        waitUntilElementVisible(txtNewPassword, 3);
        enterText(txtNewPassword, newPassword);
    }

    public void confirmNewPassword(String newPassword) {
        waitUntilElementVisible(txtConfirmPassword, 3);
        enterText(txtConfirmPassword, newPassword);
    }

    public void verifyPasswordChanged() {
        clickElement(btnChangePassword);
        Assert.assertTrue(isPasswordChanged(), "Password change failed.");
    }

    public void verifyConfirmationMessage() {
        waitUntilElementVisible(msgConfirmation, 3);
        String message = getTextFromElement(msgConfirmation);
        Assert.assertEquals(message, "Your password has been changed successfully.", "Confirmation message mismatch.");
    }

    public void verifyAuditLogEntry() {
        Assert.assertTrue(isAuditLogEntryCreated(), "Audit log entry not created.");
    }

    public void verifyErrorMessage() {
        waitUntilElementVisible(msgError, 3);
        String message = getTextFromElement(msgError);
        Assert.assertEquals(message, "Incorrect current password.", "Error message mismatch.");
    }

    public void verifyNoPasswordChange() {
        Assert.assertFalse(isPasswordChanged(), "Password change should not be processed.");
    }

    public void verifyForgottenPassword() {
        Assert.assertTrue(isForgottenPassword(), "Password is not forgotten.");
    }

    public void navigateToPasswordResetPage() {
        clickElement(passwordResetLink);
    }

    public void enterEmailAddress(String emailAddress) {
        waitUntilElementVisible(emailAddressField, 3);
        enterText(emailAddressField, emailAddress);
    }

    public void verifyPasswordResetLinkSent() {
        Assert.assertTrue(isPasswordResetLinkSent(), "Password reset link not sent.");
    }

    public void verifyPasswordResetLinkUsage() {
        Assert.assertTrue(canUsePasswordResetLink(), "Cannot use password reset link.");
    }

    public void verifyPasswordChangeInitiated() {
        Assert.assertTrue(isPasswordChangeInitiated(), "Password change not initiated.");
    }

    public void verifyGDPRCompliance() {
        Assert.assertTrue(isGDPRCompliant(), "Password change process not GDPR compliant.");
    }
}