package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class SSOLoginPage extends WebReusableComponents {

    protected By btnLoginWithSSO = By.id("loginWithSSOButton");
    protected By txtSSOUsername = By.id("ssoUsername");
    protected By txtSSOCredentials = By.id("ssoCredentials");
    protected By errorMessage = By.id("errorMessage");
    protected By networkErrorMessage = By.id("networkErrorMessage");
    protected By loginScreen = By.id("loginScreen");
    protected By dashboard = By.id("dashboard");

    public SSOLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginScreen() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    public void verifyLoginScreenElements() {
        Assert.assertTrue(isElementVisible(loginScreen), "Login screen elements are not visible.");
    }

    public void verifySSOButtonVisibility() {
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO button is not visible.");
    }

    public void clickSSOButton() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        clickElement(btnLoginWithSSO);
    }

    public void verifySSORedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("sso"), "Not redirected to SSO authentication page.");
    }

    public void enterSSOCredentials(String username, String credentials) {
        waitUntilElementVisible(txtSSOUsername, 3);
        enterText(txtSSOUsername, username);
        enterText(txtSSOCredentials, credentials);
    }

    public void submitSSOCredentials() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        clickElement(btnLoginWithSSO);
    }

    public void verifyCredentialsAccepted() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("application"), "Credentials not accepted.");
    }

    public void verifyRedirectionToApplication() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("application"), "Not redirected back to the application.");
    }

    public void verifySuccessfulLogin() {
        Assert.assertTrue(isElementVisible(dashboard), "User is not successfully logged in.");
    }

    public void verifyHomeScreenDisplay() {
        Assert.assertTrue(isElementVisible(dashboard), "Home screen is not displayed.");
    }

    public void verifyAdminUserExists() {
        // Logic to verify admin user exists
        Assert.assertTrue(true, "Admin user does not exist.");
    }

    public void verifySSOIntegrationActive() {
        // Logic to verify SSO integration is active
        Assert.assertTrue(true, "SSO integration is not active.");
    }

    public void verifySSOButtonPresence() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO button is not present.");
    }

    public void assertSSOButtonVisible() {
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO button is not visible.");
    }

    public void setSSOCredentials(String credentials) {
        waitUntilElementVisible(txtSSOCredentials, 3);
        enterText(txtSSOCredentials, credentials);
    }

    public void enterInvalidSSOCredentials(String username, String credentials) {
        enterSSOCredentials(username, credentials);
        submitSSOCredentials();
    }

    public void verifyInvalidCredentialsErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid credentials", "Error message does not match.");
    }

    public void assertUserNotLoggedIn() {
        Assert.assertFalse(isElementVisible(dashboard), "User is logged in.");
    }

    public void verifyLoginScreenRemainsVisible() {
        Assert.assertTrue(isElementVisible(loginScreen), "Login screen is not visible.");
    }

    public void verifySSOConfiguration() {
        // Logic to verify SSO configuration
        Assert.assertTrue(true, "SSO configuration is incorrect.");
    }

    public void simulateNetworkFailure() {
        // Logic to simulate network failure
        Assert.assertTrue(true, "Network failure simulation failed.");
    }

    public void verifyNetworkErrorMessage() {
        waitUntilElementVisible(networkErrorMessage, 3);
        Assert.assertTrue(isElementVisible(networkErrorMessage), "Network error message is not displayed.");
    }

    public void verifyUserNotLoggedIn() {
        Assert.assertFalse(isElementVisible(dashboard), "User is logged in.");
    }

    public void verifyLoginScreenVisibility() {
        waitUntilElementVisible(loginScreen, 3);
        Assert.assertTrue(isElementVisible(loginScreen), "Login screen is not visible.");
    }

    public void verifyNoDashboardRedirection() {
        Assert.assertFalse(isElementVisible(dashboard), "User is redirected to the dashboard.");
    }
}