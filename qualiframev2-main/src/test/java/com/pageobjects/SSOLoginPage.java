package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class SSOLoginPage extends WebReusableComponents {

    protected By btnLoginWithSSO = By.id("loginWithSSOButton");
    protected By txtSSOUsername = By.id("ssoUsername");
    protected By txtSSOPassword = By.id("ssoPassword");
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
        waitUntilElementVisible(loginScreen, 3);
        Assert.assertTrue(isElementVisible(loginScreen), "Login screen elements are not visible.");
    }

    public void verifySSOButtonVisibility() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO button is not visible.");
    }

    public void verifySSOButtonPresence() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO button is not present.");
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
        Assert.assertTrue(currentURL.contains("ssoAuthPage"), "Not redirected to SSO authentication page.");
    }

    public void enterSSOCredentials(String username, String password) {
        waitUntilElementVisible(txtSSOUsername, 3);
        enterText(txtSSOUsername, username);
        enterText(txtSSOPassword, password);
    }

    public void submitSSOCredentials() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        clickElement(btnLoginWithSSO);
    }

    public void verifyCredentialsAcceptance() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("applicationHome"), "Credentials not accepted.");
    }

    public void verifyRedirectionToApplication() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("applicationHome"), "Not redirected back to the application.");
    }

    public void verifySuccessfulLogin() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("dashboard"), "Login was not successful.");
    }

    public void verifyHomeScreenDisplay() {
        Assert.assertTrue(isElementVisible(dashboard), "Home screen is not displayed.");
    }

    public void verifyInvalidCredentialsErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid credentials", "Error message does not match.");
    }

    public void assertUserNotLoggedIn() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("login"), "User is redirected to home screen.");
    }

    public void simulateNetworkFailure() {
        // Logic to simulate network failure
    }

    public void verifyNetworkErrorMessage() {
        waitUntilElementVisible(networkErrorMessage, 3);
        String actualMessage = getTextFromElement(networkErrorMessage);
        Assert.assertEquals(actualMessage, "Network issues detected.", "Incorrect error message.");
    }

    public void verifyUserNotLoggedIn() {
        String currentURL = getCurrentURL();
        Assert.assertFalse(currentURL.contains("dashboard"), "User is logged in.");
    }

    public void verifyLoginScreenVisibility() {
        waitUntilElementVisible(loginScreen, 3);
        Assert.assertTrue(isElementVisible(loginScreen), "Login screen is not visible.");
    }

    public void verifyNoDashboardRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertFalse(currentURL.contains("dashboard"), "User is redirected to the dashboard.");
    }
}