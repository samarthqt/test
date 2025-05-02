package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LoginPage extends WebReusableComponents {

    protected By txtEmail = By.id("email");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By errorMessage = By.id("errorMessage");
    protected By linkForgotPassword = By.id("forgotPasswordLink");
    protected By checkboxRememberMe = By.id("rememberMeCheckbox");
    protected By btnLogout = By.id("logoutButton");

    public void enterEmail(String email) {
        waitUntilElementVisible(txtEmail, 3);
        enterText(txtEmail, email);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void clickForgotPasswordLink() {
        waitUntilElementVisible(linkForgotPassword, 3);
        clickElement(linkForgotPassword);
    }

    public void verifyPasswordResetPageRedirection() {
        String expectedURL = getAppUrl() + "/password-reset";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the password reset page.");
    }

    public void verifyRememberMeCheckboxVisibility() {
        waitUntilElementVisible(checkboxRememberMe, 3);
        Assert.assertTrue(isElementVisible(checkboxRememberMe), "Remember Me checkbox is not visible.");
    }

    public void toggleRememberMeCheckbox() {
        waitUntilElementVisible(checkboxRememberMe, 3);
        clickElement(checkboxRememberMe);
    }

    public void clickLogoutButton() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLoginPageRedirection() {
        String expectedURL = getAppUrl() + "/login";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the login page.");
    }
}