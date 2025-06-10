package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import java.util.*;

public class LoginPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By btnLoginWithSSO = By.id("loginWithSSOButton");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginScreen() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    public void verifyLoginScreenElements() {
        waitUntilElementVisible(txtUserName, 3);
        waitUntilElementVisible(txtPassword, 3);
        waitUntilElementVisible(btnLogin, 3);
        waitUntilElementVisible(btnLoginWithSSO, 3);
        
        boolean isUserNameVisible = isElementVisible(txtUserName);
        boolean isPasswordVisible = isElementVisible(txtPassword);
        boolean isLoginButtonVisible = isElementVisible(btnLogin);
        boolean isSSOButtonVisible = isElementVisible(btnLoginWithSSO);
        
        assert isUserNameVisible : "Username field is not visible on the login screen.";
        assert isPasswordVisible : "Password field is not visible on the login screen.";
        assert isLoginButtonVisible : "Login button is not visible on the login screen.";
        assert isSSOButtonVisible : "SSO button is not visible on the login screen.";
    }

    public void verifySSOButtonVisibility() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        boolean isVisible = isElementVisible(btnLoginWithSSO);
        assert isVisible : "SSO button is not visible on the login screen.";
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

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }
}