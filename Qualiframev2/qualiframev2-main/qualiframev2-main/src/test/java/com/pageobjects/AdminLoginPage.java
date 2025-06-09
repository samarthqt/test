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
    protected By adminMenus = By.cssSelector(".admin-menu");

    public AdminLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginPageDisplayed() {
        waitUntilElementVisible(txtUserName, 3);
        waitUntilElementVisible(txtPassword, 3);
        Assert.assertTrue(isElementVisible(txtUserName) && isElementVisible(txtPassword), "Login page is not displayed correctly.");
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void verifyUserNameEntered() {
        String enteredUserName = getAttribute(txtUserName, "value");
        Assert.assertFalse(enteredUserName.isEmpty(), "Username is not entered.");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void verifyPasswordEntered() {
        String enteredPassword = getAttribute(txtPassword, "value");
        Assert.assertFalse(enteredPassword.isEmpty(), "Password is not entered.");
    }

    public void verifyPasswordMasked() {
        String passwordType = getAttribute(txtPassword, "type");
        Assert.assertEquals(passwordType, "password", "Password is not masked.");
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginProcessing() {
        Assert.assertTrue(isElementVisible(By.id("processingIndicator")), "Login request is not being processed.");
    }

    public void verifyHomePageRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("home"), "Admin user is not redirected to the home screen.");
    }

    public void verifyAdminMenusVisible() {
        waitUntilElementVisible(adminMenus, 3);
        Assert.assertTrue(isElementVisible(adminMenus), "Admin-specific menus are not visible.");
    }

    public void clickLogoutButton() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLogoutRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("login"), "User is not redirected to the login page after logout.");
    }
}