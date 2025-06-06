package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

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
        waitUntilElementVisible(btnLogin, 3);
    }

    public void verifySSOButtonVisibility() {
        waitUntilElementVisible(btnSSOLogin, 3);
        Assert.assertTrue(isElementVisible(btnSSOLogin), "SSO Login button is not visible.");
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void verifyUserNameEntry(String expectedUsername) {
        String actualUsername = getElementAttribute(txtUserName, "value");
        Assert.assertEquals(actualUsername, expectedUsername, "Username entry mismatch.");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void verifyPasswordEntry(String expectedPassword) {
        String actualPassword = getElementAttribute(txtPassword, "value");
        Assert.assertEquals(actualPassword, expectedPassword, "Password entry mismatch.");
    }

    public void verifyPasswordMasking() {
        String passwordType = getElementAttribute(txtPassword, "type");
        Assert.assertEquals(passwordType, "password", "Password is not masked.");
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginProcessing() {
        waitUntilElementVisible(adminMenu, 5);
        Assert.assertTrue(isElementVisible(adminMenu), "Login processing failed.");
    }

    public void verifyHomePageRedirection() {
        String expectedURL = getAppUrl() + "/home";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the home screen.");
    }

    public void verifyAdminMenusVisibility() {
        waitUntilElementVisible(adminMenu, 3);
        Assert.assertTrue(isElementVisible(adminMenu), "Admin menus are not visible.");
    }

    public void performLogout() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLogoutRedirection() {
        String expectedURL = getAppUrl() + "/login";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the login page after logout.");
    }
}