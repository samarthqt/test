package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LoginSSOPage extends WebReusableComponents {

    protected By btnLoginWithSSO = By.id("loginWithSSOButton");
    protected By txtSSOUsername = By.id("ssoUsername");
    protected By txtSSOPassword = By.id("ssoPassword");
    protected By btnSubmitSSO = By.id("submitSSOButton");
    protected By loginScreen = By.id("loginScreen");
    protected By ssoLoginPage = By.id("ssoLoginPage");
    protected By successfulLoginMessage = By.id("successfulLoginMessage");
    protected By ssoIntegrationConfig = By.id("ssoIntegrationConfig");

    public LoginSSOPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyAccessToLoginScreen() {
        WebElement loginScreenElement = driver.findElement(loginScreen);
        Assert.assertTrue(loginScreenElement.isDisplayed(), "Login screen is not accessible.");
    }

    public void navigateToLoginScreen() {
        driver.get(getAppUrl() + "/login");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Failed to navigate to login screen.");
    }

    public void verifyLoginScreenDisplayed() {
        WebElement loginScreenElement = driver.findElement(loginScreen);
        Assert.assertTrue(loginScreenElement.isDisplayed(), "Login screen is not displayed.");
    }

    public void verifySSOIntegrationConfigured() {
        WebElement ssoConfigElement = driver.findElement(ssoIntegrationConfig);
        Assert.assertTrue(ssoConfigElement.isDisplayed(), "SSO integration is not configured.");
    }

    public void clickLoginWithSSOButton() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        clickElement(btnLoginWithSSO);
    }

    public void verifyRedirectionToSSOLoginPage() {
        WebElement ssoLoginPageElement = driver.findElement(ssoLoginPage);
        Assert.assertTrue(ssoLoginPageElement.isDisplayed(), "Redirection to SSO login page failed.");
    }

    public void enterSSOCredentials() {
        waitUntilElementVisible(txtSSOUsername, 3);
        enterText(txtSSOUsername, "validUsername");
        waitUntilElementVisible(txtSSOPassword, 3);
        enterText(txtSSOPassword, "validPassword");
    }

    public void verifyCredentialsAccepted() {
        WebElement successfulLoginElement = driver.findElement(successfulLoginMessage);
        Assert.assertTrue(successfulLoginElement.isDisplayed(), "Credentials are not accepted.");
    }

    public void submitSSOLoginForm() {
        waitUntilElementVisible(btnSubmitSSO, 3);
        clickElement(btnSubmitSSO);
    }

    public void verifySuccessfulLogin() {
        WebElement successfulLoginElement = driver.findElement(successfulLoginMessage);
        Assert.assertTrue(successfulLoginElement.isDisplayed(), "Login was not successful.");
    }
}