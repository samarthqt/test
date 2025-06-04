package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AdminLoginPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By btnSSOLogin = By.id("ssoLoginButton");
    protected By adminMenu = By.id("adminMenu");
    protected By btnLogout = By.id("logoutButton");

    public AdminLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginPageElements() {
        waitUntilElementVisible(txtUserName, 3);
        waitUntilElementVisible(txtPassword, 3);
        Assert.assertTrue(isElementVisible(txtUserName), "Username field is not visible");
        Assert.assertTrue(isElementVisible(txtPassword), "Password field is not visible");
    }

    public void verifySSOButtonVisibility() {
        waitUntilElementVisible(btnSSOLogin, 3);
        Assert.assertTrue(isElementVisible(btnSSOLogin), "SSO Login button is not visible");
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void verifyUserNameEntry(String expectedUsername) {
        String actualUsername = getTextFromElement(txtUserName);
        Assert.assertEquals(actualUsername, expectedUsername, "Username entry mismatch");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void verifyPasswordEntry(String expectedPassword) {
        String actualPassword = getTextFromElement(txtPassword);
        Assert.assertEquals(actualPassword, expectedPassword, "Password entry mismatch");
    }

    public void verifyPasswordMasking() {
        String passwordType = getElementAttribute(txtPassword, "type");
        Assert.assertEquals(passwordType, "password", "Password is not masked");
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginRequestProcessing() {
        // Logic to verify login request processing
        Assert.assertTrue(isElementVisible(adminMenu), "Login request processing failed");
    }

    public void verifyHomeScreenRedirection() {
        String currentURL = getCurrentURL();
        String expectedURL = testHarness.getData("LoginData", "ExpectedHomePageURL");
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the home screen");
    }

    public void verifyAdminMenusVisibility() {
        waitUntilElementVisible(adminMenu, 3);
        Assert.assertTrue(isElementVisible(adminMenu), "Admin menus are not visible");
    }

    public void clickLogoutButton() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLogoutRedirection() {
        String currentURL = getCurrentURL();
        String expectedURL = testHarness.getData("LoginData", "ExpectedLoginPageURL");
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the login page");
    }
}