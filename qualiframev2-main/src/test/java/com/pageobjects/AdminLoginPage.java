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
    protected By btnLogout = By.id("logoutButton");
    protected By homeScreen = By.id("homeScreen");
    protected By adminMenus = By.id("adminMenus");

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
        Assert.assertEquals(passwordType, "password", "Password is not masked.");
    }

    public void verifyLoginRequestProcessed() {
        // Logic to verify login request processing
        Assert.assertTrue(isElementVisible(homeScreen), "Login request is not processed.");
    }

    public void verifyHomeScreenRedirection() {
        Assert.assertTrue(isElementVisible(homeScreen), "Admin user is not redirected to the home screen.");
    }

    public void verifyAdminMenusVisible() {
        Assert.assertTrue(isElementVisible(adminMenus), "Admin-specific menus are not visible.");
    }

    public void verifyLogoutRedirection() {
        Assert.assertTrue(isElementVisible(txtUserName) && isElementVisible(txtPassword), "User is not redirected to the login page after logout.");
    }
}