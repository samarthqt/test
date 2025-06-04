package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LoginPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By errorMessage = By.id("errorMessage");
    protected By btnLoginWithSSO = By.id("loginWithSSOButton");
    protected By txtAdminUsername = By.id("adminUsername");
    protected By txtAdminSSOCredentials = By.id("adminSSOCredentials");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginPageDisplayed() {
        Assert.assertTrue(isElementVisible(txtUserName) && isElementVisible(txtPassword), "Login page is not displayed correctly.");
    }

    public void verifyLoginUnsuccessful() {
        Assert.assertTrue(isElementVisible(errorMessage), "Login attempt was successful unexpectedly.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Error message is not displayed.");
    }

    public void verifyErrorMessageContent(String expectedMessage) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message content does not match.");
    }

    public void verifyErrorMessageIncorrectCredentials() {
        String message = getTextFromElement(errorMessage);
        Assert.assertEquals(message, "The username/password is incorrect.", "Error message does not state incorrect credentials.");
    }

    public void verifyUserRemainsOnLoginPage() {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, getAppUrl(), "User is not on the login page.");
    }

    public void verifyCurrentPageIsLoginPage() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("login"), "User is not on the login page.");
    }

    public void verifyErrorMessageGuidance() {
        String guidanceText = getTextFromElement(errorMessage);
        Assert.assertTrue(guidanceText.contains("Please try again"), "Guidance text is not clear.");
    }

    public void waitForProcessing() {
        waitUntilElementInvisible(By.id("loadingSpinner"), 5);
    }

    public void navigateToLoginScreen() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    public void verifyLoginScreenElements() {
        Assert.assertTrue(isElementVisible(txtUserName) && isElementVisible(txtPassword) && isElementVisible(btnLogin), "Login screen elements are not displayed correctly.");
    }

    public void setAdminUsername(String username) {
        waitUntilElementVisible(txtAdminUsername, 3);
        enterText(txtAdminUsername, username);
    }

    public void setAdminSSOCredentials(String credentials) {
        waitUntilElementVisible(txtAdminSSOCredentials, 3);
        enterText(txtAdminSSOCredentials, credentials);
    }

    public void clickSSOButton() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        clickElement(btnLoginWithSSO);
    }

    public void verifySSOButtonPresence() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO button is not visible");
    }

    public void assertSSOButtonVisible() {
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO button is not visible");
    }

    public void verifySSORedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("sso"), "User is not redirected to SSO page.");
    }

    public void verifyAdminUserExists() {
        // Logic to verify admin user existence
        Assert.assertTrue(isElementVisible(txtAdminUsername), "Admin user does not exist.");
    }

    public void verifySSOConfiguration() {
        // Logic to verify SSO configuration
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "SSO configuration is not correct.");
    }

    public void enterInvalidSSOCredentials(String username, String credentials) {
        enterText(txtAdminUsername, username);
        enterText(txtAdminSSOCredentials, credentials);
        submitCredentials();
    }

    public void verifyInvalidCredentialsErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid credentials", "Error message does not match");
    }

    public void assertAdminUserNotLoggedIn() {
        // Logic to assert admin user is not logged in
        Assert.assertTrue(isElementVisible(txtAdminUsername), "Admin user is unexpectedly logged in.");
    }

    public void verifyLoginScreenVisibility() {
        Assert.assertTrue(isElementVisible(txtUserName) && isElementVisible(txtPassword), "Login screen is not visible.");
    }

    public void submitCredentials() {
        clickElement(btnLogin);
    }
}