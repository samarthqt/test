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
    protected By btnLogout = By.id("logoutButton");
    protected By adminMenus = By.id("adminMenus");
    protected By btnSSOLogin = By.id("ssoLoginButton");

    public AdminLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginPageDisplayed() {
        Assert.assertTrue(isElementVisible(txtUserName), "Username field is not visible.");
        Assert.assertTrue(isElementVisible(txtPassword), "Password field is not visible.");
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void verifyUserNameEntered(String username) {
        String enteredUserName = getElementAttribute(txtUserName, "value");
        Assert.assertEquals(enteredUserName, username, "Username is not entered correctly.");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void verifyPasswordEntered(String password) {
        String enteredPassword = getElementAttribute(txtPassword, "value");
        Assert.assertEquals(enteredPassword, password, "Password is not entered correctly.");
    }

    public void verifyPasswordMasked() {
        String passwordType = getElementAttribute(txtPassword, "type");
        Assert.assertEquals(passwordType, "password", "Password is not masked.");
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginRequestProcessed() {
        Assert.assertTrue(isElementVisible(adminMenus), "Login request is not processed correctly.");
    }

    public void verifyHomeScreenRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("home"), "User is not redirected to the home screen.");
    }

    public void verifyAdminMenusVisible() {
        Assert.assertTrue(isElementVisible(adminMenus), "Admin menus are not visible.");
    }

    public void clickLogoutButton() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLogoutRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("login"), "User is not redirected to the login page after logout.");
    }

    public void verifySSOButtonVisible() {
        Assert.assertTrue(isElementVisible(btnSSOLogin), "SSO Login button is not visible.");
    }
}