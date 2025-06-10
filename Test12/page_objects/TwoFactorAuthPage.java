package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TwoFactorAuthPage extends WebReusableComponents {

    protected By securitySettingsLink = By.id("securitySettings");
    protected By enable2FAButton = By.id("enable2FA");
    protected By multiple2FAMethods = By.id("2FAMethods");
    protected By preferred2FAMethodDropdown = By.id("preferred2FAMethod");
    protected By notificationMessage = By.id("notificationMessage");
    protected By loginPrompt = By.id("loginPrompt");
    protected By verify2FAFunctionalityMessage = By.id("verify2FAFunctionality");
    protected By setupPageLink = By.id("setupPage");

    public TwoFactorAuthPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(securitySettingsLink), "User is not logged in.");
    }

    public void navigateToSecuritySettings() {
        waitUntilElementVisible(securitySettingsLink, 3);
        clickElement(securitySettingsLink);
    }

    public void enableTwoFactorAuthentication() {
        waitUntilElementVisible(enable2FAButton, 3);
        clickElement(enable2FAButton);
        Assert.assertTrue(isElementVisible(notificationMessage), "Failed to enable two-factor authentication.");
    }

    public void verifyMultiple2FAMethodsPresented() {
        Assert.assertTrue(isElementVisible(multiple2FAMethods), "Multiple 2FA methods are not presented.");
    }

    public void choosePreferred2FAMethod() {
        selectByVisibleText(preferred2FAMethodDropdown, "SMS");
        Assert.assertTrue(isElementVisible(notificationMessage), "Failed to choose preferred 2FA method.");
    }

    public void verifyTwoFactorAuthenticationEnabled() {
        Assert.assertTrue(isElementVisible(enable2FAButton), "Two-factor authentication is not enabled.");
    }

    public void trigger2FAActivity() {
        // Simulate 2FA activity
        clickElement(enable2FAButton);
        Assert.assertTrue(isElementVisible(notificationMessage), "2FA activity not triggered.");
    }

    public void verifyNotificationReceived() {
        Assert.assertTrue(isElementVisible(notificationMessage), "Notification for 2FA activity not received.");
    }

    public void attemptLogin() {
        // Simulate login attempt
        clickElement(loginPrompt);
        Assert.assertTrue(isElementVisible(notificationMessage), "Login attempt failed.");
    }

    public void verify2FAPrompt() {
        Assert.assertTrue(isElementVisible(loginPrompt), "2FA prompt not displayed.");
    }

    public void verify2FAFunctionality() {
        Assert.assertTrue(isElementVisible(verify2FAFunctionalityMessage), "2FA functionality verification failed.");
    }

    public void navigateTo2FASetupPage() {
        waitUntilElementVisible(setupPageLink, 3);
        clickElement(setupPageLink);
        Assert.assertTrue(isElementVisible(notificationMessage), "Failed to navigate to 2FA setup page.");
    }

    public void select2FAMethod(String method) {
        selectByVisibleText(preferred2FAMethodDropdown, method);
        Assert.assertTrue(isElementVisible(notificationMessage), "Failed to select 2FA method.");
    }

    public void configure2FAMethod(String method) {
        WebElement methodConfig = driver.findElement(By.id(method + "Configuration"));
        Assert.assertTrue(methodConfig.isDisplayed(), "Configuration for " + method + " failed.");
    }
}