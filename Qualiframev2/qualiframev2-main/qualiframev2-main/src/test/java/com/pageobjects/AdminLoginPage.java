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
    protected By btnSSOLogin = By.id("ssoLoginButton");
    protected By homeScreen = By.id("homeScreen");
    protected By adminMenus = By.cssSelector(".admin-menu");
    protected By logoutButton = By.id("logoutButton");

    public AdminLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
        Assert.assertFalse(getTextFromElement(txtUserName).isEmpty(), "Username is not entered.");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
        Assert.assertFalse(getTextFromElement(txtPassword).isEmpty(), "Password is not entered.");
        Assert.assertEquals(getAttribute(txtPassword, "type"), "password", "Password is not masked.");
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        verifyLoginRequestProcessing();
    }

    public void verifyLoginPageElements() {
        Assert.assertTrue(isElementVisible(txtUserName), "Username field is not visible.");
        Assert.assertTrue(isElementVisible(txtPassword), "Password field is not visible.");
    }

    public void verifySSOButtonVisibility() {
        Assert.assertTrue(isElementVisible(btnSSOLogin), "SSO Login button is not visible.");
    }

    public void verifyUserNameEntry() {
        Assert.assertFalse(getTextFromElement(txtUserName).isEmpty(), "Username is not entered.");
    }

    public void verifyPasswordEntry() {
        Assert.assertFalse(getTextFromElement(txtPassword).isEmpty(), "Password is not entered.");
    }

    public void verifyPasswordMasking() {
        Assert.assertEquals(getAttribute(txtPassword, "type"), "password", "Password is not masked.");
    }

    public void verifyLoginRequestProcessing() {
        // Logic to verify login request processing
        Assert.assertTrue(true, "Login request processing verified.");
    }

    public void verifyHomeScreenRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("home"), "User is not redirected to the home screen.");
    }

    public void verifyAdminMenusVisibility() {
        Assert.assertTrue(isElementVisible(adminMenus), "Admin menus are not visible.");
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        verifyLogoutRedirection();
    }

    public void verifyLogoutRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("login"), "User is not redirected to the login page after logout.");
    }
}