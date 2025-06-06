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
    protected By adminMenu = By.id("adminMenu");

    public AdminLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void verifyUserNameEntered(String expectedUsername) {
        String actualUsername = getAttribute(txtUserName, "value");
        Assert.assertEquals(actualUsername, expectedUsername, "Username entry failed.");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void verifyPasswordEntered(String expectedPassword) {
        String actualPassword = getAttribute(txtPassword, "value");
        Assert.assertEquals(actualPassword, expectedPassword, "Password entry failed.");
    }

    public void verifyPasswordMasking() {
        String passwordType = getAttribute(txtPassword, "type");
        Assert.assertEquals(passwordType, "password", "Password is not masked.");
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginProcessing() {
        // Example logic to verify login processing
        waitUntilElementVisible(adminMenu, 5);
        Assert.assertTrue(isElementVisible(adminMenu), "Login processing failed.");
    }

    public void verifyHomePageRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("home"), "User is not redirected to the home screen.");
    }

    public void verifyAdminMenusVisible() {
        waitUntilElementVisible(adminMenu, 3);
        Assert.assertTrue(isElementVisible(adminMenu), "Admin menus are not visible.");
    }

    public void clickLogoutButton() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLogoutRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("login"), "User is not redirected to the login page after logout.");
    }

    public void verifyLoginPageElements() {
        Assert.assertTrue(isElementVisible(txtUserName), "Username field is not visible.");
        Assert.assertTrue(isElementVisible(txtPassword), "Password field is not visible.");
    }
}