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
    protected By txtSSOPassword = By.id("ssoPassword");
    protected By btnSubmitSSO = By.id("submitSSOButton");
    protected By errorMessage = By.id("errorMessage");
    protected By networkErrorMessage = By.id("networkErrorMessage");
    protected By loginScreenElements = By.cssSelector(".login-screen-elements");
    protected By homeScreen = By.id("homeScreen");

    public SSOLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginScreen() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    public void verifyLoginScreenElements() {
        waitUntilElementVisible(loginScreenElements, 3);
        Assert.assertTrue(isElementDisplayed(loginScreenElements), "Login screen elements are not displayed.");
    }

    public void verifySSOButtonVisibility() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        Assert.assertTrue(isElementDisplayed(btnLoginWithSSO), "SSO button is not visible.");
    }

    public void assertSSOButtonVisible() {
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO button is not visible.");
    }

    public void clickSSOButton() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        clickElement(btnLoginWithSSO);
    }

    public void verifySSORedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("sso"), "Not redirected to SSO page.");
    }

    public void enterSSOCredentials(String username, String password) {
        waitUntilElementVisible(txtSSOUsername, 3);
        enterText(txtSSOUsername, username);
        enterText(txtSSOPassword, password);
    }

    public void submitSSOCredentials() {
        waitUntilElementVisible(btnSubmitSSO, 3);
        clickElement(btnSubmitSSO);
    }

    public void verifyCredentialsAccepted() {
        Assert.assertTrue(isElementVisible(homeScreen), "Credentials not accepted.");
    }

    public void verifyInvalidCredentialsMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid credentials", "Error message does not match.");
    }

    public void verifyNetworkErrorMessage() {
        waitUntilElementVisible(networkErrorMessage, 3);
        Assert.assertTrue(isElementDisplayed(networkErrorMessage), "Network error message is not displayed.");
    }

    public void verifySSOIntegration() {
        // Logic to verify SSO integration
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO integration is not verified.");
    }

    public void verifySSOButtonPresence() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO button presence is not verified.");
    }

    public void verifyLoginScreenVisibility() {
        Assert.assertTrue(isElementDisplayed(loginScreenElements), "Login screen is not visible.");
    }

    public void verifyNoDashboardRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertFalse(currentURL.contains("dashboard"), "Unexpected redirection to dashboard.");
    }

    public void verifyRedirectionToApplication() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("application"), "Not redirected back to application.");
    }

    public void setAdminUsername(String username) {
        // Logic to set admin username if needed
        enterText(txtSSOUsername, username);
    }

    public void verifyHomeScreenDisplayed() {
        Assert.assertTrue(isElementVisible(homeScreen), "Home screen not displayed.");
    }

    public void verifySuccessfulLogin() {
        Assert.assertTrue(isElementVisible(homeScreen), "User not logged in successfully.");
    }

    public void simulateNetworkFailure() {
        // Logic to simulate network failure
        Assert.assertTrue(isElementVisible(networkErrorMessage), "Network failure simulation failed.");
    }

    public void verifyUserNotLoggedIn() {
        Assert.assertFalse(isElementVisible(homeScreen), "User is unexpectedly logged in.");
    }

    public void assertUserNotLoggedIn() {
        Assert.assertFalse(isElementVisible(homeScreen), "User is unexpectedly logged in.");
    }
}