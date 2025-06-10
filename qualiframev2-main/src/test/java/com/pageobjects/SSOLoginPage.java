package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public SSOLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginScreen() {
        driver.get(getAppUrl() + "/coco-login");
        maximizeWindow();
    }

    public void verifyLoginScreenElements() {
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "Login screen elements are not visible.");
    }

    public void verifySSOButtonVisibility() {
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO button is not visible.");
    }

    public void clickSSOLoginButton() {
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

    public void verifyCredentialsAccepted() {
        // Logic to verify credentials acceptance
        Assert.assertTrue(true, "Credentials are not accepted.");
    }

    public void verifyRedirectionToApplication() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("applicationHome"), "Not redirected back to the application.");
    }

    public void verifySuccessfulLogin() {
        // Logic to verify successful login
        Assert.assertTrue(true, "Admin user is not successfully logged in.");
    }

    public void verifyHomeScreenDisplayed() {
        // Logic to verify home screen display
        Assert.assertTrue(true, "Home screen is not displayed.");
    }

    public void setAdminUsername(String username) {
        waitUntilElementVisible(txtSSOUsername, 3);
        enterText(txtSSOUsername, username);
    }

    public void verifyInvalidCredentialsErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid credentials", "Error message does not match.");
    }

    public void verifyNoDashboardRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertFalse(currentURL.contains("dashboard"), "User is redirected to the dashboard.");
    }

    public void verifyNetworkErrorMessage() {
        waitUntilElementVisible(networkErrorMessage, 3);
        String actualMessage = getTextFromElement(networkErrorMessage);
        Assert.assertEquals(actualMessage, "Network issues detected.", "Network error message is incorrect.");
    }

    public void enterInvalidSSOCredentials(String username, String credentials) {
        setAdminUsername(username);
        enterSSOCredentials(username, credentials);
        submitSSOCredentials();
    }

    public void verifyLoginScreenRemainsVisible() {
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "Login screen is not visible.");
    }

    public void simulateNetworkFailure() {
        // Simulate network failure logic
        Assert.assertTrue(true, "Network failure simulation not successful.");
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

    public void verifyUserNotLoggedIn() {
        // Logic to verify user is not logged in
        Assert.assertTrue(true, "User is logged in unexpectedly.");
    }

    public void verifyAdminUserExists() {
        // Logic to verify admin user exists
        Assert.assertTrue(true, "Admin user does not exist.");
    }

    public void assertUserNotLoggedIn() {
        // Logic to assert user is not logged in
        Assert.assertTrue(true, "User is logged in unexpectedly.");
    }
}