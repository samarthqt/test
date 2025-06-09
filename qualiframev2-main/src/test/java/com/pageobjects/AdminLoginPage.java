package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AdminLoginPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By btnLogout = By.id("logoutButton");
    protected By adminMenus = By.id("adminMenus");
    protected By btnSSOLogin = By.id("ssoLoginButton");

    public AdminLoginPage() {
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

    public void clickLogoutButton() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLoginPageDisplayed() {
        Assert.assertTrue(isElementVisible(txtUserName) && isElementVisible(txtPassword), "Login page is not displayed correctly.");
    }

    public void verifyUserNameEntered(String expectedUsername) {
        String actualUsername = getAttributeValue(txtUserName, "value");
        Assert.assertEquals(actualUsername, expectedUsername, "Username is not entered correctly.");
    }

    public void verifyPasswordEntered(String expectedPassword) {
        String actualPassword = getAttributeValue(txtPassword, "value");
        Assert.assertEquals(actualPassword, expectedPassword, "Password is not entered correctly.");
    }

    public void verifyPasswordMasked() {
        String passwordType = getAttributeValue(txtPassword, "type");
        Assert.assertEquals(passwordType, "password", "Password is not masked correctly.");
    }

    public void verifyLoginRequestProcessed() {
        Assert.assertTrue(isElementVisible(adminMenus), "Login request is not processed correctly.");
    }

    public void verifyHomeScreenRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("home"), "Admin user is not redirected to the home screen.");
    }

    public void verifyAdminMenusVisible() {
        Assert.assertTrue(isElementVisible(adminMenus), "Admin-specific menus are not visible on the home screen.");
    }

    public void verifyLogoutRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("login"), "User is not redirected to the login page after logout.");
    }

    public void verifySSOButtonVisible() {
        Assert.assertTrue(isElementVisible(btnSSOLogin), "SSO Login button is not visible on the login screen.");
    }
}