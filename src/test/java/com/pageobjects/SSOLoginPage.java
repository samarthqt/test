package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SSOLoginPage extends WebReusableComponents {

    protected By btnLoginWithSSO = By.id("loginWithSSOButton");
    protected By txtSSOUsername = By.id("ssoUsername");
    protected By txtSSOCredentials = By.id("ssoCredentials");
    protected By errorMessage = By.id("errorMessage");
    protected By loginScreenElements = By.id("loginScreenElements");
    protected By networkErrorMessage = By.id("networkErrorMessage");

    public SSOLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginScreen() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    public void verifyLoginScreenElements() {
        waitUntilElementVisible(loginScreenElements, 3);
        Assert.assertTrue(isElementVisible(loginScreenElements), "Login screen elements are not visible.");
    }

    public void verifySSOButtonVisibility() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO button is not visible.");
    }

    public void clickSSOButton() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        clickElement(btnLoginWithSSO);
    }

    public void verifySSORedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("sso-authentication"), "Not redirected to SSO authentication page.");
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

    public void verifyCredentialsAcceptance() {
        String currentURL = getCurrentURL();
        Assert.assertFalse(currentURL.contains("error"), "Credentials not accepted.");
    }

    public void verifyRedirectionToApplication() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("application"), "Not redirected back to the application.");
    }

    public void verifySuccessfulLogin() {
        WebElement homeElement = findElement(By.id("homeScreen"));
        Assert.assertTrue(homeElement.isDisplayed(), "Home screen is not displayed.");
    }

    public void verifyHomeScreenDisplay() {
        WebElement homeElement = findElement(By.id("homeScreen"));
        Assert.assertTrue(homeElement.isDisplayed(), "Home screen is not displayed.");
    }

    public void verifyAdminUserExists() {
        WebElement adminElement = findElement(By.id("adminUser"));
        Assert.assertTrue(adminElement.isDisplayed(), "Admin user does not exist.");
    }

    public void setAdminUsername(String username) {
        waitUntilElementVisible(txtSSOUsername, 3);
        enterText(txtSSOUsername, username);
    }

    public void verifySSOIntegrationActive() {
        WebElement ssoElement = findElement(By.id("ssoIntegration"));
        Assert.assertTrue(ssoElement.isDisplayed(), "SSO integration is not active.");
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
        setAdminUsername(username);
        setSSOCredentials(credentials);
        submitSSOCredentials();
    }

    public void verifyInvalidCredentialsErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid credentials.", "Error message does not match.");
    }

    public void assertAdminUserNotLoggedIn() {
        WebElement adminElement = findElement(By.id("adminUser"));
        Assert.assertFalse(adminElement.isDisplayed(), "Admin user is logged in.");
    }

    public void verifyLoginScreenRemainsVisible() {
        Assert.assertTrue(isElementVisible(loginScreenElements), "Login screen is not visible.");
    }

    public void simulateNetworkFailure() {
        // Simulate network failure logic
        WebElement networkElement = findElement(By.id("networkFailure"));
        Assert.assertTrue(networkElement.isDisplayed(), "Network failure not simulated.");
    }

    public void verifyNetworkErrorMessage() {
        waitUntilElementVisible(networkErrorMessage, 3);
        String actualMessage = getTextFromElement(networkErrorMessage);
        Assert.assertEquals(actualMessage, "Network issues detected.", "Network error message does not match.");
    }

    public void verifyUserNotLoggedIn() {
        WebElement userElement = findElement(By.id("userStatus"));
        Assert.assertFalse(userElement.isDisplayed(), "User is logged in.");
    }

    public void verifyLoginScreenVisibility() {
        Assert.assertTrue(isElementVisible(loginScreenElements), "Login screen is not visible.");
    }

    public void verifyNoDashboardRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertFalse(currentURL.contains("dashboard"), "User is redirected to the dashboard.");
    }
}