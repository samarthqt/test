package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class AdminLoginPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By btnSSOLogin = By.id("ssoLoginButton");
    protected By adminMenus = By.id("adminMenus");

    public AdminLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get(getAppUrl() + "/admin/login");
    }

    public void verifyLoginPageDisplayed() {
        Assert.assertTrue(isElementVisible(txtUsername), "Username field is not visible");
        Assert.assertTrue(isElementVisible(txtPassword), "Password field is not visible");
    }

    public void verifySSOButtonVisible() {
        Assert.assertTrue(isElementVisible(btnSSOLogin), "SSO Login button is not visible");
    }

    public void enterUsername(String username) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
    }

    public void verifyUsernameEntered(String username) {
        Assert.assertEquals(getAttributeValue(txtUsername, "value"), username, "Username not entered correctly");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void verifyPasswordEntered(String password) {
        Assert.assertEquals(getAttributeValue(txtPassword, "value"), password, "Password not entered correctly");
    }

    public void verifyPasswordMasked() {
        Assert.assertEquals(getAttributeValue(txtPassword, "type"), "password", "Password is not masked");
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginRequestProcessed() {
        // Logic to verify login request processing
        Assert.assertTrue(isElementVisible(adminMenus), "Login request not processed correctly");
    }

    public void verifyHomeScreenRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("/admin/home"), "Admin user is not redirected to the home screen");
    }

    public void verifyAdminMenusVisible() {
        Assert.assertTrue(isElementVisible(adminMenus), "Admin-specific menus are not visible");
    }

    public void logoutAdminAccount() {
        // Logic to logout admin account
        clickElement(By.id("logoutButton"));
    }

    public void verifyLogoutRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("/admin/login"), "User is not redirected to the login page after logout");
    }
}